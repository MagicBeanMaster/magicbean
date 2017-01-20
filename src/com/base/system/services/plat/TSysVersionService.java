package com.base.system.services.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.TSysVersion;
import com.base.system.entity.pojo.Page;
import com.base.system.entity.pojo.VersionVO;

/**
 * 
 * @description 系统版本信息 
 * @author lq
 * @date 2016年5月17日 上午11:21:26 
 * @version
 */
public interface TSysVersionService {

	/**
	 * 
	 * @description 新增或修改版本信息 
	 * @author lq
	 * @date 2016年5月17日 上午11:21:14
	 */
	public void saveOrUpdate(TSysVersion ver);
	
	/**
	 * 
	 * @description 获取版本信息 
	 * @param id 版本ID
	 * @return
	 * @author lq
	 * @date 2016年5月17日 上午11:22:03
	 */
	public TSysVersion getProById(int id);
	
	/**
	 * 
	 * @description 版本信息列表
	 * @param page
	 * @return
	 * @author lq
	 * @date 2016年5月17日 上午11:21:40
	 */
	public List<VersionVO> getList(Page page);
	
	/**
	 * 
	 * @description 获取最近的版本信息 
	 * @return
	 * @author lq
	 * @date 2016年5月17日 下午3:33:33
	 */
	public List<VersionVO> getTopVersion();
	
	/**
	 * 
	 * @description 统计版本信息 
	 * @param page
	 * @return
	 * @author lq
	 * @date 2016年5月17日 上午11:22:20
	 */
	public int getCount(Page page);
	
	/**
	 * 
	 * @description 删除版本信息 
	 * @param id
	 * @author lq
	 * @date 2016年5月17日 下午2:33:15
	 */
	public int del(int id);
}
