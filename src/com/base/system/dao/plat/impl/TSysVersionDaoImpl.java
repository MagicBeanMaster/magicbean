package com.base.system.dao.plat.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.system.dao.plat.TSysVersionDao;
import com.base.system.entity.TSysVersion;
import com.base.system.entity.pojo.Page;
import com.base.system.entity.pojo.VersionVO;
import com.booty.sys.dao.BaseDao;

@Repository("tSysVersionDao")
public class TSysVersionDaoImpl implements TSysVersionDao {

	@Resource
	private BaseDao baseDaoPackage;
	
	@Override
	public void saveOrUpdate(TSysVersion ver) {
		
		baseDaoPackage.saveOrUpdate(ver);
	}

	@Override
	public TSysVersion getProById(int id) {
		String sql = "select * from t_sys_version where id = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		
		return baseDaoPackage.queryForObject(sql, list, TSysVersion.class);
	}

	@Override
	public List<VersionVO> getList(Page page) {
		String sql = "select v.* from t_sys_version v  where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if(StringUtils.isNotBlank(page.getKeys())){
			sql += " and (v.content like ? or v.likecontent like ?)";
			String k = "%" + page.getKeys().trim() +"%";
			list.add(k);
			list.add(k);
		}
		
		
		sql += " order by v.createtime desc ";
		if(page.getPageNum() != null && page.getPageSize() != null){
			sql += " limit ?,?";
			list.add((page.getPageNum()-1)*page.getPageSize());
			list.add(page.getPageSize());
		}
		
		return baseDaoPackage.queryForList(sql, list, VersionVO.class);
	}

	@Override
	public List<VersionVO> getTopVersion() {
		String sql = "select v.* from t_sys_version v  where 1=1 ";
		
		sql +=" order by v.createtime desc limit 0,5 ";
		return baseDaoPackage.queryForList(sql, null,VersionVO.class);
	}

	@Override
	public int getCount(Page page) {
		String sql = "select count(1) from t_sys_version v where 1 = 1 ";
		List<Object> list = new ArrayList<Object>();
		if(StringUtils.isNotBlank(page.getKeys())){
			sql = " select count(1) from t_sys_version v where 1=1 ";
			sql += " and (v.content like ? or v.likecontent like ? )";
			String k = "%" + page.getKeys().trim() +"%";
			list.add(k);
			list.add(k);
		}
		
		return baseDaoPackage.queryForInt(sql, list);
	}

	@Override
	public int del(int id) {
		String sql = "delete from t_sys_version where id =  "+id;
		return baseDaoPackage.batchUpdate(sql);
	}

}
