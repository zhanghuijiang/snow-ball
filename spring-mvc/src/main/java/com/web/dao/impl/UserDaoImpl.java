package com.web.dao.impl;

import com.web.dao.BasicDataSource;
import com.web.dao.MongoDataSource;
import com.web.dao.UserDao;

public class UserDaoImpl implements UserDao {

	private BasicDataSource dataSource;
	private MongoDataSource mongoDataSource;
	
	public BasicDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public MongoDataSource getMongoDataSource() {
		return mongoDataSource;
	}

	public void setMongoDataSource(MongoDataSource mongoDataSource) {
		this.mongoDataSource = mongoDataSource;
	}

	public int getUserCount() {
		String sql = "select count(*) from user";
		return dataSource.queryForInt(sql);
	}
	
	public int addUser(String name, int age) {
		String sql = "insert into user (name, age) values (?, ?)";
		return dataSource.update(sql,name,age);
	}

	public Boolean createCollection(String name){
		return mongoDataSource.createCollection(name);
	}
    
	
}
