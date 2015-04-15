package com.web.service.impl;

import java.util.List;
import java.util.Map;

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

	public List<Map<String, Object>> getSysUser(String email, String password) {
		String sql = "select email from sysuser where email='"+email+"' and password = '"+password+"'";
		return userDao.getSysUser(sql);
	}

	public int getSysUserCount() {
		String sql = "select count(*) from sysuser";
		return userDao.queryForInt(sql);
	}
	
}
