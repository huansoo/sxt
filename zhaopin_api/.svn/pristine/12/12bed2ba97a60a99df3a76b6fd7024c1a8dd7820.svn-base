/**
 * 
 */
package com.wugu.zhaopin.webapp.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.wugu.zhaopin.commons.ConverStr;
import com.wugu.zhaopin.commons.DataUtil;
import com.wugu.zhaopin.webapp.util.ContextUtil;


/**
 * @author Sean
 * 
 */
public abstract class BaseJob {

	private static List<Class<?>> jobTypes;
	private HttpServletRequest request;
	private HttpServletResponse response;
	protected transient final Logger logger = Logger.getLogger(getClass());


	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Object getBean(String beanId) {
		return ContextUtil.getContext().getBean(beanId);
	}

	public Object getBean(String beanId, Class<?> c) {
		return ContextUtil.getContext().getBean(beanId, c);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getBeanEx(String beanId, Class<T> t){
		T bean = (T)ContextUtil.getContext().getBean(beanId, t);
		return bean;
	}
	
	public String getQueryString(String query){
	    String result = null;
        try
        {
            result = getRequest().getParameter(query);
            
            //空字符串也认为是null
            if (result == null || "".equals(result.trim()))
                return null;
            
            //判断客户端提交方式，如果是post，需要反utf-8解码
            if (getRequest().getMethod().equalsIgnoreCase("Post")){
                result = URLDecoder.decode(result, "utf-8");
            }
            
            return result;
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return result;
        }

	}
	
	public Integer getQueryInt(String query){
	    String result = getQueryString(query);
	    //如果为null或是非整数
	    if (result == null  || (!"0".equals(result.trim()) && !DataUtil.isInteger(result.trim()))){
	        return null;
	    }
	    else {
	        return DataUtil.toInt(result);
	    }
	}
	
	public Long getQueryLong(String query){
        String result = getQueryString(query);
        if (result == null || !DataUtil.isInteger(result.trim())){
            return null;
        }
        else {
            return DataUtil.toLong(result);
        }
	}
	
	public static <T> T getModelFromJson(String json, Class<T> t){
		JSONObject obj = JSONObject.fromObject(json);
		@SuppressWarnings("unchecked")
		T model = (T)JSONObject.toBean(obj, t);
		return model;				
	}
	
	public String getStringFromHttp() {    	 
        StringBuffer buffer = new StringBuffer();
 
        // 获取输入流
        BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(
					getRequest().getInputStream()));
	        // 将返回的数据读到buffer中
	        String temp = null;
	 
	        while ((temp = reader.readLine()) != null) {
	                 buffer.append(temp);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} 
         return buffer.toString();
     }
	
	public boolean invokeMethod(String name) throws Exception {
		Class<?> t = this.getClass();
		Method[] methods = t.getMethods();
		for (Method m : methods) {
			if (m.getName().equalsIgnoreCase(name)) {
				try {
					m.invoke(this);
					return true;
				} catch (Exception e) {
					StringWriter writer = new StringWriter();
					e.getCause().printStackTrace(new PrintWriter(writer, true));
					throw new Exception(writer.toString());
				}
			}
		}
		return false;
	}

	public static Class<?> getJobTypeByName(String name) {
		for (Class<?> t : getJobTypes()) {
			String strName = t.getSimpleName();
			if (strName.equalsIgnoreCase(name))
				return t;
		}
		return null;
	}

	public static List<Class<?>> getJobTypes() {
		if (jobTypes == null) {
			List<Class<?>> types = new ArrayList<Class<?>>();
			types.add(UserJob.class);
			types.add(CompanyJob.class);
			types.add(DictinaryJob.class);
			types.add(DeliveryJob.class);
			types.add(AuditionJob.class);
			types.add(SMSJob.class);
			types.add(MailJob.class);
			types.add(TagJob.class);
			types.add(ToolJob.class);
			
			jobTypes = types;
		}
		return jobTypes;
	}
	
	public int getResult(int result1, int result2){
		if ((result1 > 0) && (result2 > 0)) {
			return  1;
		}
		else 
			return  0;		
	}
	
	public static String string2Json(String s) {       
	    StringBuffer sb = new StringBuffer ();       
	    for (int i = 0; i < s.length(); i++) {       
	     
	        char c = s.charAt(i);       
	        switch (c) {       
	        case '\"':       
	            sb.append("\\\"");       
	            break;       
	        case '\\':       
	            sb.append("\\\\");       
	            break;       
	        case '/':       
	            sb.append("\\/");       
	            break;       
	        case '\b':       
	            sb.append("\\b");       
	            break;       
	        case '\f':       
	            sb.append("\\f");       
	            break;       
	        case '\n':       
	            sb.append("\\n");       
	            break;       
	        case '\r':       
	            sb.append("\\r");       
	            break;       
	        case '\t':       
	            sb.append("\\t");       
	            break;       
	        default:       
	            sb.append(c);       
	        }  
	    }
        return sb.toString();       
	}

}
