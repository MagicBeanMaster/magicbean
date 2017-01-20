<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传文件</title>
</head>
<body>

<form action="<%=basePath %>tool/uploadfile.php" method="post" enctype="multipart/form-data">

<table>
	<tr>
		<td>上传文件</td>
		<td><input type="file" name="file" /></td>
	</tr>
	<tr>
		<td>存放位置</td>
		<td><input type="text" name="saveposition" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="提交" /><input type="reset" value="清除" /></td>
	</tr>
</table>

</form>
</body>
</html>