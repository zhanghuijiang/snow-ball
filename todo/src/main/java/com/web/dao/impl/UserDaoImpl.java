package com.web.dao.impl;

import java.util.List;
import java.util.Map;

import com.web.dao.UserDao;
import com.web.source.Source;

public class UserDaoImpl implements UserDao {
	
	private Source source;

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public List<Map<String, Object>> getSysUser(String sql) {
		return source.queryForMapBySql(sql);
	}

	public int queryForInt(String sql) {
		return source.queryForIntBySql(sql);
	}
	
}
