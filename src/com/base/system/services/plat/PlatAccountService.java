package com.base.system.services.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.plat.TPlatAccount;

public interface PlatAccountService {
	
	/**
	 * 
	 * @description 保存账号信息 
	 * @param plataccount
	 * @date 2016年2月14日 下午5:21:42
	 */
	public void saveorUpdate(TPlatAccount plataccount) throws Exception;
	
	/**
	 * 
	 * @description 删除账号 
	 * @param id 员工id
	 * @return
	 * @date 2016年2月14日 下午5:21:49
	 */
	public int del(int id);
	
	/**
	 * 
	 * @description 获取账号信息 
	 * @param id
	 * @return
	 * @date 2016年2月14日 下午5:22:04
	 */
	public TPlatAccount getPro(int id);
	
	/**
	 * 
	 * @description  获取账号信息 
	 * @param account 帐号
	 * @param pwd 密码
	 * @return
	 * @date 2016年7月9日 上午10:58:08
	 */
	public TPlatAccount getPro(String account,String pwd);
	
	/**
	 * 
	 * @description 获取账号信息 
	 * @param empId 员工id
	 * @return
	 * @date 2016年7月9日 上午10:58:25
	 */
	public TPlatAccount getProByEmpId(Integer empId);
	
	/**
	 * 
	 * @description 账号列信息 
	 * @param map
	 * @return
	 * @throws Exception
	 * @date 2016年2月14日 下午5:22:44
	 */
	public List<Map<String, Object>> getList(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * @description 列表信息统计 
	 * @param map
	 * @return
	 * @date 2016年2月19日 上午10:56:54
	 */
	public int getlistCount(Map<String, Object> map);
	
	/**
	 * 
	 * @description 统计账号信息条数 
	 * @param map
	 * @return
	 * @date 2016年2月14日 下午5:24:35
	 */
	public int getCount(Map<String, Object> map);
	/**
	 * 
	 * @description 验证账号的唯一性 
	 * @param account
	 * @param id
	 * @return
	 * @date 2016年2月16日 下午3:58:00
	 */
	public int valAccount(String account,String id);
	
	
	/**
	 * 
	 * @description 验证账号名是否存在 
	 * @param account 账号
	 * @return
	 * @date 2016年3月22日 上午9:58:34
	 */
	public TPlatAccount isCheckAccount(String account);
	
	/**
	 * 
	 * @description 通过员工id获取帐号角色信息
	 * @param empid 员工id
	 * @return
	 * @date 2016年7月6日 下午2:34:41
	 */
	public Map<String,Object> getAccountAndRoleByEmpid(Integer empid);

	/**
	 * 
	 * @description 查询账号是否被使用
	 * @param account 账号
	 * @return
	 * @date 2016年7月9日 上午10:58:44
	 */
	public int CountCheckAccount(String account);
	
}
