package com.base.listener;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.lang.StringUtils;

import com.base.system.entity.SysUser;
import com.base.system.services.plat.TSysLoginLogsService;
import com.base.system.services.plat.impl.TSysLoginLogsServiceImpl;
import com.base.utils.SpringUtils;

/**
 * 监听session超时事件
 * @since 2015-10-20
 * @version 1.0
 * @author liangxy
 *
 */
public class SessionListener implements HttpSessionAttributeListener {
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		
	}

	/**
	 * 当session过期时告诉业务系统该用户已经登录超时
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {

	}
	
}
