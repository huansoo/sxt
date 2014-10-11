<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'employee_resign.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript" src="js/common/validations.js"></script>
	<script type="text/javascript" src="js/common/utils.js"></script>
	
	<script type="text/javascript"> 
				$(function(){

					$('#cizhiTime , #lizhiTime').datebox({
							currentText: '今天' ,
							closeText: '关闭' ,
							disabled : false,
							required : true,
							missingMessage : '必填字段!' , 
							formatter : formatDate
					});


					$('#subform').click(function(){
							if($('#myform').form('validate')){
								$('#myform').get(0).submit();
							} else {
								$.messager.alert('提示' ,'提交失败!','error');
							}
					});



				});
	
	
	</script>
  </head>
  
  <body>
			<div id="p" class="easyui-panel" style="width:700px;height:400px;padding:10px;"
				title="辞职信息归档" iconCls="icon-add"
				collapsible="true" maximizable=true >
						<form id="myform" action="Employee_resign.action" method="post">
								<input type="hidden" name="employeeVO.id" value="${employeeVO.id}" />
								<table border="0" align=center >
									<tr  >
										<td colspan="2" align=center >
												<b>员工【${employeeVO.ename}】辞职登记</b>
										</td>
									</tr>								
									<tr >
										<td>辞职日期:</td>
										<td><input id="cizhiTime"  name="employeeVO.cizhiTime" value="" /></td>
									</tr>
									<tr>
										<td>真正离职日期:</td>
										<td><input id="lizhiTime"  name="employeeVO.lizhiTime" value="" /></td>
									</tr>		
									<tr>
										<td>离职原因:</td>
										<td><textarea class="easyui-validatebox" required="true" missingMessage="该字段必填!" id="cizhireason" name="employeeVO.cizhiReason" rows="7" cols="50"></textarea></td>
									</tr>
									<tr >
										<td colspan="2">
									 		<a class="easyui-linkbutton" id="subform" iconCls="icon-ok" href="javascript:void(0)" >提交申请</a>
	  										<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:history.back();">返回</a>										
										</td>
									</tr>																	
								</table>
						
						
						</form>
			
			
			</div>
  </body>
</html>
