/**
 * 
 */
package com.wugu.ycyp.webapp.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wugu.ycyp.util.DataUtil;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.HttpUtil;


/**
 * 
* @ClassName: BaseJob
* @Description: 控制基类
* @author lijun
* @date 2014-7-23 
*
 */
public abstract class BaseJob {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ApiResult<?> result;
	
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
	
	public String getStringFromStream() {    	 
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
	
	/**
	 * 
	* @Title: invokeMethod
	* @Description: 调用job对象方法
	* @author lijun
	* @param name
	* @return
	* @throws Exception
	* @throws
	 */
	public boolean invokeMethod(String name) throws Exception {
		Class<?> t = this.getClass();
		Method[] methods = t.getMethods();
		for (Method m : methods) {
			if (m.getName().equalsIgnoreCase(name)) {
				try {
					m.invoke(this);
					//调用返回数据方法
					responseJson(); 
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
	
	public void setResult(ApiResult<?> result){
	    this.result = result;
	}
	
	public void responseJson() throws IOException{
	    HttpUtil.responseJson(result, getResponse());
	}
	
	public static void main(String[] arg) throws Exception{
	    String str = "'areaId':1,'content':'','createTime':0,'id':1,'imgUrl':'1','name':'1','opId':0,'showContent':'11','status':1,'title':'1','type':0,'updateTime':0,'userId':1";
	    str = URLEncoder.encode(str, "utf-8");
	    System.out.println(str);
	}
}
