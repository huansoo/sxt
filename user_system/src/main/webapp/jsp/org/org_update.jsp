<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'org_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript" src="js/common/validation.js"></script>
	<script type="text/javascript">

	
		function showWin(){
			$('#mydiv').dialog('open');
		}
		function closedialog(){
			$('#mydiv').window('close');
		}	
		var nodeId = ${org.id};			// EL取得当前选择node 此变量用于子窗体iframe接收
		var topId  = ${org.pid};		// 顶级机构(用于根节点判断)
		var selectRadio = 0;				// 接受iframe子窗体nodeId

		function back_info(nodeId ,nodeName ,isChecked){
			if(topId != -1){
				//iframe是否选中节点 
				if(isChecked){
					//alert("iframe子页面选中的返回值为："+ nodeId + "," + nodeName);
					$('#radioValue').html('选择父级机构为:' + nodeName);
					selectRadio = nodeId;
				} else {
					selectRadio = 0;
					$('#radioValue').html('点击设置');
				} 
			}
		}


		function subform(){
			document.getElementById('parentId').value = selectRadio;	//提交表单前传递parenId 
			document.getElementById('myform').submit();
		}
		
		

				
	</script>
  </head>
 
  <body>
<div id="p" class="easyui-panel" title="组织机构设置" icon="icon-save" collapsible="true"  maximizable=true 
	style="width: 900px; height: 450px; padding: 10px; background: #fafafa;">
  		<form id="myform" action="org/updateOrg.action" method="post">
  			<input type="hidden" id="parentId" name="pid" />
  			<input type="hidden" name="orgVO.parentId" value="${org.pid}" />
  			<input type="hidden" name="orgVO.id" value="${orgVO.id }">
  			<table>
  			<tr>
  				<td>组织机构名称：</td>
  				<td><input name="orgVO.oname" size="40" class="easyui-validatebox" required="true" missingMessage="不能为空" invalidMessage="必须大于等于2个长度,小于10个长度"  validType="midLength[2,10]"  value="${org.oname}" /></td>
  			</tr>
  			<tr>
  				<td>组织机构负责人：</td>
  				<td><input  name="orgVO.principal" size="40"  type="text" class="easyui-validatebox" required="true" missingMessage="不能为空"  value="${org.principal}" /></td>
  			</tr>
  			<tr>
  				<td>组织机构信息：</td>
  				<td><textarea  name="orgVO.descript" rows="5" cols="40"   type="text" class="easyui-validatebox" required="true" missingMessage="不能为空"  >${org.descript}</textarea></td>
  			</tr> 
  			<tr>
  				<td>设置组织机构：</td>
  				<td>
  					<a id="radioValue" href="javascript:void(0);" onclick="showWin()">选择父级机构为:${parentName eq ""?"无顶级机构":parentName}</a> 
				    <div id="mydiv" class="easyui-dialog" title="添加" style="padding: 10px;width: 500;height:400;" 
				 	iconCls="icon-redo" closed="true" maximizable="false" minimizable="false" collapsible="false">
				 		<iframe style='overflow:scroll;overflow-x:hidden' width="100%" scrolling="yes" height=85% frameborder="0" src="jsp/org/org_tree.jsp" ></iframe>					  
						<div align="center">
							<a id="close1" class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closedialog()" >关闭</a>				    
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
