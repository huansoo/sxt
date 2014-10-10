package com.wugu.zhaopin.webapp.job;

import java.io.IOException;
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
import com.wugu.zhaopin.service.CompanyManager;
import com.wugu.zhaopin.util.DateUtil;
import com.wugu.zhaopin.util.ObjectUtil;
import com.wugu.zhaopin.vo.ZpCompanyContact;
import com.wugu.zhaopin.vo.ZpCompanyContactCriteria;
import com.wugu.zhaopin.vo.ZpCompanyInfo;
import com.wugu.zhaopin.vo.ZpPostInfo;
import com.wugu.zhaopin.vo.ZpPostInfoCriteria;
import com.wugu.zhaopin.webapp.model.PostReportCriteria;
import com.wugu.zhaopin.webapp.model.PostReportModel;
import com.wugu.zhaopin.webapp.model.PostSearchCriteria;
import com.wugu.zhaopin.webapp.model.PostSearchModel;
import com.wugu.zhaopin.webapp.model.ResumeInfoCriteria;
import com.wugu.zhaopin.webapp.model.ZpCompanyContactModel;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.webapp.model.page.PageWraper;
import com.wugu.zhaopin.webapp.util.JobUtil;

/**
 * 
* @ClassName: CompanyJob
* @Description: 公司相关接口类
* @author lijun
* @date 2013-12-25 上午9:14:11
*
 */
public class CompanyJob extends BaseJob {
    private static final String METHODNAME_GETLASTPOSTLIST  = "getlastpostlist_"; 
    private static final String METHODNAME_GETPOSTINFO  = "getpostbyid_";

	private CompanyManager companymanager;
	
	public CompanyManager getCompanyManager() {
		if (companymanager == null){
			companymanager = (CompanyManager)getBeanEx("companymanager", CompanyManager.class);
		}
		return companymanager;
	}
	
	private void removeMemchache(Long postId){
	    String key = METHODNAME_GETLASTPOSTLIST;
	    if (MemCachedMaker.hasCache(key)){
	        MemCachedMaker.remove(key);
	    }
	    
	    key = METHODNAME_GETPOSTINFO + postId;
	    if (MemCachedMaker.hasCache(key)){
            MemCachedMaker.remove(key);
        }
	}
	
