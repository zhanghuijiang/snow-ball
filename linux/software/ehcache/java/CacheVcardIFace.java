package com.vcard.cache.target;

import java.util.List;

import net.sf.ehcache.Cache;

import com.vcard.dao.Vcard_user;


public abstract class CacheVcardIFace implements CacheHandle{
	
	private static String[] cacheMethodNames ={"getUser"};
	
	private static String[] updateCacheMethodNames ={"UpdateUser"};
	
	@Override
	public boolean ifContinueCaching(String methodName){
		boolean ifContinue = false;
		for (String name : cacheMethodNames) {
			if(methodName.equals(name)){
				ifContinue = true;
				break;
			}
		}
		return ifContinue;
	}
	
	@Override
	public boolean ifContinueRemoving(String methodName){
		boolean ifContinue = false;
		for (String name : updateCacheMethodNames) {
			if(methodName.equals(name)){
				ifContinue = true;
				break;
			}
		}
		return ifContinue;
	}
	
	@Override
	public void removeCache(Cache cache,Object returnValue,java.lang.reflect.Method method, Object[] args, Object classObj){
		String className = classObj.getClass().getName();
		Vcard_user user = (Vcard_user)args[0];
		long uniqueId = user.getSysid();
		List list = cache.getKeys();
		for (int i = 0; i < list.size(); i++) {
			String cacheKey = String.valueOf(list.get(i));
			if (cacheKey.startsWith(className) && cacheKey.endsWith(String.valueOf(uniqueId))) {
				System.out.println(cache.getName() + " is removing " + cacheKey);
				cache.remove(cacheKey);
			}
		}
	}
	
}
