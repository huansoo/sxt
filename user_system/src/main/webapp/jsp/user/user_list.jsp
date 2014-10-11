<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript" src="js/common/validations.js"></script>		
	<script type="text/javascript" src="js/common/grid.js"></script>
	<script type="text/javascript">
			$(function(){
				var cfg = new GridConfig();
				cfg.set$table($('#t_user'));
				cfg.setTitle('用户列表');
				cfg.setCollapsible(true);
				cfg.setFitColumns(true);
				cfg.setLoadMsg('数据正在装载中');
				cfg.setUrl('User_getList.action');
				cfg.setPagination(true);
				cfg.setRownumbers(true);
				cfg.setStriped(true);
				cfg.setColumn('账号' , 'uname' , '200' , 2 , 'center' , true);
				cfg.setColumn('员工姓名' , 'ename' , '100' , 2 , 'center' , true);
				cfg.setColumn('状态' , 'state' , '100' , 2 , 'center' , true);
				cfg.setColumn('操作' ,'op' , '100' , 2 , 'center' , true , function(value , record , index ){ 
						if(record.state == '有效'){
							return "<a href=User_userOut.action?id="+ record.id+" >注销</a>";
						} else {
							return "<a href=User_userIn.action?id="+ record.id+">有效</a>";
						} 
				});
				cfg.createDateGrid();
			});
	</script>
  </head>
  
  <body>
    	
  </body>
  
  	<table id="t_user"></table>
</html>
