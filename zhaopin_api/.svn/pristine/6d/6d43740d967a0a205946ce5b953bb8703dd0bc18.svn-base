package com.wugu.zhaopin.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.wugu.zhaopin.dao.CompanyDAO;
import com.wugu.zhaopin.webapp.model.PostReportCriteria;
import com.wugu.zhaopin.webapp.model.PostSearchCriteria;
import com.wugu.zhaopin.webapp.model.PostSearchModel;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageManager;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

/*
 * 公司信息与公司联系方式扩展
 */

public class CompanyDAOImpl implements CompanyDAO {
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/*
	 * 分页查询
	 * @see com.wugu.zhaopin.dao.ZpCompanyInfoDAO#selectBypage(com.wugu.zhaopin.vo.ZpCompanyInfoCriteria)
	 */
	@Override
	public PageWraper selectBypage(ZpCompanyInfoCriteria example)
			throws SQLException {
    	PageWraper pw = null;
    	
    	int count = countByExample(example);
        List list = sqlMapClient.queryForList("company.selectByPage", example);
        
		pw = PageManager.getPageWraper(example.getPageInfo(), list, count);
        return pw;
	}
	@Override
	public int countByExample(ZpCompanyInfoCriteria example)
			throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"company.ibatorgenerated_countByExample", example);
		return count;
	}
	@Override
	public List selectByExample(ZpCompanyInfoCriteria example)
			throws SQLException {
		List list = sqlMapClient.queryForList(
				"company.ibatorgenerated_selectByExample", example);
		return list;
	}

	public ZpCompanyInfoModel selectByPrimaryKey(Integer companyId)
			throws SQLException {
		ZpCompanyInfoModel key = new ZpCompanyInfoModel();
		key.setCompanyId(companyId);
		ZpCompanyInfoModel record = (ZpCompanyInfoModel) sqlMapClient.queryForObject(
				"company.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}
	
	@Override
	public PageWraper getPostResultByCondition(PostSearchCriteria example)
			throws SQLException {
    	PageWraper pw = null;
    	List list = null;
    	
    	int count = countByExample(example);
    	
    	list = sqlMapClient.queryForList("company.getPostResult", example);
        
		pw = PageManager.getPageWraper(example.getPageInfo(), list, count);
		
        return pw;	
    }
	
	@Override
	public int countByExample(PostSearchCriteria example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"company.countByExample", example);
		return count;
	}
    /* (非 Javadoc)
    * <p>Title: getPostReport</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.dao.CompanyDAO#getPostReport(com.wugu.zhaopin.webapp.model.PostReportCriteria)
    */
    @Override
    public PageWraper getPostReport(PostReportCriteria example)
            throws SQLException
    {
        PageWraper pw = null;
        List list = null;
        
        int count = countPostReport(example);
        
        list = sqlMapClient.queryForList("company.getPostReport", example);
        
        pw = PageManager.getPageWraper(example.getPageInfo(), list, count);
        
        return pw;
    }
    
    public int countPostReport(PostReportCriteria example) throws SQLException{
        Integer count = (Integer) sqlMapClient.queryForObject(
                "company.countPostReport", example);
        return count;
    }

}
