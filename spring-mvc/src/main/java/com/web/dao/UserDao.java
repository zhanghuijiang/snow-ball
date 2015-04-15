package com.web.dao;

public interface UserDao{

	public int getUserCount();

	public int addUser(String name, int age);

	public Boolean createCollection(String name);

}
