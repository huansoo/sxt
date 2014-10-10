package com.wugu.zhaopin.dao.impl;

import com.wugu.zhaopin.dao.ZpDictinaryDAO;
import com.wugu.zhaopin.vo.ZpDictinary;
import com.wugu.zhaopin.vo.ZpDictinaryCriteria;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;

public class ZpDictinaryDAOImpl implements ZpDictinaryDAO {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public ZpDictinaryDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public int countByExample(ZpDictinaryCriteria example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"zp_dictinary.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public int deleteByExample(ZpDictinaryCriteria example) throws SQLException {
		int rows = sqlMapClient.delete(
				"zp_dictinary.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public int deleteByPrimaryKey(Integer rowId) throws SQLException {
		ZpDictinary key = new ZpDictinary();
		key.setRowId(rowId);
		int rows = sqlMapClient.delete(
				"zp_dictinary.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public Integer insert(ZpDictinary record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"zp_dictinary.ibatorgenerated_insert", record);
		return (Integer) newKey;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public Integer insertSelective(ZpDictinary record) throws SQLException {
		Object newKey = sqlMapClient.insert(
				"zp_dictinary.ibatorgenerated_insertSelective", record);
		return (Integer) newKey;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	@SuppressWarnings("unchecked")
	public List<ZpDictinary> selectByExample(ZpDictinaryCriteria example)
			throws SQLException {
		List<ZpDictinary> list = sqlMapClient.queryForList(
				"zp_dictinary.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public ZpDictinary selectByPrimaryKey(Integer rowId) throws SQLException {
		ZpDictinary key = new ZpDictinary();
		key.setRowId(rowId);
		ZpDictinary record = (ZpDictinary) sqlMapClient.queryForObject(
				"zp_dictinary.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public int updateByExampleSelective(ZpDictinary record,
			ZpDictinaryCriteria example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"zp_dictinary.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public int updateByExample(ZpDictinary record, ZpDictinaryCriteria example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"zp_dictinary.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public int updateByPrimaryKeySelective(ZpDictinary record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"zp_dictinary.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	public int updateByPrimaryKey(ZpDictinary record) throws SQLException {
		int rows = sqlMapClient.update(
				"zp_dictinary.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table zp_dictinary
	 * @ibatorgenerated  Mon Dec 23 10:14:47 CST 2013
	 */
	private static class UpdateByExampleParms extends ZpDictinaryCriteria {
		private Object record;

		public UpdateByExampleParms(Object record, ZpDictinaryCriteria example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

}