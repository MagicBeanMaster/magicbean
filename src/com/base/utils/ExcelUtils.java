package com.base.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @description Excel工具类 
 * @author lq
 * @date 2015年9月2日 上午10:47:51 
 * @version
 */
public class ExcelUtils {

	/**
	 * 
	 * @description 导入excel表格数据 
	 * @param filePath excel的存放位置
	 * @return 返回表格里的数据
	 * @throws IOException
	 * @author lq
	 * @throws InvalidFormatException 
	 * @date 2015年9月6日 上午9:28:18
	 */
	public static List<Map<String,Object>> readExcel(String filePath) throws IOException, InvalidFormatException{
		File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("传入的文件不存在：" + filePath);
        }
		List<Map<String,Object>> listmap=new ArrayList<Map<String,Object>>();
		String suffix=filePath.substring(filePath.lastIndexOf("."),filePath.length());
		Workbook workbook=null;
		if(".xlsx".equals(suffix)){//2007
			workbook=new XSSFWorkbook(OPCPackage.open(new FileInputStream(file)));
		}else{//.xls
			workbook = new HSSFWorkbook(new FileInputStream(filePath));   
		}
		listmap=readXls(workbook);
		return listmap;
	}
	/**
	 * 
	 * @description  根据上传文件 解析文件内容
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @date 2015年11月19日 上午10:57:32
	 */
	public static List<Map<String, Object>> readExcel(MultipartFile file) throws IOException, InvalidFormatException{
		List<Map<String,Object>> listmap=new ArrayList<Map<String,Object>>();
		
		String filePath = file.getOriginalFilename();
		String suffix=filePath.substring(filePath.lastIndexOf("."),filePath.length());
		Workbook workbook=null;
		if(".xlsx".equals(suffix)){//2007
			workbook=new XSSFWorkbook(OPCPackage.open(file.getInputStream()));
		}else{//.xls
			workbook = new HSSFWorkbook(file.getInputStream());   
		}
		listmap=readXls(workbook);
		
		return listmap;
	}
	
	public static void main(String[] args) {
//		String filePath="C:\\t.xls";
		String filePath="C:\\b.xlsx";
		try {
			List<Map<String,Object>> listmap=readExcel(filePath);
			for (Map<String, Object> map : listmap) {
				Set<?> s=map.keySet();
				for (Object o : s) {
					System.out.print(map.get(o)+"\t");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			ExceptionUtils.dealException(e);
		}
	}
	
	
	private static List<Map<String,Object>> readXls(Workbook workbook) throws IOException{
		List<Map<String,Object>> listmap=new ArrayList<Map<String,Object>>();
		int sheetnum=workbook.getNumberOfSheets();
		int countrownum;
		int countcolnum;
	    // 循环工作表Sheet  
	    for(int numSheet = 0; numSheet < sheetnum; numSheet++){  
	    	Sheet sheet=workbook.getSheetAt(numSheet);
	    	if(sheet == null){  
	    		break;  
	        }
	    	countrownum=sheet.getLastRowNum();
	    	// 循环行Row   
	    	for(int rowNum = 0; rowNum <= countrownum; rowNum++){  
	    		Map<String,Object> map=new LinkedHashMap<String, Object>();
	    		Row row=sheet.getRow(rowNum);
	    		if(row == null){  
	    			break;  
	    		}  
	    		countcolnum=row.getLastCellNum();
	    		// 循环列Cell    
	    		for(int cellNum = 0; cellNum <= countcolnum; cellNum++){ 
	    			Cell cell=row.getCell(cellNum);
	        		if(cell == null){  
	        		break;  
	        		}  
	        		map.put("col"+cellNum, getValue( cell));
	          
	        	}  
	    		listmap.add(map);
	    	}  
	    } 
	    
	    return listmap;
	}
	private static String getValue(Cell cell){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String ret;  
        if(cell!=null){
	        switch (cell.getCellType()) {  
	        case Cell.CELL_TYPE_BLANK:  
	            ret = "";  
	            break;  
	        case Cell.CELL_TYPE_BOOLEAN:  
	            ret = String.valueOf(cell.getBooleanCellValue());  
	            break;  
	        case Cell.CELL_TYPE_ERROR:  
	            ret = null;  
	            break;  
	        case Cell.CELL_TYPE_FORMULA:  
	            Workbook wb = cell.getSheet().getWorkbook();  
	            CreationHelper crateHelper = wb.getCreationHelper();  
	            FormulaEvaluator evaluator = crateHelper.createFormulaEvaluator();  
	            ret = getValue(evaluator.evaluateInCell(cell));
	            break;  
	        case Cell.CELL_TYPE_NUMERIC:  
	            if (DateUtil.isCellDateFormatted(cell)) {   
	                Date theDate = cell.getDateCellValue();  
	                ret = simpleDateFormat.format(theDate);  
	            } else {   
	                ret = NumberToTextConverter.toText(cell.getNumericCellValue());  
	            }  
	            break;  
	        case Cell.CELL_TYPE_STRING:  
	            ret = cell.getRichStringCellValue().getString();  
	            break;  
	        default:  
	            ret = null;  
	        }  
        }else{
        	ret="";
        }
        return ret;
	}  
	
	/**
	 * 
	 * @description 将下载的数据组装到Excel表格中 
	 * @param headmap 表格头标题
	 * @param listmap 表格数据
	 * @param filename 文件名称
	 * @return
	 */
	public static HSSFWorkbook  downloadExcel(Map<String,Object> headmap,List<Map<String,Object>> listmap,String filename){
		HSSFWorkbook wb=new HSSFWorkbook ();
		HSSFSheet sheet=wb.createSheet(filename);
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell=null;
		Set<String> headset=headmap.keySet();
		HSSFCellStyle style = wb.createCellStyle();   
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//样式居中 
        
		//设置表头
		int t=0;
		for (Object obj : headset) {
			cell=row.createCell(t);
			cell.setCellValue(headmap.get(obj)==null?"":headmap.get(obj).toString());
			cell.setCellStyle(style);
			t++;
		}
		
		for (int i = 0; i < listmap.size(); i++) {
			row=sheet.createRow(i+1);
			Map<String,Object> map=listmap.get(i);
			int temp=0;
			for (Object obj : headset) {
				cell=row.createCell(temp);
				cell.setCellValue(map.get(obj)==null?"":map.get(obj).toString());
				cell.setCellStyle(style);
				temp++;
			}
		}
		
		return wb;
	}
	
	/**
	 * 
	 * @description 下载Excel文档 
	 * @param headmap
	 * @param listmap
	 * @param filename
	 * @param response
	 * @throws IOException
	 */
	public static void reportExcel(Map<String,Object> headmap,List<Map<String,Object>> listmap,
			String filename,HttpServletResponse response) throws IOException{
		HSSFWorkbook wb=downloadExcel(headmap,listmap, filename);
		response.setContentType("application/vnd.ms-excel");  
		response.setHeader("content-disposition", "attachment;filename=" + filename + ".xls");  
		OutputStream fOut = response.getOutputStream();
        wb.write(fOut);  
        fOut.flush();  
        fOut.close();  
	}
	
	/**
	 * 
	 * @description 下载文件模板
	 * @param file
	 * @param request
	 * @param response
	 * @date 2015年11月19日 上午9:08:23
	 */
	public static void downloadExcelTemplate(File file , HttpServletResponse response){
		String fullFileName = file.getPath();
		String name = file.getName();
		String filetype = name.substring(name.indexOf("."),name.length());
		response.setContentType("application/vnd.ms-excel");  
		response.setHeader("content-disposition", "attachment;filename=" +"customertemplate" + filetype);  
        InputStream in;
		OutputStream out;
		try {
			in = new FileInputStream(fullFileName);  
			out = response.getOutputStream();
        int b;  
        while((b=in.read())!= -1)  
        {  
            out.write(b);  
        }  
        in.close();  
        out.close();  
		} catch (FileNotFoundException e) {
			ExceptionUtils.dealException(e);
		} catch (IOException e) {
			ExceptionUtils.dealException(e);
		} 
		
	}
	
	/**
	 * excle数据导出 2007
	 * @description 
	 * @param headmap 添加数据的头
	 * @param listmap 添加的数据
	 * @param workbook 被添加的excle表格
	 * @param sheetIndex 被添加表格的页签
	 * @date 2016年4月5日 上午11:57:32 
	 */
	public static Workbook xssfDownload(List<String> head,List<Map<String, Object>> listmap, XSSFWorkbook workbook, Integer sheetIndex) {
		/*设置表格样式*/
		XSSFCellStyle style = workbook.createCellStyle(); 
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		style.setFillForegroundColor((short) 13);
//		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框   
//		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框   
//		style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框   
//		style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		
		if (head != null || listmap != null) {//判断是否为空，如果都为空则不进行数据添加
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);//获取当前要操作的excle页签
			for (int i = 0; i < listmap.size(); i++) {//循环传入的数据
				XSSFRow row=sheet.createRow(sheet.getLastRowNum()+1);//在excle表格中的最后一行后面新建一行
				Map<String,Object> map=listmap.get(i);
//				Set<String> headset=headmap.keySet();
				int templat = 0;
				for (String obj : head) {
					XSSFCell cell=row.createCell(templat++);
					cell.setCellValue(map.get(obj)==null?"":map.get(obj).toString());
//					cell.setCellStyle(style);
				}
			}
		}
		return workbook;
	}
	
	/**
	 * excle数据导出(2003)
	 * @description 
	 * @param headmap 数据列（如果没有数据传null）有多少列数据及列名字
	 * @param listmap 添加的数据
	 * @param workbook 被添加的excle表格
	 * @param sheetIndex 被添加表格的页签
	 * @date 2016年4月5日 上午11:57:32 
	 */
	public static Workbook hssfDownload(List<String> head,List<Map<String, Object>> listmap, HSSFWorkbook workbook, Integer sheetIndex) {
		HSSFCellStyle style = workbook.createCellStyle(); //定义样式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
//		style.setFillForegroundColor((short) 13);//背景色
//		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框   
//		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框   
//		style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框   
//		style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		if (head != null || listmap != null) {//判断是否为空，如果都为空则不进行数据添加
			HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			for (int i = 0; i < listmap.size(); i++) {
				HSSFRow row=sheet.createRow(sheet.getLastRowNum()+1);
				Map<String,Object> map=listmap.get(i);
//				Set<String> headset=headmap.keySet();
				int templat = 0;
				for (String obj : head) {
					HSSFCell cell=row.createCell(templat++);
					cell.setCellValue(map.get(obj)==null?"":map.get(obj).toString());
				}
			}
		}
		return workbook;
	}
	
	/**
	 * @description 
	 * @param file 导出的文件
	 * @param headmap 数据列（如果没有数据传null）有多少列数据及列名字
	 * @param listmap 填充到列表中的数据（如果没有数据传null）
	 * @param filename 导出文件的名字
	 * @param response 
	 * @param sheetIndex excle的第几个页签（从0开始计数）
	 * @throws Exception
	 * @date 2016年4月5日 下午4:00:12 
	 */
	public static void reportExcel(File file,List<String> headmap,List<Map<String,Object>> listmap,
			String filename,HttpServletResponse response, Integer sheetIndex) throws Exception{
		String name = file.getName();
		String filetype = name.substring(name.indexOf("."),name.length());
		Workbook wb=null;
		if(".xlsx".equals(filetype)){//2007
			XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(new FileInputStream(file)));
			//修改表头数据，需定位到单元格才能实现修改
			
			wb= xssfDownload(headmap,listmap, workbook,sheetIndex);
		}else{//.xls 2003
			HSSFWorkbook hw = new HSSFWorkbook(new FileInputStream(file));
			//修改表头数据，需定位到单元格才能实现修改
			
			wb = hssfDownload(headmap,listmap,hw,sheetIndex);   
		}
		response.setContentType("application/vnd.ms-excel");  
		response.setHeader("content-disposition", "attachment;filename=" + new String(filename.getBytes("utf-8"), "ISO-8859-1") + filetype);  
		OutputStream fOut = response.getOutputStream();
        wb.write(fOut);  
        fOut.flush();  
        fOut.close();  
	}
	
	
	/**
	 * 导出的文件 修改表头 
	 * @description 
	 * @param file 导出的文件
	 * @param head 数据列（如果没有数据传null）有多少列数据及列名字
	 * @param listmap 填充到列表中的数据（如果没有数据传null）
	 * @param filename 导出文件的名字
	 * @param response 
	 * @param sheetIndex excle的第几个页签（从0开始计数）
	 * @param String title 表头
	 * @throws Exception
	 * @date 2016年4月7日 上午10:54:49 
	 */
	public static void reportExcelTitle(File file,List<String> head,List<Map<String,Object>> listmap,
			String filename,HttpServletResponse response, Integer sheetIndex,String title) throws Exception{
		String name = file.getName();
		String filetype = name.substring(name.indexOf("."),name.length());
		Workbook wb=null;
		
		if(".xlsx".equals(filetype)){//2007
			XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(new FileInputStream(file)));
			
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell=row.getCell(0);
			cell.setCellValue(title);
			
			wb= xssfDownload(head,listmap, workbook,sheetIndex);
		}else{//.xls 2003
			HSSFWorkbook hw = new HSSFWorkbook(new FileInputStream(file));
			
			Sheet sheet = hw.getSheetAt(sheetIndex);
			Row row = sheet.getRow(0);
			Cell cell=row.getCell(0);
			cell.setCellValue(title);
			
			wb = hssfDownload(head,listmap,hw,sheetIndex);   
		}
		response.setContentType("application/vnd.ms-excel");  
		response.setHeader("content-disposition", "attachment;filename=" + new String(filename.getBytes("utf-8"), "ISO-8859-1") + filetype);  
		OutputStream fOut = response.getOutputStream();
        wb.write(fOut);  
        fOut.flush();  
        fOut.close();  
	}
}
