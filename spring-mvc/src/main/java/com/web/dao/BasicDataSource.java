package com.web.dao;



/**
 * 基础数据源
 * @author arvin
 */
public interface BasicDataSource{
	
	public int queryForInt(String sql);

	public int update(String sql,Object...args);
	
}
