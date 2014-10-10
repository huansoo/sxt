package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpResumeCertificateDAO;
import com.wugu.zhaopin.service.ResumeCertificateManager;
import com.wugu.zhaopin.vo.ZpResumeCertificate;
import com.wugu.zhaopin.vo.ZpResumeCertificateCriteria;

public class ResumeCertificateManagerImpl implements ResumeCertificateManager {
	private ZpResumeCertificateDAO resumecertificatedao;
	
	public ZpResumeCertificateDAO getResumecertificatedao() {
		return resumecertificatedao;
	}

	public void setResumecertificatedao(ZpResumeCertificateDAO resumeCertificatedao) {
		this.resumecertificatedao = resumeCertificatedao;
	}

	@Override
	public int countByExample(ZpResumeCertificateCriteria example) throws SQLException {
		return resumecertificatedao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpResumeCertificateCriteria example)
			throws SQLException {
		return resumecertificatedao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long resumeCertificateId) throws SQLException {
		return resumecertificatedao.deleteByPrimaryKey(resumeCertificateId);
	}

	@Override
	public Long insert(ZpResumeCertificate record) throws SQLException {
		return resumecertificatedao.insert(record);
	}

	@Override
	public Long insertSelective(ZpResumeCertificate record) throws SQLException {
		return resumecertificatedao.insertSelective(record);
	}

	@Override
	public List<ZpResumeCertificate> selectByExample(ZpResumeCertificateCriteria example)
			throws SQLException {
		return resumecertificatedao.selectByExample(example);
	}

	@Override
	public ZpResumeCertificate selectByPrimaryKey(Long resumeCertificateId) throws SQLException {
		return resumecertificatedao.selectByPrimaryKey(resumeCertificateId);
	}

	@Override
	public int updateByExampleSelective(ZpResumeCertificate record,
			ZpResumeCertificateCriteria example) throws SQLException {
		return resumecertificatedao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpResumeCertificate record, ZpResumeCertificateCriteria example)
			throws SQLException {
		return resumecertificatedao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpResumeCertificate record)
			throws SQLException {
		return resumecertificatedao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpResumeCertificate record) throws SQLException {
		return resumecertificatedao.updateByPrimaryKey(record);
	}

}
