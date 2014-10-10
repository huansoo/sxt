/**  
* @Title:  StringUtils.java
* @Package com.wugu.ycyp.util
* @Description: TODO(用一句话描述该文件做什么)
* @author yangch
* @date  2014-9-12 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.util;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * @ClassName: StringUtils
 * @Description: 字符串工具类
 * @author yangch
 * @date 2014-9-12 
 *
 */
public class StringUtils
{
    /**
     * 
      * @Title: isEmpty
      * @Description: 判断是否是空串
      * @author yangch
      * @date 2014-9-15 
      * @param str
      * @return
      * @throws
     */
    public static boolean isEmpty(String str){
        return (null == str) || ("".equals(str.trim()));
    }
    /**
     * 
      * @Title: isNullString
      * @Description: 判断是否是空串或者为“null”
      * @author yangch
      * @date 2014-9-15 
      * @param str
      * @return
      * @throws
     */
    public static boolean isNullString(String str){
        if (str == null) return true;
        if(str.trim().equals("")) return true;
        return str.trim().equalsIgnoreCase("null");
    }
    public static void main(String[] args)
    {
        String json = "{\"status\":0,\"result\":[{\"x\":102.81949097402,\"y\":24.855137758894},{\"x\":104.09980906589,\"y\":30.648320501055}]}";
        JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Float.class, new JsonValueProcessor()
        {
            
            @Override
            public Object processObjectValue(String paramString, Object paramObject,
                    JsonConfig paramJsonConfig)
            {
                // TODO Auto-generated method stub
                return process(paramObject);
            }
            
            @Override
            public Object processArrayValue(Object paramObject,
                    JsonConfig paramJsonConfig)
            {
                return process(paramObject);
            }
            private Object process(Object value) {
                System.out.println("-------------");
                System.out.println(value);
                return String.valueOf(value);
            }

        });
        JSONObject obj = JSONObject.fromObject(json,config);
        System.out.println(obj.toString());
    }
}
