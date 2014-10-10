<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml">  
<head>  
<title>请求</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  
<script type="text/javascript" src="/web/js/jquery-1.9.0.min.js"></script>  
<script type="text/javascript">
function commit(){  
	var jsonstr ={"companyId":1,"createTime":1,"industryId":"1","introduce":"公司A","license":"1111111111","name":"公司A","opId":1,"scaleId":"1","siteUrl":"www.wugu.com.cn","status":1,"type":1,"updateTime":1};
    var str = JSON.stringify(jsonstr);
    console.log("json str:",jsonstr)
    $.post("http://localhost:8080/zhaopin/main!call.action?api=Company.InsertCompany",{json:str},callback,"json");
}
</script>  
<style type="text/css">  
div  
{  
    font-family:sans-serif;  
}  
</style>  
</head>     
<body> 
<form  id="form1" method="post" action="http://58.83.169.204:8080/zhaopin/main.action"> 
<input type="hidden" id="api" name="api" value="Delivery.getLastDelivery"/>
<input type="text" id="json1" name="json1" value={"companyId":2,"tewst":2,"companycontact":{"address":"3","companyContactId":3,"companyId":2,"contactMan":"张三","context":"修改3","createTime":3,"email":"修改3","fixedTel":"修改3","location":"3","mobileTel":"3","opId":3,"page":"3","realPath":"3","result":"3","status":3,"type":3,"updateTime":3,"useSession":"3"},"createTime":3,"industryId":"3","introduce":"公司C修改","license":"33333","name":"公司C","opId":3,"scaleId":"3","siteUrl":"www.wugu.com.cn","status":3,"type":3,"updateTime":3}>
<textarea name="json" id="json" clos="1000" rows="50" warp="virtual">{resumeId:26;postId:604}</textarea>
<input  id="GetDataBtn" value="生成数据" type="submit"/>  

<p><span id="article_link" style="display:none;z-index:100"></span></p>
</form>  
</body>  
</html>  
