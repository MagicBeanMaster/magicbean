package com.base.system.services.plat.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.system.dao.plat.TPlatResourceDao;
import com.base.system.dao.plat.TPlatRolesDao;
import com.base.system.entity.plat.TPlatAccountroles;
import com.base.system.entity.plat.TPlatRoles;
import com.base.system.services.plat.PlatRolesService;
import com.base.utils.DateUtils;

@Service("platRolesService")
public class PlatRolesServiceImpl implements PlatRolesService {

	@Resource
	private TPlatRolesDao tPlatRolesDao;
	@Resource
	private TPlatResourceDao tPlatResourceDao;
	

	@Override
	@Transactional
	public void saveorUpdate(TPlatRoles platRoles,List<String> reslist ) {
		
//		List<String> reslist = new ArrayList<String>();
//		if(StringUtils.isNotEmpty(resourceids)){
//			String[] strs = resourceids.split(",");
//			for (String s : strs) {
//				if(!"0".equals(s))
//					reslist.add(s);
//			}
//		}
		if(platRoles.getId() != null){
			int rid = platRoles.getId();
			TPlatRoles old = tPlatRolesDao.getPro(rid);
			old.setRolesname(platRoles.getRolesname());
			old.setRemark(platRoles.getRemark());
			tPlatRolesDao.saveorUpdate(old);
			tPlatResourceDao.delRolesResouce(rid);
			tPlatResourceDao.saveRolesResouce(rid, reslist);
		}else{
			platRoles.setStatus(0);
			platRoles.setCreatetime(DateUtils.getTimestamp());
			int rolesid = tPlatRolesDao.saveorUpdate(platRoles);
			tPlatResourceDao.saveRolesResouce(rolesid, reslist);
		}
		

	}

	@Override
	@Transactional
	public int del(int id) {
		tPlatResourceDao.delRolesResouce(id);
		return tPlatRolesDao.del(id);
	}

	@Override
	@Transactional
	public int saveAccountRoles(int accountid, int rolesid) {
		this.delAccountRoles(accountid);
		return tPlatRolesDao.saveAccountRoles(accountid, rolesid);
	}

	@Override
	public int delAccountRoles(int accountid) {
		return tPlatRolesDao.delAccountRoles(accountid);
	}

	@Override
	public TPlatRoles getPro(int id) {
		return tPlatRolesDao.getPro(id);
	}

	@Override
	public TPlatRoles getRolesByAccountId(String accountid) {
		return tPlatRolesDao.getRolesByAccountId(accountid);
	}

	@Override
	public List<Map<String, Object>> getList(Map<String, Object> map) throws Exception {
		return tPlatRolesDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return tPlatRolesDao.getCount(map);
	}

	@Override
	public int valRoles(String rolesname, String rid) {
		int result = 0;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(rid) && !"0".equals(rid)){
			paramMap.put("id", rid);
			paramMap.put("rolesname", rolesname);
			int temp = tPlatRolesDao.getCount(paramMap);
			if(temp == 1)
				return result;
			else{
				paramMap.clear();
				paramMap.put("rolesname", rolesname);
				result = tPlatRolesDao.getCount(paramMap);
			}
		}else{
			paramMap.put("rolesname", rolesname);
			result = tPlatRolesDao.getCount(paramMap);
		}
		return result;
	}

	@Override
	public List<TPlatRoles> getRolesList() {
		return tPlatRolesDao.getRolesList();
	}

	@Override
	public TPlatAccountroles getAccountRoles(int accountid) {
		return tPlatRolesDao.getAccountRoles(accountid);
	}

}
