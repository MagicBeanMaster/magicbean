package com.base.system.dao.plat;
import java.util.List;
import java.util.Map;

import com.base.system.entity.plat.TPlatAccountroles;
import com.base.system.entity.plat.TPlatRoles;

public interface TPlatRolesDao {

	/**
	 * 
	 * @description 保存角色 
	 * @param platRoles
	 * @date 2016年2月14日 下午5:07:42
	 */
	public int saveorUpdate(TPlatRoles platRoles);
	
	/**
	 * 
	 * @description 删除角色 
	 * @param id
	 * @return
	 * @date 2016年2月14日 下午5:07:50
	 */
	public int del(int id);
	
	/**
	 * 
	 * @description 保存用户角色关系 
	 * @param accountid 账号ID
	 * @param rolesid 角色ID
	 * @return
	 * @date 2016年2月14日 下午5:07:57
	 */
	public int saveAccountRoles(int accountid,int rolesid);
	
	/**
	 * 
	 * @description 删除用户角色 
	 * @param accountid 用户ID
	 * @return
	 * @date 2016年2月14日 下午5:08:20
	 */
	public int delAccountRoles(int accountid);
	
	/**
	 * 
	 * @description 获取角色信息 
	 * @param id 角色ID
	 * @return
	 * @date 2016年2月14日 下午5:08:35
	 */
	public TPlatRoles getPro(int id);
	
	
	/**
	 * 
	 * @description 获取账号角色 
	 * @param accountid
	 * @return
	 * @date 2016年2月18日 上午11:13:15
	 */
	public TPlatRoles getRolesByAccountId(String accountid);
	
	/**
	 * 
	 * @description 角色列表 
	 * @param map
	 * @return
	 * @throws Exception
	 * @date 2016年2月14日 下午5:08:47
	 */
	public List<Map<String, Object>> getList(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * @description 列表数据统计 
	 * @param map
	 * @return
	 * @date 2016年2月14日 下午5:08:55
	 */
	public int getCount(Map<String, Object> map);
	
	
	/**
	 * 
	 * @description 角色列表 
	 * @return
	 * @date 2016年2月16日 下午6:16:45
	 */
	public List<TPlatRoles> getRolesList();
	
	/**
	 * 
	 * @description  获取账号的角色管理
	 * @param accountid
	 * @return
	 * @date 2016年2月16日 下午6:46:19
	 */
	public TPlatAccountroles getAccountRoles(int accountid);
}
