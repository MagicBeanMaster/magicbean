package com.base.system.services.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.plat.TPlatResource;

public interface PlatResourceService {
	
	/**
	 * 
	 * @description 保存资源信息 
	 * @param res
	 * @date 2016年2月14日 下午5:13:24
	 */
	public void saveorUpdate(TPlatResource res) throws Exception;
	
	/**
	 * 
	 * @description 删除资源信息 
	 * @param id
	 * @return
	 * @date 2016年2月14日 下午5:13:32
	 */
	public int del(int id);
	
	/**
	 * 
	 * @description 保存角色资源 
	 * @param roleid 角色ID
	 * @param reslist 资源列表
	 * @date 2016年2月14日 下午5:15:54
	 */
	public void saveRolesResouce(int roleid,List<String> reslist);
	
	/**
	 * 
	 * @description 删除角色资源信息 
	 * @param roleid
	 * @return
	 * @date 2016年2月14日 下午5:16:31
	 */
	public int delRolesResouce(int roleid);
	
	/**
	 * 
	 * @description 获取资源信息 
	 * @param id
	 * @return
	 * @date 2016年2月14日 下午5:13:39
	 */
	public TPlatResource getPro(int id);
	
	public List<TPlatResource> getProList(int type);
	
	/**
	 * 
	 * @description 获取用户资源 
	 * @param accountid
	 * @return
	 * @date 2016年2月17日 上午11:04:14
	 */
	public List<TPlatResource> getAccountResource(String accountid);
	
	
	/**
	 * 
	 * @description 获取资源信息列表 
	 * @param map
	 * @return
	 * @throws Exception
	 * @date 2016年2月14日 下午5:13:48
	 */
	public List<Map<String, Object>> getList(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * @description 统计资源信息列表数据 
	 * @param map
	 * @return
	 * @date 2016年2月14日 下午5:13:57
	 */
	public int getCount(Map<String, Object> map);
	
	/**
	 * 
	 * @description 通过资源类型和资源id获取下级资源
	 * @param map
	 * @return
	 * @date 2016年7月9日 上午10:59:44
	 */
	public List<Map<String, Object>> getAllListTree(Map<String, Object> map);
	
	/**
	 * 
	 * @description 更加角色获取角色所对应的资源id 
	 * @param rolesid
	 * @return
	 * @date 2016年2月16日 下午2:13:57
	 */
	public List<Integer> getRolesResouces(String rolesid);
}
