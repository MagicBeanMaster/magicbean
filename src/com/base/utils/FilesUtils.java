package com.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class FilesUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(FilesUtils.class);
	
	@SuppressWarnings("static-access")
	public static void parseDir(String srcPath,String targerPath){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		int beforeday = cal.get(cal.DATE);
		logger.debug("beforeday======"+beforeday);
		File file = new File(srcPath);
		File[] files = file.listFiles();
		String tempPath = targerPath;// 
		File filePath = new File(tempPath);
		if(!filePath.isDirectory())
			filePath.mkdirs();
		
		List<String> mklist = new ArrayList<>(5);
		if(files!=null && files.length>0){
			Calendar t = Calendar.getInstance();
			int tt ;
			for (File file2 : files) {
				t.setTimeInMillis(file2.lastModified());
				logger.debug("文件的日期："+t.get(t.YEAR)+"-"+t.get(t.MONTH)+"-"+t.get(t.DATE));
				tt = t.get(t.DATE);
				logger.debug("备份文件==beforeday=="+beforeday+"==tt:"+tt);
				if(file2.isFile()){
					if(beforeday==tt){
						FilesUtils.copyFile(file2, tempPath);
					}
				}else{
					mklist.add(file2.getName());
				}
					
			}
		}
		if(mklist.size()>0){
			for (String s : mklist) {
				FilesUtils.parseDir(srcPath+File.separator+s, targerPath+File.separator+s);
			}
		}
	}
	
	
	/**
	 * 
	 * @description 复制文件 
	 * @param file 源文件file
	 * @param savePath 目标文件存放位置
	 * @date 2016年1月13日 下午4:06:46
	 */
	@SuppressWarnings({ "unused"})
	private static void copyFile(File file,String savePath){
		file.renameTo(new File(savePath));
		byte[] bt = new byte[1024];
		File savedFile = new File(savePath ,  file.getName());
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(savedFile);
			int readNum = 0;
			while ((readNum = fis.read(bt)) != -1) {
				fos.write(bt, 0, bt.length);
			}
			fis.close();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
