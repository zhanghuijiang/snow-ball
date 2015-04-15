package com.web.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.web.dao.MongoDataSource;

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
