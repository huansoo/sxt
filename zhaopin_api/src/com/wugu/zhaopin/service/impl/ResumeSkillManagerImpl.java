package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpResumeSkillDAO;
import com.wugu.zhaopin.service.ResumeSkillManager;
import com.wugu.zhaopin.vo.ZpResumeSkill;
import com.wugu.zhaopin.vo.ZpResumeSkillCriteria;

public class ResumeSkillManagerImpl implements ResumeSkillManager {
	private ZpResumeSkillDAO resumeskilldao;
	

	public ZpResumeSkillDAO getResumeskilldao() {
		return resumeskilldao;
	}

	public void setResumeskilldao(ZpResumeSkillDAO resumeskilldao) {
		this.resumeskilldao = resumeskilldao;
	}

	@Override
	public int countByExample(ZpResumeSkillCriteria example) throws SQLException {
		return resumeskilldao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpResumeSkillCriteria example)
			throws SQLException {
		return resumeskilldao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long resumeSkillId) throws SQLException {
		return resumeskilldao.deleteByPrimaryKey(resumeSkillId);
	}

	@Override
	public Long insert(ZpResumeSkill record) throws SQLException {
		return resumeskilldao.insert(record);
	}

	@Override
	public Long insertSelective(ZpResumeSkill record) throws SQLException {
		return resumeskilldao.insertSelective(record);
	}

	@Override
	public List<ZpResumeSkill> selectByExample(ZpResumeSkillCriteria example)
			throws SQLException {
		return resumeskilldao.selectByExample(example);
	}

	@Override
	public ZpResumeSkill selectByPrimaryKey(Long resumeSkillId) throws SQLException {
		return resumeskilldao.selectByPrimaryKey(resumeSkillId);
	}

	@Override
	public int updateByExampleSelective(ZpResumeSkill record,
			ZpResumeSkillCriteria example) throws SQLException {
		return resumeskilldao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpResumeSkill record, ZpResumeSkillCriteria example)
			throws SQLException {
		return resumeskilldao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpResumeSkill record)
			throws SQLException {
		return resumeskilldao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpResumeSkill record) throws SQLException {
		return resumeskilldao.updateByPrimaryKey(record);
	}

}
