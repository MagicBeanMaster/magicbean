package com.base.listener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.constant.Constant;
import com.base.task.BackFilesRunnable;

public class SystemListener implements ServletContextListener {
	
	private static final Logger logger = LoggerFactory.getLogger(SystemListener.class);

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		Constant.BACKTIME = servletContext.getInitParameter("BACKTIME");
		Constant.BACKPATH = servletContext.getInitParameter("BACKPATH");
		System.out.println("SystemListenerlistent中的=====IP====="+Constant.IP);
		Properties prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("novalidatepath.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		if(prop.stringPropertyNames()!=null){
			Iterator<String> it=prop.stringPropertyNames().iterator();
			while(it.hasNext()){
				Constant.NOVLIDATEPATH.add(it.next());
			}
		}
		
		new Thread(new BackFilesRunnable()).start();
	}

}
