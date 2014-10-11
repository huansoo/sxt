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
	<script type="text/javascript" src="js/common/validations.js"></script>
	<script type="text/javascript" src="js/common/utils.js"></script>
	<script type="text/javascript">
			
	</script>
  </head>
  
  <body>
  		<div id="p" class="easyui-panel" style="width:700px;height:400px;padding:10px;"
				title="用户新增" iconCls="icon-add"
				collapsible="true" maximizable=true >
 				<table>
 						<tr>
 							<td>员工姓名：</td>
 							<td>${employeeVO.ename}</td>
 						</tr>
 						<tr>
 							<td>出生日期：</td>
 							<td>${employeeVO.birthday}</td>
 						</tr>
						<tr>
							<td>性别：</td>
							<td>
								  ${employeeVO.sex eq 1?"男":"女"}
							</td>
						</tr>
 						<tr>
 							<td>身份证号：</td>
 							<td>
 								${employeeVO.cardId}
 							</td>
 						</tr>
 						<tr>
 							<td>家庭地址：</td>
 							<td>${employeeVO.address}</td>
 						</tr>
 						<tr>
 							<td>所属机构：</td>
 							<td>${employeeVO.orgName eq null ?"该员工没有设置所属机构":employeeVO.orgName}</td>
 						</tr>
 						<tr>
 							<td>职位:</td>
 							<td><a href="javascript:void(0);">选择所在职位</a></td>
 						</tr>
 						<tr>
 							<td>底薪：</td>
 							<td>
 								${employeeVO.baseSalary}
 							</td>
 						</tr>
 						<tr>
 							<td>电话补助：</td>
 							<td>${employeeVO.phoneComm}</td>
 						</tr>
 						<tr>
 							<td>交通补助</td>
 							<td>${employeeVO.busComm}</td>
 						</tr>
 						<tr>
 							<td>保险补助</td>
 							<td>${employeeVO.baoxianComm}</td>
 						</tr>
 						<tr>
 							<td>入职日期</td>
 							<td>${employeeVO.ruzhiTime}</td>
 						</tr>
 						<tr>
 							<td colspan="2">
  								<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:history.back();">返回</a>
 							</td>
 						</tr> 											
 				</table>
 		</div>
  </body>
</html>
