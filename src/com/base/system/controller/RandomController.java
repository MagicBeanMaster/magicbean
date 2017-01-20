package com.base.system.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.base.utils.VerifyCodeUtils;


@Controller
@RequestMapping("random")
public class RandomController {
	
	/**
	 * 
	 * @description 验证码生成并保存缓存
	 * @param request
	 * @param response
	 * @date 2016年7月9日 上午10:56:52
	 */
	@ResponseBody
	@RequestMapping("code")
	public void code(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(true);
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
          
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        session.setAttribute("code", verifyCode.toLowerCase());
        //生成图片  
        int w = 110, h = 40;  
        try {
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
	}

	
}
