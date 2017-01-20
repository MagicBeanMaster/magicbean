package com.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.booty.sys.email.EMailAwre;
import com.booty.sys.email.impl.EMailFactory;
import com.booty.sys.email.pojo.MailInfo;

/**
 * 
 * @description 消息接收失败的邮件信息
 * @author lq
 * @date 2016年3月31日 上午9:43:04 
 * @version
 */
public class SocketEmailUtils {

	private static final Logger logger = LoggerFactory.getLogger(SocketEmailUtils.class);
	
	
	
	public static void sendException(String ip,String mess,String contents) {
		EMailAwre eMailAwre = new EMailFactory();
		MailInfo info = new MailInfo();
		info.setMailServerHost(EmailUtils.SERVERHOST);
		info.setMailServerPort(EmailUtils.SERVERPORT);
		info.setValidate(true);
		info.setUserName(EmailUtils.USERNAME);
		info.setPassword(EmailUtils.PASSWORD);
		String subject = EmailUtils.serverName+"  通信传输数据未处理";
		info.setSubject(subject);
		
		StringBuilder msg = new StringBuilder(300);
		msg.append(EmailUtils.TAB).append(EmailUtils.TAB).append(subject).append("\n\n");
		msg.append(EmailUtils.TAB).append("服务器IP: ").append(ip).append("\n");
		msg.append(EmailUtils.TAB).append("描述: ").append(mess).append("\n");
		msg.append(EmailUtils.TAB).append("传输内容: ").append(contents).append("\n");
		info.setContent(msg.toString());
		
		if(EmailUtils.emaillArr.size()>0){
			for (String email : EmailUtils.emaillArr) {
				info.setToAddress(email);
				if(logger.isDebugEnabled()) logger.debug("发送邮件=="+info.toString());
				eMailAwre.sendTextEmail(info);
			}
		}
		if(EmailUtils.emaillArr1.size()>0){
			for (String email : EmailUtils.emaillArr1) {
				info.setToAddress(email);
				if(logger.isDebugEnabled()) logger.debug("发送邮件=="+info.toString());
				eMailAwre.sendTextEmail(info);
			}
		}
		
	}
}
