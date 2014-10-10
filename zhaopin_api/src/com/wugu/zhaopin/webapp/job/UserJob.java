
package com.wugu.zhaopin.webapp.job;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.wugu.zhaopin.cache.MemCachedMaker;
import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.commons.DataUtil;
import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.service.ResumeCertificateManager;
import com.wugu.zhaopin.service.ResumeEducationManager;
import com.wugu.zhaopin.service.ResumeExperienceManager;
import com.wugu.zhaopin.service.ResumeInfoManager;
import com.wugu.zhaopin.service.ResumeLanguageManager;
import com.wugu.zhaopin.service.ResumeSkillManager;
import com.wugu.zhaopin.service.UserManager;
import com.wugu.zhaopin.util.DateUtil;
import com.wugu.zhaopin.vo.BaseDistrict;
import com.wugu.zhaopin.vo.ZpPersonInfo;
import com.wugu.zhaopin.vo.ZpPersonInfoCriteria;
import com.wugu.zhaopin.vo.ZpResumeCertificateCriteria;
import com.wugu.zhaopin.vo.ZpResumeEducation;
import com.wugu.zhaopin.vo.ZpResumeEducationCriteria;
import com.wugu.zhaopin.vo.ZpResumeExperience;
import com.wugu.zhaopin.vo.ZpResumeExperienceCriteria;
import com.wugu.zhaopin.vo.ZpResumeInfo;
import com.wugu.zhaopin.vo.ZpResumeInfoCriteria;
import com.wugu.zhaopin.vo.ZpResumeLanguage;
import com.wugu.zhaopin.vo.ZpResumeLanguageCriteria;
import com.wugu.zhaopin.vo.ZpResumeSkill;
import com.wugu.zhaopin.vo.ZpResumeSkillCriteria;
import com.wugu.zhaopin.vo.ZpUser;
import com.wugu.zhaopin.vo.ZpUserCriteria;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.webapp.model.PostReportCriteria;
import com.wugu.zhaopin.webapp.model.PostReportModel;
import com.wugu.zhaopin.webapp.model.ResumeInfo;
import com.wugu.zhaopin.webapp.model.ResumeInfoCriteria;
import com.wugu.zhaopin.webapp.model.ResumeReportCriteria;
import com.wugu.zhaopin.webapp.model.ResumeReportModel;
import com.wugu.zhaopin.webapp.model.ResumeSearchModel;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;
import com.wugu.zhaopin.vo.ZpResumeCertificate;
import com.wugu.zhaopin.webapp.util.JobUtil;

/**
 * 
* @ClassName: UserJob
* @Description: 个人信息接口
* @author lijun
* @date 2013-12-25 下午4:34:47
*
 */
public class UserJob extends BaseJob {
    private static final String METHODNAME_GETLASTRESUMELIST  = "getlastresumelist_";   
    
	private UserManager usermanager; //用户服务对象
	private ResumeInfoManager resumeInfoManager; //简历信息服务对象
	private ResumeExperienceManager resumeExperienceManager; //工作经历服务对象
	private ResumeEducationManager resumeEducationManager; //教育经历服务对象
    private ResumeLanguageManager resumeLanguageManager; //教育经历服务对象
    private ResumeCertificateManager resumeCertificateManager; //证书服务对象
    private ResumeSkillManager resumeSkillManager; //证书服务对象
    
	public UserManager getUsermanager() {
		if(usermanager == null){
			usermanager = (UserManager) getBean("usermanager", UserManager.class);
		}
		return usermanager;
	}
	
	public ResumeInfoManager getResumeInfoManager() {
		if(resumeInfoManager == null){
			resumeInfoManager = (ResumeInfoManager) getBean("resumeinfomanager", ResumeInfoManager.class);
		}
		return resumeInfoManager;		
	}
	
	public ResumeExperienceManager getResumeExperienceManager() {
		if(resumeExperienceManager == null){
			resumeExperienceManager = (ResumeExperienceManager) getBean("resumeexperiencemanager", ResumeExperienceManager.class);
		}
		return resumeExperienceManager;		
	}	
	
   public ResumeEducationManager getResumeEducationManager() {
        if(resumeEducationManager == null){
            resumeEducationManager = (ResumeEducationManager) getBean("resumeeducationmanager", ResumeEducationManager.class);
        }
        return resumeEducationManager;     
    }
   
   public ResumeLanguageManager getResumeLanguageManager() {
       if(resumeLanguageManager == null){
           resumeLanguageManager = (ResumeLanguageManager) getBean("resumelanguagemanager", ResumeLanguageManager.class);
       }
       return resumeLanguageManager;     
   }
   
   public ResumeCertificateManager getResumeCertificateManager() {
       if(resumeCertificateManager == null){
           resumeCertificateManager = (ResumeCertificateManager) getBean("resumecertificatemanager", ResumeCertificateManager.class);
       }
       return resumeCertificateManager;     
   }
   
