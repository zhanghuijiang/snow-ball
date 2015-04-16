##Spring MVC  ~ Spring JDBC + Mysql

0.代码目录重新调整-项目目录结构图    
![Aaron Swartz](https://github.com/ittarvin/snow-ball/blob/master/spring-mvc/src/main/webapp/images/java_web_catalogue3.png?raw=true)   
1.pom.xml 配置导入依赖jar   

    	<!-- spring framework mvc Datebase begin -->  
    		<dependency>
    			<groupId>commons-dbcp</groupId>
    			<artifactId>commons-dbcp</artifactId>
    			<version>1.4</version>
    		</dependency>
    		<dependency>
    			<groupId>mysql</groupId>
    			<artifactId>mysql-connector-java</artifactId>
    			<version>5.1.6</version>
            </dependency>
            <dependency>
    			<groupId>org.springframework</groupId>
    			<artifactId>spring-jdbc</artifactId>
    			<version>2.5.6</version>
             </dependency>
    	 <!-- spring framework mvc Datebase end -->
    	 
2.applicationContext-dataSource.xml 配置数据源  

        	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        	    <property name="driverClassName" value="com.mysql.jdbc.Driver" />
        	    <property name="url" value="jdbc:mysql://127.0.0.1:3306/test?jdbcCompliantTruncation=false&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;autoConnect=true" />
        	    <property name="username" value="root" />
        	    <property name="password" value="123456" />
        	</bean>
      
          <bean id="jdbcDataSource" class="com.web.dao.impl.JdbcDataSourceImpl" scope="singleton">
               <property name="dataSource" ref="dataSource"/>
          </bean>
          
3.使用spring jdbc 操作数据源

     public interface BasicDataSource{}//自定义操作方法
     
     public class JdbcDataSourceImpl implements BasicDataSource{
      	
      	 private JdbcTemplate jdbcTemplate;
      	 
      	 public void setDataSource(DataSource dataSource) {
      	      this.jdbcTemplate = new JdbcTemplate(dataSource);
      	 }
      	 
      }
          
4.applicationContext-dao.xml 配置调用数据源   

    <bean id="userDao" class="com.web.dao.impl.UserDaoImpl" scope="prototype">
       <property name="dataSource" ref="jdbcDataSource"></property>
    </bean>

5.实现类调用数据源

      public class UserDaoImpl implements UserDao {
      
      	private BasicDataSource dataSource;
      
      	public BasicDataSource getDataSource() {
      		return dataSource;
      	}
      
      	public void setDataSource(BasicDataSource dataSource) {
      		this.dataSource = dataSource;
      	}
      	
      }

6.bean.xml 配置文件中的  scope="prototype/singleton"   
singleton:类的实例只被创建一次  
![Aaron Swartz](https://github.com/ittarvin/snow-ball/blob/master/spring-mvc/src/main/webapp/images/singleton.png?raw=true)   
prototype:类被调用是都会产生一个新的实例
![Aaron Swartz](https://github.com/ittarvin/snow-ball/blob/master/spring-mvc/src/main/webapp/images/prototype.png?raw=true)   









