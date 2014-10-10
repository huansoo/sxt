/**  
* @Title:  AuditionJob.java
* @Package com.wugu.zhaopin.webapp.job
* @Description: 面试邀请
* @author lijun
* @date  2013-12-25 下午3:34:41
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
import com.wugu.zhaopin.service.AuditionInfoManager;
import com.wugu.zhaopin.service.ResumeInfoManager;
import com.wugu.zhaopin.util.DateUtil;
import com.wugu.zhaopin.vo.ZpAuditionInfo;
import com.wugu.zhaopin.vo.ZpAuditionInfoCriteria;
import com.wugu.zhaopin.vo.ZpDeliveryInfo;
import com.wugu.zhaopin.vo.ZpDeliveryInfoCriteria;
import com.wugu.zhaopin.vo.ZpResumeInfo;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.api.MailUtil;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.webapp.model.AuditionInfo;
import com.wugu.zhaopin.webapp.model.AuditionInfoCriteria;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel;
import com.wugu.zhaopin.webapp.model.page.PageWraper;
import com.wugu.zhaopin.webapp.util.JobUtil;

/**
 * @ClassName: AuditionJob
 * @Description: 面试邀请
 * @author lijun
 * @date 2013-12-25 下午3:34:41
 *
 */
public class AuditionJob extends BaseJob
{
    private AuditionInfoManager auditionInfoManager; 
    private ResumeInfoManager resumeInfoManager; //简历信息服务对象
    private static Executor executor = Executors.newFixedThreadPool(10); 
    
    public AuditionInfoManager getAuditionInfoManager(){
        if(auditionInfoManager == null){
            auditionInfoManager = (AuditionInfoManager) getBean("auditioninfomanager", AuditionInfoManager.class);
        }
        return auditionInfoManager;        
    }
    
