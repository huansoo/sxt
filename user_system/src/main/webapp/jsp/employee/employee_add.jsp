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

	
			$(function(){
					//对于日期的控件添加 
					$('#birthday , #ruzhiTime').datebox( {
						currentText : '今天',
						closeText : '关闭',
						disabled : false,
						required : true,
						missingMessage : '必填字段!' , 
						formatter : formatDate
					});
					//对于薪水的校验 
					$('#baseSalary ,#phoneComm , #baoxianComm , #busComm').numberbox({min:0 ,max:100000 ,precision:0});
					
					//表单验证 
					$('#subform').click(function(){
						if($('#myform').form('validate')){
							$('#myform').get(0).submit();
							//$.messager.alert('提示信息','新增成功！','info');
						} else {
							$.messager.alert('提示信息','新增失败！','info');
						}
			
					});
			});

			/***********************************orgtree****************************/
			function showDialog(){
				$('#mydiv').dialog('open');
			}

			function closedialog(){
				$('#mydiv').dialog('close');
			}
		
			/**
				父窗体的函数 
			*/
			function getValues(nodeId , nodeName , isChecked){
					if(nodeId == 999999 ){
						$.messager.alert('提示','上级机构不能添加!','error');
						return null;
					}
					if(isChecked){
						$('#orgId').val(nodeId);
						$('#text').html('当前选择机构为:'+nodeName);
					} else {
						$('#orgId').val("0");
						$('#text').html('请设置所属机构'); 
					}
			}


			/***********************************jobtree****************************/
			function showDialog2(){
				$('#mydiv2').dialog('open');
			}

			function closedialog2(){
				$('#mydiv2').dialog('close');
			}
		
			/**
				父窗体的函数 
			*/
			function getMap(map){

				if(map.nodeName == ''){
					$('#jobIds').val("");
					$('#jobNames').html('请选择所在职位');
				} else {
					$('#jobIds').val(map.nodeId);
					$('#jobNames').html('当前选择职位为:'+map.nodeName); 
				}
 			}			
			
	</script>
  </head>
  
  <body>
  		<div id="p" class="easyui-panel" style="width:700px;height:400px;padding:10px;"
				title="用户新增" iconCls="icon-add"
				collapsible="true" maximizable=true >
 			<form id="myform" action="Employee_saveEmployee.action" method="post">
 					<input type="hidden" id="jobIds" name="employeeVO.jobIds" value="">
 					<input type="hidden" id="orgId" name="employeeVO.orgId" value="0">
 				<table>
 						<tr>
 							<td>员工姓名：</td>
 							<td><input name="employeeVO.ename" class="easyui-validatebox" required="true" missingMessage="该字段必填!" validType="midLength[2,6]" invalidMessage="员工姓名必须大于等于2小于等于6个长度!" value="" /></td>
 						</tr>
 						<tr>
 							<td>出生日期：</td>
 							<td><input id="birthday" name="employeeVO.birthday" value="" /></td>
 						</tr>
						<tr>
							<td>性别：</td>
							<td>
								男<input type="radio" name="employeeVO.sex" checked="checked" value="1" />
								女<input type="radio" name="employeeVO.sex" value="2" />
							</td>
						</tr>
 						<tr>
 							<td>身份证号：</td>
 							<td>
 								<input name="employeeVO.cardId"  class="easyui-validatebox" required="true" missingMessage="该字段必填!"  validType="cardLength[15,18]" invalidMessage="身份证必须符合15或18位数字!"  value="" />
 							</td>
 						</tr>
 						<tr>
 							<td>家庭地址：</td>
 							<td><input name= "employeeVO.address" class="easyui-validatebox" required="true" missingMessage="该字段必填!"  value=""/></td>
 						</tr>
 						<tr>
 							<td>所属机构：</td>
 							<td><a id="text" href="javascript:void(0);" onclick="showDialog();">请设置所属机构</a></td>
 							
		 					<div id="mydiv" class="easyui-dialog" title="设置机构" style="padding: 10px;width: 500;height:400;" 
						 		iconCls="icon-redo" closed="true" maximizable="false" minimizable="false" collapsible="false">
								<iframe width="100%" style='overflow:scroll;overflow-x:hidden' scrolling="yes" height=85% frameborder="0"   src="jsp/employee/employee_orgtree.jsp"></iframe>				 		
								<div align="center">
									<a id="close1" class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closedialog()" >关闭</a>				    
								</div>		
						    </div>
 						</tr>
 						<tr>
 							<td>职位:</td>
 							<td><a id="jobNames" href="javascript:void(0);" onclick="showDialog2();" >请选择所在职位</a></td>
		 					<div id="mydiv2" class="easyui-dialog" title="设置机构" style="padding: 10px;width: 500;height:400;" 
						 		iconCls="icon-redo" closed="true" maximizable="false" minimizable="false" collapsible="false">
								<iframe width="100%" style='overflow:scroll;overflow-x:hidden' scrolling="yes" height=85% frameborder="0"   src="jsp/employee/employee_jobtree.jsp"></iframe>				 		
								<div align="center">
									<a id="close2" class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closedialog2()" >关闭</a>				    
								</div>		
						    </div> 							
 						</tr>
 						<tr>
 							<td>底薪：</td>
 							<td>
 								<input id="baseSalary" name="employeeVO.baseSalary"  class="easyui-validatebox" required="true" missingMessage="该字段必填!" value="" />
 							</td>
 						</tr>
 						<tr>
 							<td>电话补助：</td>
 							<td><input id="phoneComm" name="employeeVO.phoneComm"  class="easyui-validatebox" required="true" missingMessage="该字段必填!" value="" /></td>
 						</tr>
 						<tr>
 							<td>交通补助</td>
 							<td><input id="busComm" name="employeeVO.busComm"  class="easyui-validatebox" required="true" missingMessage="该字段必填!" value="" /></td>
 						</tr>
 						<tr>
 							<td>保险补助</td>
 							<td><input id="baoxianComm" name="employeeVO.baoxianComm"  class="easyui-validatebox" required="true" missingMessage="该字段必填!" value="" /></td>
 						</tr>
 						<tr>
 							<td>入职日期</td>
 							<td><input id="ruzhiTime" name="employeeVO.ruzhiTime" value="" /></td>
 						</tr>
 						<tr>
 							<td colspan="2">
 								<a class="easyui-linkbutton" id="subform" iconCls="icon-ok" href="javascript:void(0)" >新增员工</a>
 							</td>
 						</tr> 											
 				</table>
 					
 			
 			
 			
 			
 			</form>	
 		</div>
  </body>
</html>
