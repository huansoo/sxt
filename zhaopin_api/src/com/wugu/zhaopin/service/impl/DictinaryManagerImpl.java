package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpDictinaryDAO;
import com.wugu.zhaopin.service.DictinaryManager;
import com.wugu.zhaopin.vo.ZpDictinary;
import com.wugu.zhaopin.vo.ZpDictinaryCriteria;

public class DictinaryManagerImpl implements DictinaryManager {

	/**
	 * 
	 */
	private ZpDictinaryDAO dictinarydao;
	
	public ZpDictinaryDAO getDictinarydao() {
		return dictinarydao;
	}

	public void setDictinarydao(ZpDictinaryDAO dictinarydao) {
		this.dictinarydao = dictinarydao;
	}

	@Override
	public int countByExample(ZpDictinaryCriteria example) throws SQLException {
		return dictinarydao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpDictinaryCriteria example) throws SQLException {
		return dictinarydao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer rowId) throws SQLException {
		return dictinarydao.deleteByPrimaryKey(rowId);
	}

	@Override
	public Integer insert(ZpDictinary record) throws SQLException {
		return dictinarydao.insert(record);
	}

	@Override
	public Integer insertSelective(ZpDictinary record) throws SQLException {
		return dictinarydao.insertSelective(record);
	}

	@Override
	public List<ZpDictinary> selectByExample(ZpDictinaryCriteria example)
			throws SQLException {
		return dictinarydao.selectByExample(example);
	}

	@Override
	public ZpDictinary selectByPrimaryKey(Integer rowId) throws SQLException {
		return dictinarydao.selectByPrimaryKey(rowId);
	}

	@Override
	public int updateByExampleSelective(ZpDictinary record,
			ZpDictinaryCriteria example) throws SQLException {
		return dictinarydao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpDictinary record, ZpDictinaryCriteria example)
			throws SQLException {
		return dictinarydao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpDictinary record)
			throws SQLException {
		return dictinarydao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpDictinary record) throws SQLException {
		return dictinarydao.updateByPrimaryKey(record);
	}

}
