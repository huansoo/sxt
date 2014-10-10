package com.wugu.zhaopin.service;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.wugu.zhaopin.sms.SMSInfo;
import com.wugu.zhaopin.sms.SMSSender;
import com.wugu.zhaopin.sms.SMSServer;
import com.wugu.zhaopin.sms.SMSUserInfo;
import com.wugu.zhaopin.util.Base64Encry;
import com.wugu.zhaopin.util.InfoUtil;

public class SMSManager {

	private static Logger log = Logger.getLogger(SMSManager.class);
	
	private static Map<String,String> config = new HashMap<String,String>();
	
	private static SMSServer smsserver;
	private static SMSSender sender;
	
	private static void getServer(){
        if(smsserver == null){
            init();
        }            
	}
	
	private static void init(){
		ResourceBundle rb = null;
		try {
			rb = ResourceBundle.getBundle("SMS");
		} catch (Exception e) {
			log.warn(e);
		}
		if(rb != null){
			Enumeration<String> allkey = rb.getKeys();
			for(;allkey.hasMoreElements();){
				setRbValue(allkey.nextElement(), rb);
			}
		}
		
		smsserver = new SMSServer();
		
		if(config.containsKey("username")){
			smsserver.setUserName(config.get("username"));
		}
		if(config.containsKey("password")){
			try {
				smsserver.setPassword(Base64Encry.decryptBASE64(config.get("password")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        if(config.containsKey("soapurl")){
            smsserver.setSoapActionURI(config.get("soapurl"));
        }
        
        //初始化短信发送服务对象
        if (sender == null){
            sender = new SMSSender(smsserver);
        }
	}
	
	private static void setRbValue(String key,ResourceBundle rb){
		String value=null;
		try {
			value=rb.getString(key);
		} catch (Exception e) {
			log.warn(e);
		}
		if(value!=null){
			config.put(key, value);
		}
	}
	
	private static void saveServer() throws Exception{
	    getServer();
	    
	    Properties pro = new Properties();
		pro.setProperty("userName", smsserver.getUserName() == null?"":smsserver.getUserName());
		pro.setProperty("password", smsserver.getPassword() == null?"":smsserver.getPassword());
		pro.setProperty("soapUrl", smsserver.getSoapActionURI() == null?"":smsserver.getSoapActionURI());
		
		String path = InfoUtil.getClassPath();
		File f = new File(path + "SMS.properties");
		FileOutputStream out = new FileOutputStream(f);
		
		pro.store(out, "SMS");
		out.close();
		
		log.info("保存短信服务配置信息！");
	}
	
	public static SMSServer getSMSServer() {
	    getServer();
	    
		return smsserver;
	}
	
    public static void setSMSServer(SMSServer server) throws Exception {
        getServer();
        
        smsserver = server;
        saveServer();
    }
	
    /**
     * 
    * @Title: sendSMS
    * @Description: 发送短信
    * @author lijun
    * @param smsInfo 信息对象
    * @return 返回错误代码 成功为0
    * @throws Exception
    * @throws
     */
	public static String sendSMS(SMSInfo smsInfo) throws Exception {
	    getServer();
	    
	    return sender.sendSMS(smsInfo);
	}
	
	/**
	 * 
	* @Title: getErrorInfo
	* @Description: 获取错误代码描述信息
	* @author lijun
	* @param code
	* @return 错误代码描述信息
	* @throws Exception
	 */
	public static String getErrorInfo(String code) throws Exception{
	    getServer();
	    
	    return sender.getErrorInfo(code);
	}
	
	/**
	 * 
	* @Title: getBalance
	* @Description: 获取当前账户剩余短信条数
	* @author lijun
	* @return 当前账户剩余短信条数
	* @throws Exception
	* @throws
	 */
	public static Integer getBalance() throws Exception{
	    getServer();
	    
        return sender.getBalance(); 
	}
	
	/**
	 * 
	* @Title: sendSMSAuto
	* @Description: 自动发送短信
	* @author lijun
	* @param smsInfo 短信信息对象
	* @return 发送结果代码
	* @throws Exception
	* @throws
	 */
	public static String sendSMSAuto(SMSInfo smsInfo) throws Exception {
        getServer();
        
        return sender.sendSMSAuto(smsInfo);     
    } 
	
	/**
	 * 
	* @Title: recvSMS
	* @Description: 接收短信息
	* @author lijun
	* @return 返回短信列表
	* @throws Exception
	* @throws
	 */
	public static List recvSMS() throws Exception {
        getServer();
        
        return sender.recvSMS();
	}
	
	public static SMSUserInfo getUserInfo() throws Exception{
	    getServer();
	    
	    return sender.getUserInfo();
	}
	
	public static void main(String[] arg) throws Exception {
	    
	    System.out.println(URLEncoder.encode("'验证码****，你正在吾谷人才发布信息，勿向他人提供该码'", "utf-8"));
//        SMSInfo smsInfo = new SMSInfo();
//        smsInfo.addMobileNumber("15810515258");
//        String content = "测试" + 0;
//        smsInfo.setContent(content);
//        sendSMS(smsInfo);
//	    for (int i = 0; i < 20; i ++){
            SMSInfo smsInfo = new SMSInfo();
            smsInfo.addMobileNumber("13810800557");
            String content = "验证码，你正在吾谷人才发布信息，勿向他人提供该码";
            smsInfo.setContent(content);
            sendSMS(smsInfo);
//        }
//        for (int i = 0; i < 5; i ++){
//            SMSInfo smsInfo = new SMSInfo();
//            smsInfo.addMobileNumber("15810515258");
//            String content = "验证码" + i * 1000 + "，你正在吾谷人才发布信息，勿向他人提供该码";
//            smsInfo.setContent(content);                
//            sendSMS(smsInfo);
//            Thread.sleep(1000);
//        }
//        for (int i = 0; i < 20; i ++){
//            SMSInfo smsInfo = new SMSInfo();
//            smsInfo.addMobileNumber("18601375710");
//            String content = "测试" + i + 2;
//            smsInfo.setContent(content);
//            sendSMS(smsInfo);
//            Thread.sleep(1000);
//        }
        //content = URLDecoder.decode(content, "utf-8");
//        smsInfo.setContent(content);
//        getServer();
//        JSONObject obj = JSONObject.fromObject(sender.getUserInfo());
//        System.out.println(obj.toString());
        
        //System.out.println(SMSManager.sendSMS(smsInfo));
//        System.out.println(SMSManager.ge(smsInfo));
        //System.out.println(getBalance());
	    
	}
	
	
}
