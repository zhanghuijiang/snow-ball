package com.web.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.web.dao.BasicDataSource;



/**
 * Spring JDBC 实现数据操作
 * @author arvin
 */
public class JdbcDataSourceImpl implements BasicDataSource{
	
	 private JdbcTemplate jdbcTemplate;
	 
	 public void setDataSource(DataSource dataSource) {
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }

	 public int queryForInt(String sql) {
		return jdbcTemplate.queryForInt(sql);
	 }

	public int update(String sql,Object...args) {
		return jdbcTemplate.update(sql, args);
	}
	 
}
