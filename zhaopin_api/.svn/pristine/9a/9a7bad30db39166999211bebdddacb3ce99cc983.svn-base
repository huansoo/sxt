/**  
* @Title:  SMSJob.java
* @Package com.wugu.zhaopin.webapp.job
* @Description: 短信接口
* @author lijun
* @date  2014-1-8 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.webapp.job;

import java.net.URLDecoder;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wugu.zhaopin.commons.ConverStr;
import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.commons.ValidateUtil;
import com.wugu.zhaopin.service.SMSManager;
import com.wugu.zhaopin.sms.SMSInfo;
import com.wugu.zhaopin.sms.SMSUserInfo;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.webapp.util.JobUtil;


/**
 * @ClassName: SMSJob
 * @Description: 短信接口
 * @author lijun
 * @date 2014-1-8 
 *
 */
public class SMSJob extends BaseJob
{
    /**
     * 
    * @Title: sendSMS
    * @Description: 短信发送接口
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void sendSMS() throws Exception{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            String mobileStr = getQueryString(JobUtil.PARAMTER_SMS_MOBILE);
            if(mobileStr == null){
                throw new Exception("query mobilestr missed!");
            }
            String[] mobiles = mobileStr.split(",");
            
            String content = getQueryString(JobUtil.PARAMTER_SMS_CONTENT);
            if(content == null){
                throw new Exception("query content missed!");
            }
            
            SMSInfo smsInfo = new SMSInfo();
            for (int i = 0; i < mobiles.length; i++)
            {                
                smsInfo.addMobileNumber(mobiles[i]);
            } 
            //强行转换内容为utf-8编码
            //content = ConverStr.converStr.changeCharset(content, "utf-8", "utf-8");
            smsInfo.setContent(content);
            
            String logInfo = smsInfo.getLogInfo();
            
            String result = SMSManager.sendSMS(smsInfo);
            //如果未发送成功，则抛出异常
            if (result != null && !result.equals("0")){
                logger.error(logInfo + smsInfo.getLogEnd(SMSManager.getErrorInfo(result)));
                throw new Exception(SMSManager.getErrorInfo(result));
            }
            logger.info(logInfo + smsInfo.getLogEnd(SMSManager.getErrorInfo(result)));
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(SMSManager.getErrorInfo(result));
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    /**
     * 
    * @Title: getBalance
    * @Description: 获取剩余短信条数
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void getBalance() throws Exception{
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            
            logger.info("………………开始查询剩余短信数量……………………");
            
            Integer result = SMSManager.getBalance();
            logger.info("剩余短信数量：" + result);
            
            logger.info("………………完成查询………………");
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(result);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(0);
            apiresult.setException(ex.toString());
            
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    /**
     * 
    * @Title: sendSMSAuto
    * @Description: 自动发送短信接口
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void sendSMSAuto() throws Exception{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            String mobileStr = getQueryString(JobUtil.PARAMTER_SMS_MOBILE);
            if(mobileStr == null){
                throw new Exception("query mobilestr missed!");
            }
            String[] mobiles = mobileStr.split(",");
            
            String content = getQueryString(JobUtil.PARAMTER_SMS_CONTENT);
            if(content == null){
                throw new Exception("query content missed!");
            }
            
            String sTime = getQueryString(JobUtil.PARAMTER_SMS_STIME);
            if(sTime == null){
                throw new Exception("query stime missed!");
            }
            else if (!ValidateUtil.validateDate(sTime)){
                throw new Exception("非法的日期格式：" + sTime);
            }
            
            SMSInfo smsInfo = new SMSInfo();
            for (int i = 0; i < mobiles.length; i++)
            {                
                smsInfo.addMobileNumber(mobiles[i]);
            } 
            smsInfo.setContent(content);
            smsInfo.setsTime(sTime);            
            
            String logInfo = smsInfo.getLogInfo();
            
            String result = SMSManager.sendSMSAuto(smsInfo);
            //如果未发送成功，则抛出异常
            if (result != null && !result.equals("0")){
                logger.error(logInfo + smsInfo.getLogEnd(SMSManager.getErrorInfo(result)));
                throw new Exception(SMSManager.getErrorInfo(result));
            }
            logger.info(logInfo + smsInfo.getLogEnd(SMSManager.getErrorInfo(result)));
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(SMSManager.getErrorInfo(result));
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }  
    
    /**
     * 
    * @Title: recvSMS
    * @Description: 接收短信息
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void recvSMS() throws Exception{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {          
            List list = SMSManager.recvSMS();
            JSONArray arr = JSONArray.fromObject(list);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(arr.toString());
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }  
    
    /**
     * 
    * @Title: getSMSUserInfo
    * @Description: 获取短信账户信息
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void getSMSUserInfo() throws Exception{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {          
            SMSUserInfo user = SMSManager.getUserInfo();
            JSONObject obj = JSONObject.fromObject(user);
            System.out.println(obj.toString());
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(obj.toString());
            
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    } 
    
}
