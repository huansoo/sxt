<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'job_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript" src="js/common/validation.js"></script>
	<script type="text/javascript">
				/**
					div 1
				*/
				function showWin(){
					$('#mydiv').dialog('open');
				}
				function closedialog(){
					$('#mydiv').window('close');
				}	

				var nodeId = ${jobVO.id };			// EL取得当前选择node 此变量用于子窗体iframe接收
				var topId  = ${jobVO.parentId};		// 顶级机构(用于根节点判断)
				var selectRadio = 0;				// 接受iframe子窗体nodeId
			
				function back_info(nodeId ,nodeName ,isChecked){
					if(topId != 999999){
						if(isChecked){
							$('#radioValue').html('选择父级职位为:' + nodeName);
							selectRadio = nodeId;
						} else {
							selectRadio = 0 ;
							$('#radioValue').html('点击设置');
						} 
					}
				}

				/*
						div2
				*/
				function showWin2(){
					$('#mydiv2').dialog('open');
				}
				function closedialog2(){
					$('#mydiv2').window('close');
				}

				var myNodeId = ${jobVO.orgId};
							
				function getValues(nodeId , nodeName , isChecked){
					if(isChecked){
						$('#orgId').val(nodeId);
						$('#text').html('当前选择机构为:'+nodeName);
					} else {
						$('#orgId').val('0');
						$('#text').html('请设置所属机构'); 
					}
				}
				
				function subform(){
					document.getElementById('parentId').value = selectRadio;	//提交表单前传递parenId 
					document.getElementById('myform').submit();
				}	

	</script>
  </head>
  
  <body>
 <div id="p" class="easyui-panel" title="职位设置" icon="icon-save" collapsible="true"  maximizable=true 
	style="width: 900px; height: 450px; padding: 10px; background: #fafafa;">
  		<form id="myform" action="Job_updateJob.action" method="post">
  			<input type="hidden" id="parentId" name="parentId" />
  			<input type="hidden" name="jobVO.parentId" value="${jobVO.parentId}" />
  			<input type="hidden" name="jobVO.id" value="${jobVO.id }">
  			<input type="hidden" id="orgId" name="jobVO.orgId" value="0" />
  			<table>
  			<tr>
  				<td>职位名称：</td>
  				<td><input name="jobVO.jname" size="40" class="easyui-validatebox" required="true" missingMessage="不能为空" invalidMessage="必须大于等于2个长度,小于10个长度"  validType="midLength[2,10]"  value="${jobVO.jname}" /></td>
  			</tr>
  			<tr>
  				<td>职位信息描述：</td>
  				<td><textarea  name="jobVO.descript" rows="5" cols="40"   type="text" class="easyui-validatebox" required="true" missingMessage="不能为空"  >${jobVO.descript}</textarea></td>
  			</tr> 
  			<tr>
  				<td>设置职位：</td>
  				<td>
  					<a id="radioValue" href="javascript:void(0);" onclick="showWin()">选择父级职位为:${jobVO.parentName eq null?"无顶级职位":jobVO.parentName}</a> 
				    <div id="mydiv" class="easyui-dialog" title="添加" style="padding: 10px;width: 500;height:400;" 
				 	iconCls="icon-redo" closed="true" maximizable="false" minimizable="false" collapsible="false">
				 		<iframe style='overflow:scroll;overflow-x:hidden' width="100%" scrolling="yes" height=85% frameborder="0" src="jsp/job/job_tree.jsp" ></iframe>					  
						<div align="center">
							<a id="close1" class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closedialog()" >关闭</a>				    
						</div>					    
				    </div>  				
  				</td>
  			</tr> 
  			<tr>
  				<td>设置所属机构：</td>
  				<td>
  					<a id="text" href="javascript:void(0);" onclick="showWin2()">${jobVO.orgName eq null ?"请设置所属机构":jobVO.orgName}</a>  
				    <div id="mydiv2" class="easyui-dialog" title="添加" style="padding: 10px;width: 500;height:400;" 
				 	iconCls="icon-redo" closed="true" maximizable="false" minimizable="false" collapsible="false">
				 		<iframe style='overflow:scroll;overflow-x:hidden' width="100%" scrolling="yes" height=85% frameborder="0" src="jsp/job/job_orgtree.jsp" ></iframe>					  
						<div align="center">
							<a id="close2" class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closedialog2()" >关闭</a>				    
						</div>					    
				    </div>  				
  				</td>
  			</tr>  			 			 			
  			<tr>
  				<td align="center" colspan="2">
  					<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0)" onclick="subform()" >修改</a>
  					<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:history.back();">返回</a>
  				</td>
  			</tr>   			  			
  		 </table>
  	  </form>
</div>    
  </body>
</html>
