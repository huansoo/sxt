/**  
* @Title:  MailManager.java
* @Package com.wugu.zhaopin.service
* @Description: 邮件服务类
* @author lijun
* @date  2014-1-15 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.wugu.zhaopin.commons.ValidateUtil;
import com.wugu.zhaopin.mail.MailInfo;
import com.wugu.zhaopin.mail.MailSender;
import com.wugu.zhaopin.mail.MailServer;
import com.wugu.zhaopin.util.Base64Encry;
import com.wugu.zhaopin.util.FileUtil;
import com.wugu.zhaopin.util.InfoUtil;

/**
 * 
* @ClassName: MailManager
* @Description: 邮件服务类
* @author lijun
* @date 2014-1-15 
*
 */
public class MailManager {

    private static Logger log = Logger.getLogger(MailManager.class);
    private static Map<String,String> config = new HashMap<String,String>();
    
    private static MailServer mailserver;
    
    private static void init(){
        ResourceBundle rb=null;
        try {
            rb = ResourceBundle.getBundle("mail");
        } catch (Exception e) {
            log.warn(e);
        }
        if(rb != null){
            Enumeration<String> allkey=rb.getKeys();
            for(;allkey.hasMoreElements();){
                setRbValue(allkey.nextElement(), rb);
            }
        }
        
        mailserver = new MailServer();
        
        if(config.containsKey("stmp")){
            mailserver.setServerHost(config.get("stmp"));
        }
        if(config.containsKey("port")){
            mailserver.setServerPort(config.get("port"));
        }
        if(config.containsKey("sendName")){
            mailserver.setSendName(config.get("sendName"));
        }
        if(config.containsKey("password")){
            try {
                mailserver.setPassword(Base64Encry.decryptBASE64(config.get("password")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(config.containsKey("serverAddress")){
            mailserver.setServerAddress(config.get("serverAddress"));
        }
        if(config.containsKey("templatePath")){
            mailserver.setTemplatePath(config.get("templatePath"));
        }
    }
    
    private static void setRbValue(String key,ResourceBundle rb){
        String value = null;
        try {
            value = rb.getString(key);
        } catch (Exception e) {
            log.warn(e);
        }
        if(value != null){
            config.put(key, value);
        }
    }
    
    private static void saveServer() throws Exception{
        if(mailserver == null){
            init();
        }
        Properties pro = new Properties();
        pro.setProperty("stmp", mailserver.getServerHost() == null?"" : mailserver.getServerHost());
        pro.setProperty("port", mailserver.getServerPort() == null?"" : mailserver.getServerPort());
        pro.setProperty("sendName", mailserver.getSendName() == null?"" : mailserver.getSendName());
        pro.setProperty("password", mailserver.getPassword() == null?"" : mailserver.getPassword());
        pro.setProperty("serverAddress", mailserver.getServerAddress() == null?"" : mailserver.getServerAddress());
        pro.setProperty("templatePath", mailserver.getTemplatePath() == null?"" : mailserver.getTemplatePath());
        
        String path = InfoUtil.getClassPath();        
        File f = new File(path + "mail.properties");
        FileOutputStream out = new FileOutputStream(f);
        
        pro.store(out, "mail");
        out.close();
    }
    
    public static void sendMail(MailInfo mailInfo) throws Exception {
        if(mailserver == null){
            init();
        }
        MailSender sender = new MailSender(mailserver);
        sender.sendMail(mailInfo);
    }
    
    /**
     * 
    * @Title: sendMailByTemplate
    * @Description: 发送模板邮件
    * @author lijun
    * @param toAddress 收件人邮箱
    * @param toUserName 收件人名称
    * @param title 邮件标题
    * @param template 模板名称
    * @param map 替换变量列表
    * @throws Exception
    * @throws
     */
    public static void sendMailByTemplate(String toAddress, String toUserName, 
            String title, String template, HashMap<String,String> map) throws Exception {
        MailInfo mailInfo = new MailInfo();
        MailInfo.Person person = new MailInfo.Person(toUserName, toAddress);
        mailInfo.addToAdress(person);
        mailInfo.setSubject(title);
        mailInfo.setContent(FileUtil.replaceKeys(getMailServer().getTemplatePath() + template, map));
        sendMail(mailInfo);
    }

    public static void setMailServer(MailServer server)throws Exception {
        if(mailserver == null){
            init();
        }
        mailserver = server;
        saveServer();
    }

    public static MailServer getMailServer() {
        if(mailserver == null){
            init();
        }
        return mailserver;
    }

    public static void main(String[] arg) throws Exception{
////        saveServer();
//       MailInfo mail = new MailInfo();
//       mail.setSubject("测试邮件！");
//       mail.setContent("测试测试");
//       mail.addToAdress(new MailInfo.Person("李军", "lijun@wugu.com.cn"));
//       HashMap<String, String> map = new HashMap<String, String>();
//       map.put("{userName}", "李军");
//       map.put("{companyname}", "公司");
//       map.put("{postName}", "工程师");
//       map.put("{url_audition}", "http://rencai.wugu.com.cn/Audition/AuditionInfo?auditionId=1");
//       map.put("{url_postInfo}", "http://rencai.wugu.com.cn/Audition/AuditionInfo?auditionId=1");
//       map.put("{url_companyInfo}", "http://rencai.wugu.com.cn/Audition/AuditionInfo?auditionId=1");
//       map.put("{url_otherAudtion}", "http://rencai.wugu.com.cn/Audition/AuditionInfo?auditionId=1");
//       map.put("{url_MyAllResume}", "http://rencai.wugu.com.cn/Audition/AuditionInfo?auditionId=1");  
//       
//       sendMailByTemplate("lijun@wugu.com.cn", "吾谷人才", "测试邮件", "personMailContent.html", map);

        
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("{userName}", "李军");
        map.put("{companyname}", "公司甲");
        map.put("{postName}", "工程师");
        
        map.put("{url_resume}", "/Audition/Detail?resumeid=29&companyid=44");
        map.put("{url_postInfo}",  "http://rencai.wugu.com.cn/Audition/AuditionInfo?auditionId=1");
        map.put("{url_myReceive}",  "http://rencai.wugu.com.cn/Audition/AuditionInfo?auditionId=1");
        map.put("{url_rencai}",  "http://rencai.wugu.com.cn/Audition/AuditionInfo?auditionId=1");
        sendMailByTemplate("lijun@wugu.com.cn", "吾谷人才", "测试邮件", "companyMailContent.html", map);
    }
}
