package com.base.system.dao.plat.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.base.system.dao.plat.TSysOperterLogsDao;
import com.base.system.entity.TSysOperterLogs;
import com.booty.sys.dao.BaseDao;

@Repository("tSysOperterLogsDao")
public class TSysOperterLogsDaoImpl implements TSysOperterLogsDao {

	@Resource
	private BaseDao baseDaoPackage;
	
	@Override
	public int save(TSysOperterLogs operlogs) {
		return baseDaoPackage.saveOrUpdate(operlogs);
	}
	
	@Override
	public int betchSave(List<TSysOperterLogs> list){
		return baseDaoPackage.batchUpdate(list.toArray());
	}
	
	@Override
	public void batchSave(int appid,List<String> list){
		List<TSysOperterLogs> logslist = new ArrayList<TSysOperterLogs>();
		if(list != null && list.size()>0){
			TSysOperterLogs t = null;
			for (String s : list) {
				if(StringUtils.isNotEmpty(s)){
					String[] strs = s.split("~");
					t = new TSysOperterLogs();
					t.setAccount(strs[0]);
					t.setMethodname(strs[1]);
					t.setRemark(strs[2]);
					t.setCreatetime(new Timestamp(Long.parseLong(strs[3])));
					t.setIp(strs[4]);
					if(strs.length>=6)
						t.setMac(strs[5]);
					logslist.add(t);
				}
			}
			
			if(logslist.size()>0){
				baseDaoPackage.batchUpdate(logslist.toArray());
			}
			
		}
	}
	
	@Override
	public List<Map<String, Object>> getOperterLogsList(Map<String, Object> paramMap) {
		String preSql = "select a.*, b.appname from t_sys_operter_logs a left join tb_sys_app b on a.appid = b.appid where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		String keys = ConvertUtils.convert(paramMap.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql += " and (b.appname like ? or a.remark like ?)";
			list.add("%"+keys+"%");
			list.add("%"+keys+"%");
		}
		preSql += " order by a.createtime desc ";
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
	public int countOperterLogs(Map<String, Object> map) {
		String preSql = "select count(1) from t_sys_operter_logs a left join tb_sys_app b on a.appid = b.appid where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		String keys = ConvertUtils.convert(map.get("keys"));
		if(StringUtils.isNotEmpty(keys)){
			preSql += " and (b.appname like ? or a.remark like ?)";
			list.add("%"+keys+"%");
			list.add("%"+keys+"%");
		}
		return baseDaoPackage.queryForInt(preSql, list);
	}

}
