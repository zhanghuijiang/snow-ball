package com.web.service;

import java.util.List;
import java.util.Map;

public interface UserService {

	/**
	 * 获取用户信息
	 * @param email
	 * @param password
	 * @return
	 */
	public List<Map<String, Object>> getSysUser(String email, String password);

	/**
	 * 获取用户数量
	 * @return
	 */
	public int getSysUserCount();

}
