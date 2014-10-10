package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpCompanyContact;
import com.wugu.zhaopin.vo.ZpCompanyContactCriteria;
import com.wugu.zhaopin.vo.ZpCompanyInfo;
import com.wugu.zhaopin.vo.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.vo.ZpPostInfo;
import com.wugu.zhaopin.vo.ZpPostInfoCriteria;
import com.wugu.zhaopin.webapp.model.PostReportCriteria;
import com.wugu.zhaopin.webapp.model.PostSearchCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

public interface CompanyManager {
	int countByExample(ZpCompanyContactCriteria example) throws SQLException ;

	int deleteByExample(ZpCompanyContactCriteria example)throws SQLException ;

	int deleteByPrimaryKey(Integer companyContactId) throws SQLException ;

	Integer insert(ZpCompanyContact record) throws SQLException ;

	Integer insertSelective(ZpCompanyContact record) throws SQLException ;

	List<ZpCompanyContact> selectByExample(ZpCompanyContactCriteria example) throws SQLException ;

	ZpCompanyContact selectByPrimaryKey(Integer companyContactId) throws SQLException ;

	int updateByExampleSelective(ZpCompanyContact record,
			ZpCompanyContactCriteria example) throws SQLException ;

	int updateByExample(ZpCompanyContact record,
			ZpCompanyContactCriteria example) throws SQLException ;

	int updateByPrimaryKeySelective(ZpCompanyContact record) throws SQLException ;

	int updateByPrimaryKey(ZpCompanyContact record) throws SQLException ;

	int countByExample(ZpCompanyInfoCriteria example) throws SQLException ;

	int deleteByExample(ZpCompanyInfoCriteria example) throws SQLException ;

	int deleteCompanyByPrimaryKey(Integer companyId) throws SQLException ;

	Integer insert(ZpCompanyInfo record) throws SQLException ;

	Integer insertSelective(ZpCompanyInfo record) throws SQLException ;

	List<ZpCompanyInfo> selectByExample(ZpCompanyInfoCriteria example) throws SQLException ;

	ZpCompanyInfo selectInfoByPrimaryKey(Integer companyId) throws SQLException ;

	int updateByExampleSelective(ZpCompanyInfo record,
			ZpCompanyInfoCriteria example) throws SQLException ;

	int updateByExample(ZpCompanyInfo record, ZpCompanyInfoCriteria example) throws SQLException ;

	int updateByPrimaryKeySelective(ZpCompanyInfo record) throws SQLException ;

	int updateByPrimaryKey(ZpCompanyInfo record) throws SQLException ;	
	
	int insert(ZpCompanyInfo companyInfo, ZpCompanyContact companyContact) throws Exception;
	
	int update(ZpCompanyInfo companyInfo, ZpCompanyContact companyContact) throws Exception;
	
	int countByExample(com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria example) throws SQLException ;
	
	PageWraper selectBypage(com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria example) throws SQLException;
	
	List<com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel> selectByExample(com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria example) throws SQLException ;

	com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel selectCompanyByPrimaryKey(Integer companyId) throws SQLException ;
	
	PageWraper getPostResultByCondition(PostSearchCriteria example) throws SQLException;
	
	Long insert(ZpPostInfo record) throws SQLException;
	
	int updateByPrimaryKeySelective(ZpPostInfo record) throws SQLException;
	
	ZpPostInfo selectByPrimaryKey(Long postId) throws SQLException;
	
	List<ZpPostInfo> selectByExample(ZpPostInfoCriteria example) throws SQLException;
	
	int deletePostByKey(Long postId) throws SQLException;
	
	PageWraper getPostReport(PostReportCriteria example) throws SQLException;
	
	int getPostCount(ZpPostInfoCriteria example) throws SQLException;
}
