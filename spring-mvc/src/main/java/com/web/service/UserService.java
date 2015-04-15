package com.web.service;

public interface UserService {

	public int getUserCount();

	public int addUser(String name, int age);

	public Boolean createCollection(String name);
}
