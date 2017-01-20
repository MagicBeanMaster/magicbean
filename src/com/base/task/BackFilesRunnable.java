package com.base.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.base.constant.Constant;
import com.base.utils.ExceptionUtils;
import com.base.utils.FileUtils;

public class BackFilesRunnable implements Runnable{
	private long HOURS = TimeUnit.HOURS.toMillis(1);
	@Override
	public void run() {
		while(!Thread.interrupted()){
			long nowUpdateTime = 0l;
			try {
				nowUpdateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" "+Constant.BACKTIME).getTime();
			} catch (ParseException e1) {
				ExceptionUtils.dealException(e1);
			}
			long result = nowUpdateTime - System.currentTimeMillis();
			if(result > HOURS || result < 0){
				try {
					TimeUnit.MILLISECONDS.sleep(HOURS);
				} catch (InterruptedException e) {
					ExceptionUtils.dealException(e);
				}
			}
			if(result > 0 && result < HOURS){
				try {
					TimeUnit.MILLISECONDS.sleep(result);
				} catch (InterruptedException e) {
					ExceptionUtils.dealException(e);
				}
				FileUtils.parseDir(Constant.PICPATH, Constant.BACKPATH);
//				FileUtils.deleteFile();
			}
		}
		
	}

}
