package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpResumeExperienceDAO;
import com.wugu.zhaopin.service.ResumeExperienceManager;
import com.wugu.zhaopin.vo.ZpResumeExperience;
import com.wugu.zhaopin.vo.ZpResumeExperienceCriteria;

public class ResumeExperienceManagerImpl implements ResumeExperienceManager {
	private ZpResumeExperienceDAO resumeexperiencedao;
	

	public ZpResumeExperienceDAO getResumeexperiencedao() {
		return resumeexperiencedao;
	}

	public void setResumeexperiencedao(ZpResumeExperienceDAO resumeexperiencedao) {
		this.resumeexperiencedao = resumeexperiencedao;
	}

	@Override
	public int countByExample(ZpResumeExperienceCriteria example) throws SQLException {
		return resumeexperiencedao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpResumeExperienceCriteria example)
			throws SQLException {
		return resumeexperiencedao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long resumeEducationId) throws SQLException {
		return resumeexperiencedao.deleteByPrimaryKey(resumeEducationId);
	}

	@Override
	public Long insert(ZpResumeExperience record) throws SQLException {
		return resumeexperiencedao.insert(record);
	}

	@Override
	public Long insertSelective(ZpResumeExperience record) throws SQLException {
		return resumeexperiencedao.insertSelective(record);
	}

	@Override
	public List<ZpResumeExperience> selectByExample(ZpResumeExperienceCriteria example)
			throws SQLException {
		return resumeexperiencedao.selectByExample(example);
	}

	@Override
	public ZpResumeExperience selectByPrimaryKey(Long resumeEducationId) throws SQLException {
		return resumeexperiencedao.selectByPrimaryKey(resumeEducationId);
	}

	@Override
	public int updateByExampleSelective(ZpResumeExperience record,
			ZpResumeExperienceCriteria example) throws SQLException {
		return resumeexperiencedao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpResumeExperience record, ZpResumeExperienceCriteria example)
			throws SQLException {
		return resumeexperiencedao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpResumeExperience record)
			throws SQLException {
		return resumeexperiencedao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpResumeExperience record) throws SQLException {
		return resumeexperiencedao.updateByPrimaryKey(record);
	}
}
