package com.base.system.dao.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.plat.TPlatAccount;

/**
 * 
 * @description 账号Dao 
 * @author lq
 * @date 2016年2月14日 下午5:21:34 
 * @version
 */
public interface TPlatAccountDao {

	/**
	 * 
	 * @description 保存账号信息 
	 * @param plataccount
	 * @date 2016年2月14日 下午5:21:42
	 */
	public void saveorUpdate(TPlatAccount plataccount);
	
	/**
	 * 
	 * @description 删除账号 
	 * @param id
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
	 * @description 获取所有帐号
	 * @return
	 * @date 2016年7月9日 上午11:02:12
	 */
	public List<String> getAccountlist();

	/**
	 * 
	 * @description 通过员工id获取帐号信息 
	 * @param empId 员工id
	 * @return
	 * @date 2016年7月9日 上午11:02:25
	 */
	public TPlatAccount getProByEmpId(Integer empId);

	/**
	 * 
	 * @description 通过员工id获取帐号角色信息
	 * @param empid 员工id
	 * @return
	 * @date 2016年7月6日 下午2:34:41
	 */
	public Map<String, Object> getAccountAndRoleByEmpid(Integer empid);
	/**
	 * 
	 * @description 获取帐号信息
	 * @param account
	 * @return
	 * @date 2016年7月6日 下午3:31:31
	 */
	public TPlatAccount getProByAccount(String account);
	
}
