<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript" src="js/common/grid.js"></script>
	<script type="text/javascript">
			$(function(){
				var c = new GridConfig();
				c.set$table($('#t_emp'));
				c.setTitle('离职员工列表');
				c.setCollapsible(true);
				c.setFrozenColumns(false);
				c.setStriped(true);
				c.setRownumbers(true);
				c.setPagination(true);
				c.setFitColumns(true);
				c.setLoadMsg('数据加载中...');
				c.setUrl('Employee_outEmployeeList.action');
				c.setColumn('员工姓名','ename','100', 2 ,'center' , true);
				c.setColumn('性别','sex','50', 2 ,'center' , true , function(value , record , index){
						if(value == 1){
								return "<span style='color:red;'>男</span>";
						} else {
								return "<span style='color:green;'>女</span>"; 
						}		
				});
				c.setColumn('入职日期','ruzhiTime','80', 2 ,'center' , true);
				c.setColumn('辞职日期','cizhiTime','80', 2 ,'center' , true);
				c.setColumn('辞职原因','cizhiReason','200', 2 ,'center' , true);
				c.setColumn('基本待遇','baseSalary','80', 2 ,'center' , true);
				c.setColumn('所属机构','orgName','100', 2 ,'center' , true);
				c.setColumn('职位','jobNames','100', 2 ,'center' , true);
				c.setColumn('操作','op','100', 2 ,'center' , true , function(value , record , index){
						return "<a href=Employee_lookInfo.action?id=" +record.id +"  >查看详细</a>";
				});
				c.createDateGrid();
			});
	
	</script>
  </head>
  
  <body>
		<table id="t_emp"></table>
  </body>
</html>
