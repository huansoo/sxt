package com.wugu.ycyp.webapp.util;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.wugu.ycyp.webapp.model.ApiResult;

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
	//web请求中json数据参数名称
    public static final String PARAMTER_JSON = "json";   
    //ID变量名
    public static final String PARAMTER_ID  = "id"; 
    //用户ID变量名
    public static final String PARAMTER_USERID = "userid"; 
    //用户名
    public static final String PARAMTER_USERNAME = "username";
    //更新时间
    public static final String PARAMTER_UPDATETIME = "updatetime"; 
    //删除标记字段名
    public static final String FIELD_STATUS = "status"; 
    
    //搜索条件名称定义‘
    //关键字
    public static final String PARAMTER_KEYWORD = "keyword";             
    //查询开始时间
    public static final String PARAMTER_STARTTIME = "starttime";         
    //查询结束时间
    public static final String PARAMTER_FINISHTIME = "finishtime";       
    //当前页
    public static final String PARAMTER_PAGE = "page";                   
    //分页大小
    public static final String PARAMTER_PAGESIZE = "pagesize";           
    //电话号码
    public static final String PARAMTER_SMS_MOBILE = "mobilestr"; 
    //短信内容
    public static final String PARAMTER_SMS_CONTENT = "content"; 
    //定时时间
    public static final String PARAMTER_SMS_STIME = "stime"; 
    //标签标识
    public static final String PARAMTER_TAG_ID = "tagid"; 
    //验证码验证方式
    public static final String PARAMTER_VERIFY_TYPE = "verifyType"; 
    //地址ID串 
    public static final String PARAMTER_ADDRESS_IDS = "ids"; 
    //文章标识
    public static final String PARAMTER_ARTICLE_ID = "articleId"; 
    //人物标识
    public static final String PARAMTER_PERSON_ID = "personId"; 
    
	// 获取错误的返回结果
	public static ApiResult<String> getErrorResult(String code, String exceptionString){
		ApiResult<String> res = new ApiResult<String>();
		res.setCode(code);
		res.setSuccess(0);
		res.setStatus(500);
		res.setData(null);
		res.setException(exceptionString);
		return res;
	}
	
	/**
	 * 
	* @Title: getJsonConfig
	* @Description: 生成Json回调对象，用于在生成Json时过滤callbacks属性
	* @author lijun
	* @return
	* @throws
	 */
	public static JsonConfig getJsonConfig(){
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter(){
            public boolean apply(Object source, String name, Object value) {
                boolean isExists = false;
                //过滤自动生成的属性
                if ("callbacks".equals(name))
                    isExists = true;
                return isExists;
            }
        });

        return config;
    }

}
