package com.base.system.dao.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.TSysOperterLogs;

/**
 * 
 * @description 操作日志Dao 
 * @author lq
 * @date 2016年1月4日 下午6:41:22 
 * @version
 */
public interface TSysOperterLogsDao {

	/**
	 * 
	 * @description 保存操作日志
	 * @param operlogs
	 * @return
	 * @date 2016年1月4日 下午6:43:46
	 */
	public int save(TSysOperterLogs operlogs);
	
	/**
	 * 
	 * @description 批量保存操作日志信息 
	 * @param list 操作日志实体列表
	 * @return
	 * @author lq
	 * @date 2016年5月23日 下午12:59:57
	 */
	public int betchSave(List<TSysOperterLogs> list);
	/**
	 * 
	 * @description 批量保存日志信息 
	 * @param list
	 * @date 2016年1月7日 上午11:10:21
	 */
	public void batchSave(int appid,List<String> list);
	
	/**
	 * 
	 * @description 操作日志列表 
	 * @param map
	 * @return
	 * @date 2016年1月4日 上午11:46:44
	 */
	public List<Map<String,Object>> getOperterLogsList(Map<String,Object> map);
	
	/**
	 * 
	 * @description 操作日志统计 
	 * @param map
	 * @return
	 * @date 2016年1月4日 上午11:46:53
	 */
	public int countOperterLogs(Map<String,Object> map);
}
