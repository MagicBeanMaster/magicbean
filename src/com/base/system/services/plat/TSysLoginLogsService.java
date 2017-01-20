package com.base.system.services.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.TSysLoginLogs;

/**
 * 
 * @description 登录操作日志Service 
 * @author lq
 * @date 2016年1月4日 上午11:46:06 
 * @version
 */
public interface TSysLoginLogsService {
	
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
	 * @description 删除登录日志
	 * @param ac 账号
	 * @return
	 * @date 2016年7月9日 上午11:01:09
	 */
	public int cl(String ac);
}
