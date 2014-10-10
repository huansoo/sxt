package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpResumeTagDAO;
import com.wugu.zhaopin.service.ResumeTagManager;
import com.wugu.zhaopin.vo.ZpResumeTag;
import com.wugu.zhaopin.vo.ZpResumeTagCriteria;

public class ResumeTagManagerImpl implements ResumeTagManager {
	private ZpResumeTagDAO resumetagdao;
	

	public ZpResumeTagDAO getResumetagdao() {
		return resumetagdao;
	}

	public void setResumetagdao(ZpResumeTagDAO resumetagdao) {
		this.resumetagdao = resumetagdao;
	}

	@Override
	public int countByExample(ZpResumeTagCriteria example) throws SQLException {
		return resumetagdao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpResumeTagCriteria example)
			throws SQLException {
		return resumetagdao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long resumeTagId) throws SQLException {
		return resumetagdao.deleteByPrimaryKey(resumeTagId);
	}

	@Override
	public Long insert(ZpResumeTag record) throws SQLException {
		return resumetagdao.insert(record);
	}

	@Override
	public Long insertSelective(ZpResumeTag record) throws SQLException {
		return resumetagdao.insertSelective(record);
	}

	@Override
	public List<ZpResumeTag> selectByExample(ZpResumeTagCriteria example)
			throws SQLException {
		return resumetagdao.selectByExample(example);
	}

	@Override
	public ZpResumeTag selectByPrimaryKey(Long resumeTagId) throws SQLException {
		return resumetagdao.selectByPrimaryKey(resumeTagId);
	}

	@Override
	public int updateByExampleSelective(ZpResumeTag record,
			ZpResumeTagCriteria example) throws SQLException {
		return resumetagdao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpResumeTag record, ZpResumeTagCriteria example)
			throws SQLException {
		return resumetagdao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpResumeTag record)
			throws SQLException {
		return resumetagdao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpResumeTag record) throws SQLException {
		return resumetagdao.updateByPrimaryKey(record);
	}

}