	/**
	 * 
	* @Title: InsertCompany
	* @Description: 添加公司信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void insertCompany() throws IOException, SQLException{
		String json = null;
		ApiResult<Integer> apiresult = new ApiResult<Integer>();
		try {
			json = getQueryString(JobUtil.JsonDataName);
			if(json == null){
				throw new Exception("query json missed!");
			}
			
			//json对象转换成java对象
			ZpCompanyInfoModel companyinfomodel = getModelFromJson(json, ZpCompanyInfoModel.class);	
			ZpCompanyContactModel companycontactmodel = companyinfomodel.getCompanyContact();
			
	         //发送短信验证码验证日志
			if (companyinfomodel.getVerifyType() != null){
    			Integer verifyType = companyinfomodel.getVerifyType();
    			
                if (verifyType == 1 ){
                    logger.info("smsVeiryfy_start------------------------------\n");
                    logger.info("sendMobile:" + companycontactmodel.getMobileTel() + "  \n");
                    logger.info("returnTime:" + DateUtil.getNowTimeStr() + "  \n");
                    logger.info("veryfyResult:success\n");
                    logger.info("------------------------------smsVeiryfy_end \n");
                }
			}
            
			ZpCompanyInfo companyinfo = new ZpCompanyInfo();
			ZpCompanyContact companyContact = new ZpCompanyContact();
			
			//对象赋值
			ObjectUtil.Copy(companyinfomodel, companyinfo);
			ObjectUtil.Copy(companycontactmodel, companyContact);
			
			//添加公司基本信息
			int result = getCompanyManager().insert(companyinfo, companyContact);
			
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
	* @Title: UpdateCompany
	* @Description: 修改公司信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void updateCompany() throws IOException, SQLException{
		String json = null;
		ApiResult<Integer> apiresult = new ApiResult<Integer>();
		try {
			json = getQueryString(JobUtil.JsonDataName);
			if(json == null){
				throw new Exception("query json missed!");
			}
			
			//json对象转换成java对象
			ZpCompanyInfoModel companyInfoModel = getModelFromJson(json, ZpCompanyInfoModel.class);	
			ZpCompanyContactModel companyContactModel = companyInfoModel.getCompanyContact();
			
            //发送短信验证码验证日志
			if (companyInfoModel.getVerifyType() != null){
    			Integer verifyType = companyInfoModel.getVerifyType();
               
    			if (verifyType == 1 ){
                   logger.info("smsVeiryfy_start------------------------------\n");
                   logger.info("sendMobile:" + companyContactModel.getMobileTel() + "  \n");
                   logger.info("returnTime:" + DateUtil.getNowTimeStr() + "  \n");
                   logger.info("veryfyResult:success\n");
                   logger.info("------------------------------smsVeiryfy_end \n");
    			}
			}
           
			ZpCompanyInfo companyInfo = new ZpCompanyInfo();
			ZpCompanyContact companyContact = new ZpCompanyContact();
			
			//对象赋值
			ObjectUtil.Copy(companyInfoModel, companyInfo);
			ObjectUtil.Copy(companyContactModel, companyContact);
			
			int result = 0;
			//添加公司基本信息
			if (companyContactModel == null){
			    result = getCompanyManager().updateByPrimaryKeySelective(companyContact);
			}
			else {
			    result = getCompanyManager().update(companyInfo, companyContact);
			}
			
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
	* @Title: addPostCondition
	* @Description: 添加职位搜索条件
	* @author lijun
	* @param postSearch
	* @param criteria
	* @throws
	 */
	private void addPostCondition(PostSearchModel postSearch, 
		PostSearchCriteria.Criteria criteria){
		criteria.andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
	    
		//公司ID
		if (postSearch.getCompanyId() != null && postSearch.getCompanyId() != -1) {
			criteria.andCompanyIdEqualTo(postSearch.getCompanyId());
		}	
		
		//地点
		if (postSearch.getWorkAdress() != null) {
			criteria.andWorkAddressLike("%" + postSearch.getWorkAdress() + "%");
		}	
		
		//公司类型
		if (postSearch.getCompanyType() != null && postSearch.getCompanyType()!= -1){
			criteria.andCompanyTypeEqualTo(postSearch.getCompanyType());
		}
		
		//剔除的职位 -1时代表不剔除
		if (postSearch.getExcludingIds() != null && !postSearch.getExcludingIds().equals(ConstantUtil.WithOutInt)){
			List<Integer> list = new ArrayList<Integer>(); 
			
			String[] strs = postSearch.getExcludingIds().split(ConstantUtil.SplitChar);
			
			for (int i=0; i < strs.length; i++)
				list.add(Integer.parseInt(strs[i]));
			criteria.andPostIdNotIn(list);
		}
		
		//职位类型
		if (postSearch.getPostType() != null && postSearch.getPostType() != -1){
			criteria.andPostTypeEqualTo(postSearch.getPostType());
		}		
		
		//教育背景
        if (postSearch.getEducationBg() != null && postSearch.getEducationBg() != -1)
            criteria.andEducationBgEqualTo(postSearch.getEducationBg());
		
		//薪资
		if (postSearch.getSalary() != null && postSearch.getSalary() != -1){
			criteria.andSalaryEqualTo(postSearch.getSalary());
		}
		
		//工作经验
		if (postSearch.getWorkExprience() != null && postSearch.getWorkExprience() != -1){
			criteria.andWorkExprienceEqualTo(postSearch.getWorkExprience());
		}

		//开始时间
		if (postSearch.getStartTime() != null){
			criteria.andUpdateTimeGreaterThanOrEqualTo(postSearch.getStartTime());
		}
		
		//结束时间
		if (postSearch.getFinishTime() != null){
			criteria.andUpdateTimeLessThanOrEqualTo(postSearch.getFinishTime());
		}
		
		//状态
		if (postSearch.getStatus() != null){
            criteria.andStatusEqualTo(postSearch.getStatus());
        }
	}
	
