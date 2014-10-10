package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpResumeEducation;
import com.wugu.zhaopin.vo.ZpResumeEducationCriteria;

public interface ResumeEducationManager {
	int countByExample(ZpResumeEducationCriteria example) throws SQLException;

	int deleteByExample(ZpResumeEducationCriteria example) throws SQLException;

	int deleteByPrimaryKey(Long resumeEducationId) throws SQLException;

	Long insert(ZpResumeEducation record) throws SQLException;

	Long insertSelective(ZpResumeEducation record) throws SQLException;

	List<ZpResumeEducation> selectByExample(ZpResumeEducationCriteria example)
			throws SQLException;

	ZpResumeEducation selectByPrimaryKey(Long resumeEducationId) throws SQLException;

	int updateByExampleSelective(ZpResumeEducation record,
			ZpResumeEducationCriteria example) throws SQLException;

	int updateByExample(ZpResumeEducation record, ZpResumeEducationCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpResumeEducation record) throws SQLException;

	int updateByPrimaryKey(ZpResumeEducation record) throws SQLException;

}
