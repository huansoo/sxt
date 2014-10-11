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
	<%@ include file="../../jsp/globalresults/commons.jsp" %>
	<script type="text/javascript" src="js/common/grid.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var cfg = new GridConfig();
			cfg.set$table($('#t_outDustBox'));
			cfg.setTitle('发送历史列表');   
			cfg.setIconCls('_');
			cfg.setWidth(900);
			cfg.setHeight(390);
			cfg.setCollapsible(true);
			cfg.setFitColumns(true);
			cfg.setLoadMsg('数据正在装载中');
			cfg.setUrl('Message_outBoxList.action?flag=2');
			cfg.setPagination(true);
			cfg.setRownumbers(true);
			cfg.setStriped(true);
			cfg.setColumn('标题' , 'title' , '200' , 2 , 'center' , true);
			cfg.setColumn('发件日期' , 'createTime' , '200' , 2 , 'center' , true);
			cfg.setColumn('收件人' , 'receiverName' , '300' , 2 , 'center' , true); 
			cfg.setColumn('操作' ,'op' , '100' , 2 , 'center' , true , function(value , record , index ){ 
					return ' <a href=javascript:void(0); onclick=regain(1,'+record.id+') >恢复到发件箱</a> | <a href=javascript:void(0); onclick=deleteDust(1,'+record.id+') >删除</a>';	    
			});
			cfg.createDateGrid();


			var cfg2 = new GridConfig();
			cfg2.set$table($('#t_inDustBox'));
			cfg2.setTitle('接收历史列表');   
			cfg2.setIconCls('_');
			cfg2.setWidth(900);
			cfg2.setHeight(390); 
			cfg2.setCollapsible(true);
			cfg2.setFitColumns(true);
			cfg2.setLoadMsg('数据正在装载中');
			cfg2.setUrl('Message_inBoxList.action?flag=2');
			cfg2.setPagination(true);
			cfg2.setRownumbers(true);
			cfg2.setStriped(true);
			cfg2.setColumn('标题' , 'title' , '200' , 2 , 'center' , true );
			cfg2.setColumn('收件日期' , 'createTime' , '200' , 2 , 'center' , true);
			cfg2.setColumn('发件人' , 'senderName' , '100' , 2 , 'center' , true);  
			cfg2.setColumn('操作' ,'op' , '100' , 2 , 'center' , true , function(value , record , index ){ 
					// messageReceiver 的id 
					return '<a href=javascript:void(0); onclick=regain(2,'+record.id+')>恢复到收件箱</a> | <a href=javascript:void(0); onclick=deleteDust(2,'+record.id+') >删除</a>'; 	   
			});
			cfg2.createDateGrid();			
		});	

		// flag = 1 恢复到发件箱 , flag = 2 则恢复到收件箱 
		function regain(flag , id){
				if(flag == 1){
						$.messager.confirm('提示' , '确认恢复到发件箱?' , function(r){
							if(r){
								$.post('Message_regainBox.action?flag=1',{id:id},function(data){
									$('#t_outDustBox').datagrid('reload');	//重新加载之 
								});
							}
						});
				}
				if(flag == 2){
						$.messager.confirm('提示' , '确认恢复到收件箱?' , function(r){ 
							if(r){
								$.post('Message_regainBox.action?flag=2',{id:id},function(data){
									$('#t_inDustBox').datagrid('reload');	//重新加载之 
								});
							}
						});
				}
		}

		// flag = 1 删除垃圾 箱发件列表信息 , flag = 2 删除垃圾箱 收件列表信息(此方法为真正的物理删除之)  
		function deleteDust(flag , id){
			if(flag == 1){
				$.messager.confirm('提示' , '确认删除,此操作将无法恢复信息?' , function(r){
					if(r){
						$.post('Message_deleteDustBox.action?flag=1',{id:id},function(data){
							$('#t_outDustBox').datagrid('reload');	//重新加载之 
						});
					}
				});
			}
			if(flag == 2){
					$.messager.confirm('提示' , '确认删除,此操作将无法恢复信息?' , function(r){  
						if(r){
							$.post('Message_deleteDustBox.action?flag=2',{id:id},function(data){
								$('#t_inDustBox').datagrid('reload');	//重新加载之 
							});
						}
					});
			}

		}

		
		
	</script>
  </head>
  
  <body>
    <div id="tt" class="easyui-tabs" tools="#tab-tools" style="width:1000px;height:450px;">
		<div title="发件垃圾箱列表" iconCls="icon-remove" style="padding:20px;" cache="false">
				<table id="t_outDustBox"></table>
		</div>
		<div title="收件垃圾箱列表" iconCls="icon-remove" style="padding:20px;" cache="false"  >
				<table id="t_inDustBox"></table>
		</div>
    </div>
  </body>
</html>
