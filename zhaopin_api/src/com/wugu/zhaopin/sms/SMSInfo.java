package com.wugu.zhaopin.sms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.wugu.zhaopin.util.DateUtil;

public class SMSInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 接收者号码
	 */
	private List<String> mobileNumber =new ArrayList<String>();
	
    /**
     * 单条短信内容
     */
    private String content;    
	
	/**
	 * 多条短信内容
	 */
	private List<String> contents = new ArrayList<String>();
	
	/**
	 * 定时时间 格式如 2010-11-11 11:11:00
	 */
	private String sTime; 
	
	private String logInfo;
	
	public String getsTime()
    {
        return sTime;
    }

    public void setsTime(String sTime)
    {
        this.sTime = sTime;
    }

    public List<String> getContents()
    {
        return contents;
    }

    public void setContents(List<String> contents)
    {
        this.contents = contents;
    }

	public String getLogInfo(){
	    String info = "\n";
	    if (sTime != null)
	        info += "sendSMS_Start---------------------------------------\n"; 
	    else
	        info += "autoSMS_Start---------------------------------------\n";
	    info += "sendTime:" + DateUtil.getNowTimeStr() + "\n";   
	    info += "sendMobile:" + getMobileNumString() + "\n";
	    info += "sendContent:" + getContent() + "\n";
	    if (sTime != null)
	        info += "autoTime:" + getsTime() + "\n"; 
	    return info;
	}
	
	public String getLogEnd(String resultInfo){
	    String info = "";
	    info += "sendResult：" + resultInfo + "\n";
	    info += "endTime：" + DateUtil.getNowTimeStr() + "\n";
	    if (sTime != null)
            info += "---------------------------------------autoSMS_End \n"; 
        else
            info += "---------------------------------------sendSMS_End \n";
	    
	    return info;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 
	* @Title: addMobileNumber
	* @Description: 增加接收手机号
	* @author lijun
	* @param number
	* @throws
	 */
	public void addMobileNumber(String number){
		mobileNumber.add(number);
	}
	
	/**
	 * 
	* @Title: getMobileNumber
	* @Description: 获取手机号字符串
	* @author lijun
	* @return
	* @throws
	 */
	public List<String> getMobileNumber() {
		return mobileNumber;
	}
	
	/**
	 * 
	* @Title: addGroupInfo
	* @Description: 添加群发短信内容
	* @author lijun
	* @param mobiles 群发手机号码列表
	* @param content 群发内容
	* @throws
	 */
	public void addGroupInfo(String[] mobiles, String content){
	    for (int i = 0; i < mobiles.length; i++)
        {
            addMobileNumber(mobiles[0]);
        }
	    setContent(content);
	}
	
	private String getListToString(List<String> list){
	    String result = "";
	    for (String string : list)
        {
            result = result + string + ","; 
        }
	    return result.substring(0, result.length() - 1);
	}
	
	/**
	 * 
	* @Title: getMobileNumString
	* @Description: 获取手机号码列表字符串，以逗号“,”分割
	* @author lijun
	* @return 手机号码列表字符串，以逗号“,”分割
	* @throws
	 */
	public String getMobileNumString(){
	   return getListToString(getMobileNumber()); 
	}
	
}
