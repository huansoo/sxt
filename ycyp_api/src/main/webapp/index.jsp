<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form  id="form1" method="post" action="main.action?api=Department.getList"> 
     <table>
     	<tr>
     		<td><input type="text" name=""/></td>
     	</tr>
     </table>
	<!-- <textarea name="json" id="json" clos="1000" rows="30" warp="virtual">{"articleId":1,"createTime":1,"id":1,"opId":1,"status":1,"tagId":2,"tagName":"新闻","updateTime":1}</textarea> -->
	<input  id="GetDataBtn" value="测试" type="submit"/>  

<p><span id="article_link" style="display:none;z-index:100"></span></p>
</form>  
  </body>
</html>
