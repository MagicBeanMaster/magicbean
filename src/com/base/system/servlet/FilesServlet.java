package com.base.system.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.constant.Constant;  

public class FilesServlet extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(FilesServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -450448565823991122L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			String Origin = req.getHeader("Origin");
			String appid = req.getParameter("appid");
			String maxSize = req.getParameter("maxSize");
			resp.addHeader("Access-Control-Allow-Origin", Origin);//http://441ffdaf086b4bfd811f320798dee9a1.php
			logger.debug("doPost===Origin==="+Origin+"==接收的参数maxSize==========="+maxSize);
			DiskFileItemFactory factory = new DiskFileItemFactory() ;  
	        factory.setSizeThreshold( 8192 ) ;  
	        String savePath = "upload";
	        String tempPath = req.getSession().getServletContext().getRealPath("/upload");
	        Calendar cal=Calendar.getInstance();
	        int year = cal.get(Calendar.YEAR);//获取年份
	        int month=cal.get(Calendar.MONTH);//获取月份
	        int day=cal.get(Calendar.DATE);//获取日
	        tempPath += File.separator + "uploadFile" + File.separator +year+File.separator+ month+File.separator+ day;
	        savePath += File.separator + "uploadFile" + File.separator +year+File.separator+ month+File.separator+ day;
	        
	        File file = new File( tempPath ) ;  
	        if(!file.isDirectory()){  
	            file.mkdirs();  
	        }
	        factory.setRepository( file ) ;    
	        ServletFileUpload upload = new ServletFileUpload( factory ) ;
	        if(!"".equals(maxSize) && maxSize!=null){
	        	int size = Integer.parseInt(maxSize);
	        	long lsize = size * 1024;
	        	upload.setSizeMax(lsize);
	        }
	        List<FileItem> items;  
	        JSONObject obj = new JSONObject();
	        List<String> imglist = new ArrayList<String>();
	        try {  
	            items = upload.parseRequest(req);  
	            Iterator<FileItem> itr = items.iterator();     
	            while (itr.hasNext()) {// 依次处理每个 form field  
	                   FileItem item = (FileItem) itr.next();  
	                   if(item!=null && item.getName()!=null && !"".equals(item.getName())){
	                	   String temp = item.getName();
	                	   if(logger.isDebugEnabled())logger.debug("图片名========="+temp);
	                	   String newname = UUID.randomUUID().toString().replace("-", "") 
	                			   +System.currentTimeMillis() ;//+ temp.substring(temp.lastIndexOf("."))
	                	   String suf = "";
	                	   if(temp.indexOf(".")!=-1){
	                		   suf = temp.substring(temp.lastIndexOf("."));
	                	   }else{
	                		   suf = temp;
	                	   }
		                   if(!item.isFormField()){ /* 判断是否为表单控件（非File控件），如果不是表单控件，则上传此文件 */
		                       File savedFile = new File( tempPath ,  newname+suf );//File.createTempFile (newname,suf,new File(tempPath));//createTempFile(tempPath,newname);//File( tempPath ,  newname );
//		                       savedFile.createNewFile(tempPath,newname);
		                       item.write(savedFile) ;  
		                       imglist.add(savePath + File.separator+newname+suf);
		                       obj.put("realname", temp);
		                   }else{/* 如果是表单控件，则保存其值*/  
		                       if(logger.isDebugEnabled())logger.debug( item.getFieldName() + "-->" + item.getString() ) ;   
		                   }
	                   }else{
	                	   continue;
	                   }
	            } 
	            obj.put("type", 1);
	        }catch (FileUploadException e) {
	        	obj.put("type", -2);
				e.printStackTrace();
			} catch (Exception e) {
				obj.put("type", -1);
				e.printStackTrace();
			}finally {
				obj.put("datas",JSONArray.toJSON(imglist));
				PrintWriter ps = resp.getWriter();
				logger.debug("========"+obj.toJSONString());
				ps.write(obj.toJSONString());
				ps.flush();
				ps.close();
			}
        
	}


	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Origin = req.getHeader("Origin");
		resp.addHeader("Access-Control-Allow-Origin", Origin);
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		resp.addHeader("Access-Control-Allow-Headers", "content-type");
		resp.addHeader("Access-Control-Max-Age", "30");
		
	}

	
}
