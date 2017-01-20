package com.base.system.services.plat.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.system.dao.plat.EmployeeDao;
import com.base.system.entity.TEmployee;
import com.base.system.entity.pojo.Page;
import com.base.system.services.plat.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Resource
	private EmployeeDao employeeDao;

	@Override
	public int saveOrUpdateEmployee(TEmployee employee) {
		// TODO Auto-generated method stub
		return employeeDao.saveOrUpdateEmployee(employee);
	}

	@Override
	public TEmployee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public List<Map<String, Object>> listEmployeeByPage(Page page) {
		// TODO Auto-generated method stub
		return employeeDao.listEmployeeByPage(page);
	}

	@Override
	public TEmployee checkOnlyByPhone(String phone) {
		// TODO Auto-generated method stub
		return employeeDao.checkOnlyByPhone(phone);
	}

	@Override
	public TEmployee checkOnlyByName(String account) {
		// TODO Auto-generated method stub
		return employeeDao.checkOnlyByName(account);
	}

	@Override
	public int getTotalCountEmployee(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return employeeDao.getTotalCountEmployee(map);
	}

	@Override
	public List<Map<String, Object>> listEmployeeByRoleCode(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return employeeDao.listEmployeeByRoleCode(map);
	}

}
