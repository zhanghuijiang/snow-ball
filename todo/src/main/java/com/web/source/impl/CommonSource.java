package com.web.source.impl;


import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.web.source.Source;

public class CommonSource implements Source{
	
	 private JdbcTemplate jdbcTemplate;
	 
	 public void setDataSource(DataSource dataSource) {
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	 
	 public List<Map<String, Object>> queryForMapBySql(String sql){
		 return jdbcTemplate.queryForList(sql);
	 };
	 
	 public int queryForIntBySql(String sql){
		 return jdbcTemplate.queryForInt(sql);
	 }
	 
}
