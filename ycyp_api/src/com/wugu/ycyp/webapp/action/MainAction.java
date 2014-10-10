/**
 * 
 */
package com.wugu.ycyp.webapp.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wugu.ycyp.webapp.util.HttpUtil;
import com.wugu.ycyp.webapp.util.Code;
import com.wugu.ycyp.webapp.job.BaseJob;
import com.wugu.ycyp.webapp.model.ApiResult;

/**
 * @author lijun
 * 主控制类
 */
@Controller
public class MainAction extends BaseAction {
	private static ApplicationContext context = null;
	
	public MainAction(){
	    super();
	    
	}
	
	@RequestMapping(value="/test.action")
	public String test() throws IOException{
	    logger.warn("dddddddddddddddddddddddddddddddd");
	    return "index";
	}
	
	/**
	 * 
	* @Title: call
	* @Description: 主入口
	* @author lijun
	* @param res
	* @param req
	* @throws IOException
	* @throws
	 */
	@RequestMapping(value="/main.action")
	public void call(HttpServletResponse res, HttpServletRequest req) throws IOException {
	    getContext(req);
	    res.setHeader("Cache-Control","no-cache"); 
		res.setContentType("text/html;charset=utf-8");
		String apiStr = req.getParameter("api");
		if (apiStr == null || apiStr == "") {
		    
			ApiResult<String> apiresult = Code.getErrorResult(
					Code.Error_Param_Api_Lost, "can not find query api!");
			HttpUtil.responseJson(apiresult, res);
			return;
			
		}
		String apiAry[] = apiStr.split("\\.");
		if (apiAry.length != 2) {
			ApiResult<String> apiresult = Code
					.getErrorResult(Code.Error_Param_Api_Lost,
							"the query api has error format");
			HttpUtil.responseJson(apiresult, res);
			return;
		}
		String className = apiAry[0] + "Job";
		//在ioc容器中通过bean的name获取对应的bean对象
		BaseJob job = getJobByName(className);
		if (job == null) {
			ApiResult<String> apiresult = Code.getErrorResult(
					Code.Error_Api_Not_Found, "the api class '--" + className
							+ "--' not find");
			HttpUtil.responseJson(apiresult, res);
			return;
		}
		try {
		    job.setRequest(req);
		    job.setResponse(res);
			if(!job.invokeMethod(apiAry[1])){
				ApiResult<String> apiresult = Code.getErrorResult(
						Code.Error_Method_Not_Found, "Error_Method_Not_Found");
				HttpUtil.responseJson(apiresult, res);
				logger.info(apiresult);
				return;
			}
			
		} catch (Exception e) {
			ApiResult<String> apiresult = Code.getErrorResult(
					Code.Error_Unexcpect_Exception, e.getMessage());
			HttpUtil.responseJson(apiresult, res);
			logger.warn(apiresult);
			return;
		}

	}
	
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
	
	private ApplicationContext getContext(HttpServletRequest req){	     
	    if (MainAction.context == null)
	        MainAction.context = RequestContextUtils.getWebApplicationContext(req);
	    return MainAction.context;
	}
	
	private BaseJob getJobByName(String jobName){
	    return (BaseJob)MainAction.context.getBean(jobName);
	}
}
