package com.wugu.zhaopin.webapp.api;

import com.wugu.zhaopin.webapp.model.ApiResult;

public class Code {
	// 操作成功
	public static final String Succes = "Success";
	// 没找到对应的class
	public static final String Error_Api_Not_Found = "Error_Api_Not_Found";
	// 没找到对应的method
	public static final String Error_Method_Not_Found = "Error_Method_Not_Found";
	// api参数缺少
	public static final String Error_Param_Api_Lost = "Error_Param_Api_Lost";
	// 不可预估的异常
	public static final String Error_Unexcpect_Exception = "Error_Unexcpect_Exception";
	// 
	
	// 获取错误的返回结果
	public static ApiResult<String> getErrorResult(String code,String exceptionString){
		ApiResult<String> res = new ApiResult<String>();
		res.setCode(code);
		res.setSuccess(0);
		res.setStatus(500);
		res.setData(null);
		res.setException(exceptionString);
		return res;
	}
}
