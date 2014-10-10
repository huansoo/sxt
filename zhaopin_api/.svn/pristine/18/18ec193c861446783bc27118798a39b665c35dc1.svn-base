/**  
* @Title:  MailJob.java
* @Package com.wugu.zhaopin.webapp.job
* @Description: 邮件服务
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
package com.wugu.zhaopin.webapp.job;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.mail.MailInfo;
import com.wugu.zhaopin.mail.MailInfo.Person;
import com.wugu.zhaopin.service.MailManager;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.webapp.util.JobUtil;


/**
 * @ClassName: MailJob
 * @Description: 邮件服务
 * @author lijun
 * @date 2014-1-15 
 *
 */
public class MailJob extends BaseJob
{
    private MailInfo getMailInfo(String json){
        MailInfo mailInfo = getModelFromJson(json, MailInfo.class);        
        
        JSONObject obj = JSONObject.fromObject(json);   
        
        //发送地址
        JSONArray arr = JSONArray.fromObject(obj.getString("toAdress"));
        for (int i = 0; i < arr.size(); i++)
        {
            JSONObject o = arr.getJSONObject(i);
            Person p = getModelFromJson(o.toString(), Person.class);
            mailInfo.addToAdress(p);            
        }   
        
        //抄送地址
        arr = JSONArray.fromObject(obj.getString("ccAdress"));
        for (int i = 0; i < arr.size(); i++)
        {
            JSONObject o = arr.getJSONObject(i);
            System.out.println(o.toString());
            Person p = getModelFromJson(o.toString(), Person.class);
            mailInfo.addCcAdress(p);            
        }   
        
        //暗送地址
        arr = JSONArray.fromObject(obj.getString("bccAdress"));
        for (int i = 0; i < arr.size(); i++)
        {
            JSONObject o = arr.getJSONObject(i);
            Person p = getModelFromJson(o.toString(), Person.class);
            mailInfo.addBccAdress(p);            
        }      
        
        //附件
        arr = JSONArray.fromObject(obj.getString("atch"));
        for (int i = 0; i < arr.size(); i++)
        {
            String address = arr.getString(i);            
            mailInfo.addAtch(address);            
        }      

        return mailInfo;
    } 
    
    public static void main(String[] arg) throws Exception{
        String json = "{\"atch\":[\"D:/work/志晴短信/SDK使用说明-websever-更新-7-15.doc\"],\"bccAdress\":[{\"address\":\"wanwangzhiwang@msn.com\",\"name\":\"李军\"}]"
                    + ",\"ccAdress\":[{\"address\":\"33291349@qq.com\",\"name\":\"李军\"}]"
                    + ",\"content\":\"偶是测试啊，有木有\","
                    + "\"subject\":\"偶是测试啊，有木有\""
                    + ",\"toAdress\":[{\"address\":\"lijun@wugu.com.cn\",\"name\":\"李军\"}]}";
        
        MailJob job = new MailJob();
        
        MailInfo info = job.getMailInfo(json);
        
        JSONObject obj = JSONObject.fromObject(info);
        
        System.out.println(obj.toString());
              
    }
    
    /**
     * 
    * @Title: sendMail
    * @Description: 发送邮件
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void sendMail() throws Exception{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {          
            String json = getQueryString(JobUtil.JsonDataName);
            if (json == null)
                throw new Exception("paramter json missed!");
            
            MailInfo mailInfo = getMailInfo(json);
            
            MailManager.sendMail(mailInfo);
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData("邮件已发送！");
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    public void sendMailByTemplate() throws Exception{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {          
            
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("{userName}", "李军");
            MailManager.sendMailByTemplate("lijun@wugu.com.cn", "李军", "测试邮件", "companyMailContent.html", map);
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData("邮件已发送！");
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
}
