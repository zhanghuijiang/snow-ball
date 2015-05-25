package com.vcard.cache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;

import com.vcard.cache.target.CacheHandle;

public class MethodCacheInterceptor implements MethodInterceptor,InitializingBean {
    
    private Cache cache;
    
    public void setCache(Cache cache) {
        this.cache = cache;
    }
    
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(cache + " A cache is required. Use setCache(Cache) to provide one.");
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		    String targetName = invocation.getThis().getClass().getName();
	        String methodName = invocation.getMethod().getName();
	        Object[] arguments = invocation.getArguments();
	        Object result;
	        CacheHandle handle = (CacheHandle)invocation.getThis();
	        if(handle.ifContinueCaching(methodName)){
	        	
	        	String cacheKey = getCacheKey(targetName, methodName, arguments);
	        	Element element = null;
	        	synchronized (this) {
	        		element = cache.get(cacheKey);
	        		if (element == null) {
	        			System.out.println(cache.getName() +" is caching --> " + cacheKey);
	        			// 调用实际的方法
	        			result = invocation.proceed();
	        			element = new Element(cacheKey, (Serializable) result);
	        			cache.put(element);
	        		} else {
	        			System.out.println(cache.getName() +" is using cache -->  " + cacheKey);
	        		}
	        	}
	        	return element.getValue();
	        }else{
	        	synchronized (this) {
	        		result = invocation.proceed();
	        	}
	        }
	        
	        return result;
	}
	
	
	/**
     * <b>function:</b> 返回具体的方法全路径名称 参数
     * @author hoojo
     * @createDate 2012-7-2 下午06:12:39
     * @param targetName 全路径
     * @param methodName 方法名称
     * @param arguments 参数
     * @return 完整方法名称
     */
    private String getCacheKey(String targetName, String methodName, Object[] arguments) {
        StringBuffer sb = new StringBuffer();
        sb.append(targetName).append(".").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sb.append(".").append(arguments[i]);
            }
        }
        return sb.toString();
    }

}
