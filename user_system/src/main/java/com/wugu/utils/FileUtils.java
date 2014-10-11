/**  
 * @Title:  FileUtils.java
 * @Package com.wugu.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author yangch
 * @date  2014-9-25 
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.wugu.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: FileUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-25
 * 
 */
public class FileUtils implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @Title: resolveFileToString
     * @Description: 将文件解析成字符串
     * @author yangch
     * @date 2014-9-25
     * @param fileName
     * @return
     * @throws
     */
    public static String resolveFileToString(String fileName)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileName), "utf-8"));
            String temp = null;
            StringBuffer msgContent = new StringBuffer();
            while ((temp = reader.readLine()) != null)
            {
                msgContent.append(temp);
            }
            reader.close();
            return String.valueOf(msgContent);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 
      * @Title: replaceTemplateKeys
      * @Description: 将map中所有的占位符替换成map中占位符(key)对应的value
      * @author yangch
      * @date 2014-9-25 
      * @param map
      * @param fileContent
      * @return
      * @throws
     */
    public static String replaceTemplateKeys(Map<String, String> map, String fileContent){
        if(map == null) return fileContent;
        
        Set<String> set = map.keySet();
        Iterator<String> ite = set.iterator();
        
        while(ite.hasNext()){
            String key = ite.next();
            if(!fileContent.contains(key)) continue;
            String value = map.get(key);
            fileContent = replaceAll(fileContent, key, value);
        }
        return fileContent;
    }
    public static String replaceAll(String str, String oldStr, String newStr){
        if(str.indexOf(oldStr) == -1) return str;
        StringBuffer strBuf = new StringBuffer(str);
        int begin = strBuf.indexOf(oldStr, 0);
        while(begin != -1){
            strBuf.replace(begin, begin+oldStr.length(), newStr);
            begin = strBuf.indexOf(oldStr, begin+oldStr.length());
        }
        return strBuf.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(resolveFileToString("E:\\吾谷网\\账号.txt"));
    }
}
