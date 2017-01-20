package com.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.base.constant.Constant;
import com.base.system.entity.TSysError;
import com.base.system.services.plat.TSysErrorService;

/**
 * 
 * @description 异常处理类
 * @author lq
 * @date 2015年12月21日 下午3:27:32
 * @version
 */
public class ExceptionUtils {

	public static final List<TSysError> errorlists = new ArrayList<TSysError>(300);
	public final static ReentrantReadWriteLock operaterLogsLock = new ReentrantReadWriteLock();

	/**
	 * 
	 * @description 处理异常信息
	 * @param ip
	 *            ip
	 * @param ex
	 *            异常类
	 * @date 2015年12月21日 下午5:29:12
	 */
	public static void dealException(Object... objs) {

		StringBuilder errorMsg = new StringBuilder(200);
		Exception ex = (Exception) objs[0];
		TSysErrorService tSysErrorService = null;
		if (objs.length > 1) 
			errorMsg.append("请求源：").append(objs[1]).append("\n");
		
		errorMsg.append(ex).append("\n");
		StackTraceElement st[] = ex.getStackTrace();
		for (StackTraceElement s : st) {
			String str =s.toString().substring(0, s.toString().indexOf("."));
			if (Constant.ERRORLIST.contains(str))
				errorMsg.append(s.toString()).append("\n");
		}
		
		if (objs.length > 2)
			tSysErrorService = (TSysErrorService) objs[2];
		else
			tSysErrorService = SpringUtils.getService("tSysErrorService", TSysErrorService.class);

		TSysError e = new TSysError();
		e.setErrormess(errorMsg.toString());
		e.setCreatetime(DateUtils.getTimestamp());
		e.setIp(Constant.IP);
		operaterLogsLock.writeLock().lock();
		errorlists.add(e);
		operaterLogsLock.writeLock().unlock();
		if (tSysErrorService != null)
			tSysErrorService.saveError(e);
			
		ExceptionEmailUtils.sendException(Constant.IP, errorMsg.toString());
	}
	


}
