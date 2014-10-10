/**  
* @Title:  DeliveryInfoJob.java
* @Package com.wugu.zhaopin.webapp.job
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2013-12-25 下午1:10:59
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.webapp.job;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.commons.ValidateUtil;
import com.wugu.zhaopin.service.CompanyManager;
import com.wugu.zhaopin.service.DeliveryInfoManager;
import com.wugu.zhaopin.service.ResumeInfoManager;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.api.MailUtil;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.webapp.model.AuditionInfo;
import com.wugu.zhaopin.webapp.model.AuditionInfoCriteria;
import com.wugu.zhaopin.webapp.model.DeliveryInfo;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel;
import com.wugu.zhaopin.vo.ZpDeliveryInfo;
import com.wugu.zhaopin.vo.ZpDeliveryInfoCriteria;
import com.wugu.zhaopin.vo.ZpPostInfo;
import com.wugu.zhaopin.vo.ZpPostInfoCriteria;
import com.wugu.zhaopin.webapp.model.DeliveryInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;
import com.wugu.zhaopin.webapp.util.JobUtil;
import com.wugu.zhaopin.util.DateUtil;

/**
 * @ClassName: DeliveryInfoJob
 * @Description: 简历投递
 * @author lijun
 * @date 2013-12-25 下午1:10:59
 *
 */
public class DeliveryJob extends BaseJob
{
    private DeliveryInfoManager deliveryInfoManager; 
    private ResumeInfoManager resumeInfoManager; //简历信息服务对象
    private CompanyManager companymanager;
    private static Executor executor = Executors.newFixedThreadPool(10); 
    
    public CompanyManager getCompanyManager() {
        if (companymanager == null){
            companymanager = (CompanyManager)getBeanEx("companymanager", CompanyManager.class);
        }
        return companymanager;
    }
    
    public DeliveryInfoManager getDeliveryInfoManager(){
        if(deliveryInfoManager == null){
            deliveryInfoManager = (DeliveryInfoManager) getBean("deliveryinfomanager", DeliveryInfoManager.class);
        }
        return deliveryInfoManager;        
    }
    
