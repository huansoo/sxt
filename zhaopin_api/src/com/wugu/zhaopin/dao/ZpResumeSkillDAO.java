package com.wugu.zhaopin.dao;

import com.wugu.zhaopin.vo.ZpResumeSkill;
import com.wugu.zhaopin.vo.ZpResumeSkillCriteria;
import java.util.List;
import java.sql.SQLException;

public interface ZpResumeSkillDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int countByExample(ZpResumeSkillCriteria example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int deleteByExample(ZpResumeSkillCriteria example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int deleteByPrimaryKey(Long resumeSkillId) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	Long insert(ZpResumeSkill record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	Long insertSelective(ZpResumeSkill record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	List<ZpResumeSkill> selectByExample(ZpResumeSkillCriteria example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	ZpResumeSkill selectByPrimaryKey(Long resumeSkillId) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int updateByExampleSelective(ZpResumeSkill record,
			ZpResumeSkillCriteria example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int updateByExample(ZpResumeSkill record, ZpResumeSkillCriteria example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int updateByPrimaryKeySelective(ZpResumeSkill record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_skill
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int updateByPrimaryKey(ZpResumeSkill record) throws SQLException;
}