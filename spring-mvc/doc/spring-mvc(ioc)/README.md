## Spring MVC ~ IOC  

0.代码目录重新调整-项目目录结构图   
![Aaron Swartz](https://github.com/ittarvin/snow-ball/blob/master/spring-mvc/src/main/webapp/images/java_web_catalogue2.png?raw=true)   

1.配置web.xml 

          <!-- Convenient ApplicationContext instantiation for web applications begin -->
            <context-param>
        	    <param-name>contextConfigLocation</param-name>
        	    <param-value>classpath:applicationContext*.xml</param-value>
            </context-param>
          	<listener>
        	    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        	</listener>
          <!-- Convenient ApplicationContext instantiation for web applications end -->
          
2.配置application*.xml  

        <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans.xsd"
                default-lazy-init="true">
                
             <bean id="service" class="com.web.service.impl.ServiceImpl" scope="prototype">
                <property name="dao" ref="dao"/>
             </bean>
        </beans>

3.ApplicationContextUtil 负责实现初始化 ApplicationContext。

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


4.调用类的实现  

            @RequestMapping("print")
            public String print(HttpServletRequest request) {
        	   Service service=(Service) ApplicationContextUtil.getBean(request, "service", Service.class);
        	   service.print("hello");
               return "print";
            }

