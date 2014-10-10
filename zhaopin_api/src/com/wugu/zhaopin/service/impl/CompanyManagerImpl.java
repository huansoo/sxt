package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.service.CompanyManager;
import com.wugu.zhaopin.service.PersonInfoManager;
import com.wugu.zhaopin.service.UserManager;
import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.dao.CompanyDAO;
import com.wugu.zhaopin.dao.ZpCompanyInfoDAO;
import com.wugu.zhaopin.dao.ZpPostInfoDAO;
import com.wugu.zhaopin.dao.ZpUserDAO;
import com.wugu.zhaopin.util.ObjectUtil;
import com.wugu.zhaopin.vo.ZpCompanyInfo;
import com.wugu.zhaopin.vo.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.vo.ZpPostInfo;
import com.wugu.zhaopin.vo.ZpPostInfoCriteria;
import com.wugu.zhaopin.vo.ZpUser;
import com.wugu.zhaopin.dao.ZpCompanyContactDAO;
import com.wugu.zhaopin.vo.ZpCompanyContact;
import com.wugu.zhaopin.vo.ZpCompanyContactCriteria;
import com.wugu.zhaopin.webapp.model.PostReportCriteria;
import com.wugu.zhaopin.webapp.model.PostSearchCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

public class CompanyManagerImpl implements CompanyManager {
	
	private ZpCompanyContactDAO companycontactdao;
	private ZpCompanyInfoDAO companyinfodao;
	private CompanyDAO companydao;
	private ZpPostInfoDAO postinfodao;
    private PersonInfoManager personInfoManager;
    private UserManager userManager;	

    public PersonInfoManager getPersonInfoManager()
    {
        return personInfoManager;
    }

    public void setPersonInfoManager(PersonInfoManager personInfoManager)
    {
        this.personInfoManager = personInfoManager;
    }

    public UserManager getUserManager()
    {
        return userManager;
    }

    public void setUserManager(UserManager userManager)
    {
        this.userManager = userManager;
    }

    public ZpPostInfoDAO getPostinfodao() {
		return postinfodao;
	}

	public void setPostinfodao(ZpPostInfoDAO postinfodao) {
		this.postinfodao = postinfodao;
	}

	public CompanyDAO getCompanydao() {
		return companydao;
	}

	public void setCompanydao(CompanyDAO companydao) {
		this.companydao = companydao;
	}

	public ZpCompanyInfoDAO getCompanyinfodao() {
		return this.companyinfodao;
	}

	public void setCompanyinfodao(ZpCompanyInfoDAO companyinfodao) {
		this.companyinfodao = companyinfodao;
	}

	public ZpCompanyContactDAO getCompanycontactdao() {
		return this.companycontactdao;
	}

	public void setCompanycontactdao(ZpCompanyContactDAO companycontactdao) {
		this.companycontactdao = companycontactdao;
	}

	@Override
	public int countByExample(ZpCompanyContactCriteria example) throws SQLException  {
		return companycontactdao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpCompanyContactCriteria example)throws SQLException  {
		return companycontactdao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer companyContactId) throws SQLException  {
		return companycontactdao.deleteByPrimaryKey(companyContactId);
	}

	@Override
	public Integer insert(ZpCompanyContact record) throws SQLException  {
		return companycontactdao.insert(record);
	}

	@Override
	public Integer insertSelective(ZpCompanyContact record) throws SQLException  {
		return companycontactdao.insertSelective(record);
	}

	@Override
	public List<ZpCompanyContact> selectByExample(
			ZpCompanyContactCriteria example) throws SQLException  {
		return companycontactdao.selectByExample(example);
	}

	@Override
	public ZpCompanyContact selectByPrimaryKey(Integer companyContactId) throws SQLException  {
		return companycontactdao.selectByPrimaryKey(companyContactId);
	}

	@Override
	public int updateByExampleSelective(ZpCompanyContact record,
			ZpCompanyContactCriteria example) throws SQLException  {
		return companycontactdao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpCompanyContact record,
			ZpCompanyContactCriteria example)  throws SQLException {
		return companycontactdao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpCompanyContact record)  throws SQLException {
		return companycontactdao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpCompanyContact record) throws SQLException  {
		return companycontactdao.updateByPrimaryKey(record);
	}

	@Override
	public int countByExample(ZpCompanyInfoCriteria example) throws SQLException  {
		return companyinfodao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpCompanyInfoCriteria example) throws SQLException  {
		return companyinfodao.deleteByExample(example);
	}

	@Override
	public int deleteCompanyByPrimaryKey(Integer companyId) throws SQLException  {
		return companyinfodao.deleteByPrimaryKey(companyId);
	}

	@Override
	public Integer insert(ZpCompanyInfo record)  throws SQLException {
		return companyinfodao.insert(record);
	}

	@Override
	public Integer insertSelective(ZpCompanyInfo record) throws SQLException  {
		return companyinfodao.insertSelective(record);
	}

