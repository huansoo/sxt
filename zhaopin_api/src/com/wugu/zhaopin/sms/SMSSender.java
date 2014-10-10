package com.wugu.zhaopin.sms;

import java.util.List;

import com.wugu.zhaopin.sms.impl.SMSServerMOSIImpl;

public class SMSSender {

	private SMSServer server;
	
	private SMSService smsService;
	
	public SMSSender(SMSServer server) {
		super();
		this.server = server;
        if(server.getServerProvider().equals(SMSServer.PROVIDER_MOSI)){
            smsService = new SMSServerMOSIImpl(server);
        }
        else 
            smsService = null;
	}

	public SMSServer getServer() {
		return server;
	}

	private void checkValid() throws Exception{
        if((server == null) || !server.isValid() || smsService == null){
            throw new Exception("短信服务配置为空或者有误，请与系统管理员联系！");
        }
	}
	
	/**
	 * 
	* @Title: sendSMS
	* @Description: 发送短信
	* @author lijun
	* @param info 短信信息对象
	* @return 发送结果代码
	* @throws Exception
	* @throws
	 */
	public String sendSMS( SMSInfo info)throws Exception{
	    checkValid();
		return smsService.sendSMS(info);			
	}
	
	/**
	 * 
	* @Title: getErrorInfo
	* @Description: 获取发送结果描述信息
	* @author lijun
	* @param code 发送结果代码
	* @return 发送结果描述信息
	* @throws Exception
	* @throws
	 */
	public String getErrorInfo(String code)throws Exception{
        checkValid();
        
        return smsService.getErrorInfo(code);
	}
	
	/**
	 * 
	* @Title: getBalance
	* @Description: 获取当前账户剩余短信数量
	* @author lijun
	* @return 短信数量
	* @throws Exception
	* @throws
	 */
	public Integer getBalance() throws Exception {
	    checkValid();
	    
	    return smsService.getBalance();
	}
	
	/**
	 * 
	* @Title: sendSMSAuto
	* @Description: 自动发送短信
	* @author lijun
	* @param info 短信信息对象
	* @return 返回发送短信结果代码
	* @throws Exception
	* @throws
	 */
	public String sendSMSAuto(SMSInfo info)throws Exception{
        checkValid();
        
        return smsService.sendSMSAuto(info);            
    }
	
	/**
	 * 
	* @Title: recvSMS
	* @Description: 收取短信
	* @author lijun
	* @return 返回短信列表
	* @throws Exception
	* @throws
	 */
	public List recvSMS() throws Exception{
	    checkValid();
	    
	    return smsService.recvSMS();
	}
	
	public SMSUserInfo getUserInfo() throws Exception{
	    checkValid();
	    
        return smsService.getSMSUserInfo();
	}
}
