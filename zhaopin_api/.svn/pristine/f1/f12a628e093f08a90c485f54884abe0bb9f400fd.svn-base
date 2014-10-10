package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpAuditionInfo;
import com.wugu.zhaopin.vo.ZpAuditionInfoCriteria;
import com.wugu.zhaopin.webapp.model.AuditionInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

public interface AuditionInfoManager {
	int countByExample(ZpAuditionInfoCriteria example) throws SQLException;

	int deleteByExample(ZpAuditionInfoCriteria example) throws SQLException;

	int deleteByPrimaryKey(Long auditionInfoId) throws SQLException;

	Long insert(ZpAuditionInfo record) throws SQLException;

	Long insertSelective(ZpAuditionInfo record) throws SQLException;

	List<ZpAuditionInfo> selectByExample(ZpAuditionInfoCriteria example)
			throws SQLException;

	ZpAuditionInfo selectByPrimaryKey(Long auditionInfoId) throws SQLException;

	int updateByExampleSelective(ZpAuditionInfo record,
			ZpAuditionInfoCriteria example) throws SQLException;

	int updateByExample(ZpAuditionInfo record, ZpAuditionInfoCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpAuditionInfo record) throws SQLException;

	int updateByPrimaryKey(ZpAuditionInfo record) throws SQLException;
	
	public PageWraper selectByPage(AuditionInfoCriteria example)throws SQLException;

}
