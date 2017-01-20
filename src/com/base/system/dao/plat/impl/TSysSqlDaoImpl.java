package com.base.system.dao.plat.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.system.dao.plat.TSysSqlDao;
import com.booty.sys.dao.BaseDao;

@Repository("tSysSqlDao")
public class TSysSqlDaoImpl implements TSysSqlDao {

	@Resource
	private BaseDao baseDaoPackage;
	
	@Override
	public List<Map<String, Object>> getSqlsList(Map<String, Object> paramMap) {
		String sql = "select * from t_sys_sql where 1 = 1 order by createtime desc ";
		List<Object> list = new ArrayList<Object>();
		String startIndex= ConvertUtils.convert(paramMap.get("startIndex"));
		String pageSize= ConvertUtils.convert(paramMap.get("pageSize"));
		if (StringUtils.isNotEmpty(pageSize) && StringUtils.isNotEmpty(startIndex)) {
			sql += " limit ?,?";
			list.add(Integer.valueOf(startIndex.toString()));
			list.add(Integer.valueOf(pageSize.toString()));
		}
		return baseDaoPackage.queryForList(sql, list);
	}

	@Override
	public int countSqlsLogs(Map<String, Object> map) {
		String sql = "select count(1) from t_sys_sql";
		List<Object> list = new ArrayList<Object>();
		return baseDaoPackage.queryForInt(sql, list);
	}

}
