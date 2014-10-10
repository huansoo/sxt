package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpTag;
import com.wugu.zhaopin.vo.ZpTagCriteria;

public interface TagManager {
	int countByExample(ZpTagCriteria example) throws SQLException;

	int deleteByExample(ZpTagCriteria example) throws SQLException;

	int deleteByPrimaryKey(int tagId) throws SQLException;

	int insert(ZpTag record) throws SQLException;

	int insertSelective(ZpTag record) throws SQLException;

	List<ZpTag> selectByExample(ZpTagCriteria example)
			throws SQLException;

	ZpTag selectByPrimaryKey(int tagId) throws SQLException;

	int updateByExampleSelective(ZpTag record,
			ZpTagCriteria example) throws SQLException;

	int updateByExample(ZpTag record, ZpTagCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpTag record) throws SQLException;

	int updateByPrimaryKey(ZpTag record) throws SQLException;

}
