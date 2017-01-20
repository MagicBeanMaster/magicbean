package com.base.system.services.plat.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.system.dao.plat.TSysLoginLogsDao;
import com.base.system.entity.TSysLoginLogs;
import com.base.system.services.plat.TSysLoginLogsService;

@Service("tSysLoginLogsService")
public class TSysLoginLogsServiceImpl implements TSysLoginLogsService {

	@Resource
	private TSysLoginLogsDao tSysLoginLogsDao;
	
	@Override
	public int save(TSysLoginLogs loginLogs) {
		return tSysLoginLogsDao.save(loginLogs);
	}

	@Override
	public int update(String account, String sessId, String remark) {
		return tSysLoginLogsDao.update(account, sessId, remark);
	}

	@Override
	public List<Map<String, Object>> getLoginLogsList(Map<String, Object> map) {
		return tSysLoginLogsDao.getLoginLogsList(map);
	}

	@Override
	public int countLoginLogs(Map<String, Object> map) {
		return tSysLoginLogsDao.countLoginLogs(map);
	}

	@Override
	public int cl(String ac) {
		return tSysLoginLogsDao.cl(ac);
	}

}
