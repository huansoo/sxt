/**  
* @Title:  XMLUtil.java
* @Package com.wugu.zhaopin.util
* @Description: XML解析工具类
* @author lijun
* @date  2014-1-14 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.util;

/**
 * @ClassName: XMLUtil
 * @Description: XML解析工具类
 * @author lijun
 * @date 2014-1-14 
 *
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * xml工具类
 * @author miklchen
 *
 */
public class XMLUtil {

    /**
     *     
    * @Title: doXMLParse
    * @Description: 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
    * @author lijun
    * @param strxml xml字符串
    * @return 第一级元素键值对
    * @throws JDOMException
    * @throws IOException
    * @throws
     */
    public static Map doXMLParse(String strxml) throws JDOMException, IOException {
        if(null == strxml || "".equals(strxml)) {
            return null;
        }
        
        Map m = new HashMap();
        InputStream in = new ByteArrayInputStream(strxml.getBytes("utf-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if(children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = XMLUtil.getChildrenText(children);
            }            
            m.put(k, v);
        }
        
        //关闭流
        in.close();
        
        return m;
    }
    
    /**
     * 
    * @Title: getChildrenText
    * @Description: 获取子结点的xml
    * @author lijun
    * @param children
    * @return 子节点字符串
    * @throws
     */
    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()) {
            Iterator it = children.iterator();
            while(it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()) {
                    sb.append(XMLUtil.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }
        
        return sb.toString();
    }
    
    /**
     * 
    * @Title: getXMLEncoding
    * @Description: 获取xml编码字符集
    * @author lijun
    * @param strxml xml字符串
    * @return 编码字符集
    * @throws JDOMException
    * @throws IOException
    * @throws
     */
    public static String getXMLEncoding(String strxml) throws JDOMException, IOException {
        InputStream in = new ByteArrayInputStream(strxml.getBytes());
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        in.close();
        return (String)doc.getProperty("encoding");
    }
    
  public static void main(String[] arg) throws Exception{
      Map map = doXMLParse("<UserInfo xmlns=''><Result>0</Result><Sn>wugu</Sn><Balance>9</Balance><Agent>阿冰</Agent><Port></Port><Signature>【吾谷网】</Signature><Flag>True</Flag></UserInfo>");
      System.out.println(map);
  }
}
