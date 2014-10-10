/**  
* @Title:  MOSIAllInfo.java
* @Package com.wugu.zhaopin.sms.impl
* @Description: TODO(用一句话描述该文件做什么)
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
package com.wugu.zhaopin.sms;

/**
 * @ClassName: MOSIAllInfo
 * @Description: 短信账户信息类
 * @author lijun
 * @date 2014-1-14 
 *
 */
public class SMSUserInfo
{
    private Integer result; 
    private String port;
    private boolean flag;
    private String agent;
    private String sn;
    private Integer balance;
    private String signature;
    public Integer getResult()
    {
        return result;
    }
    public void setResult(Integer result)
    {
        this.result = result;
    }
    public String getPort()
    {
        return port;
    }
    public void setPort(String port)
    {
        this.port = port;
    }
    public boolean isFlag()
    {
        return flag;
    }
    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    public String getAgent()
    {
        return agent;
    }
    public void setAgent(String agent)
    {
        this.agent = agent;
    }
    public String getSn()
    {
        return sn;
    }
    public void setSn(String sn)
    {
        this.sn = sn;
    }
    public Integer getBalance()
    {
        return balance;
    }
    public void setBalance(Integer balance)
    {
        this.balance = balance;
    }
    public String getSignature()
    {
        return signature;
    }
    public void setSignature(String signature)
    {
        this.signature = signature;
    } 
}