	@Override
	public List<ZpCompanyInfo> selectByExample(ZpCompanyInfoCriteria example) throws SQLException  {
		return companyinfodao.selectByExample(example);
	}

	@Override
	public ZpCompanyInfo selectInfoByPrimaryKey(Integer companyId)  throws SQLException {
		return companyinfodao.selectByPrimaryKey(companyId);
	}

	@Override
	public int updateByExampleSelective(ZpCompanyInfo record,
			ZpCompanyInfoCriteria example) throws SQLException  {
		return companyinfodao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpCompanyInfo record,
			ZpCompanyInfoCriteria example) throws SQLException  {
		return companyinfodao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpCompanyInfo record)  throws SQLException {
		return companyinfodao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpCompanyInfo record) throws SQLException  {
		return companyinfodao.updateByPrimaryKey(record);
	}

	@Override
	public PageWraper selectBypage(com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria example)throws SQLException {
		return companydao.selectBypage(example);
	}

	@Override
	public List<com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel> selectByExample(
			com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria example)
			throws SQLException {
		return companydao.selectByExample(example);
	}

	@Override
	public com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel selectCompanyByPrimaryKey(
			Integer companyId) throws SQLException {
		return companydao.selectByPrimaryKey(companyId);
	}
	
	private int addUser(ZpCompanyInfo companyInfo, ZpCompanyContact companyContact) 
	        throws Exception{
	    ZpUser user = new ZpUser();
        //从公司数据中复制用户信息
        ObjectUtil.Copy(companyInfo, user);  
        ObjectUtil.Copy(companyContact, user);
        
        user.setUserName(companyInfo.getUserName());
        user.setRealName(companyInfo.getName());
        //user.setMobileTel(companyContact.getMobileTel());
        user.setType(ConstantUtil.USER_TYPE_COMPANY);
        
	    return userManager.addUser(user);
	}

	@Override
	public int insert(ZpCompanyInfo companyInfo, ZpCompanyContact companyContact)
			throws Exception {
	    Integer companyId = insertSelective(companyInfo);
	    companyContact.setCompanyId(companyId);
	    insertSelective(companyContact);
	    //添加用户信息
	    addUser(companyInfo, companyContact);
		return  companyId;
	}

	@Override
	public int update(ZpCompanyInfo companyInfo, ZpCompanyContact companyContact)
			throws Exception {
	    int result = ((updateByPrimaryKeySelective(companyInfo) > 0) 
		            && (updateByPrimaryKeySelective(companyContact) > 0))? 1:0;
	    if (result == 1){
	        result = addUser(companyInfo, companyContact);
	    }
	    return result;
	}

	@Override
	public PageWraper getPostResultByCondition(PostSearchCriteria example)
			throws SQLException {
		return companydao.getPostResultByCondition(example);
	}

	@Override
	public Long insert(ZpPostInfo record) throws SQLException {
		return postinfodao.insertSelective(record);
	}
	
	public ZpPostInfo selectByPrimaryKey(Long postId) throws SQLException {
		return postinfodao.selectByPrimaryKey(postId);
	}

	public int deletePostByKey(Long postId) throws SQLException  {
		return postinfodao.deleteByPrimaryKey(postId);
	}

    /* (非 Javadoc)
    * <p>Title: selectByExample</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.CompanyManager#selectByExample(com.wugu.zhaopin.vo.ZpPostInfoCriteria)
    */
    @Override
    public List<ZpPostInfo> selectByExample(ZpPostInfoCriteria example)
            throws SQLException
    {
        return postinfodao.selectByExample(example);
    }

    /* (非 Javadoc)
    * <p>Title: updateByPrimaryKeySelective</p>
    * <p>Description: </p>
    * @param record
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.CompanyManager#updateByPrimaryKeySelective(com.wugu.zhaopin.vo.ZpPostInfo)
    */
    @Override
    public int updateByPrimaryKeySelective(ZpPostInfo record)
            throws SQLException
    {
        return postinfodao.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
    * <p>Title: getPostReport</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.CompanyManager#getPostReport(com.wugu.zhaopin.webapp.model.PostReportCriteria)
    */
    @Override
    public PageWraper getPostReport(PostReportCriteria example)
            throws SQLException
    {
        return companydao.getPostReport(example);
    }

    /* (非 Javadoc)
    * <p>Title: countByExample</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.CompanyManager#countByExample(com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria)
    */
    @Override
    public int countByExample(
            com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria example)
            throws SQLException
    {
        return companydao.countByExample(example);
    }

    /* (非 Javadoc)
    * <p>Title: getPostCount</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.CompanyManager#getPostCount(com.wugu.zhaopin.vo.ZpPostInfoCriteria)
    */
    @Override
    public int getPostCount(ZpPostInfoCriteria example) throws SQLException
    {
        return postinfodao.countByExample(example);
    }
}
