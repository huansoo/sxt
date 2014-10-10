/**  
* @Title:  ObjectUtil.java
* @Package com.wugu.zhaopin.util
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2013-12-26 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @ClassName: ObjectUtil
 * @Description: 对象操作公用类
 * @author lijun
 * @date 2013-12-26 
 *
 */
public class ObjectUtil
{
    /**
     * 
    * @Title: Copy
    * @Description: 两个对象属性赋值
    * @author lijun
    * @param source 原对象
    * @param dest 目标对象
    * @throws Exception
    * @throws
     */
    public static void Copy(Object source, Object dest)throws Exception {  
        //获取属性  
        BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), java.lang.Object.class);  
        PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();  
          
        BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), java.lang.Object.class);  
        PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();  
          
        try{  
            for(int i=0;i<sourceProperty.length;i++){  
                  
                for(int j=0;j<destProperty.length;j++){  
                      
                   if(sourceProperty[i].getName().equals(destProperty[j].getName())){  
                        //调用source的getter方法和dest的setter方法  
                        destProperty[j].getWriteMethod().invoke(dest, sourceProperty[i].getReadMethod().invoke(source));  
                        break;                    
                    }  
                }  
            }  
        }catch(Exception e){  
            throw new Exception("属性复制失败:"+e.getMessage());  
        }  
    }  

}
