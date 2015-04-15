##Spring MVC ~ annotation
 
![Aaron Swartz](https://github.com/ittarvin/snow-ball/blob/master/spring-mvc/src/main/webapp/images/mvc.png?raw=true)   

0.Eclipse 创建 Maven Project(选择：maven-archetype-webapp/A simple Java web application)   
项目目录结构图：   
![Aaron Swartz](https://github.com/ittarvin/snow-ball/blob/master/spring-mvc/src/main/webapp/images/java_web_catalogue.png?raw=true)    
*java Build Path-Source/Default output folder : java-web/src/main/webapp/WEB-INF/classes*   

1.web.xml 配置 DispatcherServlet   
![Aaron Swartz](https://github.com/ittarvin/snow-ball/blob/master/spring-mvc/src/main/webapp/images/mvc-contexts.gif?raw=true)  

        <!-- spring framework mvc begin -->
           <!--配置分发,Spring MVC 自动查找 WEB-INF 目下命名为[servlet-name]-servlet.xml 的文件 -->
           <servlet>
                <servlet-name>springmvc</servlet-name>
                <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                <load-on-startup>1</load-on-startup>
           </servlet>
            <servlet-mapping>
                <servlet-name>springmvc</servlet-name>
                <url-pattern>/</url-pattern>
            </servlet-mapping>
         <!-- spring framework mvc end -->   
         
         
2.springmvc-servlet.xml 配置 beans (文件名称:web.xml 中的[servlet-name]-servlet.xml)

        <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:p="http://www.springframework.org/schema/p"
            xmlns:context="http://www.springframework.org/schema/context"
            xmlns:mvc="http://www.springframework.org/schema/mvc"
            xsi:schemaLocation="
                http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans.xsd
                http://www.springframework.org/schema/context
                http://www.springframework.org/schema/context/spring-context.xsd 
                http://www.springframework.org/schema/mvc
                http://www.springframework.org/schema/mvc/spring-mvc.xsd">
                
            <!-- spring framework mvc begin -->
           
            <!--  指定位置扫描注解的类文件,作为beans配置到容器中-->
            <context:component-scan base-package="com.web" />
            <!-- 打开mvc注解 -->
            <mvc:annotation-driven/>
            
            <!-- Default ViewResolver 默认视图解析器-->
               <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        		<property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
        		<property name="prefix" value="/WEB-INF/jsp/" /> <!--前置路径-->
        		<property name="suffix" value=".jsp"></property> <!--后缀名称-->
        	</bean>
            <!-- spring framework mvc end -->
        </beans>

3.pom.xml 配置依赖jar(添加完成依赖下载的jar文件是可以在 maven Dependencies 查看)

         <!-- 数据仓库 -->
          <repositories>
             <!-- spring framework mvc begin -->
        	  <repository>
        	    <id>repository.spring.release</id>
        	    <name>Spring GA Repository</name>
        	    <url>http://repo.spring.io/release</url>
        	  </repository>
        	 <!-- spring framework mvc end -->
          </repositories>  
          
          <!-- 依赖配置-->
         <dependencies>
                    <!-- spring framework mvc begin -->
                         <dependency>
        			    <groupId>junit</groupId>
        			    <artifactId>junit</artifactId>
        			    <version>3.8.1</version>
        			    <scope>test</scope>
        		  </dependency>
        		  <dependency>
        		        <groupId>org.springframework</groupId>
        		        <artifactId>spring-context</artifactId>
        		        <version>4.1.5.RELEASE</version>
        		  </dependency>
        		 <dependency>
        		        <groupId>org.springframework</groupId>
        		        <artifactId>spring-web</artifactId>
        		        <version>4.1.5.RELEASE</version>
        		  </dependency>
        		  <dependency>
        		        <groupId>org.springframework</groupId>
        		        <artifactId>spring-webmvc</artifactId>
        		        <version>4.1.5.RELEASE</version>
        		  </dependency>
        		  
        		  <dependency>
        		        <groupId>javax.servlet</groupId>
        		        <artifactId>jstl</artifactId>
        		        <version>1.2</version>
        		  </dependency>
        		  <dependency>
        		        <groupId>taglibs</groupId>
        		        <artifactId>standard</artifactId>
        		        <version>1.1.2</version>
        		  </dependency>
        		  
        		  <dependency>
        		        <groupId>org.aspectj</groupId>
        		        <artifactId>aspectjrt</artifactId>
        		         <version>1.8.0.RELEASE</version>
        		  </dependency>
        		  <dependency>
        		        <groupId>org.aspectj</groupId>
        		        <artifactId>aspectjweaver</artifactId>
        		         <version>1.8.0.RELEASE</version>
        		  </dependency>
        	<!-- spring framework mvc end -->
         </dependencies>

4.添加 IndexController

        @Controller
        public class IndexController {
        	
        	@RequestMapping("index")
            public String index(HttpServletRequest request) {
               return "index";
            }
        }


注释：1~3 配置文件中的 <!-- spring framework mvc begin -->添加的内容<!-- spring framework mvc end -->   


