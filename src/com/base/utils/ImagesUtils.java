package com.base.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.constant.Constant;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

public class ImagesUtils {
	private static final Logger logger = LoggerFactory.getLogger(ImagesUtils.class);
	private static final String CAIJIAN = "caijian";
	private static final String UPLOAD = "upload";
	
	/**
	 * 等比压缩图片
	 * @param id 用户id
	 * @param picname 文件名字
	 * @param request 
	 * @param width 宽
	 * @param height 高
	 * @return
	 * @throws Exception
	 */
	public static String cutPhoto(String id,String picname,HttpServletRequest request,int width,int height) throws Exception{
		String photoname = System.currentTimeMillis()+"."+picname.split("[.]")[1];
		String imgName = picname.split("[.]")[1];
		String caijianpath = UPLOAD+Constant.str2+id+Constant.str2+CAIJIAN+Constant.str2+photoname;
		String temp = Constant.str2+Constant.str2+UPLOAD+Constant.str2;
		ServletContext servletContext = request.getSession().getServletContext();
		String resoureImagePath = servletContext.getRealPath(temp+id+Constant.str2+picname);
		String cutImagePathFolder = servletContext.getRealPath(temp+id+Constant.str2+CAIJIAN);
		String cutImagePath = servletContext.getRealPath(Constant.str2+Constant.str2+caijianpath);
		File targetFile1 = new File(cutImagePathFolder); 
        if(!targetFile1.exists()){
        	targetFile1.mkdirs();
        }
		try {
			BufferedImage image = ImageIO.read(new File(resoureImagePath));  
			Builder<BufferedImage> builder = null;  
			int imageWidth = image.getWidth();  
			int imageHeitht = image.getHeight();  
			if (((float)height / width) != ((float)imageWidth / imageHeitht)) {  
			    if (imageWidth > imageHeitht) {  
			        image = Thumbnails.of(resoureImagePath).height(height).asBufferedImage();  
			    } else {  
			        image = Thumbnails.of(resoureImagePath).width(width).asBufferedImage();  
			    }  
			    builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, width, height).size(width, height);  
			} else {  
			    builder = Thumbnails.of(image).size(width, height);  
			}  
			builder.outputFormat(imgName).toFile(cutImagePath); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			caijianpath = null;
		}
		return caijianpath;
	}
	
	
	/**
	 * 
	 * @description  保存图片到相应的文件夹下
	 * @param filePath 上传图片的图片名
	 * @param file 上传图片文件流
	 * @param savePath 上传图片保存的文件路径
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @date 2015年11月25日 上午10:32:24
	 */
	public static String upload(String filePath,MultipartFile file,String savePath) throws IllegalStateException, IOException{
		long filename=System.currentTimeMillis();
		String savename=filename+filePath.substring(filePath.lastIndexOf("."),filePath.length());
//		String savePath="";
//		savePath =Constant.SYSTEMROOTPATH+"upload"+File.separator +filename+ savename;
		String saveimgPath= Constant.SYSTEMROOTPATH +savePath + filename + savename;
        File localFile = new File(saveimgPath);  
        file.transferTo(localFile);
        String saveurl=savePath.replace("\\", "/")+filename+savename;
		return  saveurl;
	}
	
	
	
	
	public static void delPic(HttpServletRequest req,String[] images){
		if(images!=null && images.length>0){
//			String serverName = System.getProperty("os.name").toLowerCase();
//			String tt = "";
//			if (serverName.contains("windows")) {
//				tt = Constant.PICTUREPATH.substring(0,Constant.PICTUREPATH.lastIndexOf("\\"));
//			}else{
//				tt = Constant.PICTUREPATH.substring(0,Constant.PICTUREPATH.lastIndexOf("/"));
//			}
			File file = null;
	        String basePath = req.getSession().getServletContext().getRealPath("/");

			for (String str : images) {
				if(str!=null && !"".equals(str)){
					file = new File(basePath +File.separator+str);
				logger.debug("删除=="+basePath +File.separator+str);
				if(file.exists())
					file.delete();
				}
			}
		}
	}
	
	
}
