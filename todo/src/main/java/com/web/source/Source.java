package com.web.source;

import java.util.List;
import java.util.Map;

/**
 * 数据源接口 
 * 设计模式：接口的适配器模式
 * @author arvin
 */
public interface Source {
	public List<Map<String, Object>> queryForMapBySql(String sql);
	public int queryForIntBySql(String sql);
}
