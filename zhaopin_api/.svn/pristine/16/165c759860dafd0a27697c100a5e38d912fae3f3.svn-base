package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpResumeEducationDAO;
import com.wugu.zhaopin.service.ResumeEducationManager;
import com.wugu.zhaopin.vo.ZpResumeEducation;
import com.wugu.zhaopin.vo.ZpResumeEducationCriteria;

public class ResumeEducationManagerImpl implements ResumeEducationManager {
	private ZpResumeEducationDAO resumeeducationdao;
	

	public ZpResumeEducationDAO getResumeeducationdao() {
		return resumeeducationdao;
	}

	public void setResumeeducationdao(ZpResumeEducationDAO resumeeducationdao) {
		this.resumeeducationdao = resumeeducationdao;
	}

	@Override
	public int countByExample(ZpResumeEducationCriteria example) throws SQLException {
		return resumeeducationdao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpResumeEducationCriteria example)
			throws SQLException {
		return resumeeducationdao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long resumeEducationId) throws SQLException {
		return resumeeducationdao.deleteByPrimaryKey(resumeEducationId);
	}

	@Override
	public Long insert(ZpResumeEducation record) throws SQLException {
		return resumeeducationdao.insert(record);
	}

	@Override
	public Long insertSelective(ZpResumeEducation record) throws SQLException {
		return resumeeducationdao.insertSelective(record);
	}

	@Override
	public List<ZpResumeEducation> selectByExample(ZpResumeEducationCriteria example)
			throws SQLException {
		return resumeeducationdao.selectByExample(example);
	}

	@Override
	public ZpResumeEducation selectByPrimaryKey(Long resumeEducationId) throws SQLException {
		return resumeeducationdao.selectByPrimaryKey(resumeEducationId);
	}

	@Override
	public int updateByExampleSelective(ZpResumeEducation record,
			ZpResumeEducationCriteria example) throws SQLException {
		return resumeeducationdao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpResumeEducation record, ZpResumeEducationCriteria example)
			throws SQLException {
		return resumeeducationdao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpResumeEducation record)
			throws SQLException {
		return resumeeducationdao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpResumeEducation record) throws SQLException {
		return resumeeducationdao.updateByPrimaryKey(record);
	}

}