    public ResumeInfoManager getResumeInfoManager() {
        if(resumeInfoManager == null){
            resumeInfoManager = (ResumeInfoManager) getBean("resumeinfomanager", ResumeInfoManager.class);
        }
        return resumeInfoManager;       
    }
    /**
     * 
    * @Title: getDeliveryList
    * @Description: 获取投递信息列表 （投递人id，职位id、简历id）
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getDeliveryList() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            ZpDeliveryInfoCriteria example = new ZpDeliveryInfoCriteria();
            
            ZpDeliveryInfoCriteria.Criteria Criteria = example.createCriteria();
            
            Long resumeId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            Integer postId = getQueryInt(JobUtil.PARAMTER_POSTID);
            
            if (resumeId != null){
                Criteria.andResumeIdEqualTo(resumeId);
            }
            if (userId != null){
                Criteria.andDeliveryUidEqualTo(userId);
            }
            if (postId != null){
                Criteria.andPostIdEqualTo(postId);
            }
            Criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            //加排序条件 按更新时间倒序排列
            example.setOrderByClause("update_time desc");
            
            List<ZpDeliveryInfo> list = getDeliveryInfoManager().selectByExample(example);
            
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
    
    private Long getUserIdByResumeId(Long resumeId)
            throws Exception {
        return getResumeInfoManager().selectByPrimaryKey(resumeId).getUserId();
    }
    
    /**
     * 
    * @Title: insertDeliveryInfo
    * @Description: 投递简历（参数方式）
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void insertDeliveryInfo() throws IOException, SQLException {
        ApiResult<Long> apiresult = new ApiResult<Long>();
        try {
            Long resumeId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            Long userId = getUserIdByResumeId(resumeId);
            Integer postId = getQueryInt(JobUtil.PARAMTER_POSTID);
            Integer typeId = getQueryInt(JobUtil.PARAMTER_DELIVERYTYPE);
            Integer companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
            
            ZpDeliveryInfo record = new ZpDeliveryInfo();
            record.setResumeId(resumeId);
            record.setDeliveryUid(userId);
            record.setCompanyId(companyId);
            record.setPostId(postId);
            record.setDeliveryType(typeId);
            record.setCreateTime(DateUtil.getCurrentTimes());
            record.setUpdateTime(DateUtil.getCurrentTimes());
            
            Long result = getDeliveryInfoManager().insertSelective(record);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(result);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(0L);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    private DeliveryInfo getDeliveryById(Long deliveryId) 
            throws IOException, SQLException{
        
        DeliveryInfoCriteria example = new DeliveryInfoCriteria();
        
        example.createCriteria().andDeliveryInfoIdEqualTo(deliveryId)
                .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        PageWraper pw = getDeliveryInfoManager().selectByPage(example);
        
        if (pw.getResult().size() > 0){
            return (DeliveryInfo)pw.getResult().get(0);
        }
        else
            return null;
    }
    
    private String getPostEmail(Long postId)  throws IOException, SQLException{
        String eMail = "";
        ZpPostInfo postInfo = null;
        
        ZpPostInfoCriteria example = new ZpPostInfoCriteria();
        example.createCriteria().andPostIdEqualTo(postId).
            andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        
        List<ZpPostInfo> list = getCompanyManager().selectByExample(example);
        if (list.size() > 0){
            postInfo = list.get(0);
            eMail = postInfo.getEmail();
        }
        return eMail;
    }
    
    private void sendMailEx(final Long deliveryId){
      //创建邮件发送任务  
        Runnable task = new Runnable() {  
            @Override  
            public void run() { 
                String url = ConstantUtil.URL_RENCAI_SYSTEM;
                try
                {
                    Thread.sleep(10000);
                    String userName = "我";
                    String postName = "工程师";
                    String companyName = "公司甲";
                    //获取职位对应电子邮箱
                    String eMail = "lijun@wugu.com.cn";
                    
                    if (!ValidateUtil.validateEmail(eMail))
                        throw new Exception("用户电子邮箱“" + eMail + "”非法！");
                    
                    //生成变量对象列表
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("{userName}", userName);
                    map.put("{companyname}", companyName);
                    map.put("{postName}", postName);
                    
                    map.put("{url_resume}", url);
                    map.put("{url_postInfo}", url);
                    map.put("{url_myReceive}", url);
                    map.put("{url_rencai}", url + "/resume/Talent");
                    
                    MailUtil.sendCompanyMail(eMail, userName, postName, companyName, map);
                }
                catch (Exception e)
                {
                    System.out.println("发送邮件出错：" + e);
                }
            }
         };  
         //使用Executor框架的线程池执行邮件发送任务  
         executor.execute(task);   
    }
    
    private void sendMail(final Long deliveryId){
        //创建邮件发送任务  
        Runnable task = new Runnable() {  
            @Override  
            public void run() { 
                String url = ConstantUtil.URL_RENCAI_SYSTEM;
                try
                {
                    DeliveryInfo delivery = getDeliveryById(deliveryId);
                    
                    String userName = delivery.getPersonInfo().getRealName();
                    String postName = delivery.getPostName();
                    String companyName = delivery.getCompanyName();
                    //获取职位对应电子邮箱
                    String eMail = getPostEmail(delivery.getPostId().longValue());
                    
                    if (!ValidateUtil.validateEmail(eMail))
                        throw new Exception("用户电子邮箱“" + eMail + "”非法！");
                    
                    //生成变量对象列表
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("{userName}", userName);
                    map.put("{companyname}", companyName);
                    map.put("{postName}", postName);
                    
                    map.put("{url_resume}", url + "/Audition/Detail?resumeid="+ delivery.getResumeId() +"&companyid=" + delivery.getCompanyId());
                    map.put("{url_postInfo}", url + "/Job/detail?postid=" + delivery.getPostId());
                    map.put("{url_myReceive}", url + "/company/MyReceive");
                    map.put("{url_rencai}", url + "/resume/Talent");
                    
                    MailUtil.sendCompanyMail(eMail, userName, postName, companyName, map);
                }
                catch (Exception e)
                {
                    System.out.println("发送邮件出错：" + e);
                }
            }
         };  
         //使用Executor框架的线程池执行邮件发送任务  
         executor.execute(task);  
    }
    /**
     * 
    * @Title: DeliveryResume
    * @Description: 投递简历(JSON格式)
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void deliveryResume() throws IOException, SQLException {
        ApiResult<Long> apiresult = new ApiResult<Long>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpDeliveryInfo record = getModelFromJson(json, ZpDeliveryInfo.class);
            //投递人ID有可能不传
            if (record.getDeliveryUid() == null)
                record.setDeliveryUid(getUserIdByResumeId(record.getResumeId()));
            
            Long result = getDeliveryInfoManager().insertSelective(record);
            
            //发送邮件通知
            if (result > 0)
                sendMail(result);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(result);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(0L);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    /**
     * 
    * @Title: deleteDelivery
    * @Description: 删除收到的简历
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void deleteDelivery() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long deliveryId = getQueryLong(JobUtil.PARAMTER_DELIVERYID);
            if(deliveryId == null){
                throw new Exception("query deliveryid missed!");
            }
            
            ZpDeliveryInfo record = new ZpDeliveryInfo();
            record.setDeliveryInfoId(deliveryId);
            record.setStatus(ConstantUtil.RECORDDELETESIGN);
            
            Integer result = getDeliveryInfoManager().updateByPrimaryKeySelective(record);
            
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
    * @Title: getLastDelivery
    * @Description: 根据简历ID和职位ID返回最近的投递对象
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getLastDelivery() throws IOException, SQLException {
        ApiResult<ZpDeliveryInfo> apiresult = new ApiResult<ZpDeliveryInfo>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            ZpDeliveryInfo result = null;
            ZpDeliveryInfo record = getModelFromJson(json, ZpDeliveryInfo.class);
            
            ZpDeliveryInfoCriteria example = new ZpDeliveryInfoCriteria();
            example.createCriteria().andResumeIdEqualTo(record.getResumeId())
                        .andPostIdEqualTo(record.getPostId())
                        .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            example.setOrderByClause("update_time desc");            
            List<ZpDeliveryInfo> list = getDeliveryInfoManager().selectByExample(example);
            if (list.size() > 0)
                result = list.get(0);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(result);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(null);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    /**
     * 
    * @Title: selectByPage
    * @Description:  分页获取投递信息列表 （投递人id，职位id、简历id、当前页page、每页显示行数pagesize）
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void selectByPage() 
            throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            Integer postId = getQueryInt(JobUtil.PARAMTER_POSTID);
            Integer companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
            Integer page = getQueryInt(JobUtil.PAGE);
            Integer pageSize = getQueryInt(JobUtil.PAGESIZE);
            
            DeliveryInfoCriteria example = new DeliveryInfoCriteria();            
            DeliveryInfoCriteria.Criteria Criteria = example.createCriteria();
            if (resumeId != null){
                Criteria.andResumeIdEqualTo(resumeId);
            }
            if (userId != null){
                Criteria.andDeliveryUidEqualTo(userId);
            }
            if (postId != null){
                Criteria.andPostIdEqualTo(postId);
            }            
            if (companyId != null){
                Criteria.andCompanyIdEqualTo(companyId);
            }            
          
            Criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            //加排序条件 按更新时间倒序排列
            example.setOrderByClause("update_time desc");
            
            //设置分页
            if (getQueryString(JobUtil.PAGE) != null)
                example.getPageInfo().setPage(page);
            if (getQueryString(JobUtil.PAGESIZE) != null)
                example.getPageInfo().setPageSize(pageSize);
            
            PageWraper pw = getDeliveryInfoManager().selectByPage(example);
            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("deliverys", arr.toString());
            map.put("pageinfo", obj.toString());  
            arr = JSONArray.fromObject(map);
            System.out.println(arr.toString());
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
    * @Title: getCountByUser
    * @Description: 获取用户投递简历次数
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getCountByUser() 
            throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            
            ZpDeliveryInfoCriteria example = new ZpDeliveryInfoCriteria();            
            ZpDeliveryInfoCriteria.Criteria Criteria = example.createCriteria();

            if (userId != null){
                Criteria.andDeliveryUidEqualTo(userId);
            }          
          
            Criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            
            Integer result = getDeliveryInfoManager().countByExample(example);
            
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
    * @Title: getCountByCompany
    * @Description: 根据公司id，获取收到简历的个数
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getCountByCompany() 
            throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Integer companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
            
            ZpDeliveryInfoCriteria example = new ZpDeliveryInfoCriteria();            
            ZpDeliveryInfoCriteria.Criteria Criteria = example.createCriteria();

            if (companyId != null){
                Criteria.andCompanyIdEqualTo(companyId);
            }          
          
            Criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            
            Integer result = getDeliveryInfoManager().countByExample(example);
            
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
    public static void main(String[] arg) throws Exception{
        DeliveryJob job = new DeliveryJob();
        job.sendMailEx(38L);
        System.out.println("已经结束了");
    }
}
