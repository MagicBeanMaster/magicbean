package com.base.system.services.plat.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.system.dao.plat.TSysOperterLogsDao;
import com.base.system.entity.TSysOperterLogs;
import com.base.system.services.plat.TSysOperterLogsService;


@Service("tSysOperterLogsService")
public class TSysOperterLogsServiceImpl implements TSysOperterLogsService {

	@Resource
	private TSysOperterLogsDao tSysOperterLogsDao;
	
	@Override
	public int save(TSysOperterLogs operlogs) {
		return tSysOperterLogsDao.save(operlogs);
	}

	@Override
	public int batchSave(List<TSysOperterLogs> list) {
		return tSysOperterLogsDao.betchSave(list);
		
	}

	@Override
	public List<Map<String, Object>> getOperterLogsList(Map<String, Object> map) {
		return tSysOperterLogsDao.getOperterLogsList(map);
	}

	@Override
	public int countOperterLogs(Map<String, Object> map) {
		return tSysOperterLogsDao.countOperterLogs(map);
	}

}
