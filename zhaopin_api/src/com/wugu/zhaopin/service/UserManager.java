/**
 * 
 */
package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpUser;
import com.wugu.zhaopin.vo.ZpUserCriteria;
import com.wugu.zhaopin.vo.ZpUser;

/**
 * @author Sean
 *  
 */
public interface UserManager {
	int countByExample(ZpUserCriteria example) throws SQLException;

	int deleteByExample(ZpUserCriteria example) throws SQLException;

	int deleteByPrimaryKey(Long userId) throws SQLException;

	void insert(ZpUser record) throws SQLException;

	void insertSelective(ZpUser record) throws SQLException;

	List<ZpUser> selectByExample(ZpUserCriteria example)
			throws SQLException;

	ZpUser selectByPrimaryKey(Long userId) throws SQLException;

	int updateByExampleSelective(ZpUser record,
			ZpUserCriteria example) throws SQLException;

	int updateByExample(ZpUser record, ZpUserCriteria example)
			throws SQLException;

	int updateByPrimaryKeySelective(ZpUser record) throws SQLException;

	int updateByPrimaryKey(ZpUser record) throws SQLException;
	
	boolean checkUserExists(Long userid) throws SQLException;
	/**
	 * 
	* @Title: addUser
	* @Description: 添加用户，如果用户存在更新用户，否则插入
	* @author lijun
	* @param record
	* @return 插入成功返回1，更新成功返回更新行数
	* @throws SQLException
	* @throws
	 */
	int addUser(ZpUser record) throws SQLException;

}
