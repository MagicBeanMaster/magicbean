package com.base.system.services.plat.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.base.system.dao.plat.TPlatResourceDao;
import com.base.system.entity.plat.TPlatResource;
import com.base.system.services.plat.PlatResourceService;
import com.base.utils.DateUtils;

@Service("platResourceService")
public class PlatResourceServiceImpl implements PlatResourceService {

	@Resource
	private TPlatResourceDao tPlatResourceDao;
	
	@Override
	public void saveorUpdate(TPlatResource res) {
		if(res.getId() != null){
			TPlatResource old = tPlatResourceDao.getPro(res.getId());
			old.setMenuname(res.getMenuname());
			old.setPath(res.getPath());
			old.setIcon(res.getIcon());
			old.setOrd(res.getOrd());
			old.setRemark(res.getRemark());
			old.setType(res.getType());
			old.setParentid(res.getParentid());
			res = old;
		}else{
			res.setStatus(0);
			res.setCreatetime(DateUtils.getTimestamp());
		}
		tPlatResourceDao.saveorUpdate(res);
		
	}

	@Override
	public int del(int id) {
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("parentid", id);
		List<Map<String, Object>> list=	tPlatResourceDao.getAllListTree(map);
		if(list!=null){
			for (Map<String, Object> map2 : list) {
				String childid=map2.get("id").toString();
				tPlatResourceDao.del(Integer.parseInt(childid));
				
				map.put("parentid", childid);
				List<Map<String, Object>> list1=tPlatResourceDao.getAllListTree(map);
				if(list1!=null){
					for (Map<String, Object> map3 : list1) {
						String childid1=map3.get("id").toString();
						tPlatResourceDao.del(Integer.parseInt(childid1));
					}
				}
			}
		}
		return tPlatResourceDao.del(id);
	}

	@Override
	public void saveRolesResouce(int roleid, List<String> reslist) {
		tPlatResourceDao.saveRolesResouce(roleid, reslist);

	}

	@Override
	public int delRolesResouce(int roleid) {
		return tPlatResourceDao.delRolesResouce(roleid);
	}

	@Override
	public TPlatResource getPro(int id) {
		return tPlatResourceDao.getPro(id);
	}

	@Override
	public List<TPlatResource> getProList(int type) {
		return tPlatResourceDao.getProList(type);
	}

	@Override
	public List<Map<String, Object>> getList(Map<String, Object> map) throws Exception {
		return tPlatResourceDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return tPlatResourceDao.getCount(map);
	}

	@Override
	public List<Map<String, Object>> getAllListTree(Map<String, Object> map) {
		
		return tPlatResourceDao.getAllListTree(map);
	}

	@Override
	public List<Integer> getRolesResouces(String rolesid) {
		return tPlatResourceDao.getRolesResouces(rolesid);
	}

	@Override
	public List<TPlatResource> getAccountResource(String accountid) {
		return tPlatResourceDao.getAccountResource(accountid);
	}

}
