package com.base.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFileGenerator {
	//dao层包名
	private static final String dao = "dao";
	//service层包名
	private static final String service = "services";
	
	private static final String str = "\\";
	
	private static final String str1 = ".";
	//basedao包
	private static final String baseDao = "com.booty.sys.dao";
	//basedao类名
	private static final String baseDaoClassName = "BaseDao";
	//basedao类注入名
	private static final String baseDaoInfuseName = "baseDaoPackage";
	//分页对象包名
	private static final String pagePackageName = "com.base.entity.pojo";
	//分页对象
	private static final String pageClassName = "Page";
	//类的注释
	private static final String classRemark = "员工岗位信息";
	//作者名
	private static final String authorname = "yangzx";
	
	public static void Generate(@SuppressWarnings("rawtypes") Class clazz) throws Exception{  
		generateDaoFile(clazz);
		generateDaoImplFile(clazz);
		generateServiceFile(clazz);
		generateServiceImplFile(clazz);
    }  
	
	protected static void generateDaoFile(@SuppressWarnings("rawtypes") Class clazz) throws Exception {
		String simpleName = clazz.getSimpleName().replaceFirst("T", "");
		String originalName = clazz.getSimpleName();
        StringBuilder sBuilder = new StringBuilder(1000);  
        String clazzname = clazz.getPackage().getName();
        sBuilder.append("package " + getPackageName(clazzname,str1) + dao + str1 + simpleName.toLowerCase() + ";");  
        sBuilder.append("\n\n");  
        sBuilder.append("import java.util.List;\n");
        sBuilder.append("import java.util.Map;\n\n");
        sBuilder.append("import " + clazz.getPackage().getName() + str1 + originalName + ";\n"); 
        sBuilder.append("import " + pagePackageName + str1 + pageClassName + ";\n\n"); 
        sBuilder.append("/**\n");
        sBuilder.append(" *\n");
        sBuilder.append(" * @description " + classRemark + "Dao层数据访问接口\n");
        sBuilder.append(" * @author "+authorname+" \n");
        sBuilder.append(" * @date "+ getNowDate() +"\n");
        sBuilder.append(" * @version 1.0\n");
        sBuilder.append(" */\n");
        sBuilder.append("public interface " + simpleName + "Dao { \n\n"); 
        generateSaveInterface(simpleName, originalName, sBuilder);
        generateUpdateInterface(simpleName, originalName, sBuilder);
        generateInfoByIdInterface(simpleName, originalName, sBuilder);
        generateListByPageInterface(simpleName, originalName, sBuilder);
        sBuilder.append("}\n");  
        String path = getPackageName(clazzname,str) + "dao" + str + simpleName.toLowerCase();
        writeStringFileToDesk(sBuilder.toString().getBytes(),path,simpleName+"Dao");  
  
//        System.out.println("=====================");  
//        System.out.println(sBuilder.toString());  
	}
	protected static void generateDaoImplFile(@SuppressWarnings("rawtypes") Class clazz) throws Exception {
		String simpleName = clazz.getSimpleName().replaceFirst("T", "");
		String originalName = clazz.getSimpleName();
        StringBuilder sBuilder = new StringBuilder(1000);  
        String clazzname = clazz.getPackage().getName();
        String packgename = getPackageName(clazzname,str1);
        sBuilder.append("package " + packgename + dao + str1 + simpleName.toLowerCase() + ".impl;");  
        sBuilder.append("\n\n");  
        sBuilder.append("import java.util.ArrayList;\n"); 
        sBuilder.append("import java.util.List;\n"); 
        sBuilder.append("import java.util.Map;\n\n"); 
        sBuilder.append("import javax.annotation.Resource;\n\n");
//        sBuilder.append("import org.apache.commons.lang.StringUtils;\n"); 
        sBuilder.append("import org.springframework.stereotype.Repository;\n\n"); 
        sBuilder.append("import " + clazzname + str1 + originalName + ";\n");  
        sBuilder.append("import " + pagePackageName + str1 + pageClassName + ";\n"); 
        sBuilder.append("import " + packgename + dao + str1 + simpleName.toLowerCase() + "." + simpleName + "Dao;\n");  
        sBuilder.append("import "+ baseDao + str1 + baseDaoClassName + ";\n\n"); 
        sBuilder.append("/**\n");
        sBuilder.append(" *\n");
        sBuilder.append(" * @description " + classRemark + "Dao层接口实现类\n");
        sBuilder.append(" * @author "+authorname+" \n");
        sBuilder.append(" * @date "+ getNowDate() +"\n");
        sBuilder.append(" * @version 1.0\n");
        sBuilder.append(" */\n");
        sBuilder.append("@Repository(\""+simpleName.toLowerCase()+"Dao\")\n");
        sBuilder.append("public class " + simpleName + "DaoImpl implements "+simpleName+"Dao { \n\n"); 
        sBuilder.append("\t@Resource\n");
        sBuilder.append("\tprivate "+ baseDaoClassName + " " + baseDaoInfuseName +";\n\n");
        generateSaveInterfaceImpl(simpleName, originalName, sBuilder);
        generateUpdateInterfaceImpl(simpleName, originalName, sBuilder);
        generateInfoByIdInterfaceImpl(simpleName, originalName, sBuilder);
        generateListByPageInterfaceImpl(simpleName, originalName, sBuilder);
        sBuilder.append("}\n");  
        
        String path = getPackageName(clazzname,str) + dao + str + simpleName.toLowerCase() + str +"impl";
        writeStringFileToDesk(sBuilder.toString().getBytes(),path,simpleName+"DaoImpl");  
  
//        System.out.println("=====================");  
//        System.out.println(sBuilder.toString());  
	}
	protected static void generateServiceFile(@SuppressWarnings("rawtypes") Class clazz) throws Exception {
		String simpleName = clazz.getSimpleName().replaceFirst("T", "");
		String originalName = clazz.getSimpleName();
		StringBuilder sBuilder = new StringBuilder(1000); 
		String clazzname = clazz.getPackage().getName();
        sBuilder.append("package " + getPackageName(clazzname,str1) + service + str1 + simpleName.toLowerCase()+";");  
        sBuilder.append("\n\n");  
        sBuilder.append("import java.util.List;\n");
        sBuilder.append("import java.util.Map;\n\n");
        sBuilder.append("import " + clazzname + str1 + originalName + ";\n");
        sBuilder.append("import " + pagePackageName + str1 + pageClassName + ";\n\n");
        sBuilder.append("/**\n");
        sBuilder.append(" *\n");
        sBuilder.append(" * @description " + classRemark + "业务逻辑处理接口\n");
        sBuilder.append(" * @author "+authorname+" \n");
        sBuilder.append(" * @date "+ getNowDate() +"\n");
        sBuilder.append(" * @version 1.0\n");
        sBuilder.append(" */\n");
        sBuilder.append("public interface " + simpleName + "Service { \n\n"); 
        generateSaveInterface(simpleName, originalName, sBuilder);
        generateUpdateInterface(simpleName, originalName, sBuilder);
        generateInfoByIdInterface(simpleName, originalName, sBuilder);
        generateListByPageInterface(simpleName, originalName, sBuilder);
        sBuilder.append("}\n");  
        
        String path = getPackageName(clazzname,str) + service + str + simpleName.toLowerCase();
        writeStringFileToDesk(sBuilder.toString().getBytes(),path,simpleName+"Service");  
  
//        System.out.println("=====================");  
//        System.out.println(sBuilder.toString());  
	}
	protected static void generateServiceImplFile(@SuppressWarnings("rawtypes") Class clazz) throws Exception {
		String simpleName = clazz.getSimpleName().replaceFirst("T", "");
		String originalName = clazz.getSimpleName();
        StringBuilder sBuilder = new StringBuilder(1000); 
        String clazzname = clazz.getPackage().getName();
        String packgename = getPackageName(clazzname,str1);
        sBuilder.append("package "+ packgename + service + str1 +simpleName.toLowerCase()+".impl;");  
        sBuilder.append("\n\n");  
//        sBuilder.append("import java.util.ArrayList;\n"); 
        sBuilder.append("import java.util.List;\n"); 
        sBuilder.append("import java.util.Map;\n\n"); 
        sBuilder.append("import javax.annotation.Resource;\n\n");
//        sBuilder.append("import org.apache.commons.lang.StringUtils;\n"); 
        sBuilder.append("import org.springframework.stereotype.Repository;\n\n"); 
        sBuilder.append("import "+ packgename + dao + str1 + simpleName.toLowerCase() + str1 + simpleName +"Dao;\n");  
        sBuilder.append("import " + clazzname + str1 + originalName + ";\n");  
        sBuilder.append("import "+ packgename + service + str1 + simpleName.toLowerCase() + "." + simpleName + "Service;\n"); 
        sBuilder.append("import " + pagePackageName + str1 + pageClassName + ";\n\n"); 
        sBuilder.append("/**\n");
        sBuilder.append(" *\n");
        sBuilder.append(" * @description " + classRemark + "业务逻辑处理实现类\n");
        sBuilder.append(" * @author "+authorname+" \n");
        sBuilder.append(" * @date "+ getNowDate() +"\n");
        sBuilder.append(" * @version 1.0\n");
        sBuilder.append(" */\n");
        sBuilder.append("@Repository(\""+simpleName.toLowerCase()+"Service\")\n");
        sBuilder.append("public class " + simpleName + "ServiceImpl implements "+simpleName+"Service { \n\n"); 
        sBuilder.append("\t@Resource\n");
        sBuilder.append("\tprivate " + simpleName + "Dao " + simpleName.toLowerCase() + "Dao;\n\n");
        generateSaveServiceInterfaceImpl(simpleName, originalName, sBuilder);
        generateUpdateServiceInterfaceImpl(simpleName, originalName, sBuilder);
        generateInfoByIdServiceInterfaceImpl(simpleName, originalName, sBuilder);
        generateListByPageServiceInterfaceImpl(simpleName, originalName, sBuilder);
        sBuilder.append("}\n");  
        
        String path = getPackageName(clazzname,str) + service + str +simpleName.toLowerCase()+ str +"impl";
        writeStringFileToDesk(sBuilder.toString().getBytes(),path,simpleName+"ServiceImpl");  
  
//        System.out.println("=====================");  
//        System.out.println(sBuilder.toString());  
	}
	
    protected static void generateSaveInterface(String simpleName, String originalName, StringBuilder sBuilder) { 
    	sBuilder.append("\t/**\n");
    	sBuilder.append("\t *\n");
    	sBuilder.append("\t * @description  保存"+originalName+"实体信息\n");
    	sBuilder.append("\t * @param "+simpleName.toLowerCase()+" \n");
    	sBuilder.append("\t * @return 返回实体保存成功的主键\n");
    	sBuilder.append("\t * @date "+ getNowDate() +" \n");
    	sBuilder.append("\t */\n");
        sBuilder.append("\tpublic int save" + simpleName + "("+originalName+ " " + simpleName.toLowerCase() +");\n\n");  
    }  
    protected static void generateSaveInterfaceImpl(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t@Override\n");
    	sBuilder.append("\tpublic int save" + simpleName + "(" + originalName + " " + simpleName.toLowerCase() +"){\n");  
        sBuilder.append("\t\treturn "+ baseDaoInfuseName +".saveOrUpdateObj(" + simpleName.toLowerCase() + ");\n");
        sBuilder.append("\t}\n\n");  
    }
    protected static void generateSaveServiceInterfaceImpl(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t@Override\n");
    	sBuilder.append("\tpublic int save" + simpleName + "("+originalName+ " " + simpleName.toLowerCase() +"){\n");  
        sBuilder.append("\t\treturn "+simpleName.toLowerCase()+"Dao.save" + simpleName + "(" + simpleName.toLowerCase() +");\n");
        sBuilder.append("\t}\n\n");  
    }
    
    
    protected static void generateUpdateInterface(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t/**\n");
    	sBuilder.append("\t *\n");
    	sBuilder.append("\t * @description  修改"+originalName+"实体信息\n");
    	sBuilder.append("\t * @param "+simpleName.toLowerCase()+" \n");
    	sBuilder.append("\t * @return 返回受影响行数\n");
    	sBuilder.append("\t * @date "+ getNowDate() +" \n");
    	sBuilder.append("\t */\n");
        sBuilder.append("\tpublic int update" + simpleName + "("+originalName+ " " + simpleName.toLowerCase() +");\n\n");  
    }
    protected static void generateUpdateInterfaceImpl(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t@Override\n");
    	sBuilder.append("\tpublic int update" + simpleName + "("+originalName+ " " + simpleName.toLowerCase() +"){\n");  
        sBuilder.append("\t\treturn " + baseDaoInfuseName + ".saveOrUpdate("+simpleName.toLowerCase()+");\n");  
        sBuilder.append("\t}\n\n");  
    } 
    protected static void generateUpdateServiceInterfaceImpl(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t@Override\n");
    	sBuilder.append("\tpublic int update" + simpleName + "("+originalName+ " " + simpleName.toLowerCase() +"){\n");  
    	sBuilder.append("\t\treturn "+simpleName.toLowerCase()+"Dao.update" + simpleName + "(" + simpleName.toLowerCase() +");\n");
        sBuilder.append("\t}\n\n");  
    }
    
    protected static void generateListByPageInterface(String simpleName, String originalName, StringBuilder sBuilder) { 
    	sBuilder.append("\t/**\n");
    	sBuilder.append("\t *\n");
    	sBuilder.append("\t * @description  根据page获取" + originalName + "列表 (分页)\n");
    	sBuilder.append("\t * @param page 参数列表\n");
    	sBuilder.append("\t * @return 返回查询结果listmap集\n");
    	sBuilder.append("\t * @date "+ getNowDate() +" \n");
    	sBuilder.append("\t */\n");
        sBuilder.append("\tpublic List<Map<String, Object>> query" + simpleName + "ListByPage(Page page);\n\n");  
    }
    protected static void generateListByPageInterfaceImpl(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t@Override\n");
    	sBuilder.append("\tpublic List<Map<String, Object>> query" + simpleName + "ListByPage(Page page){\n"); 
        sBuilder.append("\t\tStringBuilder preSql = new StringBuilder();\n");
        sBuilder.append("\t\tList<Object> parameterLists = new ArrayList<Object>();\n");
        sBuilder.append("\t\tMap<String, Object> map = page.getParamsMap();\n");
        sBuilder.append("\t\t//在这里添加你自己的条件代码^.^\n\n\n\n");
//        sBuilder.append("\t\tpreSql.append(\" order by ta.createtime desc \");\n ");
        sBuilder.append("\t\tInteger startIndex= page.getStartIndex();\n");
        sBuilder.append("\t\tInteger pageSize= page.getPageSize(); \n");
        sBuilder.append("\t\tif (startIndex!=null && pageSize!=null ) {\n");
        sBuilder.append("\t\t\tpreSql .append(\" limit ?,?\");\n");
        sBuilder.append("\t\t\tparameterLists.add(startIndex);\n");
        sBuilder.append("\t\t\tparameterLists.add(pageSize);\n");
        sBuilder.append("\t\t}\n");
        sBuilder.append("\t\treturn "+ baseDaoInfuseName +".queryForList(preSql.toString(),parameterLists);\n");
        sBuilder.append("\t}\n\n");
    }
    protected static void generateListByPageServiceInterfaceImpl(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t@Override\n");
    	sBuilder.append("\tpublic List<Map<String, Object>> query" + simpleName + "ListByPage(Page page){\n");  
    	sBuilder.append("\t\treturn " + simpleName.toLowerCase() + "Dao.query" + simpleName + "ListByPage(page);\n");
        sBuilder.append("\t}\n\n");    
    }
    
    
    protected static void generateInfoByIdInterface(String simpleName, String originalName, StringBuilder sBuilder) { 
    	sBuilder.append("\t/**\n");
    	sBuilder.append("\t *\n");
    	sBuilder.append("\t * @description  根据"+simpleName.toLowerCase()+"id 查询 "+originalName+"信息\n");
    	sBuilder.append("\t * @param "+simpleName.toLowerCase()+"id \n");
    	sBuilder.append("\t * @return \n");
    	sBuilder.append("\t * @date "+ getNowDate() +" \n");
    	sBuilder.append("\t */\n");
        sBuilder.append("\tpublic "+originalName+" query" + simpleName + "By"+simpleName+"id(int "+simpleName.toLowerCase()+"id);\n\n");  
    }
    protected static void generateInfoByIdInterfaceImpl(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t@Override\n");
    	sBuilder.append("\tpublic " + originalName + " query" + simpleName + "By" + simpleName + "id(int " + simpleName.toLowerCase() + "id){\n"); 
        sBuilder.append("\t\tStringBuilder preSql = new StringBuilder(\" select * from t_" + simpleName.toLowerCase() + " where id =? \");\n");
        sBuilder.append("\t\tList<Object> parameterLists = new ArrayList<Object>();\n");
        sBuilder.append("\t\tparameterLists.add("+simpleName.toLowerCase()+"id);\n");
        sBuilder.append("\t\treturn "+ baseDaoInfuseName +".queryForObject(preSql.toString(), parameterLists, " + originalName + ".class);\n");
        sBuilder.append("\t}\n\n");
    }
    protected static void generateInfoByIdServiceInterfaceImpl(String simpleName, String originalName, StringBuilder sBuilder) {  
    	sBuilder.append("\t@Override\n");
    	sBuilder.append("\tpublic " + originalName + " query" + simpleName + "By" + simpleName + "id(int " + simpleName.toLowerCase() + "id){\n");  
    	sBuilder.append("\t\treturn " + simpleName.toLowerCase() + "Dao.query" + simpleName + "By" + simpleName + "id(" + simpleName.toLowerCase() + "id);\n");
        sBuilder.append("\t}\n\n");    
    }
    
    protected static void writeStringFileToDesk(byte[] data,String path,String fileName)throws Exception{ 
        File file = new File(System.getProperty("user.dir") + str + "src"+ str +path,fileName + ".java");  
        if(!file.getParentFile().exists()){  
            file.getParentFile().mkdirs();  
        }  
//        System.out.println("file.getAbsolutePath()---> " + file.getAbsolutePath());  
        OutputStream os = new FileOutputStream(file);  
        os.write(data,0,data.length);
        os.flush();
        os.close();  
    } 
    
    protected static String getNowDate() {
        Calendar now = Calendar.getInstance();  
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日 ahh:mm:ss ");   
        return fmt.format(now.getTime()); 
	}
    
    protected static String getPackageName(String name,String str){
    	String temp = ""; 
    	String[] string= name.split("\\.");
        for (int i = 0; i < string.length-1; i++) {
        	temp += string[i]+str;
		}
    	return temp;
    }
    
    public static void main(String[] args) throws Exception {
    	//===========单个生成类==========
    	long start = System.currentTimeMillis();
    	@SuppressWarnings("rawtypes")
    	Class clazz = Class.forName("com.personnel.base.entity.TPost");  
        System.out.println(clazz.getSimpleName());  
        MyFileGenerator.Generate(clazz); 
    	System.out.println(System.currentTimeMillis()-start);
    	
    	
//    	//============批量生成类============== 
//        File file=new File("D:\\workspace\\Personnel\\src\\com\\base\\entity\\");
//        String test[]  = file.list();
//        String className = null;
//        @SuppressWarnings("rawtypes")
//		Class clazz = null;
//        long start = System.currentTimeMillis();
//        for(int i=0;i<test.length;i++){
//        	className = test[i];
//        	if(!"pojo".equals(className)){
//        		className = className.replace(".java", "");
//        		clazz = Class.forName("com.personnel.base.entity."+className);  
//                MyFileGenerator.Generate(clazz); 
//        	}
//        }
//        System.out.println(System.currentTimeMillis()-start);
	}
    
    
}