	/**
	 * 
	* @Title: getCompanyCount
	* @Description: 获取公司数量
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getCompanyCount() throws IOException, SQLException{
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            ZpCompanyInfoCriteria example = new ZpCompanyInfoCriteria();
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            
            Integer count = getCompanyManager().countByExample(example);         
                        
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
	
	/**
	 * 
	* @Title: getPostCount
	* @Description: 获取职位数量
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getPostCount() throws IOException, SQLException{
        Integer companyId = null;
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
            
            if(companyId == null){
                throw new Exception("query companyid missed!");
            }        
            
            ZpPostInfoCriteria example = new ZpPostInfoCriteria();
            
            //正常状态，刨去-1和100两种情况
            example.createCriteria().andStatusEqualTo(ConstantUtil.RECORDVILIDSIGN)
                    .andCompanyIdEqualTo(companyId);
            
            Integer count = getCompanyManager().getPostCount(example);         
                        
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
	
	/**
	 * 
	* @Title: SelectByPage
	* @Description: 分页查询公司列表
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void selectByPage() throws IOException, SQLException{
		String json = null;
		ApiResult<String> apiresult = new ApiResult<String>();
		try {
			json = getQueryString(JobUtil.JsonDataName);
			if(json == null){
				throw new Exception("query json missed!");
			}
			
			PostSearchCriteria example = new PostSearchCriteria();
			//json查询条件转换成对象
			PostSearchModel postSearch = getModelFromJson(json, PostSearchModel.class);
			
			//先查询职位关键字
            String keyWord = postSearch.getKeyWord();
			PostSearchCriteria.Criteria criteria1 = example.createCriteria();
			if (keyWord != null && !"".equals(keyWord.trim())) {
				criteria1.andNameLike("%" + keyWord +"%");
			}	
			addPostCondition(postSearch, criteria1);
			
			//再查询公司关键字
            if (keyWord != null && !"".equals(keyWord.trim())) {
                PostSearchCriteria.Criteria criteria2 = example.createCriteria();
                addPostCondition(postSearch, criteria2);
				criteria2.andCompanyNameLike("%" + keyWord +"%");
	            //加上或条件
	            example.or(criteria2);
			}	
            
			example.getPageInfo().setPage(postSearch.getPage());
			example.getPageInfo().setPageSize(postSearch.getPageSize());
			//example.getPageInfo().setStart((postSearch.getPage() - 1) * postSearch.getPageSize());
			//设置排序字段
			example.setOrderByClause("status ASC, update_time DESC");
			
			PageWraper pw = getCompanyManager().getPostResultByCondition(example);			
			
			JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("postlist", arr.toString());
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
	
	private PageWraper getLastPostList_in()
            throws IOException, SQLException{
        String key = METHODNAME_GETLASTPOSTLIST;
        if (MemCachedMaker.hasCache(key)){
            return (PageWraper)MemCachedMaker.get(key);
        }
        else {
            PostSearchCriteria example = new PostSearchCriteria();            
            PostSearchCriteria.Criteria criteria = example.createCriteria();
            
            criteria.andStatusEqualTo(ConstantUtil.RECORDVILIDSIGN);         
            example.setOrderByClause("update_time DESC");
            
            example.getPageInfo().setPage(1);
            example.getPageInfo().setPageSize(15);//首页显示15条记录
            
            PageWraper page = getCompanyManager().getPostResultByCondition(example);          
            
            MemCachedMaker.set(key, page, ConstantUtil.FIRSTPAGE_CATCHE_TIME);
            
            return page;     
        }
	}
	/**
	 * 
	* @Title: getLastPostList
	* @Description: 获取最新职位信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getLastPostList() throws IOException, SQLException{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {           
            PageWraper pw = getLastPostList_in();          
            
            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("postlist", arr.toString());
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
	
	/**
	 * 
	* @Title: getCompanyInfo
	* @Description: 根据公司id获取公司信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getCompanyInfo() throws IOException, SQLException{
		ApiResult<String> apiresult = new ApiResult<String>();
		try {
			//json = getQueryString(JobUtil.JsonDataName);
			Integer companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
			if(companyId == null){
				throw new Exception("query companyid missed!");
			}
            ZpCompanyInfoCriteria example = new ZpCompanyInfoCriteria();
            
            example.createCriteria().andCompanyIdEqualTo(companyId)
                    .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
			List<ZpCompanyInfoModel> list = 
			        getCompanyManager().selectByExample(example);
			ZpCompanyInfoModel companyInfo = null;
			String jsonstr = ""; 
			if (list.size() > 0){
			    companyInfo = list.get(0);
			}
			
            JsonConfig config = JobUtil.getJsonConfig();
            JSONObject json = JSONObject.fromObject(companyInfo, config);
            jsonstr = json.toString();
            System.out.println(jsonstr);
			
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
	* @Title: getCompanyByUserId
	* @Description: 根据UserId获取公司信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getCompanyByUserId() throws IOException, SQLException{
        ApiResult<ZpCompanyInfoModel> apiresult = new ApiResult<ZpCompanyInfoModel>();
        try {
            Long userId = getQueryLong(JobUtil.PARAMTER_USERID);
            if(userId == null){
                throw new Exception("query userid missed!");
            }
            ZpCompanyInfoCriteria example = new ZpCompanyInfoCriteria();            
            example.createCriteria().andUserIdEqualTo(userId)
                    .andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            
            List<ZpCompanyInfoModel> list = 
                    getCompanyManager().selectByExample(example);
            ZpCompanyInfoModel companyInfo = null;
            if (list.size() > 0){
                companyInfo = list.get(0);
            }
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(companyInfo);
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
	* @Title: getCompanyContact
	* @Description: 根据公司id获取公司联系方式
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getCompanyContact() throws IOException, SQLException{
		String json = null;
		ApiResult<String> apiresult = new ApiResult<String>();
		try {
			//json = getQueryString(JobUtil.JsonDataName);
			Integer companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
			if(companyId == null){
				throw new Exception("query companyid missed!");
			}
			
			ZpCompanyContactCriteria example = new ZpCompanyContactCriteria();
			
			example.createCriteria().andCompanyIdEqualTo(companyId);
			
			List<ZpCompanyContact> list = getCompanyManager().selectByExample(example);
			
			JsonConfig config = JobUtil.getJsonConfig();
			JSONArray jsonArr = JSONArray.fromObject(list, config);				
			
			apiresult.setCode(Code.Succes);
			apiresult.setStatus(200);
			apiresult.setData(jsonArr.toString());
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
	* @Title: insertPostInfo
	* @Description: 添加修改职位信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void insertPostInfo() throws IOException, SQLException{
		String json = null;
		ApiResult<Long> apiresult = new ApiResult<Long>();
		try {
			json = getQueryString(JobUtil.JsonDataName);
			if(json == null){
				throw new Exception("query json missed!");
			}
			
			ZpPostInfo postInfo = getModelFromJson(json, ZpPostInfo.class);
			
			Long result = getCompanyManager().insert(postInfo);
			
	        //更新最新职位列表缓存
            if (result > 0)
                removeMemchache(result);
					
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
	* @Title: updatePostInfo
	* @Description: 更新职位信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void updatePostInfo() throws IOException, SQLException{
        String json = null;
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            ZpPostInfo postInfo = getModelFromJson(json, ZpPostInfo.class);
            
            Integer result = getCompanyManager().updateByPrimaryKeySelective(postInfo);
                    
            //更新最新职位列表缓存
            if (result > 0){
                removeMemchache(postInfo.getPostId());
            }
                    
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
	* @Title: getPostInfo
	* @Description: 根据职位id获取职位信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getPostInfo() throws IOException, SQLException {
		ApiResult<ZpPostInfo> apiresult = new ApiResult<ZpPostInfo>();
		try {
			Long postId = getQueryLong(JobUtil.PARAMTER_POSTID);
			if(postId == null){
				throw new Exception("query postid missed!");
			}
            ZpPostInfo postInfo = null;
            
            String key = METHODNAME_GETPOSTINFO + postId;
			if (MemCachedMaker.hasCache(key)){
			     postInfo = (ZpPostInfo)MemCachedMaker.get(key);
		        }
		     else {
    			ZpPostInfoCriteria example = new ZpPostInfoCriteria();
    			
    			example.createCriteria().andPostIdEqualTo(postId).
    			    andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
    			
    			List<ZpPostInfo> list = getCompanyManager().selectByExample(example);
    			if (list.size() > 0){
    			    postInfo = list.get(0);
    			    MemCachedMaker.set(key, postInfo, ConstantUtil.POSTINFO_CATCHE_TIME);
    			}
			}
			
			apiresult.setCode(Code.Succes);
			apiresult.setStatus(200);
			apiresult.setData(postInfo);
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
	* @Title: getPostListByCompany
	* @Description: 根据公司ID获取职位列表
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
    public void getPostListByCompany() throws IOException, SQLException {
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Integer companyId = getQueryInt(JobUtil.PARAMTER_COMPANYID);
            Integer page = getQueryInt(JobUtil.PAGE);
            Integer pageSize = getQueryInt(JobUtil.PAGESIZE);
            
            if(getQueryString(JobUtil.PARAMTER_COMPANYID) == null){
                throw new Exception("query companyid missed!");
            }
            PostSearchCriteria example = new PostSearchCriteria();
            example.createCriteria().andCompanyIdEqualTo(companyId).
                andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
            
            example.setOrderByClause("status ASC, update_time desc");
            
            //设置分页
            if (getQueryString(JobUtil.PAGE) != null)
                example.getPageInfo().setPage(page);
            if (getQueryString(JobUtil.PAGESIZE) != null)
                example.getPageInfo().setPageSize(pageSize);
            
            PageWraper pw = getCompanyManager().getPostResultByCondition(example);
            
            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("postlist", arr.toString());
            map.put("pageinfo", obj.toString());  
            
            arr = JSONArray.fromObject(map);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(arr.toString());
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
	* @Title: deletePostById
	* @Description: 删除职位,更改状态Status为-1
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void deletePostById() throws IOException, SQLException {
		String json = null;
		ApiResult<Integer> apiresult = new ApiResult<Integer>();
		try {
			Long postId = getQueryLong(JobUtil.PARAMTER_POSTID);
			if(postId == null){
				throw new Exception("query postid missed!");
			}
			ZpPostInfo postInfo = new ZpPostInfo();
			postInfo.setPostId(postId);
			postInfo.setStatus(ConstantUtil.RECORDDELETESIGN);
			Integer result = getCompanyManager().updateByPrimaryKeySelective(postInfo);
			
            //更新最新职位列表缓存
            if (result > 0)
                removeMemchache(postInfo.getPostId());
                    
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
	
    /* keyType
     *1：职位名（模糊）
     *2：职位id
     *3：公司名（模糊）
     *4：公司id  
     */	
	private void addKeyWordCondition(PostReportModel postSearch, 
            PostReportCriteria.Criteria criteria){
        switch (postSearch.getKeyType())
        {
            case 1:
                criteria.andPostNameLike("%" + postSearch.getKeyWord() + "%");
                break;
            case 2:
                criteria.andPostIdEqualTo(DataUtil.toLong(postSearch.getKeyWord()));
                break;
            case 3:
                criteria.andCompanyNameLike("%" + postSearch.getKeyWord() + "%");
                break;
            case 4:
                criteria.andCompanyIdEqualTo(DataUtil.toInt(postSearch.getKeyWord()));
                break;
            default:
                break;
        }

	}
	
