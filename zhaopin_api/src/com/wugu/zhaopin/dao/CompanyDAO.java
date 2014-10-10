package com.wugu.zhaopin.dao;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.webapp.model.PostReportCriteria;
import com.wugu.zhaopin.webapp.model.PostSearchCriteria;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

public interface CompanyDAO {
	int countByExample(ZpCompanyInfoCriteria example) throws SQLException;
	
	PageWraper selectBypage(ZpCompanyInfoCriteria example) throws SQLException;
	
	ZpCompanyInfoModel selectByPrimaryKey(Integer companyId) throws SQLException;
	
	List<ZpCompanyInfoModel> selectByExample(ZpCompanyInfoCriteria example)
			throws SQLException;
	
	int countByExample(PostSearchCriteria example) throws SQLException;
	
	PageWraper getPostResultByCondition(PostSearchCriteria example) throws SQLException;
	
	int countPostReport(PostReportCriteria example) throws SQLException;
	
	PageWraper getPostReport(PostReportCriteria example) throws SQLException;
}
