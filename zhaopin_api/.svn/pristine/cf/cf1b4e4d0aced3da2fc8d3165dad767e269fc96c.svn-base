package com.wugu.zhaopin.webapp.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.wugu.zhaopin.webapp.model.BaseModel;

public class JobUtil {
	public static final String JsonDataName = "json"; 	//web请求中json数据参数名称
		
	public static final String PARAMTER_COMPANYID = "companyid"; //公司ID变量名
	
	public static final String PARAMTER_POSTID = "postid"; //职位ID变量名
	
	public static final String PARAMTER_USERID = "userid"; //用户ID变量名
	
    public static final String PARAMTER_RESUMEID = "resumeid"; //简历ID
    
	public static final String PARAMTER_RESUMEEXPIRIENCEID = "resumeexpirienceid"; //简历工作经验ID

    public static final String PARAMTER_RESUMEEDUCATIONID = "resumeeducationid"; //简历教育经验ID
    
    public static final String PARAMTER_RESUMELANGUAGEID = "resumelanguageid"; //简历语言经验ID
    
    public static final String PARAMTER_RESUMECERTIFICATEID = "resumecertificateid"; //简历证书ID
    
    public static final String PARAMTER_RESUMESKILLID = "resumeskillid"; //简历技能ID

    public static final String PARAMTER_UPDATETIME = "updatetime"; //更新时间
    
    public static final String PARAMTER_DELIVERYTYPE = "deliverytype"; //投递类型
    
    public static final String PARAMTER_DELIVERYID = "deliveryid"; //投递类型
    
    public static final String FIELD_STATUS = "status"; //删除标记字段名
    
    //职位搜索条件名称定义
    public static final String KEYWORD = "keyword";             //关键字
    
    public static final String WORKADDRESS = "workaddress";     //工作地点
    
    public static final String COMPANYID= "companyid";          //公司ID
    
    public static final String EXCLUDINGIDS = "excludingids";   //不包含职位ID
    
    public static final String POSTTYPE = "posttype";           //职位类型
    
    public static final String SALARY = "salary";               //薪资
    
    public static final String WORKEXPRIENCE = "workexprience"; //工作经验
    
    public static final String COMPANYTYPE = "companytype";     //公司类型
    
    public static final String STARTTIME = "starttime";         //查询开始时间
    
    public static final String FINISHTIME = "finishtime";       //查询结束时间
    
    public static final String PAGE = "page";                   //当前页
    
    public static final String PAGESIZE = "pagesize";           //分页大小
    
    public static final String AUDITION_ID = "auditionid";      //面试邀请ID
    
    public static final String PARAMTER_PROVINCE_ID = "provinceid";      //省份ID
    
    public static final String PARAMTER_CITY_ID = "cityid";      //城市ID
    
    public static final String PARAMTER_DISTRICT_ID = "districtid";      //区ID
    
    public static final String PARAMTER_SMS_MOBILE = "mobilestr"; //电话号码
    
    public static final String PARAMTER_SMS_CONTENT = "content"; //短信内容
    
    public static final String PARAMTER_SMS_STIME = "stime"; //定时时间
    
    public static final String PARAMTER_TAG_ID = "tagid"; //标签标识
    
    public static final String PARAMTER_VERIFY_TYPE = "verifyType"; //验证码验证方式
    
    public static final String PARAMTER_ADDRESS_IDS = "ids"; //地址ID串
    /**
     * 
    * @Title: getJsonConfig
    * @Description: 生成Json回调对象，用于在生成Json时过滤BaseModel中属性， 过滤callbacks属性
    * @author lijun
    * @return 返回Json回调对象
    * @throws
     */
	public static JsonConfig getJsonConfig(){
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter(){
		    public boolean apply(Object source, String name, Object value) {
		    	boolean isExists = false;
		    	//去掉BaseModel中属性
		    	Class<?> t = BaseModel.class;
		    	
		    	Field[] fields = t.getDeclaredFields(); 
				for (Field f : fields) {
					if (f.getName().equalsIgnoreCase(name)) {
						isExists = true;
						break;
					}
				}
				//过滤自动生成的属性
				if ("callbacks".equals(name))
					isExists = true;
				return isExists;
		    }
		});

		return config;
	}
	
}
