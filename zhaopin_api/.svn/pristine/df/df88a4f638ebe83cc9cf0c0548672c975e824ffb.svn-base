/**  
* @Title:  FileUtil.java
* @Package com.wugu.zhaopin.util
* @Description: 文件内容工具类
* @author lijun
* @date  2014-2-21 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: FileUtil
 * @Description: 文件内容工具类
 * @author lijun
 * @date 2014-2-21 
 *
 */
public class FileUtil
{
    /**
     * 
    * @Title: readFromTemplate
    * @Description: 读取 模板文件
    * @author lijun
    * @param file
    * @return
    * @throws
     */
    public static String readFromTemplate(String file){
        try {
            BufferedReader bufread = new BufferedReader(new InputStreamReader
                    (new FileInputStream(file), "UTF-8"));
            String temp = null;
            StringBuffer msgContent = new StringBuffer();
            while((temp = bufread.readLine()) != null){
                msgContent.append(temp);
            }
            bufread.close();
            return msgContent.toString();
        } catch (Exception e) {
                System.out.println("找不到文件！"+ e);
                return null;
        }
    }
        
    /**
     * 
    * @Title: replaceKeys
    * @Description: 不替换直接返回
    * @author lijun
    * @param file 文件名
    * @return
    * @throws IOException
    * @throws
     */
    public static String replaceKeys(String file) throws IOException{
        String template = readFromTemplate(file);
        System.out.println(template);
        return template;
    }
    /**
     * 
    * @Title: replaceKeys
    * @Description: 替换 关键字
    * @author lijun
    * @param file 文件名
    * @param map 关键字映射列表
    * @return
    * @throws IOException
    * @throws
     */
    public static String replaceKeys(String file, HashMap<String, String> map) throws IOException{
        String template = readFromTemplate(file);
        if(template == null || map == null ) 
            return template;
        int n = map.size();
        Iterator iter = map.entrySet().iterator(); 
        String key;
        String val;
        while (iter.hasNext()) { 
            Map.Entry entry = (Map.Entry) iter.next();
            key = (String)entry.getKey(); 
            val = (String)entry.getValue();
            template = replaceAll(template, key, val);
        } 
        System.out.println(template);
        return template;
    }
    /**
     * 
    * @Title: replaceAll
    * @Description: 字符串替换
    * @author lijun
    * @param template
    * @param key
    * @param value
    * @return
    * @throws
     */
    private static String replaceAll(String template,String key,String value){
        StringBuffer strBuf = new StringBuffer(template); 
        int index = 0; 
        while(template.indexOf(key, index) != -1) { 
        index = template.indexOf(key, index); 
        strBuf.replace(template.indexOf(key, index), template.indexOf(key, index) + key.length(), value); 
        index = index + value.length(); 
        template = strBuf.toString(); 
        } 
        return strBuf.toString(); 
    }
}
