package com.base.system.services.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.TSysOperterLogs;

/**
 * 
 * @description 操作日志Service
 * @author lq
 * @date 2016年1月4日 下午6:46:11 
 * @version
 */
public interface TSysOperterLogsService {
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
	 * @description 批量保存日志信息 
	 * @param list
	 * @date 2016年1月7日 上午11:10:21
	 */
	public int batchSave(List<TSysOperterLogs> list);
	
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
