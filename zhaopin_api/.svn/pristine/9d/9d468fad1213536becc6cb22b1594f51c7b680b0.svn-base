package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpResumeCertificate;
import com.wugu.zhaopin.vo.ZpResumeCertificateCriteria;

public interface ResumeCertificateManager {
	int countByExample(ZpResumeCertificateCriteria example) throws SQLException;

	int deleteByExample(ZpResumeCertificateCriteria example) throws SQLException;

	int deleteByPrimaryKey(Long resumeCertificateId) throws SQLException;

	Long insert(ZpResumeCertificate record) throws SQLException;

	Long insertSelective(ZpResumeCertificate record) throws SQLException;

	List<ZpResumeCertificate> selectByExample(ZpResumeCertificateCriteria example)
			throws SQLException;

	ZpResumeCertificate selectByPrimaryKey(Long resumeCertificateId) throws SQLException;

	int updateByExampleSelective(ZpResumeCertificate record,
			ZpResumeCertificateCriteria example) throws SQLException;

	int updateByExample(ZpResumeCertificate record, ZpResumeCertificateCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpResumeCertificate record) throws SQLException;

	int updateByPrimaryKey(ZpResumeCertificate record) throws SQLException;

}
