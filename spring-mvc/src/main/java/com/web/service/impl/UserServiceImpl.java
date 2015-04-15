package com.web.service.impl;

import com.web.dao.UserDao;
import com.web.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public int getUserCount(){
		return userDao.getUserCount();
	}

	public int addUser(String name, int age) {
		return userDao.addUser(name,age);
	}

	public Boolean createCollection(String name){
		return userDao.createCollection(name);
	}

	
}
