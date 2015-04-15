package com.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Spring MVC ApplicationContext 工具类
 * @author arvin
 */
public class ApplicationContextUtil {
   
	
	/**
	 * 防止工具类被实例化
	 */
	private ApplicationContextUtil(){}
	
	/**
	 * 采用单例模式
	 */
	private static ApplicationContext context = null;
	
	
	/**
	 * 初始化当前ApplicationContext
	 * @param request
	 */
	private static synchronized void syncInitApplicationContext(HttpServletRequest request) {
		if(context == null){
			context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		}
	}
	
	
	/**
	 * 根据名称（id/name）获取实例 
	 * @param request ： HttpServletRequest
	 * @param targetId ：id/name
	 * @param args ：bean 类
	 * @return
	 */
	public static Object getBean(HttpServletRequest request,String targetId,Class<?> args){
		if(context==null){
			syncInitApplicationContext(request);
		}
		return context.getBean(targetId, args);
	}
	
}
