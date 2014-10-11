<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	<!--
		window.UEDITOR_HOME_URL = '/Manager/js/ueditor/'; //location.pathname.substr(0, location.pathname.lastIndexOf('/')) + '/';
	//-->
	</script>	
		<%@ include file="../../jsp/globalresults/commons.jsp" %>
		<script type="text/javascript" src="js/common/validations.js"></script>
		<script type="text/javascript" src="js/ueditor/editor_config.js"></script>
		<script type="text/javascript" src="js/ueditor/editor.js"></script>
		<link rel="stylesheet" href="js/ueditor/themes/default/ueditor.css" />
	    <style type="text/css">
	        textarea{
	            float: left;
	            width:200px;
	            height: 200px;
	            margin-left: 20px;
	        }
	        .clear{
	            clear: both;
	        }
	    </style>  
	    <script type="text/javascript">
	    
			function showDialog(){
				$('#mydiv').dialog('open');
			}
	
			function closedialog(){
				$('#mydiv').dialog('close');
			}

			function getMap(map) {
					//$('#receiverIds').val(map.nodeId);
					$('#receiverNames').val(map.nodeName);
			}


			function checkForm(){
				var flag = false ; 
				if($('#myform').form('validate')){
					$.ajax({
						url: 'Message_checkReceiverNames.action' ,  
						type: 'POST' ,		//请求的方式  默认get
						dataType : 'text' ,		// 服务器响应 接收的数据类型 
						timeout: 2000 ,			// 请求过期的时间
						data: {receivernames:$('#receiverNames').val()} ,		// 向服务器端传递的参数 
						async: false ,											// 设置是否异步 request.open('post' , url , true)
						success : function(result){
							if(result == "1"){
								flag = true ;
							} else {
								$.messager.alert('错误提示' ,result+':账号不存在!' , 'error');
							}
						} 
					});
				} else {
					$.messager.alert('提示' ,'提交失败!' ,'error');
				}
				return flag ;
			}

			
			var defaultValue = '${senderName}'; 			// 王2201124
			$(function(){
				if(defaultValue != ''){
						$('#subform').val('回复');
				}
			});

			function changeBtn(){
					if(document && document.getElementById) {
						var value = document.getElementById('receiverNames').value;
						if(value != '' && defaultValue == value){
							$('#subform').val('回复');
						} else if(value != defaultValue) {
								$('#subform').val('转发');
						}
					}
			}

			setInterval(changeBtn,2);

			

		    
	    </script>
  </head>
  
  <body>
  		<div id="p" class="easyui-panel" style="width:900px;height:450px;padding:10px;"
		title="转发信息" iconCls="icon-add"
		collapsible="true" maximizable=true >
			<form id="myform" action="Message_sendMessage.action" method="post" onsubmit="return checkForm();" >
					<!-- <input type="hidden" id="receiverIds" name="receiverIds" value=""  />  -->
				<table>
						<tr>
							<td>标题</td>
							<td><input type="text" name="message.title" class="easyui-validatebox" required="true" missingMessage="该字段必填" size="30" value="${message.title}"  /></td>
							<td>收件人</td>
							<td><input type="text" id="receiverNames" name="receiverNames" class="easyui-validatebox" required="true" missingMessage="该字段必填" value="${senderName}"  size="30" /> <input type="button" onclick="showDialog();" value="选择"/></td>
 					<div id="mydiv" class="easyui-dialog" title="选择收信人" style="padding: 10px;width: 500;height:400;" 
				 		iconCls="icon-redo" closed="true" maximizable="false" minimizable="false" collapsible="false">
						<iframe width="100%" style='overflow:scroll;overflow-x:hidden' scrolling="yes" height=85% frameborder="0"   src="jsp/message/message_userlist.jsp"></iframe>				 		
						<div align="center">
							<a id="close1" class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closedialog()" >关闭</a>				    
						</div>		
							    
				    </div>							
							
							
						</tr>
						<tr>
							<td>信件内容</td>
							<td colspan="3"><textarea id="editor" name="message.content">${message.content}</textarea></td>
						</tr>							
						<tr>
							<td colspan="4" align="center">
								<input id="subform" type="submit" value="转发">
								<input type="button" value="返回" onclick="javascript:history.back();">
							</td>
						</tr>						
				</table>
			</form>	
				
		</div>		
  </body>
<script type="text/javascript">
    var editor = new UE.ui.Editor();
    editor.render('editor');
</script>
</html>

