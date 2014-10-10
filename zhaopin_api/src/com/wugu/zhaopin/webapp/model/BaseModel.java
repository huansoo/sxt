package com.wugu.zhaopin.webapp.model;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;

import com.wugu.zhaopin.webapp.model.page.PageInfo;
import com.wugu.zhaopin.webapp.util.JobUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/**
 * 
 * @author 
 * @version 1.0.0.1  
 */

public class BaseModel implements Serializable {
	private static final long serialVersionUID = -5337484404562836810L;
	PageInfo pageInfo = new PageInfo(1,20,5);
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	//系统上下文
	String context;
	String nowDate;
	//提示信息
	String result;
	//根目录真实路径
	String realPath;
	
	//是否使用session的model对象
    private String useSession;
    

	
	public String getContext(){
		return context;
	}
	
	public void setContext(String context){
		this.context = context;
	}
	
	public String getResult(){
		return result;
	}

	public void setResult(String result){
		this.result = result;
	}
	
	//ACTION跳转信息提示
	public void setRedirectResult(String result){
		try{
			this.result = URLEncoder.encode(result,"UTF-8");
		}catch (UnsupportedEncodingException e){
			this.result = result;
		}
	}
	
	public String getRealPath(){
		return realPath;
	}
	
	public void setRealPath(String realPath){
		this.realPath = realPath;
	}
	
	public void setNowDate(String nowDate){
		this.nowDate = nowDate;
	}
	
	public String getUseSession(){
		return useSession;
	}
	
	public void setUseSession(String useSession){
		this.useSession = useSession;
	}
	
	public String toJsonString(){
		JsonConfig config = JobUtil.getJsonConfig();
		JSONObject object = JSONObject.fromObject(this, config);
		return object.toString();
	}
}