<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>组织机构列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../../jsp/globalresults/commons.jsp" %>

	<script>
		$(function(){
			var parent_id ;
			$('#t_org').treegrid({
				title:'组织机构列表', 
				iconCls:'icon-ok',
				width:1000,
				height:400,
				nowrap: false,
				rownumbers: true,
				animate:true,
				collapsible:true,
				url:'org/getOrgList.action',			
				idField:'oname',
				treeField:'oname',
				fitColumns:true ,
				frozenColumns:[[
								{field:'oname',title:'机构名称',width:200 ,
					                formatter:function(value){
					                	return '<span style="color:red">'+value+'</span>';
					                }
				                }
				]],
				columns:[[
					{field:'descript',title:'机构描述',width:120,rowspan:2  } ,
					{field:'principal',title:'机构负责人',width:120,rowspan:2  } 
				]],
				onContextMenu: function(e,row){
					//alert(row.oname);
					e.preventDefault();
					$(this).treegrid('unselectAll');
					$(this).treegrid('select', row.oname);
					$('#mm').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}
				
				/*,
				onDblClickRow:function(rowIndex ,rowData){
					var node = $('#t_org').treegrid('getSelected');
					window.location = "Org_preUpdateOrg.action?id="+node.id;
				}*/
			});				
		
		});



		function append(){
			var data = [{
				oname: '新组织机构', 
				descript: '',
				principal: ''
			}];
			var node = $('#t_org').treegrid('getSelected');
			parent_id = node.id ;
			//alert(parent_id);
			//追加到指定父节点  
			$('#t_org').treegrid('append', {
				parent: (node?node.oname:null),
				data: data
			});
			//与后台进行同步
			$.post('org/saveOrg.action' ,{pid:parent_id},function(data){
				$('#t_org').treegrid('reload');
			});
		}

		function remove(){
			var node = $('#t_org').treegrid('getSelected');
			if (node){
				var arr = $('#t_org').treegrid('getChildren',node.oname); 
				if(arr == ''){
					$.messager.confirm('提示' ,'确认删除?' , function(r){
						if(r){
							$.post('Org_deleteOrg.action' , {id:node.id} , function(data){});
							$('#t_org').treegrid('remove', node.oname);
						}
					})
				} else {
					$.messager.alert('提示','该机构还有下级机构,请先删除下级机构!', 'error');
				}				
			}
		} 
		
		function update(){
				var node = $('#t_org').treegrid('getSelected');
				window.location = "org/preUpdate.action?id="+node.id;
		}

	</script>
  </head>
  
<body>
	<table id="t_org" ></table>
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="append()">新增组织机构</div>
		<div onclick="update()">修改组织机构</div>
		<div onclick="remove()">删除组织机构</div>
	</div>
</body>
</html>
