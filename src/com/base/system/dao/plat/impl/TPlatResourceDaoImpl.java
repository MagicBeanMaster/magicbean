package com.base.system.dao.plat.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.system.dao.plat.TPlatResourceDao;
import com.base.system.entity.plat.TPlatResource;
import com.base.system.entity.plat.TPlatResourceroles;
import com.booty.sys.dao.BaseDao;

@Repository("tPlatResource")
public class TPlatResourceDaoImpl implements TPlatResourceDao {

	
	@Resource
	private BaseDao baseDaoPackage;

	@Override
	public void saveorUpdate(TPlatResource res) {
		baseDaoPackage.saveOrUpdateObj(res);
	}

	@Override
	public int del(int id) {
		String sql = "update t_plat_resource set status = -1 where id = "+id;
		
		return baseDaoPackage.batchUpdate(sql);
	}

	@Override
	public void saveRolesResouce(int roleid, List<String> reslist) {
		List<TPlatResourceroles> list = new ArrayList<TPlatResourceroles>();
		int size = reslist.size();
		if(size>0){
			for (int i = 0; i < size; i++) {
				if(StringUtils.isNotEmpty(reslist.get(i))){
					TPlatResourceroles res = new TPlatResourceroles();
					res.setRoleid(roleid);
					res.setResourceid(Integer.parseInt(reslist.get(i)));
					list.add(res);
				}
			}
			if(list.size()>0)
				baseDaoPackage.batchUpdate(list.toArray());
		}
	}

	@Override
	public int delRolesResouce(int roleid) {
		String sql = "delete from t_plat_resourceroles where roleid = " + roleid;
		
		return baseDaoPackage.batchUpdate(sql);
	}

	@Override
	public TPlatResource getPro(int id) {
		String sql = "select * from t_plat_resource where id = "+id;
		List<Object> list = new ArrayList<Object>();
		return baseDaoPackage.queryForObject(sql, list, TPlatResource.class);
	}

	
	@Override
	public List<TPlatResource> getProList(int type) {
		String preSql = "select * from t_plat_resource where status>=0 ";
		List<Object> list = new ArrayList<Object>();
		preSql +=" and type = ?";
		list.add(type);
		return baseDaoPackage.queryForList(preSql, list, TPlatResource.class);
	}

	@Override
	public List<TPlatResource> getAccountResource(String accountid) {
		String preSql = "SELECT a.* FROM t_plat_resource a LEFT JOIN t_plat_resourceroles r ON a.id = r.resourceid "
				+ "LEFT JOIN t_plat_accountroles b ON b.roleid = r.roleid WHERE a.status>=0 and b.accountid = ? order by a.ord asc,a.createtime asc";
		List<Object> list = new ArrayList<Object>();
		list.add(accountid);
		return baseDaoPackage.queryForList(preSql, list, TPlatResource.class);
	}

	@Override
	public List<Map<String, Object>> getList(Map<String, Object> paramMap) throws Exception {
		String preSql = "select a.id,a.menuname,a.path,b.menuname parentname,a.type,a.remark from t_plat_resource a "
				+ " left join t_plat_resource b on b.id = a.parentid "
				+ "where a.status>=0 ";
		List<Object> list = new ArrayList<Object>();
		String keys = ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql +=" and (a.menuname like ? or b.menuname like ? or a.path like ?)";
			list.add("%"+keys.toString()+"%");
			list.add("%"+keys.toString()+"%");
			list.add("%"+keys.toString()+"%");
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
		String preSql = "select count(1) from t_plat_resource a left join t_plat_resource b on b.id = a.parentid where a.status>=0";
		List<Object> list = new ArrayList<Object>();
		
		String keys = ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql +=" and (a.menuname like ? or b.menuname like ? or a.path like ?)";
			list.add("%"+keys.toString()+"%");
			list.add("%"+keys.toString()+"%");
			list.add("%"+keys.toString()+"%");
		}
		return baseDaoPackage.queryForInt(preSql, list);
	}

	@Override
	public List<Map<String, Object>> getAllListTree(Map<String, Object> map) {
		String preSql = "select a.id,a.menuname text,a.parentid from t_plat_resource a  where status >= 0 ";
		List<Object> list = new ArrayList<Object>();
		String type = ConvertUtils.convert(map.get("type"));
		
		if(StringUtils.isNotEmpty(type)){
			preSql += " and a.type = ?";
			list.add(type);
		}
		String parentid  = ConvertUtils.convert(map.get("parentid"));
		if(StringUtils.isNotEmpty(parentid)){
			preSql += " and a.parentid = ?";
			list.add(parentid);
		}
		return baseDaoPackage.queryForList(preSql, list);
	}

	@Override
	public List<Integer> getRolesResouces(String rolesid) {
		List<Integer> list = new ArrayList<Integer>();
		List<Object> paramlist = new ArrayList<Object>();
		String sql = "select resourceid from t_plat_resourceroles where roleid = " + rolesid;
		List<Map<String,Object>> listmap = baseDaoPackage.queryForList(sql, paramlist);
		if(listmap.size()>0){
		for (Map<String, Object> map : listmap) {
			String rid = ConvertUtils.convert(map.get("resourceid"));
			if(StringUtils.isNotEmpty(rid))
				list.add(Integer.parseInt(rid));
		}
		}
		return list;
	}
	
}
