package com.base.system.dao.plat;

import java.util.List;
import java.util.Map;

import com.base.system.entity.TSysError;

public interface TSysErrorDao {

	public void saveError(TSysError tsysError);
	
	/**
	 * 
	 * @description 批量保存错误信息列表 
	 * @param errorlist 错误信息列表对象
	 * @author lq
	 * @date 2016年5月23日 下午2:39:03
	 */
	public int beachSaveError(List<TSysError> errorlist);
	
	public List<Map<String,Object>> getErrorList(Map<String,Object> map);
	
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
