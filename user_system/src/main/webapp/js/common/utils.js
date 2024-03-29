/**
 * 	common method
 *	@author _oiYc 
 */
 
/*
 *	对于日期的格式化方法 
 */
function formatDate(v) {
	if (v instanceof Date) {
		var y = v.getFullYear();
		var m = v.getMonth() + 1;
		var d = v.getDate();
		var h = v.getHours();
		var i = v.getMinutes();
		var s = v.getSeconds();
		var ms = v.getMilliseconds();
		if (ms > 0)
			return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s
					+ '.' + ms;
		if (h > 0 || i > 0 || s > 0)
			return y + '-' + m + '-' + d + ' ' + h + ':' + i + ':' + s;
		return y + '-' + m + '-' + d;
	}
	return '';
}


/**
 * 	dataGrid 提取公共方法
 */

/*
 *		1.单独对分页组件进行配置 
 */
function displayMsg($table){	//$('#t_user')
	var pager = $table.datagrid('getPager');
	pager.pagination({
		loading:false,
		showPageList:true,
		showRefresh:true,
		beforePageText:'第',
		afterPageText:'页,共{pages}页',
		displayMsg:'当前显示记录数:第{from}到{to}条记录,共{total}条记录'
	});
}

/*
 * 		2.批量删除方法
 */
function batchDelele($table , reloadURL){
		var selectArray = $table.datagrid('getSelections');
		//拼接字符串删除所选中的(提取多个id拼接到后台循环delete) 
		var idstr='';
		for( var i =0; i< selectArray.length;i++){
			idstr += selectArray[i].id+',';
		}	
		// 1,2,3
		idstr = idstr.substring(0,idstr.length-1);
		if(idstr !=''){
			$.messager.confirm('warning','确认删除么?',function(flag){
				if(flag){
        			$.post(reloadURL,{ids:idstr},function(data){
        				$table.datagrid('reload');
	        		});
				}
			});
		} else{
			$.messager.alert('warning','请选择一行数据','warning');
		}
}

/*
 *		3.更新方法 
 */
function update($table , reloadURL){
		var data = $table.datagrid('getSelected'); //取得选择的数据 
		if(data){
			window.location = reloadURL+"?id="+data.id;
		} else {
			$.messager.alert('提示','请选择一条数据' ,'warning');
		}
}
































































