package com.base.system.dao.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.TSysLoginLogs;

/**
 * 
 * @description 登录操作日志Dao 
 * @author lq
 * @date 2016年1月4日 上午11:46:06 
 * @version
 */
public interface TSysLoginLogsDao {
	
	/**
	 * 
	 * @description 用户登录
	 * @param loginLogs
	 * @return
	 * @date 2016年1月4日 上午11:46:21
	 */
	public int save(TSysLoginLogs loginLogs);
	
	/**
	 * 
	 * @description 用户退出登录 
	 * @param account 账号
	 * @param sessId sessionId
	 * @return
	 * @date 2016年1月4日 上午11:46:29
	 */
	public int update(String account,String sessId,String remark);
	
	/**
	 * 
	 * @description 登录日志列表 
	 * @param map
	 * @return
	 * @date 2016年1月4日 上午11:46:44
	 */
	public List<Map<String,Object>> getLoginLogsList(Map<String,Object> map);
	
	/**
	 * 
	 * @description 统计登录日志条数 
	 * @param map
	 * @return
	 * @date 2016年1月4日 上午11:46:53
	 */
	public int countLoginLogs(Map<String,Object> map);
	
	/**
	 * 
	 * @description 通过帐号清空登录日志
	 * @param ac 帐号
	 * @return
	 * @date 2016年7月9日 上午11:03:32
	 */
	public int cl(String ac);
}
