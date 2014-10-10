/**
 * 
 */
package com.wugu.zhaopin.webapp.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.job.BaseJob;
import com.wugu.zhaopin.webapp.model.ApiResult;

/**
 * @author Sean
 * 
 */
public class MainAction extends BaseAction {
	private static final long serialVersionUID = 8357056445030410070L;
	
	public static String getFromStreamToStr(InputStream inputStream){
	    StringBuffer buffer = null;
	    try{
	        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
	        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);              
	        buffer = new StringBuffer();  
	        String str = null;  
	        
	        while ((str = bufferedReader.readLine()) != null) {  
	            buffer.append(str);  
	        }
	        
	        inputStreamReader.close();
	        bufferedReader.close();
	        inputStream.close();
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return buffer.toString();
	}
	
	public void call() throws IOException {
		getResponse().setHeader("Cache-Control","no-cache"); 
		getResponse().setContentType("text/html;charset=utf-8");
		String apiStr = getRequest().getParameter("api");
		
		InputStream inputStream = getRequest().getInputStream(); 
		System.out.println(getRequest().getContentType());
        String json = getFromStreamToStr(inputStream);
        System.out.println("api  =  " + getRequest().getParameter("api"));
        System.out.println("---------------------------json-----------begin---------");
        System.out.println(json);
        System.out.println("---------------------------json-----------end---------" );
        
		if (apiStr == null || apiStr == "") {
			ApiResult<String> apiresult = Code.getErrorResult(
					Code.Error_Param_Api_Lost, "can not find query api!");
			HttpUtil.responseJson(apiresult, getResponse());
			return;
		}
		String apiAry[] = apiStr.split("\\.");
		if (apiAry.length != 2) {
			ApiResult<String> apiresult = Code
					.getErrorResult(Code.Error_Param_Api_Lost,
							"the query api has error format");
			HttpUtil.responseJson(apiresult, getResponse());
			return;
		}
		String className = apiAry[0] + "Job";
		Class<?> jobClass = BaseJob.getJobTypeByName(className);
		if (jobClass == null) {
			ApiResult<String> apiresult = Code.getErrorResult(
					Code.Error_Api_Not_Found, "the api class '--" + className
							+ "--' not find");
			HttpUtil.responseJson(apiresult, getResponse());
			return;
		}
		try {
			BaseJob jobObj = (BaseJob) jobClass.newInstance();
			jobObj.setRequest(getRequest());
			jobObj.setResponse(getResponse());
			if(!jobObj.invokeMethod(apiAry[1])){
				ApiResult<String> apiresult = Code.getErrorResult(
						Code.Error_Method_Not_Found, "Error_Method_Not_Found");
				HttpUtil.responseJson(apiresult, getResponse());
				log.info(apiresult);
				return;
			}
			
		} catch (Exception e) {
			ApiResult<String> apiresult = Code.getErrorResult(
					Code.Error_Unexcpect_Exception, e.getMessage());
			HttpUtil.responseJson(apiresult, getResponse());
			log.warn(apiresult);
			return;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wugu.zhaopin.webapp.action.BaseAction#getModel()
	 */
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wugu.zhaopin.webapp.action.BaseAction#setModel(java.lang.Object)
	 */
	@Override
	public void setModel(Object o) {
		// TODO Auto-generated method stub

	}

}
