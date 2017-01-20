package com.base.bases;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class BaseResponseWrapper extends HttpServletResponseWrapper {

	public BaseResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	

}