   public ResumeSkillManager getResumeSkillManager() {
       if(resumeSkillManager == null){
           resumeSkillManager = (ResumeSkillManager) getBean("resumeskillmanager", ResumeSkillManager.class);
       }
       return resumeSkillManager;     
   }   
	/**
	 * 
	* @Title: check
	* @Description: 检查用户Id是否存在
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void check() throws IOException, SQLException {
		Long userid = 0L;
		ApiResult<Integer> apiresult = new ApiResult<Integer>();
		try {
			userid = getQueryLong(JobUtil.PARAMTER_USERID);
			if(userid == 0){
				throw new Exception("query userid missed!");
			}
			int result = getUsermanager().checkUserExists(userid)?1:0;
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
	
	private Integer getVerifyType(String json){
	    JSONObject obj = JSONObject.fromObject(json);
	    Integer result = -1;
	    if (obj.containsKey(JobUtil.PARAMTER_VERIFY_TYPE))
	        result = obj.getInt(JobUtil.PARAMTER_VERIFY_TYPE);
	    return result;
	}
	
	/**
	 * 
	* @Title: insertResumeInfo
	* @Description: 添加简历
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void insertResumeInfo() throws IOException, SQLException {
		ApiResult<Long> apiresult = new ApiResult<Long>();
        Integer verifyType = -1;
        
		try {
			String json = getQueryString(JobUtil.JsonDataName);
			if(json == null){
				throw new Exception("query json missed!");
			}
			
			Long result = 0L;
			ZpResumeInfo resumeInfo = getModelFromJson(json, ZpResumeInfo.class);
			
			//发送短信验证码验证日志
            verifyType = getVerifyType(json);
            if (verifyType == 1 ){
                logger.info("smsVeiryfy_start------------------------------\n");
                logger.info("sendMobile:" + resumeInfo.getMobileTel() + "  \n");
                logger.info("returnTime:" + DateUtil.getNowTimeStr() + "  \n");
                logger.info("veryfyResult:success\n");
                logger.info("------------------------------smsVeiryfy_end \n");
            }
			
			result = getResumeInfoManager().insert(resumeInfo, true);
			
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
	* @Title: updateResumeInfo
	* @Description: 修改用户信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void updateResumeInfo() throws IOException, SQLException {
		ApiResult<Integer> apiresult = new ApiResult<Integer>();
		Integer verifyType = -1;
		try {
			String json = getQueryString(JobUtil.JsonDataName);
			if(json == null){
				throw new Exception("query json missed!");
			}
			ZpResumeInfo resumeInfo = getModelFromJson(json, ZpResumeInfo.class); 
			
            //发送短信验证码验证日志
            verifyType = getVerifyType(json);
            if (verifyType == 1 ){
                logger.info("smsVeiryfy_start------------------------------\n");
                logger.info("sendMobile:" + resumeInfo.getMobileTel() + "  \n");
                logger.info("returnTime:" + DateUtil.getNowTimeStr() + "  \n");
                logger.info("veryfyResult:success\n");
                logger.info("------------------------------smsVeiryfy_end \n");
            }	
            
			logger.info("开始更新简历");
			int result = getResumeInfoManager().updateByPrimaryKeySelective(resumeInfo, true);
			logger.info("完成更新简历");
			
			apiresult.setCode(Code.Succes);
			apiresult.setStatus(200);
			apiresult.setData(result);
		} catch (Exception ex) {
			apiresult.setStatus(500);
			apiresult.setData(0);
			apiresult.setException(ex.toString());
            ex.printStackTrace();
            logger.error("更新简历失败：" + ex.toString());
		}
		HttpUtil.responseJson(apiresult, getResponse());		
	}
	
	/**
	 * 
	* @Title: refreshResumeInfo
	* @Description: 刷新简历，更新时间
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
    public void refreshResumeInfo() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            Integer updateTime = getQueryInt(JobUtil.PARAMTER_UPDATETIME);
            
            if(getQueryString(JobUtil.PARAMTER_RESUMEID) == null){
                throw new Exception("query resumeId missed!");
            }
            if(getQueryString(JobUtil.PARAMTER_UPDATETIME) == null){
                Long lTime = System.currentTimeMillis();
                updateTime = lTime.intValue();
            }          
            
            logger.info("刷新简历");
            ZpResumeInfo resumeInfo = new ZpResumeInfo();
            resumeInfo.setResumeId(resumeId);
            resumeInfo.setUpdateTime(updateTime.intValue());
            
            int result = getResumeInfoManager().updateByPrimaryKeySelective(resumeInfo);
            
            logger.info("成功刷新简历");
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(result);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(0);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
            logger.error("刷新简历出错：" + ex.toString());
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    private Long copyResumeInfo(Long resumeInfoId) 
            throws Exception {        
        ZpResumeInfo resumeInfo = getResumeInfoManager().selectByPrimaryKey(resumeInfoId);
        resumeInfo.setCreateTime(DateUtil.getCurrentTimes());
        resumeInfo.setUpdateTime(DateUtil.getCurrentTimes());
        resumeInfo.setResumeName(resumeInfo.getResumeName() + ConstantUtil.COPYADDSTR);
        
        return getResumeInfoManager().insert(resumeInfo);
    }
    
    private boolean copyResumeExperiences(Long resumeInfoId, Long newResumeInfoId) 
            throws IOException, SQLException {        
        List<ZpResumeExperience> list = getResumeExperienceList(resumeInfoId);
        boolean result = true;
        for (int i = 0; i < list.size(); i++){
            ZpResumeExperience item = list.get(i);
            item.setCreateTime(DateUtil.getCurrentTimes());
            item.setUpdateTime(DateUtil.getCurrentTimes());
            item.setResumeId(newResumeInfoId);
            
            result = result && getResumeExperienceManager().insert(item) > 0;            
        }
        return result;
    }    

    private boolean copyResumeEducations(Long resumeInfoId, Long newResumeInfoId) 
            throws IOException, SQLException {        
        List<ZpResumeEducation> list = getResumeEducationList(resumeInfoId);
        boolean result = true;
        for (int i = 0; i < list.size(); i++){
            ZpResumeEducation item = list.get(i);
            item.setCreateTime(DateUtil.getCurrentTimes());
            item.setUpdateTime(DateUtil.getCurrentTimes());
            item.setResumeId(newResumeInfoId);
            
            result = result && getResumeEducationManager().insert(item) > 0;            
        }
        return result;
    }  

    private boolean copyResumeLanguages(Long resumeInfoId, Long newResumeInfoId) 
            throws IOException, SQLException {        
        List<ZpResumeLanguage> list = getResumeLanguageList(resumeInfoId);
        boolean result = true;
        for (int i = 0; i < list.size(); i++){
            ZpResumeLanguage item = list.get(i);
            item.setCreateTime(DateUtil.getCurrentTimes());
            item.setUpdateTime(DateUtil.getCurrentTimes());
            item.setResumeId(newResumeInfoId);
            
            result = result && getResumeLanguageManager().insert(item) > 0;            
        }
        return result;
    }  
    
    private boolean copyResumeCertificates(Long resumeInfoId, Long newResumeInfoId) 
            throws IOException, SQLException {        
        List<ZpResumeCertificate> list = getResumeCertificateList(resumeInfoId);
        boolean result = true;
        for (int i = 0; i < list.size(); i++){
            ZpResumeCertificate item = list.get(i);
            item.setCreateTime(DateUtil.getCurrentTimes());
            item.setUpdateTime(DateUtil.getCurrentTimes());
            item.setResumeId(newResumeInfoId);
            
            result = result && getResumeCertificateManager().insert(item) > 0;            
        }
        return result;
    }  
    
    private boolean copyResumeSkills(Long resumeInfoId, Long newResumeInfoId) 
            throws IOException, SQLException {        
        List<ZpResumeSkill> list = getResumeSkillList(resumeInfoId);
        boolean result = true;
        for (int i = 0; i < list.size(); i++){
            ZpResumeSkill item = list.get(i);
            item.setCreateTime(DateUtil.getCurrentTimes());
            item.setUpdateTime(DateUtil.getCurrentTimes());
            item.setResumeId(newResumeInfoId);
            
            result = result && getResumeSkillManager().insert(item) > 0;            
        }
        return result;
    }      
    /**
     * 
    * @Title: copyResumeInfo
    * @Description: 复制简历 并返回简历列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void copyResumeInfo() throws IOException, SQLException {
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeInfoId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(resumeInfoId == null){
                throw new Exception("query resumeId missed!");
            }
            
            Long newResumeInfoId = copyResumeInfo(resumeInfoId);
            if (newResumeInfoId <= 0) {
                throw new Exception("复制简历出错，请重新再试!"); 
            }
            
            boolean result = copyResumeExperiences(resumeInfoId, newResumeInfoId);
            if (!result) {
                throw new Exception("复制工作经历出错!"); 
            }
            
            result = copyResumeEducations(resumeInfoId, newResumeInfoId);
            if (!result) {
                throw new Exception("复制教育经历出错!"); 
            }
            
            result = copyResumeLanguages(resumeInfoId, newResumeInfoId);
            if (!result) {
                throw new Exception("复制外语水平出错!"); 
            }
            
            result = copyResumeCertificates(resumeInfoId, newResumeInfoId);
            if (!result) {
                throw new Exception("复制证书出错!"); 
            }
            
            result = copyResumeSkills(resumeInfoId, newResumeInfoId);
            if (!result) {
                throw new Exception("复制工作技能出错!"); 
            }
             
            json = getResumeInfoAllJson(newResumeInfoId);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());         
    }  
    
    private ZpResumeInfo getResumeInfo(Long resumeInfoId, boolean includeDel) 
            throws Exception{
        ZpResumeInfoCriteria example = new ZpResumeInfoCriteria();
        
        if (!includeDel)
            example.createCriteria().andResumeIdEqualTo(resumeInfoId)
                .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        else
            example.createCriteria().andResumeIdEqualTo(resumeInfoId);
        
        List<ZpResumeInfo> list = getResumeInfoManager().selectByExample(example);
        ZpResumeInfo resumeInfo = null;
        if (list.size() > 0) 
            resumeInfo = list.get(0);
        
        return resumeInfo;
    }
	
	private String getResumeInfoAllJson(Long resumeInfoId) 
	        throws Exception {
	   Map<String, String> map = new HashMap<String, String>();
	   List<Object> list = new ArrayList<Object>();
	   
	   list.add(getResumeInfo(resumeInfoId, false));
	   
	   String json = "";
	   
       //json = getResumeInfoJson(resumeInfoId);
       //map.put("ResumeResumeInfo", json);	
       
	   json = getResumeSkillsJson(resumeInfoId);
	   map.put("ResumeSkill", json);
	   
	   json = getResumeCertificatesJson(resumeInfoId);
       map.put("ResumeCertificate", json);
       
       json = getResumeEducationsJson(resumeInfoId);
       map.put("ResumeEducation", json);
       
       json = getResumeExperienceJson(resumeInfoId);
       map.put("ResumeExperience", json);
       
       json = getResumeLanguagesJson(resumeInfoId);
       map.put("ResumeLanguage", json);
       
       list.add(map);      
       JSONArray arr = JSONArray.fromObject(list);
       
	   return arr.toString(); 
	}
	
	/**
	 * 
	* @Title: getResumeInfo
	* @Description: 根据简历Id获取简历信息及附加信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getResumeInfo() throws IOException, SQLException {
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeInfoId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(resumeInfoId == null){
                throw new Exception("query resumeId missed!");
            }
            
            logger.info("根据简历Id获取简历信息及附加信息");
            json = getResumeInfoAllJson(resumeInfoId);
            logger.info("成功获取简历信息及附加信息");
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
            logger.error("根据简历Id获取简历信息及附加信息失败：" + ex.toString());
        }
        HttpUtil.responseJson(apiresult, getResponse());   	    
	}
	
    private Integer deleteInfoByResumeId(Long resumeInfoId)
            throws IOException, SQLException {
        ZpResumeInfoCriteria example = new ZpResumeInfoCriteria();
        example.createCriteria().andResumeIdEqualTo(resumeInfoId);
        
        ZpResumeInfo record = new ZpResumeInfo();
        record.setResumeId(resumeInfoId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeInfoManager().updateByExampleSelective(record, example);
    }	
    
	private Integer deleteSkillsByResumeId(Long resumeInfoId)
            throws IOException, SQLException {
        ZpResumeSkillCriteria example = new ZpResumeSkillCriteria();        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId);
        
        ZpResumeSkill record = new ZpResumeSkill();
        record.setResumeId(resumeInfoId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeSkillManager().updateByExampleSelective(record, example);	
    }
	
	private Integer deleteCertificatesByResumeId(Long resumeInfoId)
            throws IOException, SQLException {
        ZpResumeCertificateCriteria example = new ZpResumeCertificateCriteria();
        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId);
        
        ZpResumeCertificate record = new ZpResumeCertificate();
        record.setResumeId(resumeInfoId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeCertificateManager().updateByExampleSelective(record, example);    
    }
	
	private Integer deleteEducationsByResumeId(Long resumeInfoId)
            throws IOException, SQLException {
        ZpResumeEducationCriteria example = new ZpResumeEducationCriteria();        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId);
        
        ZpResumeEducation record = new ZpResumeEducation();
        record.setResumeId(resumeInfoId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeEducationManager().updateByExampleSelective(record, example);    
	}
	
	private Integer deleteExperiencesByResumeId(Long resumeInfoId)
            throws IOException, SQLException {
        ZpResumeExperienceCriteria example = new ZpResumeExperienceCriteria();
        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId);
        
        ZpResumeExperience record = new ZpResumeExperience();
        record.setResumeId(resumeInfoId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeExperienceManager().updateByExampleSelective(record, example);
	}
	
	private Integer deleteLanguagesByResumeId(Long resumeInfoId)
            throws IOException, SQLException {
        ZpResumeLanguageCriteria example = new ZpResumeLanguageCriteria();
        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId);
        
        ZpResumeLanguage record = new ZpResumeLanguage();
        record.setResumeId(resumeInfoId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeLanguageManager().updateByExampleSelective(record, example);
    }

  
    private Integer deleteSkillById(Long skillId)
            throws IOException, SQLException {
        ZpResumeSkillCriteria example = new ZpResumeSkillCriteria();        
        example.createCriteria().andResumeSkillIdEqualTo(skillId);
        
        ZpResumeSkill record = new ZpResumeSkill();
        record.setResumeSkillId(skillId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeSkillManager().updateByExampleSelective(record, example);   
    }
    
    private Integer deleteCertificateById(Long certificateId)
            throws IOException, SQLException {
        ZpResumeCertificateCriteria example = new ZpResumeCertificateCriteria();
        
        example.createCriteria().andResumeCertificateIdEqualTo(certificateId);
        
        ZpResumeCertificate record = new ZpResumeCertificate();
        record.setResumeCertificateId(certificateId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeCertificateManager().updateByExampleSelective(record, example);    
    }
    
    private Integer deleteEducationById(Long educationId)
            throws IOException, SQLException {
        ZpResumeEducationCriteria example = new ZpResumeEducationCriteria();        
        example.createCriteria().andResumeEducationIdEqualTo(educationId);
        
        ZpResumeEducation record = new ZpResumeEducation();
        record.setResumeEducationId(educationId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeEducationManager().updateByExampleSelective(record, example);    
    }
    
    private Integer deleteExperienceById(Long resumeExperienceId)
            throws IOException, SQLException {
        ZpResumeExperienceCriteria example = new ZpResumeExperienceCriteria();
        
        example.createCriteria().andResumeExperienceIdEqualTo(resumeExperienceId);
        
        ZpResumeExperience record = new ZpResumeExperience();
        record.setResumeExperienceId(resumeExperienceId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeExperienceManager().updateByExampleSelective(record, example);
    }
    
    private Integer deleteLanguageById(Long resumeLanguageId)
            throws IOException, SQLException {
        ZpResumeLanguageCriteria example = new ZpResumeLanguageCriteria();
        
        example.createCriteria().andResumeLanguageIdEqualTo(resumeLanguageId);
        
        ZpResumeLanguage record = new ZpResumeLanguage();
        record.setResumeLanguageId(resumeLanguageId);
        record.setStatus(ConstantUtil.RECORDDELETESIGN);
        
        return getResumeLanguageManager().updateByExampleSelective(record, example);
    }	
	private Integer deleteResumeInfoById(Long resumeInfoId)
	        throws IOException, SQLException {
	    Integer result = 0;
	    
	    result = deleteInfoByResumeId(resumeInfoId);
	    if (result > 0){
	        result += deleteSkillsByResumeId(resumeInfoId);
	        result += deleteCertificatesByResumeId(resumeInfoId);
	        result += deleteEducationsByResumeId(resumeInfoId);
	        result += deleteExperiencesByResumeId(resumeInfoId);
	        result += deleteLanguagesByResumeId(resumeInfoId);
	    }
	     
	    return result;
	}
	
	/**
	 * 
	* @Title: deleteResumeInfoById
	* @Description: 删除简历
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
    public void deleteResumeInfoById() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeInfoId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(resumeInfoId == null){
                throw new Exception("query resumeid missed!");
            }
            
            Integer result = deleteResumeInfoById(resumeInfoId);
            
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
	* @Title: insertResumeExperience
	* @Description: 新郑工作经验
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void insertResumeExperience() throws IOException, SQLException {
		ApiResult<Long> apiresult = new ApiResult<Long>();
		try {
			String json = getQueryString(JobUtil.JsonDataName);
			if(json == null){
				throw new Exception("query json missed!");
			}
			
			ZpResumeExperience resumeExperience = 
						getModelFromJson(json, ZpResumeExperience.class); 
			
			Long result = getResumeExperienceManager().insertSelective(resumeExperience);
			
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
	* @Title: updateResumeExperience
	* @Description: 修改简历
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void updateResumeExperience() throws IOException, SQLException {
	        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpResumeExperience resumeExperience = 
                        getModelFromJson(json, ZpResumeExperience.class); 
            
            int result = getResumeExperienceManager().updateByPrimaryKeySelective(resumeExperience);
            
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
	
	private List<ZpResumeExperience> getResumeExperienceList(Long resumeInfoId) 
            throws IOException, SQLException{
        ZpResumeExperienceCriteria example = new ZpResumeExperienceCriteria();
        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId)
            .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        example.setOrderByClause("start_time desc");
        
        return getResumeExperienceManager().selectByExample(example);	    
	}
	
	private String getResumeExperienceJson(Long resumeInfoId) 
	        throws IOException, SQLException{
        List<ZpResumeExperience> list = getResumeExperienceList(resumeInfoId);
        
        JsonConfig config = JobUtil.getJsonConfig();
        JSONArray jsonArr = JSONArray.fromObject(list, config);             
	    
	    return jsonArr.toString();
	}
	
	/**
	 * 
	* @Title: getResumeExperiences
	* @Description: 根据简历ID获取工作经验列表
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getResumeExperiences() throws IOException, SQLException{
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeInfoId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(resumeInfoId == null){
                throw new Exception("query resumeId missed!");
            }
            
            json = getResumeExperienceJson(resumeInfoId);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
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
	* @Title: getResumeExperienceById
	* @Description: 根据工作经验ID获取工作经验
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
    public void getResumeExperienceById() throws IOException, SQLException{
        
        ApiResult<ZpResumeExperience> apiresult = new ApiResult<ZpResumeExperience>();
        try {
            Long resumeexpirienceId = getQueryLong(JobUtil.PARAMTER_RESUMEEXPIRIENCEID);
            if(resumeexpirienceId == null){
                throw new Exception("query resumeexpirienceid missed!");
            }
            
            ZpResumeExperience record = null;
            ZpResumeExperienceCriteria example = new ZpResumeExperienceCriteria();
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN)
                    .andResumeExperienceIdEqualTo(resumeexpirienceId);
            
            List<ZpResumeExperience> list = getResumeExperienceManager().selectByExample(example);
            if (list.size() > 0) {
                record = list.get(0); 
            }
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(record);
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
	* @Title: deleteResumeExperienceById
	* @Description: 根据工作经验ID删除工作经验
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
    public void deleteResumeExperienceById() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeExpirienceId = getQueryLong(JobUtil.PARAMTER_RESUMEEXPIRIENCEID);
            if(resumeExpirienceId == null){
                throw new Exception("query resumeExpirienceId missed!");
            }
            
            Integer result = deleteExperienceById(resumeExpirienceId);
            
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
    * @Title: insertResumeEducation
    * @Description: 添加教育经历
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void insertResumeEducation() throws IOException, SQLException {
        ApiResult<Long> apiresult = new ApiResult<Long>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpResumeEducation resumeEducation = 
                        getModelFromJson(json, ZpResumeEducation.class); 
            
            Long result = getResumeEducationManager().insertSelective(resumeEducation);
            
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
    * @Title: updateResumeEducation
    * @Description: 更新教育经历
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void updateResumeEducation() throws IOException, SQLException {
            ApiResult<Integer> apiresult = new ApiResult<Integer>();
    try {
        String json = getQueryString(JobUtil.JsonDataName);
        if(json == null){
            throw new Exception("query json missed!");
            }
            
            ZpResumeEducation resumeEducation = 
                        getModelFromJson(json, ZpResumeEducation.class); 
            
            int result = getResumeEducationManager().updateByPrimaryKeySelective(resumeEducation);
            
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
    
    private List<ZpResumeEducation> getResumeEducationList(Long resumeInfoId) 
            throws IOException, SQLException{
        ZpResumeEducationCriteria example = new ZpResumeEducationCriteria();
        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId)
                .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        example.setOrderByClause("start_time desc");
        
        return getResumeEducationManager().selectByExample(example);
        
    }
    
    private String getResumeEducationsJson(Long resumeInfoId) 
            throws IOException, SQLException{
        List<ZpResumeEducation> list = getResumeEducationList(resumeInfoId);
        
        JsonConfig config = JobUtil.getJsonConfig();
        JSONArray jsonArr = JSONArray.fromObject(list, config);             
        return jsonArr.toString();
    }
    
    /**
     * 
    * @Title: getResumeEducations
    * @Description: 根据简历ID获取教育经验列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeEducations() throws IOException, SQLException{
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeInfoId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(resumeInfoId == null){
                throw new Exception("query resumeId missed!");
            }
        
            json = getResumeEducationsJson(resumeInfoId);
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
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
    * @Title: getResumeEducationById
    * @Description: 根据教育经验ID获取教育经验
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeEducationById() throws IOException, SQLException{
        
        ApiResult<ZpResumeEducation> apiresult = new ApiResult<ZpResumeEducation>();
        try {
            Long resumeEducationId = getQueryLong(JobUtil.PARAMTER_RESUMEEDUCATIONID);
            if(resumeEducationId == null){
                throw new Exception("query resumeeducationid missed!");
            }
            
            ZpResumeEducation record = null;
            ZpResumeEducationCriteria example = new ZpResumeEducationCriteria();
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN)
                    .andResumeEducationIdEqualTo(resumeEducationId);
            
            List<ZpResumeEducation> list = getResumeEducationManager().selectByExample(example);
            if (list.size() > 0) {
                record = list.get(0); 
            }
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(record);
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
    * @Title: deleteResumeEducationById
    * @Description: 根据教育经历ID删除教育经历
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void deleteResumeEducationById() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeEducationId = getQueryLong(JobUtil.PARAMTER_RESUMEEDUCATIONID);
            if(resumeEducationId == null){
                throw new Exception("query resumeEducationId missed!");
            }
            
            Integer result = deleteEducationById(resumeEducationId);
            
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
    * @Title: insertResumeLanguage
    * @Description: 添加外语水平
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void insertResumeLanguage() throws IOException, SQLException {
        ApiResult<Long> apiresult = new ApiResult<Long>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpResumeLanguage resumeLanguage = 
                    getModelFromJson(json, ZpResumeLanguage.class); 
            
            Long result = getResumeLanguageManager().insertSelective(resumeLanguage);
            
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
    * @Title: updateResumeLanguage
    * @Description: 更新外语水平
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void updateResumeLanguage() throws IOException, SQLException {
            ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpResumeLanguage resumeLanguage = 
                        getModelFromJson(json, ZpResumeLanguage.class); 
            
            int result = getResumeLanguageManager().updateByPrimaryKeySelective(resumeLanguage);
            
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
    
    private List<ZpResumeLanguage> getResumeLanguageList(Long resumeInfoId) 
            throws IOException, SQLException{
        ZpResumeLanguageCriteria example = new ZpResumeLanguageCriteria();
        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId)
                .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);;
        example.setOrderByClause("update_time desc");
        
        return getResumeLanguageManager().selectByExample(example);        
    }
    
    private String getResumeLanguagesJson(Long resumeInfoId) 
            throws IOException, SQLException{
        List<ZpResumeLanguage> list = getResumeLanguageList(resumeInfoId);
        
        JsonConfig config = JobUtil.getJsonConfig();
        JSONArray jsonArr = JSONArray.fromObject(list, config);             
        return jsonArr.toString();
    }
        
    /**
     * 
    * @Title: getResumeLanguages
    * @Description: 根据简历ID获取外语水平列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeLanguages() throws IOException, SQLException{
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeInfoId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(resumeInfoId == null){
                throw new Exception("query resumeId missed!");
            }
            
            json = getResumeLanguagesJson(resumeInfoId);
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
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
    * @Title: getResumeLanguageById
    * @Description: 根据语言ID获取语言信息
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeLanguageById() throws IOException, SQLException{
        
        ApiResult<ZpResumeLanguage> apiresult = new ApiResult<ZpResumeLanguage>();
        try {
            Long resumeLanguageId = getQueryLong(JobUtil.PARAMTER_RESUMELANGUAGEID);
            if(resumeLanguageId == null){
                throw new Exception("query resumelanguageid missed!");
            }
            
            ZpResumeLanguage record = null;
            ZpResumeLanguageCriteria example = new ZpResumeLanguageCriteria();
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN)
                    .andResumeLanguageIdEqualTo(resumeLanguageId);
            
            List<ZpResumeLanguage> list = getResumeLanguageManager().selectByExample(example);
            if (list.size() > 0) {
                record = list.get(0); 
            }
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(record);
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
    * @Title: deleteResumeLanguageById
    * @Description: 根据外语水平ID删除外语水平
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void deleteResumeLanguageById() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeLanguageId = getQueryLong(JobUtil.PARAMTER_RESUMELANGUAGEID);
            if(resumeLanguageId == null){
                throw new Exception("query resumeLanguageId missed!");
            }
            
            Integer result = deleteLanguageById(resumeLanguageId);
            
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
    * @Title: insertResumeSkill
    * @Description: 添加工作技能
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void insertResumeSkill() throws IOException, SQLException {
        ApiResult<Long> apiresult = new ApiResult<Long>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpResumeSkill resumeSkill = 
                    getModelFromJson(json, ZpResumeSkill.class); 
            
            Long result = getResumeSkillManager().insertSelective(resumeSkill);
            
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
    * @Title: updateResumeSkill
    * @Description: 更新工作技能
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void updateResumeSkill() throws IOException, SQLException {
            ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpResumeSkill resumeSkill = 
                        getModelFromJson(json, ZpResumeSkill.class); 
            
            int result = getResumeSkillManager().updateByPrimaryKeySelective(resumeSkill);
            
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
    
    private List<ZpResumeSkill> getResumeSkillList(Long resumeInfoId) throws 
    IOException, SQLException{
        ZpResumeSkillCriteria example = new ZpResumeSkillCriteria();
        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId)
                .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);;
        example.setOrderByClause("update_time desc");
        
        return getResumeSkillManager().selectByExample(example);        
    }
    
    private String getResumeSkillsJson(Long resumeInfoId) throws 
        IOException, SQLException{
        List<ZpResumeSkill> list = getResumeSkillList(resumeInfoId);
        JsonConfig config = JobUtil.getJsonConfig();
        JSONArray jsonArr = JSONArray.fromObject(list, config);             
        return jsonArr.toString();
    }
    
    /**
     * 
    * @Title: getResumeSkills
    * @Description: 根据简历ID获取工作技能列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeSkills() throws IOException, SQLException{
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeInfoId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(resumeInfoId == null){
                throw new Exception("query resumeId missed!");
            }
            
            json = getResumeSkillsJson(resumeInfoId);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
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
    * @Title: getResumeSkillById
    * @Description: 根据技能ID获取技能
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeSkillById() throws IOException, SQLException{
        
        ApiResult<ZpResumeSkill> apiresult = new ApiResult<ZpResumeSkill>();
        try {
            Long resumeSkillId = getQueryLong(JobUtil.PARAMTER_RESUMESKILLID);
            if(resumeSkillId == null){
                throw new Exception("query resumeskillid missed!");
            }
            
            ZpResumeSkill record = null;
            ZpResumeSkillCriteria example = new ZpResumeSkillCriteria();
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN)
                    .andResumeSkillIdEqualTo(resumeSkillId);
            
            List<ZpResumeSkill> list = getResumeSkillManager().selectByExample(example);
            if (list.size() > 0) {
                record = list.get(0); 
            }
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(record);
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
    * @Title: deleteResumeSkillById
    * @Description: 根据工作技能ID删除工作技能
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void deleteResumeSkillById() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeSkillId = getQueryLong(JobUtil.PARAMTER_RESUMESKILLID);
            if(resumeSkillId == null){
                throw new Exception("query resumeSkillId missed!");
            }
            
            Integer result = deleteSkillById(resumeSkillId);
            
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
    * @Title: insertResumeCertificate
    * @Description: 添加证书
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void insertResumeCertificate() throws IOException, SQLException {
        ApiResult<Long> apiresult = new ApiResult<Long>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpResumeCertificate resumeCertificate = 
                    getModelFromJson(json, ZpResumeCertificate.class); 
            
            Long result = getResumeCertificateManager().insertSelective(resumeCertificate);
            
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
    * @Title: updateResumeCertificate
    * @Description: 更新证书
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void updateResumeCertificate() throws IOException, SQLException {
            ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpResumeCertificate resumeCertificate = 
                        getModelFromJson(json, ZpResumeCertificate.class); 
            
            int result = getResumeCertificateManager().updateByPrimaryKeySelective(resumeCertificate);
            
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
    
    private List<ZpResumeCertificate> getResumeCertificateList(Long resumeInfoId) 
            throws IOException, SQLException{
        ZpResumeCertificateCriteria example = new ZpResumeCertificateCriteria();
        
        example.createCriteria().andResumeIdEqualTo(resumeInfoId)
                .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);;
        example.setOrderByClause("update_time desc");
        
        return getResumeCertificateManager().selectByExample(example);        
    }
    
    private String getResumeCertificatesJson(Long resumeInfoId) 
            throws IOException, SQLException{
        List<ZpResumeCertificate> list = getResumeCertificateList(resumeInfoId);
        JsonConfig config = JobUtil.getJsonConfig();
        JSONArray jsonArr = JSONArray.fromObject(list, config);             
        return jsonArr.toString();
    }
    
    /**
     * 
    * @Title: getResumeCertificates
    * @Description: 根据简历ID获取证书列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeCertificates() throws IOException, SQLException{
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Long resumeInfoId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(resumeInfoId == null){
                throw new Exception("query resumeId missed!");
            }
            
            json = getResumeCertificatesJson(resumeInfoId);
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
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
    * @Title: getResumeCertificateById
    * @Description: 根据证书ID获取证书
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeCertificateById() throws IOException, SQLException{
        
        ApiResult<ZpResumeCertificate> apiresult = new ApiResult<ZpResumeCertificate>();
        try {
            Long resumeCertificateId = getQueryLong(JobUtil.PARAMTER_RESUMECERTIFICATEID);
            if(resumeCertificateId == null){
                throw new Exception("query resumecertificateid missed!");
            }
            
            ZpResumeCertificate record = null;
            ZpResumeCertificateCriteria example = new ZpResumeCertificateCriteria();
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN)
                    .andResumeCertificateIdEqualTo(resumeCertificateId);
            
            List<ZpResumeCertificate> list = getResumeCertificateManager().selectByExample(example);
            if (list.size() > 0) {
                record = list.get(0); 
            }
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(record);
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
    * @Title: deleteResumeCertificateById
    * @Description: 根据证书ID删除证书
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void deleteResumeCertificateById() throws IOException, SQLException {
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeCertificateId = getQueryLong(JobUtil.PARAMTER_RESUMECERTIFICATEID);
            if(resumeCertificateId == null){
                throw new Exception("query resumeCertificateId missed!");
            }
            
            Integer result = deleteCertificateById(resumeCertificateId);
            
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
    
    private void setCommonCondition(ResumeInfoCriteria.Criteria criteria, 
            ResumeSearchModel resumeInfo){
        //用户ID
        if (resumeInfo.getUserId() != null)
            criteria.andUserIdEqualTo(resumeInfo.getUserId());
        
        //期望地点
        if (resumeInfo.getLocation() != null)
            criteria.andHopeAddressLike("%" + resumeInfo.getLocation() + "%");
        
        //职位类别
        if (resumeInfo.getPostType() != null && resumeInfo.getPostType() != -1)
            criteria.andResumeTagsEqualTo(resumeInfo.getPostType().toString());
        
        //最低学历
        if (resumeInfo.getEducationBg() != null && resumeInfo.getEducationBg() != -1)
            criteria.andEducationBgEqualTo(resumeInfo.getEducationBg());
        
        //工作经验
        if (resumeInfo.getWorkExprience() != null && resumeInfo.getWorkExprience() != -1)
            criteria.andWorkTimeEqualTo(resumeInfo.getWorkExprience());
        
        //性别
        if (resumeInfo.getSex() != null && resumeInfo.getSex() != -1)
            criteria.andGenderEqualTo(resumeInfo.getSex());        
        
        //开始时间
        if (resumeInfo.getStartTime() != null){
            criteria.andUpdateTimeGreaterThanOrEqualTo(resumeInfo.getStartTime());
        }
        
        //结束时间
        if (resumeInfo.getFinishTime() != null){
            criteria.andUpdateTimeLessThanOrEqualTo(resumeInfo.getFinishTime());
        }
        
        //是否过滤只对部分企业公开的简历
        if (resumeInfo.getHideOpenPart() != null && resumeInfo.getHideOpenPart()){
            criteria.andOpenLevelEqualTo(ConstantUtil.RESUME_OPEN_LEVEL_ALL);
        }
        
        //期望薪资
        if (resumeInfo.getHopeSalary() != null && resumeInfo.getHopeSalary() != -1){
            criteria.andHopeSalaryEqualTo(resumeInfo.getHopeSalary());
        }
              
        criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
    }
    
    private void setCondition(ResumeInfoCriteria example,
            String json){
        ResumeInfoCriteria.Criteria criteria1 = example.createCriteria(); 
        //获取查询条件
        ResumeSearchModel resumeInfo = getModelFromJson(json, ResumeSearchModel.class);
        String keyWord = resumeInfo.getKeyWord();
        
        //如果关键字不为空，需要加上期望职位和简历名搜索
        if (keyWord != null && !"".equals(keyWord.trim())) {
            criteria1.andHopePostLike("%" + keyWord +"%");
        } 
        
        setCommonCondition(criteria1, resumeInfo);
        
        //简历名搜索
        if (keyWord != null && !"".equals(keyWord.trim())) {
            ResumeInfoCriteria.Criteria criteria2 = example.createCriteria();
            criteria2.andResumeNameLike("%" + keyWord +"%");
            setCommonCondition(criteria2, resumeInfo);
            //加上或条件
            example.or(criteria2);
        }   
        
        //设置分页
        if (resumeInfo.getPage() != 0)
            example.getPageInfo().setPage(resumeInfo.getPage());
        if (resumeInfo.getPageSize() != 0)
            example.getPageInfo().setPageSize(resumeInfo.getPageSize());
    }
    
    private PageWraper getPage(String json) throws IOException, SQLException{
        ResumeInfoCriteria example = new ResumeInfoCriteria();            
        
        setCondition(example, json);
        
        example.setOrderByClause("is_default desc, update_time desc");
        
        return getResumeInfoManager().selectBypage(example);          
    }
    
    /**
     * 
    * @Title: selectByPage
    * @Description: 分页查询简历列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void selectByPage() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            //获取简历列表
            PageWraper pw = getPage(json);
            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("resumes", arr.toString());
            map.put("pageinfo", obj.toString());  
            
            arr = JSONArray.fromObject(map);   
            json = arr.toString();
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());    
    }
    
    
    private Integer setResumeDefault(Long resumeId, boolean isDefault)
            throws Exception{
        ZpResumeInfoCriteria example = new ZpResumeInfoCriteria();
        
        ZpResumeInfo item = new ZpResumeInfo();
        
        //如果是设置默认值
        if (isDefault){
            item.setResumeId(resumeId);
            item.setIsDefault(ConstantUtil.ISDEFAULTVALUE);
            example.createCriteria().andResumeIdEqualTo(resumeId);
        }
        else {//如果是设置其他简历不为默认值 （只能有一个简历为默认值），注意与取消默认值不同
            ZpResumeInfo info = getResumeInfo(resumeId, true);
            item.setIsDefault(ConstantUtil.ISNOTDEFAULTVALUE);
            example.createCriteria().andResumeIdNotEqualTo(resumeId).
                    andUserIdEqualTo(info.getUserId());            
        }
        
        return getResumeInfoManager().updateByExampleSelective(item, example);
    }
    
    private Integer setResumeDefault(Long resumeId)
            throws Exception{
        return setResumeDefault(resumeId, true) + setResumeDefault(resumeId, false);
    }
    
    private Integer cancelResumeDefault(Long resumeId)
            throws IOException, SQLException{
        ZpResumeInfoCriteria example = new ZpResumeInfoCriteria();
        
        ZpResumeInfo item = new ZpResumeInfo();
        item.setResumeId(resumeId);
        
        item.setIsDefault(ConstantUtil.ISNOTDEFAULTVALUE);
        example.createCriteria().andResumeIdEqualTo(resumeId);            
        
        return getResumeInfoManager().updateByExampleSelective(item, example);        
    }
    
    /**
     * 
    * @Title: setResumeIsDefault
    * @Description: 设置当前简历为默认简历
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void setResumeDefault() 
            throws IOException, SQLException{
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(getQueryString(JobUtil.PARAMTER_RESUMEID) == null){
                throw new Exception("query resumeid missed!");
            }
            
            Integer result = setResumeDefault(resumeId);            
            
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
    * @Title: cancelResumeDefault
    * @Description: 取消简历默认
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void cancelResumeDefault() 
            throws IOException, SQLException{
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long resumeId = getQueryLong(JobUtil.PARAMTER_RESUMEID);
            if(getQueryString(JobUtil.PARAMTER_RESUMEID) == null){
                throw new Exception("query resumeid missed!");
            }
            
            Integer result = cancelResumeDefault(resumeId);            
            
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
    
    private ZpUser getUser(Long userId) throws SQLException {
        ZpUser user = null;
        ZpUserCriteria example = new ZpUserCriteria();
        example.createCriteria().
            andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN).andUserIdEqualTo(userId);
        List<ZpUser> list = getUsermanager().selectByExample(example);
        if (list.size() > 0)
            user = list.get(0);
        return user;
    }
    
    /**
     * 
    * @Title: getUserType
    * @Description: 获取用户类型
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getUserType() throws IOException, SQLException{
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            if(userId == null){
                throw new Exception("query userid missed!");
            }
            
            Integer result = 0;         
            ZpUser user = getUser(userId);
            if (user != null)
                result = user.getType();
            
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
    
    private Integer getResumeCountByUserId(Long userId) throws SQLException {
        ZpResumeInfoCriteria example = new ZpResumeInfoCriteria();
        example.createCriteria().
            andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN).andUserIdEqualTo(userId);
        Integer count = getResumeInfoManager().countByExample(example);
        return count;
    }
    
    /**
     * 
    * @Title: getResumeCountByUserId
    * @Description: 根据用户ID获取简历个数
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeCountByUserId() throws IOException, SQLException{
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            if(userId == null){
                throw new Exception("query userid missed!");
            }
            
            Integer result = getResumeCountByUserId(userId);        
            
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
    
    private ZpPersonInfo getPersonInfoByUserId(Long userId) 
            throws SQLException{
        ZpPersonInfo person = null;
        ZpPersonInfoCriteria example = new ZpPersonInfoCriteria();
        example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN)
                .andUserIdEqualTo(userId);
        
        List<ZpPersonInfo> list = getResumeInfoManager().selectPersonByExmaple(example);
        if (list.size() > 0)
            person = list.get(0);
        return person;
    }
    
    /**
     * 
    * @Title: getPersonInfo
    * @Description: 获取个人基本信息
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getPersonInfo()throws IOException, SQLException{
        ApiResult<ZpPersonInfo> apiresult = new ApiResult<ZpPersonInfo>();
        try {
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            if(userId == null){
                throw new Exception("query userid missed!");
            }
            
            ZpPersonInfo person = getPersonInfoByUserId(userId);        
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(person);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(null);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse()); 
    }
    
    public static void main(String[] arg) throws Exception{

    }
    
    private PageWraper getLastResumeList_In() 
            throws IOException, SQLException{
        String key = METHODNAME_GETLASTRESUMELIST;
        if (MemCachedMaker.hasCache(key)){
            return (PageWraper)MemCachedMaker.get(key);
        }
        else {
            ResumeInfoCriteria example = new ResumeInfoCriteria();            
            
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN)
                    .andOpenLevelEqualTo(ConstantUtil.RESUME_OPEN_LEVEL_ALL);
                
            example.setOrderByClause("update_time desc");
            
            PageWraper page = getResumeInfoManager().getLastResumeList(example);
            
            MemCachedMaker.set(key, page, ConstantUtil.FIRSTPAGE_CATCHE_TIME);
            
            return page;     
        }
    }
    
    /**
     * 
    * @Title: getLastResumeList
    * @Description: 获取最新简历列表 一个人只取最新一条简历
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getLastResumeList() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {            
            //获取简历列表
            PageWraper pw = getLastResumeList_In();
            
            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("resumes", arr.toString());
            map.put("pageinfo", obj.toString());  
            
            arr = JSONArray.fromObject(map);   
            String json = arr.toString();
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());    
    }

    /* keyType
    1：简历名称（模糊）resume
    2：简历ID
    3：期望职位
     */ 
    private void addKeyWordCondition(ResumeReportModel resumeReport, 
            ResumeReportCriteria.Criteria criteria){
        switch (resumeReport.getKeyType())
        {
            case 1:
                criteria.andRealNameLike("%" + resumeReport.getKeyWord() + "%");
                break;
            case 2:
                criteria.andResumeIdEqualTo(DataUtil.toLong(resumeReport.getKeyWord()));
                break;
            case 3:
                criteria.andHopePostLike("%" + resumeReport.getKeyWord() + "%");
                break;
            default:
                break;
        }

    }
    /* 
     *
            一、timeType
        1：简历创建时间
        2：简历更新时间
        3：最后投递时间
            二、startTime
            开始时间
            三、endTime
            结束时间
            四、keyType
            1：简历名称（模糊）resume
            2：简历ID
            3：期望职位
            4：求职类别
            五、keyWord
            关键字
            六、publicMan
            发布人（模糊）
            七、order
                    排序字段名
           orderType
                1：倒序
                2：正序
            八、pageSize
            页面大小
            九、page
            第几页]
            十   求职类别
    */
    private void addReportCondition(ResumeReportModel resumeReport, 
            ResumeReportCriteria.Criteria criteria)
    {
        /*
        1：简历创建时间
        2：简历更新时间
        3：最后投递时间
        */
        if (resumeReport.getTimeType() != null){
            //简历创建时间                
            if (resumeReport.getTimeType() == 1){         
                //开始时间
                if (resumeReport.getStartTime() != null){
                    criteria.andCreateTimeGreaterThanOrEqualTo(resumeReport.getStartTime());
                }
                
                //结束时间
                if (resumeReport.getEndTime() != null){
                    criteria.andCreateTimeLessThanOrEqualTo(resumeReport.getEndTime());
                }
            //简历更新时间
            }else if (resumeReport.getTimeType() == 2){
                   //开始时间
                if (resumeReport.getStartTime() != null){
                    criteria.andUpdateTimeGreaterThanOrEqualTo(resumeReport.getStartTime());
                }
                
                //结束时间
                if (resumeReport.getEndTime() != null){
                    criteria.andUpdateTimeLessThanOrEqualTo(resumeReport.getEndTime());
                }
            //最后投递时间
            }else if(resumeReport.getTimeType() == 3){
                //开始时间
                 if (resumeReport.getStartTime() != null){
                     criteria.andAuditionUpadteGreaterThanOrEqualTo(resumeReport.getStartTime());
                 }
                 
                 //结束时间
                 if (resumeReport.getEndTime() != null){
                     criteria.andAuditionUpadteLessThanOrEqualTo(resumeReport.getEndTime());
                 }   
            }
        }
           
        // 期望地址 省,市,区            
        if(resumeReport.getWorkAddress() != null){
            criteria.andHopeAddressLike("%" + resumeReport.getWorkAddress() + "%");
        }
        
        //求职类别
        if (resumeReport.getResumeTags() != null){
            criteria.andResumeTagsEqualTo(resumeReport.getResumeTags().toString());
        }
        
        //去掉删除的简历
        criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);

    }    
    
    private PageWraper getResumeReport_In(String json) 
            throws IOException, SQLException{
        ResumeReportCriteria example = new ResumeReportCriteria();  
        
      //json查询条件转换成对象
        ResumeReportModel resumeReport = getModelFromJson(json, ResumeReportModel.class);
        
        String keyWord = resumeReport.getKeyWord();
        String publicMan = resumeReport.getPublicMan();
        
        //先查询关键字
        ResumeReportCriteria.Criteria criteria1 = example.createCriteria();
        if (keyWord != null && !"".equals(keyWord.trim())) 
            addKeyWordCondition(resumeReport, criteria1);          
        
        //再查询发布人姓名关键字
        if (publicMan != null && !"".equals(publicMan.trim())) {
            //PostReportCriteria.Criteria criteria2 = example.createCriteria();
            //addReportCondition(postSearch, criteria2);
            criteria1.andUserNameLike("%" + publicMan +"%");
            //加上或条件
            //example.or(criteria2);
        }   
        addReportCondition(resumeReport, criteria1);
        
        //分页
        example.getPageInfo().setPage(resumeReport.getPage());
        example.getPageInfo().setPageSize(resumeReport.getPageSize());
        
        //设置排序字段
        /*orderType
         * 1：倒序
         * 2：正序
        */
        if (resumeReport.getOrder() != null && !"".equals(resumeReport.getOrder())){
            String orderType = (resumeReport.getOrderType() != null && resumeReport.getOrderType() == 2) ? "ASC" : "DESC";
            example.setOrderByClause(resumeReport.getOrder() + " " + orderType);
        }
        
        PageWraper page = getResumeInfoManager().getResumeReport(example);
        
        return page;     
    }
    
    /**
     * 
    * @Title: getResumeReport
    * @Description: 获取简历查询列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getResumeReport() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {        
            String json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            //获取简历列表
            PageWraper pw = getResumeReport_In(json);
            
            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("resumereport", arr.toString());
            map.put("pageinfo", obj.toString());  
            
            arr = JSONArray.fromObject(map);   
            json = arr.toString();
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
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
    * @Title: getUserCount
    * @Description: 获取用户（存在简历）数量
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getUserCount() throws IOException, SQLException{
        String json = null;
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            json = getQueryString(JobUtil.JsonDataName);
                        
            ResumeInfoCriteria example = new ResumeInfoCriteria();
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            
            Integer count = getResumeInfoManager().getLastResumeCount(example);         
                        
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(count);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(0);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());
    }
}
