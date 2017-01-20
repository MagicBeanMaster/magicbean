package com.base.system.services.plat;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.base.system.entity.TEmployee;
import com.base.system.entity.pojo.Page;

public interface EmployeeService {
	/**
	 * 
	 * @description 添加或者修改员工信息 
	 * @param employee 要添加的员工信息
	 * @return 返回执行结果
	 * @date 2015年11月12日 下午5:01:50
	 */
	public int saveOrUpdateEmployee(TEmployee employee);
	
	/**
	 * 
	 * @description 根据员工ID获取到员工信息 
	 * @param id 要获取的员工ID
	 * @return 返回查询到的员工信息
	 * @date 2015年11月12日 下午5:38:51
	 */
	public TEmployee getEmployeeById(int id);

	/**
	 * 
	 * @description  获取员工列表信息（分页）
	 * @param map 查询条件
	 * @return 返回查询到的list
	 * @date 2015年11月13日 下午2:57:43
	 */
	public List<Map<String, Object>> listEmployeeByPage(Page page) ;
	
	
	/**
	 * 
	 * @description  根据联系电话来检查唯一
	 * @param phone 电话
	 * @return 
	 * @date 2015年11月16日 上午9:57:57
	 */
	public TEmployee checkOnlyByPhone(String phone);
	
	/**
	 * 
	 * @description 根据账号检查唯一
	 * @param name 账号
	 * @return
	 * @date 2015年11月16日 下午7:05:40
	 */
	public TEmployee checkOnlyByName(String account);
	
	/**
	 * 
	 * @description 根据条件获取员工数据总数
	 * @param map 查询条件
	 * @return
	 * @date 2015年11月24日 下午2:57:50
	 */
	public int getTotalCountEmployee(Map<String, Object> map);
	
	
	/**
	 * 
	 * @description 根据条件模糊查询员工列表
	 * @param name 员工姓名
	 * @return
	 * @date 2016年1月13日 上午11:31:33
	 */
	public List<Map<String, Object>> listEmployeeByRoleCode(Map<String, Object> map);

	
}
