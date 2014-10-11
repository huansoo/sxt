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
			
	<script type="text/javascript">


	
			$(function(){
				
				$('#btn').click(function(){
						var oldpassword = $('#oldpassword').val();
						var sessionpassword = '${sessionScope.loginUser.pwd}';  
						if(oldpassword != sessionpassword ){
							$.messager.alert('提示' ,'您输入的密码不正确!' , 'error');
							$('#oldpassword').val('');
						} else {
							$("#mydiv").fadeTo("1000", 0.70); 

						}
				});

				$('#back').click(function(){
					$("#mydiv").fadeOut("1000"); 
				});


				$.extend($.fn.validatebox.defaults.rules, { 
					equal: { 
						validator: function(value, param){ 
									return $('#newpassword1').val() == $('#newpassword2').val(); 
						}, 
						message: ''  
					} 
				});


				$('#subform').click(function(){

					if($('#myform').form('validate')){
						$('#myform').get(0).submit();
					} else {
						$.messgaer.alert('提示' , '提交失败!' , 'error');
					}

				});
					
			});

	
	
	
	</script>		
			
			
	
  </head>
  
  <body>
		<div id="p" class="easyui-panel" style="width:700px;height:400px;padding:10px;"
			title="修改密码" iconCls="icon-add"
			collapsible="true" maximizable=true >
				<table>
					<tr>
						<td>请输入旧密码:</td>
						<td><input type="password" id="oldpassword" value="" /></td>
					</tr>
					<tr>
						<td colspan="2"><input id="btn" type="button" value="下一步"/></td>
					</tr>
				</table>
				<div id="mydiv" style="width: 300px ; height: 150px; background-color: #87CEFA;  display: none" >
					<form id="myform" action="User_updatePassword.action" method="post">
							<table>
								<tr>
									<td>新密码</td>
									<td><input type="password" class="easyui-validatebox" name="newpassword1" required="true" missingMessage="该字段必填!" id="newpassword1" validType="gtLength[4]" invalidMessage="输入的密码必须大于等于4位!"  value="" /></td>
								</tr>							
								<tr>
									<td>确认新密码</td>
									<td><input type="password" id="newpassword2" name="newpassword2" class="easyui-validatebox" required="true"  missingMessage="该字段必填!"  validType="equal[]" invalidMessage="两次密码必须输入一致!"  value="" /></td>
								</tr>
								<tr>
									<td colspan="2"><input type="button" id="subform"  value="修改密码"  /><input id="back" type="button"  value="隐藏"  /></td>
								</tr>															
							</table>
					</form>				
				</div>

		</div>
  </body>
</html>
