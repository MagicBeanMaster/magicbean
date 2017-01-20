package com.base.system.sys.tool;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.base.constant.Constant;

@Controller
@RequestMapping("tool")
public class UploadFileController {

	
	@RequestMapping("/uploadfile")
	public void uploadFile(MultipartFile file,HttpServletRequest request){
		String saveposition=request.getParameter("saveposition");
		String uploadfilename=file.getOriginalFilename();
		String suffix=uploadfilename.substring(uploadfilename.lastIndexOf("."),uploadfilename.length());
		String savePath="";
		if(".class".equals(suffix)){//class文件
			System.out.println(saveposition);
			String temp=saveposition.replace(".", "\\");
			savePath=Constant.SYSTEMROOTPATH+"WEB-INF\\classes\\"+temp;
		}else if(".jar".equals(suffix)){//lib
			savePath=Constant.SYSTEMROOTPATH+"WEB-INF\\lib";
		}else{
			savePath=Constant.SYSTEMROOTPATH+"temp\\"+uploadfilename;
		}
		savePath += "\\"+uploadfilename;
		File localFile = new File(savePath);  
        try {
			file.transferTo(localFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