    public ResumeInfoManager getResumeInfoManager() {
        if(resumeInfoManager == null){
            resumeInfoManager = (ResumeInfoManager) getBean("resumeinfomanager", ResumeInfoManager.class);
        }
        return resumeInfoManager;       
    }
    /**
     * 
    * @Title: getAuditionList
    * @Description: 获取面试邀请信息
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getAuditionList() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            ZpAuditionInfoCriteria example = new ZpAuditionInfoCriteria();
            
            com.wugu.zhaopin.vo.ZpAuditionInfoCriteria.Criteria Criteria = example.createCriteria();
            
            Long resumeId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            Integer companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
            
            if (resumeId != null){
                Criteria.andResumeIdEqualTo(resumeId);
            }
            if (userId != null){
                Criteria.andAuditionUidEqualTo(userId);
            }
            if (companyId != null){
                Criteria.andCompanyIdEqualTo(companyId);
            }
            Criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            //加排序条件 按更新时间倒序排列
            example.setOrderByClause("update_time desc");
            
            List<ZpAuditionInfo> list = getAuditionInfoManager().selectByExample(example);
            
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
    
    private AuditionInfo getAuditionById(Long auditionId) 
            throws IOException, SQLException{
        
        AuditionInfoCriteria example = new AuditionInfoCriteria();
        
        example.createCriteria().andAuditionInfoIdEqualTo(auditionId)
                .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        PageWraper pw = getAuditionInfoManager().selectByPage(example);
        
        if (pw.getResult().size() > 0){
            return (AuditionInfo)pw.getResult().get(0);
        }
        else
            return null;
    }
    
    /**
     * 
    * @Title: getAuditionById
    * @Description: 根据ID获取面试邀请
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getAuditionById() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long auditionId = getQueryLong(JobUtil.AUDITION_ID);
            
            AuditionInfo audition = getAuditionById(auditionId); 
            
            String jsonstr = ""; 
            if (audition != null){
                JsonConfig config = JobUtil.getJsonConfig();
                JSONObject json = JSONObject.fromObject(audition, config);
                jsonstr = json.toString();
                
                System.out.println(jsonstr);
            }
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(jsonstr);
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
    * @Title: SelectByPage
    * @Description: 分页查询面试邀请信息
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void selectByPage() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            Integer companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
            Integer page = getQueryInt(JobUtil.PAGE);
            Integer pageSize = getQueryInt(JobUtil.PAGESIZE);
            
            AuditionInfoCriteria example = new AuditionInfoCriteria();            
            AuditionInfoCriteria.Criteria Criteria = example.createCriteria();
            if (resumeId != null){
                Criteria.andResumeIdEqualTo(resumeId);
            }
            if (userId != null){
                Criteria.andAuditionUidEqualTo(userId);
            }
            if (companyId != null){
                Criteria.andCompanyIdEqualTo(companyId);
            }            
          
            Criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            //加排序条件 按更新时间倒序排列
            example.setOrderByClause("update_time desc");
            
            //设置分页
            if (page != null)
                example.getPageInfo().setPage(page);
            if (pageSize != null)
                example.getPageInfo().setPageSize(pageSize);
            
            PageWraper pw = getAuditionInfoManager().selectByPage(example);
            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("auditons", arr.toString());
            map.put("pageinfo", obj.toString());  
            
            arr = JSONArray.fromObject(map);
            
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
    
    private void sendMail(final Long result){
      //创建邮件发送任务  
        Runnable task = new Runnable() {  
            @Override  
            public void run() {
                String url = ConstantUtil.URL_RENCAI_SYSTEM;
                try
                {
                   AuditionInfo audition = getAuditionById(result);
                   
                   String postName = audition.getPostName();
                   String companyName = audition.getCompanyName();
                   String userName = audition.getPersonInfo().getRealName();
                   //获取个人电子邮箱
                   String eMail = audition.getPersonInfo().getEmail();
                   
                   if (!ValidateUtil.validateEmail(eMail))
                       throw new Exception("用户电子邮箱“" + eMail + "”非法！");
                       
                   //生成变量对象列表
                   HashMap<String, String> map = new HashMap<String, String>();
                   map.put("{userName}", userName);
                   map.put("{companyname}", companyName);
                   map.put("{postName}", postName);
                   
                   map.put("{url_audition}", url + "/Audition/SelectByUser");
                   map.put("{url_postInfo}", url + "/Job/detail?postid=" + audition.getPostId());
                   map.put("{url_companyInfo}", url + "/company/Detail?companyid=" + audition.getCompanyId());
                   map.put("{url_otherAudtion}", url + "/Audition/SelectByUser");
                   map.put("{url_MyAllResume}", url + "/Myzhaopin/ResumeList");  
                   
                   MailUtil.sendPersonMail(eMail, userName, companyName, map);
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
    * @Title: AuditionResume
    * @Description: 发送面试邀请(JSON格式)
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void sendAuditionInfo() throws IOException, SQLException {
        ApiResult<Long> apiresult = new ApiResult<Long>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpAuditionInfo record = getModelFromJson(json, ZpAuditionInfo.class);
            //被邀请人ID有可能不传
            if (record.getAuditionUid() == null)
                record.setAuditionUid(getUserIdByResumeId(record.getResumeId()));
            
            Long result = getAuditionInfoManager().insertSelective(record);
            
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
    
    public void getCountByUser() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            if(userId == null){
                throw new Exception("query userId missed!");
            }
            ZpAuditionInfoCriteria example = new ZpAuditionInfoCriteria();            
            ZpAuditionInfoCriteria.Criteria Criteria = example.createCriteria();
            if (userId != null){
                Criteria.andAuditionUidEqualTo(userId);
            }
            Criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            
            Integer result = getAuditionInfoManager().countByExample(example);
            
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
    * @Title: getLastAudtion
    * @Description: 根据简历ID和职位ID返回最近的邀请对象
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getLastAudition() throws IOException, SQLException {
        ApiResult<ZpAuditionInfo> apiresult = new ApiResult<ZpAuditionInfo>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            ZpAuditionInfo result = null;
            ZpAuditionInfo record = getModelFromJson(json, ZpAuditionInfo.class);
            
            ZpAuditionInfoCriteria example = new ZpAuditionInfoCriteria();
            example.createCriteria().andResumeIdEqualTo(record.getResumeId())
                        .andPostIdEqualTo(record.getPostId())
                        .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            example.setOrderByClause("update_time desc");            
            List<ZpAuditionInfo> list = getAuditionInfoManager().selectByExample(example);
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
    
    public static void main(String[] arg) throws Exception{
        AuditionJob job = new AuditionJob();
        job.sendMail(1L);
    }
}
