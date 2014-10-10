package com.wugu.zhaopin.sms.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.jdom.JDOMException;

import com.wugu.zhaopin.sms.SMSConstant;
import com.wugu.zhaopin.sms.SMSInfo;
import com.wugu.zhaopin.sms.SMSServer;
import com.wugu.zhaopin.sms.SMSService;
import com.wugu.zhaopin.sms.SMSUserInfo;
import com.wugu.zhaopin.util.Base64Encry;
import com.wugu.zhaopin.util.XMLUtil;

/**
 * 
* @ClassName: SMSServerMOSIImpl
* @Description: 志晴短信服务封装类
* @author lijun
* @date 2014-1-14 
*
 */
public class SMSServerMOSIImpl implements SMSService {
    
    private static final String xmlPreStr = "<?xml   version=\"1.0\"   encoding=\"UTF8\"?> ";

	private static MOSIClient client = null;
	
	public SMSServerMOSIImpl(SMSServer server) {
		try {
			if(client == null){
				client = new MOSIClient(server.getUserName(), 
				        server.getPassword(), server.getSoapActionURI());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	* @Title: sendSMS
	* @Description: 发送短信
	* @author lijun
	* @param info 短信信息类
	* @return 发送结果编码
	* @throws Exception
	* @throws
	 */
	@Override
	public String sendSMS(SMSInfo info) throws Exception {
		String result = client.mt(info.getMobileNumString(), info.getContent());
        
        return result;            
	}

    /* (非 Javadoc)
    * <p>Title: sendSMSEx</p>
    * <p>Description: 发送定制短信</p>
    * @param info
    * @throws Exception
    * @see com.wugu.zhaopin.sms.SMSService#sendSMSEx(com.wugu.zhaopin.sms.SMSInfo)
    */
    @Override
    public void sendSMSEx(SMSInfo info) throws Exception
    {
        // TODO Auto-generated method stub
        
    }

    /* (非 Javadoc)
    * <p>Title: sendSMSAuto</p>
    * <p>Description: 定时发送短信</p>
    * @param info 短信信息对象
    * @throws Exception
    * @see com.wugu.zhaopin.sms.SMSService#sendSMSAuto(com.wugu.zhaopin.sms.SMSInfo)
    */
    @Override
    public String sendSMSAuto(SMSInfo info) throws Exception
    {
        String result = client.sendSMSAuto(info.getMobileNumString(), 
                info.getContent(), info.getsTime());
        
        return result;            
      
    }
    
    private MOSIRecvResult getRecvResult(String rec){
        String[] recs = rec.split(SMSConstant.SMS_MOBILE_SPACER); 
        if (recs.length < 4)
            return null;
        MOSIRecvResult result = new MOSIRecvResult();
        result.setId(Integer.parseInt(recs[0]));
        result.setMobile(recs[1]);
        result.setContent(recs[2]);
        result.setsTime(recs[3]);
        
        return result;
    }

    /* (非 Javadoc)
    * <p>Title: receiveSMS</p>
    * <p>Description: </p>
    * @return
    * @throws Exception
    * @see com.wugu.zhaopin.sms.SMSService#receiveSMS()
    */
    @Override
    public List recvSMS() throws Exception
    {
        String result = client.recsms();
        if (result == null || "".equals(result))
            return null;
        
        String[] strs = result.split("\n");        
        List<MOSIRecvResult> list = new ArrayList<MOSIRecvResult>();
        for (int i = 0; i < strs.length; i ++ ){
            MOSIRecvResult recv = getRecvResult(strs[i]);
            list.add(recv);
        }
        return list;
    }

    /* (非 Javadoc)
    * <p>Title: getBalance</p>
    * <p>Description: 获取账户余额</p>
    * @return
    * @throws Exception
    * @see com.wugu.zhaopin.sms.SMSService#getBalance()
    */
    @Override
    public Integer getBalance() throws Exception
    {
        return client.balance();
    }

    /* (非 Javadoc)
    * <p>Title: getErrorInfo</p>
    * <p>Description: 获取发送结果描述信息</p>
    * @param code 发送结果代码
    * @return 发送结果描述信息
    * @see com.wugu.zhaopin.sms.SMSService#getErrorInfo(java.lang.String)
    */
    @Override
    public String getErrorInfo(String code)
    {
        return MOSIClient.getErrorInfo(code);
    }
    
    private SMSUserInfo getUserInfoByStr(String userInfoStr) throws Exception{
        Map map = XMLUtil.doXMLParse(userInfoStr);
        if (map.size() == 0)
            return null;
        else {     
            SMSUserInfo userInfo = new SMSUserInfo();
            userInfo.setResult(Integer.parseInt((String)map.get("Result")));
            userInfo.setPort((String)map.get("Port"));
            userInfo.setFlag(( map.get("Flag") != null? ((String)map.get("Flag")).equalsIgnoreCase("true") : false));
            userInfo.setAgent((String)map.get("Agent"));
            userInfo.setBalance(Integer.parseInt((String)map.get("Balance")));
            userInfo.setSignature((String)map.get("Signature"));
            userInfo.setSn((String)map.get("Sn"));
            
            return userInfo;
        }
    }

    /* (非 Javadoc)
    * <p>Title: getSMSUserInfo</p>
    * <p>Description: 获取短信账户信息</p>
    * @return 短信账户信息
    * @throws Exception
    * @see com.wugu.zhaopin.sms.SMSService#getSMSUserInfo()
    */
    @Override
    public SMSUserInfo getSMSUserInfo() throws Exception
    {   
        String userInfoStr = client.GetAllInfo();
        return getUserInfoByStr(xmlPreStr + userInfoStr);
    }

}
