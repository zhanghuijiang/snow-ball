package com.vcard.cache;

import net.sf.ehcache.Cache;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.InitializingBean;

import com.vcard.cache.target.CacheHandle;

public class MethodCacheAfterAdvice implements AfterReturningAdvice,InitializingBean {
	
	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public MethodCacheAfterAdvice() {
		super();
	}

	public void afterPropertiesSet() throws Exception {
		
	}

	public void afterReturning(Object returnValue,java.lang.reflect.Method method, Object[] args, Object classObj)throws Throwable {
		CacheHandle handle = (CacheHandle)classObj;
		if(handle.ifContinueRemoving(method.getName())){
			handle.removeCache(cache,returnValue,method,args,classObj);
		}
	}
}