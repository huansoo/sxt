/**  
* @Title:  MailUtil.java
* @Package com.wugu.zhaopin.webapp.api
* @Description: TODO(用一句话描述该文件做什么)
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
package com.wugu.zhaopin.webapp.api;

import java.util.HashMap;

import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.service.MailManager;

/**
 * @ClassName: MailUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-2-21 
 *
 */
public class MailUtil
{
    /**
     * 
    * @Title: sendMailByTemplate
    * @Description: 按文件模板发送邮件
    * @author lijun
    * @param toAddress 发送地址
    * @param toUserName 接收人姓名
    * @param title 邮件标题
    * @param template 模板文件名
    * @param map 变量列表
    * @throws Exception
    * @throws
     */
    public static void sendMailByTemplate(String toAddress, String toUserName, 
            String title, String template, HashMap<String,String> map) throws Exception { 
        MailManager.sendMailByTemplate(toAddress, toUserName, title, template, map);
    }
    
    /**
     * 
    * @Title: sendPersonMail
    * @Description: 发送个人邮件
    * @author lijun
    * @param toAddress 个人邮件地址
    * @param toUserName 个人姓名
    * @param companyName 发件公司姓名
    * @param map 变量列表
    * @throws Exception
    * @throws
     */
    public static void sendPersonMail(String toAddress, String toUserName, 
            String companyName, HashMap<String,String> map) throws Exception {
        MailUtil.sendMailByTemplate(toAddress, toUserName, 
                companyName + ConstantUtil.MAIL_TEMPLATE_PERSON_TITLE, ConstantUtil.MAIL_TEMPLATE_PERSON, map);
    }
    
    /**
     * 
    * @Title: sendCompanyMail
    * @Description: 发送公司邮件
    * @author lijun
    * @param toAddress 收件公司邮件地址
    * @param userName 求职个人姓名
    * @param postName 职位名称
    * @param companyName 公司名称
    * @param map 变量列表
    * @throws Exception
    * @throws
     */
    public static void sendCompanyMail(String toAddress, String userName, String postName, 
            String companyName, HashMap<String,String> map) throws Exception {
        MailUtil.sendMailByTemplate(toAddress, companyName, 
                String.format(ConstantUtil.MAIL_TEMPLATE_COMPNAY_TITLE, postName, userName), 
                ConstantUtil.MAIL_TEMPLATE_COMPANY, map);
    }
}
