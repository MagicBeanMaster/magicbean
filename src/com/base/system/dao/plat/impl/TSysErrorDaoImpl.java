package com.base.system.dao.plat.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.system.dao.plat.TSysErrorDao;
import com.base.system.entity.TSysError;
import com.booty.sys.dao.BaseDao;

@Repository("tSysErrorDao")
public class TSysErrorDaoImpl  implements TSysErrorDao{

	@Resource
	private BaseDao baseDaoPackage;
	
	@Override
	public void saveError(TSysError tsysError) {
		baseDaoPackage.saveOrUpdate(tsysError);
	}

	@Override
	public int beachSaveError(List<TSysError> errorlist) {
		if(errorlist != null && !errorlist.isEmpty()){
			return baseDaoPackage.batchUpdate(errorlist.toArray());
		}
		return 0;
	}

	@Override
	public List<Map<String, Object>> getErrorList(Map<String, Object> paramMap) {
		String preSql = "select a.* from t_sys_error a " 
					+ "  where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		
		String keys= ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql += " and a.errormess like ? or a.id=? ";
			list.add("%"+keys+"%");
			list.add(keys);
		}
		preSql +=" order by a.createtime desc ";
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
	public int countError(Map<String, Object> paramMap) {
		String preSql = "select count(1) from t_sys_error a "
					+ " where 1=1  ";
		List<Object> list = new ArrayList<Object>();
		String keys= ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql += " and a.errormess like ? or a.id=? ";
			list.add("%"+keys+"%");
			list.add(keys);
		}
		return baseDaoPackage.queryForInt(preSql, list);
	}

	@Override
	public int delError() {
		String preSql = "delete from t_sys_error ";
		return baseDaoPackage.batchUpdate(preSql);
	}

}
