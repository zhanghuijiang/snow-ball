##Spring MVC ~ Mongodb   

1.pom.xml 配置jar

      <!-- spring framwork MongoDb begin -->
    	  <dependency>
    			<groupId>org.springframework.data</groupId>
    			<artifactId>spring-data-jpa</artifactId>
    			<version>1.4.1.RELEASE</version>
    	  </dependency>
    	  <dependency>
    		<groupId>org.springframework.data</groupId>
    		<artifactId>spring-data-mongodb</artifactId>
    		<version>1.2.1.RELEASE</version><!--注意版本，哈哈-->
          </dependency>
          <dependency>
    		<groupId>org.springframework</groupId>
    		<artifactId>spring-tx</artifactId>
    		<version>3.1.0.RELEASE</version>
          </dependency>
          <!-- spring framwork MongoDb end -->
          
      
2.applicationContext-dataSource.xml 配置数据源

      <!-- spring framwork MongoDb begin -->
          <mongo:mongo id="mongo" host="127.0.0.1" port="27017">
            <mongo:options connections-per-host="8"
                         threads-allowed-to-block-for-connection-multiplier="4"
                         connect-timeout="1000"
                         max-wait-time="1500"
                         auto-connect-retry="true"
                         socket-keep-alive="true"
                         socket-timeout="1500"
                         slave-ok="true"
                         write-number="1"
                         write-timeout="0"
                         write-fsync="true"/>
          </mongo:mongo>
          
          <mongo:db-factory dbname="javaweb" mongo-ref="mongo"/>
          
          <bean id="anotherMongoTemplate" class="org.springframework.data.mongodb.core.MongoTemplate">
            <constructor-arg name="mongoDbFactory" ref="mongoDbFactory"/>
          </bean>
      
          <bean id="mongoDataSource" class="com.web.dao.impl.MongoDataSourceImpl" scope="singleton">
              <property name="mongoTemplate" ref="anotherMongoTemplate"/>
          </bean>
         <!-- spring framwork MongoDb end -->
         

3.dao 实现类 MongoDataSourceImpl

      public class MongoDataSourceImpl implements MongoDataSource{
      
      	private  MongoTemplate  mongoTemplate;
      
      	public MongoTemplate getMongoTemplate() {
      		return mongoTemplate;
      	}
      
      
      	public void setMongoTemplate(MongoTemplate mongoTemplate) {
      		this.mongoTemplate = mongoTemplate;
      	}
      	
      	
      	public boolean createCollection(String name){
      		mongoTemplate.createCollection(name);
      		return mongoTemplate.collectionExists(name);
      	}
      	
      }

