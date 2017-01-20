package com.base.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.base.constant.Constant;
import com.base.system.entity.SysUser;

public class SystemFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(SystemFilter.class);
	private static final String XMLHttpRequest = "XMLHttpRequest";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest1, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest1;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
		HttpSession session = httpRequest.getSession();
		StringBuilder basePathTemp = new StringBuilder(50);
		String managername = httpRequest.getContextPath();
		if ("".equals(Constant.basePath)) {
			basePathTemp.append(httpRequest.getScheme()).append(Constant.str).append(httpRequest.getServerName())
					.append(Constant.str1).append(httpRequest.getServerPort()).append(managername)
					.append(Constant.str2);
			Constant.basePath = basePathTemp.toString();
		}

		String uri = httpRequest.getRequestURI();
		String type = httpRequest.getHeader("X-Requested-With");
		if (uri.indexOf("/admin/") != -1) {
			SysUser user = (SysUser) session.getAttribute("businessUser");
			uri = uri.substring(uri.indexOf("admin/"));
			if (user == null) {
				if (!XMLHttpRequest.equals(type)) {
					httpResponse.sendRedirect(Constant.basePath + "login.jsp");
				} else {// Ajax请求
					httpResponse.setStatus(302);
				}
			} else {
				if(user.getType()==2){//系统管理员
					filterChain.doFilter(httpRequest, servletResponse);
				}else{
					Object platPathListObject = session.getAttribute("platpathlist");
					List<?> pathlist = null;
					if (platPathListObject instanceof List)
						pathlist = (List<?>) platPathListObject;
					if (Constant.NOVLIDATEPATH.contains(uri) || (pathlist != null && pathlist.contains(uri)))
						filterChain.doFilter(httpRequest, servletResponse);
					else {
						logger.debug("没有权限请与管理员联系！" + uri);
						httpResponse.sendError(401);
					}
				}
			}
		} else {
			filterChain.doFilter(httpRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
