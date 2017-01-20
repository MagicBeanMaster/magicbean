package com.base.system.dao.plat.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.system.dao.plat.TSysLoginLogsDao;
import com.base.system.entity.TSysLoginLogs;
import com.base.utils.DateUtils;
import com.booty.sys.dao.BaseDao;

@Repository("tSysLoginLogsDao")
public class TSysLoginLogsDaoImpl implements TSysLoginLogsDao {

	@Resource
	private BaseDao baseDaoPackage;
	
	@Override
	public int save(TSysLoginLogs loginLogs) {
		return baseDaoPackage.saveOrUpdate(loginLogs);
	}

	@Override
	public int update(String account, String sessId,String remark) {
		String sql = "update t_sys_login_logs set outtime = '"+DateUtils.getTimestamp()+"',remark = '"+remark+"' where account = '"+account+"' and sessId = '"+sessId+"'";
		return baseDaoPackage.batchUpdate(sql);
	}

	@Override
	public List<Map<String, Object>> getLoginLogsList(Map<String, Object> paramMap) {
		String preSql = "select a.*,r.rolesname from t_sys_login_logs a "
				+ " left join tb_sys_superaccount su on a.account = su.account and su.`status` = 0 "
				+ " left join tb_sys_emp emp on a.account = emp.account and emp.`status` = 0 "
				+ " left join tb_sys_superaccount_roles ro on (emp.accountuuid = ro.accountuuid or ro.accountuuid = su.accountuuid) "
				+ " left join tb_sys_roles r on r.rolesuuid = ro.rolesuuid "
				+ "where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		String keys = ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql +=" and sessId = ?";
			list.add(keys);
		}
		preSql +=" order by a.intime desc";
		
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
	public int countLoginLogs(Map<String, Object> map) {
		String preSql = "select count(1) from t_sys_login_logs where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		String keys = ConvertUtils.convert(map.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql +=" and sessId = ?";
			list.add(keys);
		}
		return baseDaoPackage.queryForInt(preSql, list);
	}

	@Override
	public int cl(String ac) {
		String preSql = "delete from t_sys_login_logs where account=? and outtime is not null";
		List<Object> list = new ArrayList<Object>();
		if(StringUtils.isEmpty(ac))
			ac = "sr";
		list.add(ac);
		return baseDaoPackage.delete(preSql, list);
	}

}
