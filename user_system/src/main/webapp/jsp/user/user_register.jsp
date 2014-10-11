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
  </head>
  
  	<script type="text/javascript">
  			$(function(){
  					$('#sel_1').combobox({
						onChange: function(newValue , oldValue){
  							$('#sel_2').combobox('setValue','');
							$('#sel_2').combobox('reload', 'User_getEmployeeList.action?orgId='+newValue);
							
						}
  	  				});

  	  				$('#btn').click(function(){
						$.post('User_createAccount.action' ,{empId:$('#sel_2').combobox('getValue')} , function(data){
							var result  = eval(data); 
							if(result.constructor == Array){
								$.messager.alert('生成账号成功提示' ,'生成账号成功!<br/>生成的账号:' + result[0].uname + '<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;初始密码:' + result[0].pwd , 'info');
							} else {
								$.messager.alert('生成账号失败提示' ,'该用户账号已存在!' ,'warning');
							}
						});
  	  	  				

  	  	  			});
  	  		});
  	  		
  	</script>
  
  <body>
  		<div id="p" class="easyui-panel" style="width:700px;height:400px;padding:10px;"
		title="用户注册" iconCls="icon-add"
		collapsible="true" maximizable=true >
			<form action="" method="post">
				<table border="0">
					<tr>
							<td>选择所属机构：</td>
							<td>
									<input id="sel_1" class="easyui-combobox" 
											name="sel_1"
											url="User_getOrgList.action" 
											valueField="id" 
											textField="oname" 
											required="true"
											missingMessage="该字段必填"
											panelHeight="auto" />
							</td>
					</tr>				
					<tr>
							<td>选择指定员工：</td>
							<td>
											<input id="sel_2" 
											class="easyui-combobox" 
											name="sel_2" 
											valueField="id" 
											textField="ename" 
											panelHeight="auto" 
											required="true" 
											missingMessage="该字段必填" value="" />
							</td>
					</tr>
					<tr>
							<td colspan="2">
								<input id="btn" type="button" value="新生成账号" />
							</td>
					</tr>									
				</table>							
			</form>
		</div>
  </body>
</html>
