package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpTagDAO;
import com.wugu.zhaopin.service.TagManager;
import com.wugu.zhaopin.vo.ZpTag;
import com.wugu.zhaopin.vo.ZpTagCriteria;

public class TagManagerImpl implements TagManager {
	private ZpTagDAO tagdao;
	
	public ZpTagDAO getTagdao() {
		return tagdao;
	}

	public void setTagdao(ZpTagDAO Tagdao) {
		this.tagdao = Tagdao;
	}

	@Override
	public int countByExample(ZpTagCriteria example) throws SQLException {
		return tagdao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpTagCriteria example)
			throws SQLException {
		return tagdao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(int tagId) throws SQLException {
		return tagdao.deleteByPrimaryKey(tagId);
	}

	@Override
	public int insert(ZpTag record) throws SQLException {
		return tagdao.insert(record);
	}

	@Override
	public int insertSelective(ZpTag record) throws SQLException {
		return tagdao.insertSelective(record);
	}

	@Override
	public List<ZpTag> selectByExample(ZpTagCriteria example)
			throws SQLException {
		return tagdao.selectByExample(example);
	}

	@Override
	public ZpTag selectByPrimaryKey(int TagId) throws SQLException {
		return tagdao.selectByPrimaryKey(TagId);
	}

	@Override
	public int updateByExampleSelective(ZpTag record,
			ZpTagCriteria example) throws SQLException {
		return tagdao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpTag record, ZpTagCriteria example)
			throws SQLException {
		return tagdao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpTag record)
			throws SQLException {
		return tagdao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpTag record) throws SQLException {
		return tagdao.updateByPrimaryKey(record);
	}

}
