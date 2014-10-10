package com.wugu.zhaopin.dao;

import com.wugu.zhaopin.vo.ZpResumeLanguage;
import com.wugu.zhaopin.vo.ZpResumeLanguageCriteria;
import java.util.List;
import java.sql.SQLException;

public interface ZpResumeLanguageDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int countByExample(ZpResumeLanguageCriteria example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int deleteByExample(ZpResumeLanguageCriteria example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int deleteByPrimaryKey(Long resumeLanguageId) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	Long insert(ZpResumeLanguage record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	Long insertSelective(ZpResumeLanguage record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	List<ZpResumeLanguage> selectByExample(ZpResumeLanguageCriteria example)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	ZpResumeLanguage selectByPrimaryKey(Long resumeLanguageId)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int updateByExampleSelective(ZpResumeLanguage record,
			ZpResumeLanguageCriteria example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int updateByExample(ZpResumeLanguage record,
			ZpResumeLanguageCriteria example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int updateByPrimaryKeySelective(ZpResumeLanguage record)
			throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_resume_language
	 * @ibatorgenerated  Wed Dec 18 15:16:05 CST 2013
	 */
	int updateByPrimaryKey(ZpResumeLanguage record) throws SQLException;
}