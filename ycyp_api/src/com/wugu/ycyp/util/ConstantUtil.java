package com.wugu.ycyp.util;

public class ConstantUtil {
    //数据库记录的合法标记
    public static final Integer RECORD_STATUS_GENERAL = 1; 
    //数据库记录的删除标记-回收站
    public static final Integer RECORD_STATUS_RECYCLE = -1; 
    //数据库记录的彻底删除标记
    public static final Integer RECORD_STATUS_DELETED = -100; 
    //字符串间隔符
    public static final String SplitChar = ",";                 
    //SQL查询时，不包含的代表数字
    public static final String WithOutInt = "-1";       
    //复制副本时默认附加的字符串
    public static final String COPYADDSTR = "副本";       
    //默认字符集
    public static final String DEFCHARTSET = "UTF-8";   
    //是默认值
    public static final Integer ISDEFAULTVALUE = 1;     
    //不是默认值
    public static final Integer ISNOTDEFAULTVALUE = 0;  
    //用户类型 1：个人  2：公司
    public static final Integer USER_TYPE_PERSON = 1;
    //用户类型 1：个人  2：公司
    public static final Integer USER_TYPE_COMPANY = 2;
    //默认缓存时间24小时
    public static final int DEFAULT_CATCHE_TIME = 24*60*60*1000;
    //首页列表缓存时间10分钟
    public static final int FIRSTPAGE_CATCHE_TIME = 10*60*1000;
    //职位信息缓存时间10分钟
    public static final int POSTINFO_CATCHE_TIME = 10*60*1000;  
    //区域一级分类父节点值
    public static final Long AREACLASS_FIRSTLEVEL_PARENTID = 0L;
    //特产一级分类父节点值
    public static final Long CATEGORY_FIRSTLEVEL_PARENTID = 0L;
   //区域路径间隔字符串
    public static final String AREA_PATH_SPLIT = "->";
    //MD5秘钥
    public static final String MD5KEY = "ycyp";
    
    public static void main(String[] arg ) throws Exception{
        
    }
}	
