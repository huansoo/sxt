package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpResumeLanguageDAO;
import com.wugu.zhaopin.service.ResumeLanguageManager;
import com.wugu.zhaopin.vo.ZpResumeLanguage;
import com.wugu.zhaopin.vo.ZpResumeLanguageCriteria;

public class ResumeLanguageManagerImpl implements ResumeLanguageManager {
	private ZpResumeLanguageDAO resumelanguagedao;
	

	public ZpResumeLanguageDAO getResumelanguagedao() {
		return resumelanguagedao;
	}

	public void setResumelanguagedao(ZpResumeLanguageDAO resumelanguagedao) {
		this.resumelanguagedao = resumelanguagedao;
	}

	@Override
	public int countByExample(ZpResumeLanguageCriteria example) throws SQLException {
		return resumelanguagedao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpResumeLanguageCriteria example)
			throws SQLException {
		return resumelanguagedao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long resumeLanguageId) throws SQLException {
		return resumelanguagedao.deleteByPrimaryKey(resumeLanguageId);
	}

	@Override
	public Long insert(ZpResumeLanguage record) throws SQLException {
		return resumelanguagedao.insert(record);
	}

	@Override
	public Long insertSelective(ZpResumeLanguage record) throws SQLException {
		return resumelanguagedao.insertSelective(record);
	}

	@Override
	public List<ZpResumeLanguage> selectByExample(ZpResumeLanguageCriteria example)
			throws SQLException {
		return resumelanguagedao.selectByExample(example);
	}

	@Override
	public ZpResumeLanguage selectByPrimaryKey(Long resumeLanguageId) throws SQLException {
		return resumelanguagedao.selectByPrimaryKey(resumeLanguageId);
	}

	@Override
	public int updateByExampleSelective(ZpResumeLanguage record,
			ZpResumeLanguageCriteria example) throws SQLException {
		return resumelanguagedao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpResumeLanguage record, ZpResumeLanguageCriteria example)
			throws SQLException {
		return resumelanguagedao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpResumeLanguage record)
			throws SQLException {
		return resumelanguagedao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpResumeLanguage record) throws SQLException {
		return resumelanguagedao.updateByPrimaryKey(record);
	}

}
