package com.wugu.ycyp.webapp.model;

import java.io.Serializable;

import net.sf.json.JSONObject;

import com.wugu.ycyp.webapp.util.Code;

/**
 * @author Sean
 *
 */
public class ApiResult<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1552145865566665L;
	private int success;//api调用是否成功  
	private int status;//返回状态码;正确为200;包含异常错误为500
	private String code;
	private T data;//返回结果数据集
	private String exception;//异常信息;

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String toJsonString(){
		JSONObject object = JSONObject.fromObject(this);
		return object.toString();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setSuccessData(T data){
        this.setCode(Code.Succes);
        this.setSuccess(1);
        this.setStatus(200);
        this.setData(data);	    
	}
	
	public void setExceptionData(String exception){
        this.setSuccess(0);
        this.setStatus(500);
        this.setData(null); 
        this.setException(exception);
	}
}
