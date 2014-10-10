package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpResumeTag;
import com.wugu.zhaopin.vo.ZpResumeTagCriteria;

public interface ResumeTagManager {
	int countByExample(ZpResumeTagCriteria example) throws SQLException;

	int deleteByExample(ZpResumeTagCriteria example) throws SQLException;

	int deleteByPrimaryKey(Long resumeTagId) throws SQLException;

	Long insert(ZpResumeTag record) throws SQLException;

	Long insertSelective(ZpResumeTag record) throws SQLException;

	List<ZpResumeTag> selectByExample(ZpResumeTagCriteria example)
			throws SQLException;

	ZpResumeTag selectByPrimaryKey(Long resumeTagId) throws SQLException;

	int updateByExampleSelective(ZpResumeTag record,
			ZpResumeTagCriteria example) throws SQLException;

	int updateByExample(ZpResumeTag record, ZpResumeTagCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpResumeTag record) throws SQLException;

	int updateByPrimaryKey(ZpResumeTag record) throws SQLException;

}
