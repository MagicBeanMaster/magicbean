package com.base.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DbInfo1 {
	private static Properties properties = new Properties();
	static {
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static String clazzName = properties.getProperty("jdbc.driverClassName");
	private static String url = properties.getProperty("jdbc.url");
	private static String username = properties.getProperty("jdbc.username");
	private static String password = properties.getProperty("jdbc.password");
	private static String databaseName = url.substring(url.lastIndexOf("/")+1,url.indexOf("?"));

	public String getFileName(String tablename) {
		String FileName = tablename.substring(0, 1).toUpperCase();
		String[] arr = tablename.substring(1).split("_");
		for (String s : arr) {
			if (s.length() > 1) {
				s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
			}
			FileName += s;
		}
		return FileName;
	}

	/**
	 * 
	 * @param con
	 * @param databaseName
	 * @param pojoPath
	 * @param packageName
	 * @throws SQLException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void createPojoFileByDatabase(Connection con, String pojoPath, String packageName)
			throws SQLException, UnsupportedEncodingException, IOException {
		Statement statement = con.createStatement();
		String allTables = "select DISTINCT(TABLE_NAME) from  INFORMATION_SCHEMA.COLUMNS where TABLE_SCHEMA = '"
				+ databaseName + "'";
		ResultSet allTableRet = statement.executeQuery(allTables);
		while (allTableRet.next()) {
			String tableName = allTableRet.getString("TABLE_NAME");
			createPojoFileByTableName(con, pojoPath, packageName, tableName);
		}

	}

	public void createPojoFileByTableName(Connection con, String pojoPath, String packageName,
			String tableName) throws SQLException, UnsupportedEncodingException, IOException {
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery(
				"select IS_NULLABLE,COLUMN_NAME,DATA_TYPE,CHARACTER_MAXIMUM_LENGTH,COLUMN_COMMENT,COLUMN_KEY,EXTRA from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='"
						+ tableName + "' and TABLE_SCHEMA = '" + databaseName + "'");
		String FileName = getFileName(tableName);
		File java = new File(pojoPath + FileName + ".java");
		OutputStream os = new FileOutputStream(java);
		String packageInfo = "package " + packageName + ";\n";
		packageInfo += "import javax.persistence.GeneratedValue;\n";
		packageInfo += "import javax.persistence.GenerationType;\n";
		packageInfo += "import javax.persistence.Id;\n";
		packageInfo += "import javax.persistence.Table;\n\n";
		String classInfo = "@Table(name=\"" + tableName + "\")\npublic class " + FileName
				+ " implements java.io.Serializable {\n";
		String getSetTemplate = "";
		String overrideToString = "\t@Override\n\tpublic String toString() { \n";
		overrideToString += "\t\treturn \"" + FileName + "[";
		int i = 0;
		while (res.next()) {
			String columnName = res.getString("COLUMN_NAME");
			String dataType = res.getString("DATA_TYPE");
			String columnComment = res.getString("COLUMN_COMMENT");
			String COLUMN_KEY = res.getString("COLUMN_KEY").toUpperCase();
			String EXTRA = res.getString("EXTRA").toLowerCase();
			String javaType = typeConverter(dataType.toLowerCase());
			/*
			 * if(javaType.equals("java.lang.String")){ getInsertSqlValues
			 * +="'\""+"+"+columnName+"+"+"\"',"; }else{ getInsertSqlValues
			 * +="\""+"+"+columnName+"+"+"\","; }
			 */
			if (COLUMN_KEY.equals("PRI")) {
				classInfo += "\t@Id\n";
				if (EXTRA.equals("auto_increment")) {
					classInfo += "\t@GeneratedValue(strategy=GenerationType.AUTO)\n";
					i--;
				} else {
					// getInsertSql+= columnName+",";
					// getInsertSqlValues +="?,";
					// getInsertParameterBody +=
					// "\t\to["+i+"]="+columnName+";\n";
					classInfo += "\t@GeneratedValue(strategy=GenerationType.TABLE)\n";
					i--;
				}
			} else {
				// getInsertSql+= columnName+",";
				// getInsertSqlValues +="?,";
				// getInsertParameterBody += "\t\to["+i+"]="+columnName+";\n";
			}
			classInfo += "\tprivate " + javaType + " " + columnName + ";//" + columnComment + "\n";
			String functionName = columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
			getSetTemplate += "\tpublic void set" + functionName + "(" + javaType + " " + columnName + "){\n";
			getSetTemplate += "\t\tthis." + columnName + "=" + columnName + ";\n";
			getSetTemplate += "\t}\n";
			getSetTemplate += "\tpublic " + javaType + " get" + functionName + "(){\n";
			getSetTemplate += "\t\treturn " + columnName + ";\n";
			getSetTemplate += "\t}\n";
			overrideToString += columnName + "=\"" + "+" + columnName + "+" + "\",";
			i++;
		}
		// getInsertParameter+="\t\tObject[] o=new
		// Object["+i+"];\n"+getInsertParameterBody+"\t\treturn o;\n\t}\n";
		res.close();
		statement.close();
		overrideToString = overrideToString.substring(0, overrideToString.length() - 1) + "]\";\n";
		overrideToString += "\t}\n";
		classInfo += "\tpublic " + FileName + "(){\n\n\t}\n";
		// String getTableName = "\tpublic java.lang.String
		// getRealTableName(){\n\t\treturn \""+tableName+"\";\n\t}\n";
		// String insertSqlFunction = getInsertSql.substring(0,
		// getInsertSql.length()-1)+")"+getInsertSqlValues.toString().substring(0,
		// getInsertSqlValues.length()-1)+")"+"\""+";\n";
		// insertSqlFunction+="\t\treturn insertSql;\n";
		// insertSqlFunction+="\t}\n";
		String fileContent = packageInfo + classInfo + getSetTemplate + overrideToString + "}";
		os.write(fileContent.getBytes("utf-8"));
		os.flush();
		os.close();
	}

	public Connection getConnection()
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException, IOException {
		Connection con = null;
		Class.forName(clazzName);
		con = DriverManager.getConnection(url, username, password);
		return con;
	}

	public String typeConverter(String dbtype) {
		String javaType = "java.lang.String";
		switch (dbtype) {
		case "bigint":
			javaType = "java.math.BigInteger";
			break;
		case "int":
			javaType = "java.lang.Integer";
			break;
		case "datetime":
			javaType = "java.sql.Timestamp";
			break;
		case "timestamp":
			javaType = "java.sql.Timestamp";
			break;
		case "varchar":
			javaType = "java.lang.String";
			break;
		case "text":
			javaType = "java.lang.String";
			break;
		case "char":
			javaType = "java.lang.String";
			break;
		case "blob":
			javaType = "java.lang.byte[]";
			break;
		case "integer":
			javaType = "java.lang.Long";
			break;
		case "tinyint":
			javaType = "java.lang.Integer";
			break;
		case "smallint":
			javaType = "java.lang.Integer";
			break;
		case "mediumint":
			javaType = "java.lang.Integer";
			break;
		case "bit":
			javaType = "java.lang.Boolean";
			break;
		case "float":
			javaType = "java.lang.Float";
			break;
		case "double":
			javaType = "java.lang.Double";
			break;
		case "decimal":
			javaType = "java.math.BigDecimal";
			break;
		case "date":
			javaType = "java.util.Date";
			break;
		case "time":
			javaType = "java.sql.Time";
			break;
		case "year":
			javaType = "java.util.Date";
			break;
		default:
			break;
		}
		return javaType;
	}
	

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException, IOException {
		
		 String pojoPath ="C:\\Users\\Administrator\\Desktop\\info\\src\\com\\base\\entity\\"; 
		 String packageName ="com.base.entity"; 
		 DbInfo1 dbInfo = new DbInfo1(); 
		 long start = System.currentTimeMillis();
		 dbInfo.createPojoFileByTableName(dbInfo.getConnection(), pojoPath, packageName, "t_roomtype");
//		 dbInfo.createPojoFileByDatabase(dbInfo.getConnection(), pojoPath, packageName);
		 System.out.println(System.currentTimeMillis()-start);
	}
}
