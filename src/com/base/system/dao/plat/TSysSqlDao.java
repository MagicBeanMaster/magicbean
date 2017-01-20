package com.base.system.dao.plat;

import java.util.List;
import java.util.Map;

/**
 * 
 * 需优化的sql Dao
 * @author Administrator
 *
 */
public interface TSysSqlDao {
	
	/**
	 * sql列表
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> getSqlsList(Map<String,Object> map);
	
	/**
	 * 统计数
	 * @param map
	 * @return
	 */
	public int countSqlsLogs(Map<String,Object> map);
	
	
}
