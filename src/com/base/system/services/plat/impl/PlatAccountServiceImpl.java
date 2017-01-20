package com.base.system.services.plat.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.system.dao.plat.TPlatAccountDao;
import com.base.system.entity.plat.TPlatAccount;
import com.base.system.services.plat.PlatAccountService;
import com.base.utils.DateUtils;

@Service("platAccountService")
public class PlatAccountServiceImpl implements PlatAccountService {

	@Resource
	private TPlatAccountDao tPlatAccountDao;
	
	@Override
	@Transactional
	public void saveorUpdate(TPlatAccount plataccount) throws Exception {
		if(plataccount.getId() != null){
			String p = plataccount.getPwd();
			TPlatAccount old = tPlatAccountDao.getPro(plataccount.getId());
			old.setAccount(plataccount.getAccount());
			if(StringUtils.isNotEmpty(p) && !p.equals(old.getPwd())){
				old.setPwd(plataccount.getPwd());
			}
			old.setType(plataccount.getType());
			old.setName(plataccount.getName());
			plataccount = old;
			old = null;
			
		}else{
			plataccount.setCreatetime(DateUtils.getTimestamp());
		}
		tPlatAccountDao.saveorUpdate(plataccount);
	}

	@Override
	public int del(int id) {
		return tPlatAccountDao.del(id);
	}

	@Override
	public TPlatAccount getPro(int id) {
		return tPlatAccountDao.getPro(id);
	}

	@Override
	public TPlatAccount getPro(String account, String pwd) {

		return tPlatAccountDao.getPro(account, pwd);
	}

	@Override
	public List<Map<String, Object>> getList(Map<String, Object> map) throws Exception {
		return tPlatAccountDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return tPlatAccountDao.getCount(map);
	}

	@Override
	public int getlistCount(Map<String, Object> map) {
		return tPlatAccountDao.getlistCount(map);
	}

	@Override
	public int valAccount(String account, String id) {
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(id) && !"0".equals(id)){
			map.put("account", account);
			map.put("id", id);
			int temp = tPlatAccountDao.getCount(map);
			if(temp == 1)
				return result;
			else{
				map.clear();
				map.put("account", account);
				result = tPlatAccountDao.getCount(map);
			}
			
		}
		
		return result;
	}

	@Override
	public TPlatAccount isCheckAccount(String account) {
		// TODO Auto-generated method stub
		return tPlatAccountDao.getProByAccount(account);
	}

	@Override
	public TPlatAccount getProByEmpId(Integer empId) {
		// TODO Auto-generated method stub
		return tPlatAccountDao.getProByEmpId(empId);
	}

	@Override
	public Map<String, Object> getAccountAndRoleByEmpid(Integer empid) {
		// TODO Auto-generated method stub
		return tPlatAccountDao.getAccountAndRoleByEmpid(empid);
	}

	@Override
	public int CountCheckAccount(String account) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("account", account);
		return tPlatAccountDao.getCount(map);
		
	}

}
