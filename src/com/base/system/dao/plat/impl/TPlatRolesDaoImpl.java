package com.base.system.dao.plat.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.system.dao.plat.TPlatRolesDao;
import com.base.system.entity.plat.TPlatAccountroles;
import com.base.system.entity.plat.TPlatRoles;
import com.booty.sys.dao.BaseDao;

@Repository("tPlatRoles")
public class TPlatRolesDaoImpl implements TPlatRolesDao {
	@Resource
	private BaseDao baseDaoPackage;

	@Override
	public int saveorUpdate(TPlatRoles platRoles) {
		
		return baseDaoPackage.saveOrUpdateObj(platRoles);
		
	}

	@Override
	public int del(int id) {
		String sql = "update t_plat_roles set status=-1 where id = "+id;
		return baseDaoPackage.batchUpdate(sql);
	}

	@Override
	public int saveAccountRoles(int accountid, int rolesid) {
		String sql = "insert into t_plat_accountroles(accountid,roleid) value("+accountid+","+rolesid+")";
		return baseDaoPackage.batchUpdate(sql);
	}

	@Override
	public int delAccountRoles(int accountid) {
		String sql = "delete from t_plat_accountroles where accountid="+accountid;
		return baseDaoPackage.batchUpdate(sql);
	}

	@Override
	public TPlatRoles getPro(int id) {
		String sql = "select * from t_plat_roles where id = " + id;
		List<Object> list = new ArrayList<Object>();
		return baseDaoPackage.queryForObject(sql, list, TPlatRoles.class);
	}

	@Override
	public TPlatRoles getRolesByAccountId(String accountid) {
		String sql = "select b.* from t_plat_accountroles a left join t_plat_roles b on a.roleid = b.id where a.accountid= ?";
		List<Object> list = new ArrayList<Object>();
		list.add(accountid);
		
		return baseDaoPackage.queryForObject(sql, list, TPlatRoles.class);
	}

	@Override
	public List<Map<String, Object>> getList(Map<String, Object> paramMap) throws Exception {
		String preSql = "select * from t_plat_roles where status>=0 ";
		List<Object> list = new ArrayList<Object>();
		String keys = ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql += " and rolesname like ?";
			list.add("%"+keys+"%");
		}
		
		String startIndex= ConvertUtils.convert(paramMap.get("startIndex"));
		String pageSize= ConvertUtils.convert(paramMap.get("pageSize"));
		if (StringUtils.isNotEmpty(pageSize) && StringUtils.isNotEmpty(startIndex)) {
			preSql += " limit ?,?";
			list.add(Integer.valueOf(startIndex.toString()));
			list.add(Integer.valueOf(pageSize.toString()));
		}
		return baseDaoPackage.queryForList(preSql, list);
	}

	@Override
	public int getCount(Map<String, Object> paramMap) {
		String preSql = "select count(1) from t_plat_roles where status>=0";
		List<Object> list = new ArrayList<Object>();
		String id = ConvertUtils.convert(paramMap.get("id"));
		if(StringUtils.isNotEmpty(id)){
			preSql +=" and id = ?";
			list.add(id);
		}
		String keys = ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql += " and rolesname like ?";
			list.add("%"+keys+"%");
		}
		String rolesname = ConvertUtils.convert(paramMap.get("rolesname"));
		if(StringUtils.isNotEmpty(rolesname)){
			preSql +=" and rolesname = ?";
			list.add(rolesname);
		}
		
		return baseDaoPackage.queryForInt(preSql, list);
	}

	@Override
	public List<TPlatRoles> getRolesList() {
		String preSql = "select * from t_plat_roles where status>=0 ";
		List<Object> list = new ArrayList<Object>();
		
		return baseDaoPackage.queryForList(preSql, list, TPlatRoles.class);
	}

	@Override
	public TPlatAccountroles getAccountRoles(int accountid) {
		String sql ="select * from t_plat_accountroles where accountid = "+accountid;
		List<Object> list = new ArrayList<Object>();
		return baseDaoPackage.queryForObject(sql, list, TPlatAccountroles.class);
	}

	
	
}
