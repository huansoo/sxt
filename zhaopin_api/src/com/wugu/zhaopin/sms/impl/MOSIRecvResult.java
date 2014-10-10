/**  
* @Title:  MOSIRecvResult.java
* @Package com.wugu.zhaopin.sms.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-1-13 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.sms.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

/**
 * @ClassName: MOSIRecvResult
 * @Description: 查询接收短信结果类
 * @author lijun
 * @date 2014-1-13 
 *
 */
public class MOSIRecvResult
{
    private Integer id;
    private String mobile;
    private String content;
    private String sTime;
    
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getMobile()
    {
        return mobile;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    public String getContent()
    {
        return content;
    }
    public void setContent(String content)
    {
        this.content = content;
    }
    public String getsTime()
    {
        return sTime;
    }
    public void setsTime(String sTime)
    {
        this.sTime = sTime;
    }
    
    public static void main(String[] arg) throws Exception {
        List list = new ArrayList();
        MOSIRecvResult rec = new MOSIRecvResult();
        rec.setId(11);
        rec.setContent("");
        rec.setMobile("112312312");
        rec.setsTime("");
        list.add(rec);
        list.add(rec);
        
        JSONArray arr = JSONArray.fromObject(list);
        System.out.println(arr.toString());
        
    }
}
