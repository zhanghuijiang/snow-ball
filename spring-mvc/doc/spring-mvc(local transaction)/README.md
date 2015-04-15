## Spring MVC ~ Local Transaction   

1.applicationContext-dataSource.xml 配置   

          <!-- local transaction implementation  begin -->
          <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
              <property name="dataSource" ref="dataSource"/>
          </bean>
      
          <tx:advice id="txAdvice" transaction-manager="txManager">
              <!-- the transactional semantics... -->
              <tx:attributes>
                  <!-- all methods starting with 'get' are read-only -->
                  <tx:method name="get*" read-only="true"/>
                  <!-- other methods use the default transaction settings (see below) -->
                  <tx:method name="*"/>
              </tx:attributes>
          </tx:advice>
          
          <aop:config>
              <aop:pointcut id="serviceOperation" expression="execution(* com.web.service.*.*(..))"/>
              <aop:advisor advice-ref="txAdvice" pointcut-ref="serviceOperation"/>
          </aop:config>
          
          <!-- local transaction implementation  end -->
          
2.实现事务效果在 com.web.service.impl 包下的实现类中的任何非get方法中，保存数据之后添加代码。  
 
           throw new NullPointerException();
          


