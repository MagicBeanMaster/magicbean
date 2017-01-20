package com.base.system.dao.plat.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.system.dao.plat.TPlatAccountDao;
import com.base.system.entity.plat.TPlatAccount;
import com.booty.sys.dao.BaseDao;
import com.booty.sys.exceptions.JdhjException;

@Repository("tPlatAccountDao")
public class TPlatAccountDaoImpl implements TPlatAccountDao {

	@Resource
	private BaseDao baseDaoPackage;

	@Override
	public void saveorUpdate(TPlatAccount plataccount) {
		baseDaoPackage.saveOrUpdateObj(plataccount);
	}

	@Override
	public int del(int id) {
		String sql = "update t_plat_account set status = 0 where employeeid = "+id;
		return baseDaoPackage.batchUpdate(sql);
	}

	@Override
	public TPlatAccount getPro(int id) {
		String sql = "select * from t_plat_account where id = "+id;
		List<Object> list = new ArrayList<Object>();
 		return baseDaoPackage.queryForObject(sql, list, TPlatAccount.class);
	}

	@Override
	public TPlatAccount getPro(String account, String pwd) {
		String sql = "select * from t_plat_account where account = ? and pwd = ? and status = 1";
		List<Object> list = new ArrayList<Object>();
		list.add(account);
		list.add(pwd);
 		return baseDaoPackage.queryForObject(sql, list, TPlatAccount.class);
	}

	@Override
	public List<Map<String, Object>> getList(Map<String, Object> paramMap) throws Exception {
		String preSql = "select a.*,c.rolesname from t_plat_account a left join t_plat_accountroles b on a.id = b.accountid left join t_plat_roles c on c.id = b.roleid  where a.status>=0 and a.account!='cc'";
		List<Object> list = new ArrayList<Object>();
		String keys= ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql += " and (a.account like ? or a.`name` like ? or c.rolesname like ?)";
			list.add("%"+keys+"%");
			list.add("%"+keys+"%");
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

	
	public int getlistCount(Map<String, Object> paramMap) {
		String preSql = "select count(1) from t_plat_account a left join t_plat_accountroles b on a.id = b.accountid left join t_plat_roles c on c.id = b.roleid  where a.status>=0 and a.account!='cc' ";
		List<Object> list = new ArrayList<Object>();
		String keys= ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql += " and (a.account like ? or a.`name` like ? or c.rolesname like ?)";
			list.add("%"+keys+"%");
			list.add("%"+keys+"%");
			list.add("%"+keys+"%");
		}
		return baseDaoPackage.queryForInt(preSql, list);
	}
	
	@Override
	public int getCount(Map<String, Object> paramMap) {
		String preSql = "select count(1) from t_plat_account where status>=0";
		List<Object> list = new ArrayList<Object>();
		String id = ConvertUtils.convert(paramMap.get("id"));
		if(StringUtils.isNotEmpty(id) && !"0".equals(id)){
			preSql += " and id = ?";
			list.add(id);
		}
		
		String account = ConvertUtils.convert(paramMap.get("account"));
		if(StringUtils.isNotEmpty(account)){
			preSql += " and account = ?";
			list.add(account);
		}
		return baseDaoPackage.queryForInt(preSql, list);
	}

	@Override
	public List<String> getAccountlist() {
		String preSql = "select account from t_plat_account where status>=0";
		List<Object> param = new ArrayList<Object>();
		List<String> list = new ArrayList<String>();
		List<Map<String, Object>> listmap;
		try {
			listmap = baseDaoPackage.queryForList(preSql, param);
			for (Map<String, Object> map : listmap) {
				list.add(map.get("account").toString());
			}
		} catch (JdhjException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TPlatAccount getProByEmpId(Integer empId) {
		String sql = "select * from t_plat_account where employeeid = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(empId);
 		return baseDaoPackage.queryForObject(sql, list, TPlatAccount.class);
	}

	@Override
	public Map<String, Object> getAccountAndRoleByEmpid(Integer empid) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT t.id as acountid,t.account, tr.rolesname FROM t_plat_account t LEFT JOIN t_plat_accountroles tar ON tar.accountid = t.id LEFT JOIN t_plat_roles tr ON tr.id = tar.roleid WHERE t.employeeid = ? limit 0,1";
		List<Object> list = new ArrayList<Object>();
		list.add(empid);
		List<Map<String, Object>> listRsult=baseDaoPackage.queryForList(sql, list);
		if(listRsult!=null&&listRsult.size()>0){
			return listRsult.get(0);
		}
 		return null;
	}
	
	@Override
	public TPlatAccount getProByAccount(String account) {
		// TODO Auto-generated method stub
		String sql = "select * from t_plat_account where account = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(account);
		return baseDaoPackage.queryForObject(sql, list,TPlatAccount.class);
	}
	
	
	
	
	
}
