package com.base.system.services.plat.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.system.dao.plat.TSysErrorDao;
import com.base.system.entity.TSysError;
import com.base.system.services.plat.TSysErrorService;

@Service("tSysErrorService")
public class TSysErrorServiceImpl implements TSysErrorService{

	@Resource
	private TSysErrorDao tSysErrorDao;
	
	@Override
	public void saveError(TSysError tsysError) {
		tSysErrorDao.saveError(tsysError);
	}

	@Override
	public int beachSaveError(List<TSysError> errorlist) {
		
		return tSysErrorDao.beachSaveError(errorlist);
	}

	@Override
	public List<Map<String, Object>> getErrorList(Map<String,Object> map) {

		return tSysErrorDao.getErrorList(map);
	}

	@Override
	public int countError(Map<String, Object> map) {

		return tSysErrorDao.countError(map);
	}

	@Override
	public int delError() {
		return tSysErrorDao.delError();
	}

}
