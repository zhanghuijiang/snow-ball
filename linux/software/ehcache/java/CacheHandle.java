package com.vcard.cache.target;

import net.sf.ehcache.Cache;


/**
 * 缓存处理类
 * @author arvin
 *
 */
public interface CacheHandle {
	 /**
     * 拦截处理缓存：是否继续缓存
     */
    public boolean ifContinueCaching(String methodName);
	 /**
     * 拦截处理缓存：是否继续删除
     */
    public boolean ifContinueRemoving(String methodName);
    /**
     * 删除缓存
     */
    public void removeCache(Cache cache,Object returnValue,java.lang.reflect.Method method, Object[] args, Object classObj);
    
}
