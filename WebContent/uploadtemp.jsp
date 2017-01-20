<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% 
    String datas = request.getParameter("datas");
    System.out.print("=============="+datas);
    %>
<html>
<body>
<%=datas%>
</body>
</html>