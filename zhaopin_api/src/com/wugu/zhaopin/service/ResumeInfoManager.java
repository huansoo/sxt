package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpPersonInfoCriteria;
import com.wugu.zhaopin.vo.ZpPersonInfo;
import com.wugu.zhaopin.vo.ZpResumeInfo;
import com.wugu.zhaopin.vo.ZpResumeInfoCriteria;
import com.wugu.zhaopin.webapp.model.ResumeInfoCriteria;
import com.wugu.zhaopin.webapp.model.ResumeReportCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

public interface ResumeInfoManager {
	int countByExample(ZpResumeInfoCriteria example) throws SQLException;

	int deleteByExample(ZpResumeInfoCriteria example) throws SQLException;

	int deleteByPrimaryKey(Long resumeId) throws SQLException;

	Long insert(ZpResumeInfo record) throws SQLException, Exception;
	
    Long insert(ZpResumeInfo record, boolean addUser) throws SQLException, Exception;
    
	Long insertSelective(ZpResumeInfo record) throws SQLException;

	List<ZpResumeInfo> selectByExample(ZpResumeInfoCriteria example)
			throws Exception;

	ZpResumeInfo selectByPrimaryKey(Long resumeId) throws Exception;

	int updateByExampleSelective(ZpResumeInfo record,
			ZpResumeInfoCriteria example) throws SQLException;

	int updateByExample(ZpResumeInfo record, ZpResumeInfoCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpResumeInfo record) throws SQLException;
	
    int updateByPrimaryKeySelective(ZpResumeInfo record, boolean updateUser) 
            throws SQLException, Exception;

	int updateByPrimaryKey(ZpResumeInfo record) throws SQLException;
	
    int countByExample(ResumeInfoCriteria example) throws SQLException;
    
    PageWraper selectBypage(ResumeInfoCriteria example) throws SQLException; 
    
    List<ZpPersonInfo> selectPersonByExmaple(ZpPersonInfoCriteria example)
            throws SQLException;
    
    int getLastResumeCount(ResumeInfoCriteria example) throws SQLException;
    
    PageWraper getLastResumeList(ResumeInfoCriteria example) throws SQLException; 
    
    int getResumeReportCount(ResumeReportCriteria example) throws SQLException;
    
    PageWraper getResumeReport(ResumeReportCriteria example) throws SQLException;
}