	/* 
	 * 一、timeType
        1：职位发布时间
        2：公司发布时间
                二、startTime
                开始时间
                三、endTime
                结束时间
                四、keyType
                1：职位名（模糊）
                2：职位id
                3：公司名（模糊）
                4：公司id
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
                第几页
               十、 workAddress
               省市县         
    */
	private void addReportCondition(PostReportModel postSearch, 
	        PostReportCriteria.Criteria criteria)
	{
	        //公司ID
	        if (postSearch.getCompanyId() != null) {
	            criteria.andCompanyIdEqualTo(postSearch.getCompanyId());
	        }  
	        /*
	         * 1：职位发布时间
	         * 2：公司发布时间
            */
	        if (postSearch.getTimeType() != null){
    	        if (postSearch.getTimeType() == 1){	        
        	        //开始时间
        	        if (postSearch.getStartTime() != null){
        	            criteria.andCreateTimeGreaterThanOrEqualTo(postSearch.getStartTime());
        	        }
        	        
        	        //结束时间
        	        if (postSearch.getEndTime() != null){
        	            criteria.andCreateTimeLessThanOrEqualTo(postSearch.getEndTime());
        	        }
    	        }else if (postSearch.getTimeType() == 2){
    	               //开始时间
                    if (postSearch.getStartTime() != null){
                        criteria.andCompanyTimeGreaterThanOrEqualTo(postSearch.getStartTime());
                    }
                    
                    //结束时间
                    if (postSearch.getEndTime() != null){
                        criteria.andCompanyTimeLessThanOrEqualTo(postSearch.getEndTime());
                    }
    	        }  
	        }
	       
	        //公司状态
	        if (postSearch.getCompanyStatus() != null){
	            criteria.andCompanyStatusEqualTo(postSearch.getCompanyStatus());
	        }
	        
	        //职位状态
            if (postSearch.getPostStatus() != null){
                criteria.andPostStatusEqualTo(postSearch.getPostStatus());
            }
            
            //地址 省,市,区            
            if(postSearch.getWorkAddress() != null){
                criteria.andWorkAddressLike("%" + postSearch.getWorkAddress() + "%");
            }
	    }
	
