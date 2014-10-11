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
	<script type="text/javascript">

			
			$(function(){
					$('#t_emp').datagrid({
							title : '在职员工列表' , 
							iconCls:'icon-ok' , 
							width : 1000 , 
							height: 450 ,
							pageSize:10,
							pageList:[5,10,15,20],
							nowrap:false,				//是否在一行显示数据
							striped: true,				//是否显示斑马线
							collapsible:true,			//是否要滑动效果
							url:'employee/getOnEmployeeList.action',	//远程加载数据的地址
							loadMsg:'数据装载中......',	//加载信息时的等待提示信息
							//sortName:'age',			//定义排序列
							//sortOrder:'desc',			//定义排序方式
							remoteSort:false,	
							singleSelect: true ,		//单选模式 
							fitColumns: true ,
							/* 
							frozenColumns:[
								[			//定义复选框
									{field:'ids',checkbox:true}
						    	]
						    ],*/							
							columns:[[
								{field:'ename' , title:'员工姓名' , width: '100' , rowspan:2,align:'center', sortable: true },
								{field:'sex' , title:'性别' , width: '100' , rowspan:2,align:'center', sortable: true , 
									formatter: function(value ,record ,index){
											if(value == 1){
													return "<span style='color:red;'>男</span>";
											} else {
													return "<span style='color:green;'>女</span>"; 
											}
									}
								},
								{field:'ruzhiTime' , title:'入职日期' , width: '100' , rowspan:2,align:'center', sortable: true},
								{field:'orgName' , title:'所属机构' , width: '100' , rowspan:2,align:'center', sortable: true},
								{field:'jobNames' , title:'职位' , width: '150' , rowspan:2,align:'center', sortable: true},
								{field:'baseSalary' , title:'基本待遇' , width: '100' , rowspan:2,align:'center', sortable: true},
								{field:'state' , title:'状态' , width: '100' , rowspan:2,align:'center', sortable: true},
								{field:'operation' , title:'操作' , width: '100' , rowspan:2,align:'center', sortable: true , 
									formatter: function(value , record , index){
										return '<a href=javascript:void(0); onclick=cizhi('+record.id+')  >申请辞职</a>'; 
									}
								} 
							]],
							toolbar:[
							         {
								         text:'修改员工信息' , 	//按钮的名称
								         iconCls: 'icon-edit' , //按钮的图标样式
								         handler: function(){ 	//点击按钮时所触发的函数
												var node = $('#t_emp').datagrid('getSelected');		//获得你所选中的行 (对象)
												if(node){
													window.location = "Employee_preUpdate.action?id="+node.id;
												} else {
															$.messager.alert('提示','请选择一条记录!','error');	
												}
										}
								     }
								     /*
							         ,
								     {
								         text:'批量删除员工' , 
								         iconCls: 'icon-remove' , 
								         handler: function(){
							        	 		var arr = $('#t_emp').datagrid('getSelections');		// arr (多个对象)
												var ids = '' ;
							        	 		for(var i in arr){
													ids += arr[i].id +",";
								        	 	}
								        	 	ids = ids.substring(0, ids.length-1);

								        	 	if(ids != ''){
								        		
							        				$.messager.confirm('提示', '确认删除?', function(r){
							        					if (r){
							        						//alert('confirmed:'+r);
							        						window.location = "Employee_delete.action?ids="+ids;
							        					}
							        				});
								        	 		
									        	} else {
									        		$.messager.alert('提示','请选择一条记录!','error');	
										        }
								         }
									 }*/

							],
							pagination:true,		// 是否要分页
							rownumbers:true,		// 是否显示行号
							onRefresh:function(pageNumber,pageSize){
									$('#t_emp').datagrid({
									url:'Employee_getOnEmployeeList.action?page='+pageNumber+'&rows='+pageSize,
									loadMsg:'更新数据中......'
									});
							} ,
							onSelectPage: function(pageNumber ,pageSize){
									$('#t_emp').datagrid({
									url:'Employee_getOnEmployeeList.action?page='+pageNumber+'&rows='+pageSize,
									loadMsg:'更新数据中......'
									});								
							} 
					});
					displayMsg($('#t_emp'));
			});


			
			
			function cizhi(id){
				$.messager.confirm('提示' , '确认申请辞职?' , function(r){
					if(r){
						window.location = 'Employee_preResign.action?id='+id; 
					}
				});
			}
	</script>
	
	
  </head>
  
  <body>
  <form action="employee/getOnEmployeeList.action">
		<table>
			<tr>
				<td>员工姓名:</td>
				<td><input name="ename" type="text"/></td>
				<td>入职时间:</td>
				<td><input name="ruzhiTime" type="text"/></td>
			</tr>
			<tr align="center"><td colspan="4"><input type="submit" value="查询"/></td></tr>
		</table>
	</form>
   		<table id="t_emp"></table>
  </body>
</html>
