package com.wugu.zhaopin.sms;

import java.util.List;

public interface SMSService {
    //发送短信
	public String sendSMS(SMSInfo info)throws Exception;
	//个性发送短信 多电话对多内容
	public void sendSMSEx(SMSInfo info)throws Exception;
	//定时短信
	public String sendSMSAuto(SMSInfo info)throws Exception;
	//接收短信
	public List recvSMS()throws Exception;
	//查询余额
	public Integer getBalance()throws Exception;
	//获取错误描述信息
	public String getErrorInfo(String code);
	//获取短信账户信息
	public SMSUserInfo getSMSUserInfo()throws Exception;
}