	/**
	 * 
	* @Title: searchPostInfo
	* @Description: 查找职位信息
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getPostReport() throws IOException, SQLException {
        String json = null;
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            
            json = getQueryString(JobUtil.JsonDataName);
            if(json == null){
                throw new Exception("query json missed!");
            }
            
            PostReportCriteria example = new PostReportCriteria();        
            //json查询条件转换成对象
            PostReportModel postSearch = getModelFromJson(json, PostReportModel.class);
            
            String keyWord = postSearch.getKeyWord();
            String publicMan = postSearch.getPublicMan();
            
            //先查询关键字
            PostReportCriteria.Criteria criteria1 = example.createCriteria();
            if (keyWord != null && !"".equals(keyWord.trim())) 
                addKeyWordCondition(postSearch, criteria1);          
            
            //再查询发布人姓名关键字
            if (publicMan != null && !"".equals(publicMan.trim())) {
                //PostReportCriteria.Criteria criteria2 = example.createCriteria();
                //addReportCondition(postSearch, criteria2);
                criteria1.andUserNameLike("%" + publicMan +"%");
                //加上或条件
                //example.or(criteria2);
            }   
            addReportCondition(postSearch, criteria1);
            
            //分页
            example.getPageInfo().setPage(postSearch.getPage());
            example.getPageInfo().setPageSize(postSearch.getPageSize());
            
            //设置排序字段
            /*orderType
             * 1：倒序
             * 2：正序
            */
            if (postSearch.getOrder() != null && !"".equals(postSearch.getOrder())){
                String orderType = (postSearch.getOrderType() != null && postSearch.getOrderType() == 2) ? "ASC" : "DESC";
                example.setOrderByClause(postSearch.getOrder() + " " + orderType);
            }
            
            //查询返回数据
            PageWraper pw = getCompanyManager().getPostReport(example);          
            
            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray arr = JSONArray.fromObject(pw.getResult(), config);
            JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("postlist", arr.toString());
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
}
