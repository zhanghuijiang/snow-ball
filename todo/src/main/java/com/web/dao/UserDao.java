package com.web.dao;

import java.util.List;
import java.util.Map;

public interface UserDao{

	public List<Map<String, Object>> getSysUser(String sql);

	public int queryForInt(String sql);
	
}
