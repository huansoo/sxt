package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpResumeSkill;
import com.wugu.zhaopin.vo.ZpResumeSkillCriteria;

public interface ResumeSkillManager {
	int countByExample(ZpResumeSkillCriteria example) throws SQLException;

	int deleteByExample(ZpResumeSkillCriteria example) throws SQLException;

	int deleteByPrimaryKey(Long resumeSkillId) throws SQLException;

	Long insert(ZpResumeSkill record) throws SQLException;

	Long insertSelective(ZpResumeSkill record) throws SQLException;

	List<ZpResumeSkill> selectByExample(ZpResumeSkillCriteria example)
			throws SQLException;

	ZpResumeSkill selectByPrimaryKey(Long resumeSkillId) throws SQLException;

	int updateByExampleSelective(ZpResumeSkill record,
			ZpResumeSkillCriteria example) throws SQLException;

	int updateByExample(ZpResumeSkill record, ZpResumeSkillCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpResumeSkill record) throws SQLException;

	int updateByPrimaryKey(ZpResumeSkill record) throws SQLException;

}
