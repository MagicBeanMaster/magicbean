package com.base.system.services.plat.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.system.dao.plat.TSysVersionDao;
import com.base.system.entity.TSysVersion;
import com.base.system.entity.pojo.Page;
import com.base.system.entity.pojo.VersionVO;
import com.base.system.services.plat.TSysVersionService;

@Service("tSysVersionService")
public class TSysVersionServiceImpl implements TSysVersionService {

	@Resource
	private TSysVersionDao tSysVersionDao;
	
	@Override
	public void saveOrUpdate(TSysVersion ver) {
		tSysVersionDao.saveOrUpdate(ver);

	}

	@Override
	public TSysVersion getProById(int id) {
		return tSysVersionDao.getProById(id);
	}

	@Override
	public List<VersionVO> getList(Page page) {
		return tSysVersionDao.getList(page);
	}

	@Override
	public List<VersionVO> getTopVersion() {
		return tSysVersionDao.getTopVersion();
	}

	@Override
	public int getCount(Page page) {
		return tSysVersionDao.getCount(page);
	}

	@Override
	public int del(int id) {
		return tSysVersionDao.del(id);
	}

}
