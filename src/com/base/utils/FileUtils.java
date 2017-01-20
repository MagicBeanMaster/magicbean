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

import com.base.constant.Constant;


public class FileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
	
	@SuppressWarnings("static-access")
	public static void parseDir(String picPath,String targerPath){
		logger.debug("picPath=="+picPath+"==targerPath=="+targerPath);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		int beforeday = cal.get(cal.DATE);
		logger.debug("开始备份文件beforeday===="+beforeday);
		
		File file = new File(picPath);
		File[] files = file.listFiles();
		String tempPath = targerPath;// "C:\\test\\pic";
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
				logger.debug("tt==========="+tt);
				logger.debug("备份文件==beforeday=="+beforeday+"==tt:"+tt);
				if(file2.isFile()){
					if(beforeday==tt){
						FileUtils.copyFile(file2, tempPath);
					}
				}else{
					mklist.add(file2.getName());
				}
					
			}
		}
		if(mklist.size()>0){
			for (String s : mklist) {
				FileUtils.parseDir(picPath+File.separator+s, targerPath+File.separator+s);
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
	public static void copyFile(File file,String savePath){
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
			ExceptionUtils.dealException(e);
		} catch (IOException e) {
			ExceptionUtils.dealException(e);
		}
	}
	
	@SuppressWarnings("static-access")
	public static void deleteFile(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		int beforeday = cal.get(cal.DATE);
		int month = cal.get(cal.MONTH)+1;
		String temp = Constant.PICPATH+File.separator+"temp"+File.separator+cal.get(cal.YEAR)+File.separator+month+File.separator+beforeday;
		deleteDir(new File(temp));
		logger.debug("删除临时文件的路径====="+temp);
		
	}
	
	protected static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
        
        for (int i=0; i<children.length; i++) {
                boolean success = FileUtils.deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
