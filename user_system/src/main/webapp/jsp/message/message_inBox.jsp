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
				cfg.set$table($('#t_inBox'));
				cfg.setTitle('已接收信息列表');  
				cfg.setCollapsible(true);
				cfg.setFitColumns(true);
				cfg.setLoadMsg('数据正在装载中');
				cfg.setUrl('Message_inBoxList.action?flag=1');
				cfg.setPagination(true);
				cfg.setRownumbers(true);
				cfg.setStriped(true);
				cfg.setColumn('标题' , 'title' , '200' , 2 , 'center' , true , function(value , record , index){
						if(record.readState == '未读'){
							return "<span style=color:red >"+value+"</span>";
						} else {
							return value;
						}
				});
				cfg.setColumn('收件日期' , 'createTime' , '200' , 2 , 'center' , true);
				cfg.setColumn('发件人' , 'senderName' , '100' , 2 , 'center' , true);  
				cfg.setColumn('操作' ,'op' , '100' , 2 , 'center' , true , function(value , record , index ){ 
						// messageReceiver 的id 
						return '<a href=Message_readBox.action?id='+record.id +'>浏览</a> | <a href=javascript:void(0); onclick=addDust('+record.id+') >加入垃圾箱</a> ';	  
				});
				cfg.createDateGrid();
			});


			function addDust(id){
				$.messager.confirm('提示' , '确认加入垃圾箱?' , function(r){
					if(r){
						window.location.href = 'Message_addDustbox.action?flag=2&id='+id;
					}
				});
			}
	</script>
  </head>
  
  <body>
  		<table id="t_inBox"></table>
  </body>
</html>
