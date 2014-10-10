package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpResumeExperience;
import com.wugu.zhaopin.vo.ZpResumeExperienceCriteria;

public interface ResumeExperienceManager {
	int countByExample(ZpResumeExperienceCriteria example) throws SQLException;

	int deleteByExample(ZpResumeExperienceCriteria example) throws SQLException;

	int deleteByPrimaryKey(Long resumeEducationId) throws SQLException;

	Long insert(ZpResumeExperience record) throws SQLException;

	Long insertSelective(ZpResumeExperience record) throws SQLException;

	List<ZpResumeExperience> selectByExample(ZpResumeExperienceCriteria example)
			throws SQLException;

	ZpResumeExperience selectByPrimaryKey(Long resumeEducationId) throws SQLException;

	int updateByExampleSelective(ZpResumeExperience record,
			ZpResumeExperienceCriteria example) throws SQLException;

	int updateByExample(ZpResumeExperience record, ZpResumeExperienceCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpResumeExperience record) throws SQLException;

	int updateByPrimaryKey(ZpResumeExperience record) throws SQLException;
}
