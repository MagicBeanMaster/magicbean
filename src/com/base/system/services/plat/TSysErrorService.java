package com.base.system.services.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.TSysError;

/**
 * 
 * @description 代码错误信息处理Service
 * @author lq
 * @date 2015年12月21日 上午11:00:06 
 * @version
 */
public interface TSysErrorService {

	/**
	 * 
	 * @description 保存错误信息 
	 * @param tsysError
	 * @date 2015年12月21日 上午11:01:11
	 */
	public void saveError(TSysError tsysError);
	
	/**
	 * 
	 * @description 批量保存错误信息列表 
	 * @param errorlist 错误信息列表对象
	 * @author lq
	 * @date 2016年5月23日 下午2:39:03
	 */
	public int beachSaveError(List<TSysError> errorlist);
	
	/**
	 * 
	 * @description 获取错误信息列表 
	 * @param map
	 * @return
	 * @date 2015年12月21日 上午11:01:19
	 */
	public List<Map<String,Object>> getErrorList(Map<String,Object> map);
	
	
	/**
	 * 
	 * @description 统计错误信息 
	 * @param map
	 * @return
	 * @date 2015年12月21日 上午11:01:29
	 */
	public int countError(Map<String,Object> map);
	
	/**
	 * 
	 * @description 删除错误信息 
	 * @return
	 * @author lq
	 * @date 2016年6月16日 上午9:47:57
	 */
	public int delError();
}
