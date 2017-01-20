package com.base.system.dao.plat.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.constant.Constant;
import com.base.system.dao.plat.EmployeeDao;
import com.base.system.entity.TEmployee;
import com.base.system.entity.pojo.Page;
import com.booty.sys.dao.BaseDao;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{

	@Resource
	private BaseDao baseDaoPackage;
	
	
	@Override
	public int saveOrUpdateEmployee(TEmployee employee) {
		return baseDaoPackage.saveOrUpdateObj(employee);
	}

	@Override
	public TEmployee getEmployeeById(int id) {
		String sql = "select * from t_employee where id=? ";
		List<Object> parameterLists = new ArrayList<Object>();
		parameterLists.add(id);
		return baseDaoPackage.queryForObject(sql, parameterLists, TEmployee.class);
	}

	@Override
	public List<Map<String, Object>> listEmployeeByPage(Page page) {
		StringBuilder sql = new StringBuilder("select * from t_employee where 1 = 1 ");
		List<Object> list = new ArrayList<Object>();
		Map<String, Object> map = page.getParamsMap();
		sql = dealSQLSplice(sql, list, map);
		sql.append(" order by updatetime desc ");
		Object startIndex = page.getStartIndex();
		Object pageSize = page.getPageSize();
		if (startIndex != null  && pageSize != null ) {
			sql.append(" limit ?,? ");
			list.add(startIndex);
			list.add(pageSize);
		}
		return baseDaoPackage.queryForList(sql.toString(), list);
	}

	
	@Override
	public TEmployee checkOnlyByPhone(String phone) {
		String sql = "select * from t_employee where phone=? and status=1 ";
		List<Object> parameterLists = new ArrayList<Object>();
		parameterLists.add(phone);
		return baseDaoPackage.queryForObject(sql, parameterLists, TEmployee.class);
	}

	@Override
	public TEmployee checkOnlyByName(String account) {
		String sql = "select * from t_employee where account=? and status=1 ";
		List<Object> parameterLists = new ArrayList<Object>();
		parameterLists.add(account);
		return baseDaoPackage.queryForObject(sql, parameterLists, TEmployee.class);
	}

	@Override
	public int getTotalCountEmployee(Map<String, Object> map) {
		StringBuilder sql = new StringBuilder("select count(1) from t_employee where 1 = 1 ");
		List<Object> list = new ArrayList<Object>();
		sql = dealSQLSplice(sql, list, map);
		return baseDaoPackage.queryForInt(sql.toString(), list);
	}

	

	
	
	
	@Override
	public List<Map<String, Object>> listEmployeeByRoleCode(Map<String, Object> map) {
		String sql = "SELECT te.id,te.`name`,te.phone,(SELECT dic.`description` FROM t_configuration dic WHERE dic.id = te.sex) sexname,te.job FROM t_employee te WHERE  te.status = 1 ";
		List<Object> list = new ArrayList<Object>();
		Object name = map.get("name");
		if(name != null){ 
			sql += " AND te.`name` LIKE ? ";
			list.add("%"+map.get("name")+"%");
		}
		
		// 有权限的业务员
		Object rolesEmpid = map.get("rolesEmpid");
		if (rolesEmpid != null && StringUtils.isNotEmpty(rolesEmpid.toString())
				&& StringUtils.isNotBlank(rolesEmpid.toString())) {
			sql += " and te.id in (" + rolesEmpid + ") ";
		}
		return baseDaoPackage.queryForList(sql, list);
	}

	
	/**
	 * 拼接
	 */
	public StringBuilder dealSQLSplice(StringBuilder sql,List<Object> list,Map<String, Object> map){
		// 员工名称
		Object name = map.get("name");
		if (name != null) {
			sql.append(" and name like ? ");
			list.add("%" + name + "%");
		}
		// 员工联系方式
		Object phone = map.get("phone");
		if (phone != null) {
			sql.append(" and phone like ? ");
			list.add("%" + phone + "%");
		}
		return sql;
	}

	
}
