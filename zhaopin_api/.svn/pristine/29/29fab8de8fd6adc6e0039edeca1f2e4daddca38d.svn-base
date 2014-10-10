/**
 * 
 */
package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.dao.ZpUserDAO;
import com.wugu.zhaopin.service.UserManager;
import com.wugu.zhaopin.vo.ZpUser;
import com.wugu.zhaopin.vo.ZpUserCriteria;
import com.wugu.zhaopin.vo.ZpUser;

/**
 * @author Sean
 *
 */
public class UserManagerImpl implements UserManager {

	private ZpUserDAO userdao;
	
	public ZpUserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(ZpUserDAO Userdao) {
		this.userdao = Userdao;
	}

	@Override
	public int countByExample(ZpUserCriteria example) throws SQLException {
		return userdao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpUserCriteria example)
			throws SQLException {
		return userdao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long userId) throws SQLException {
		return userdao.deleteByPrimaryKey(userId);
	}

	@Override
	public void insert(ZpUser record) throws SQLException {
		userdao.insert(record);
	}

	@Override
	public void insertSelective(ZpUser record) throws SQLException {
		userdao.insertSelective(record);
	}

	@Override
	public List<ZpUser> selectByExample(ZpUserCriteria example)
			throws SQLException {
		return userdao.selectByExample(example);
	}

	@Override
	public ZpUser selectByPrimaryKey(Long userId) throws SQLException {
		return userdao.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByExampleSelective(ZpUser record,
			ZpUserCriteria example) throws SQLException {
		return userdao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpUser record, ZpUserCriteria example)
			throws SQLException {
		return userdao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpUser record)
			throws SQLException {
		return userdao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpUser record) throws SQLException {
		return userdao.updateByPrimaryKey(record);
	}

	@Override
	public boolean checkUserExists(Long userid) throws SQLException {
		ZpUserCriteria example = new ZpUserCriteria();
		example.createCriteria().andUserIdEqualTo(userid).andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
		
		return userdao.countByExample(example) > 0;
	}

    /* (非 Javadoc)
    * <p>Title: addUser</p>
    * <p>Description: 添加用户，如果用户存在更新用户，否则插入</p>
    * @param record 
    * @return  插入成功返回1，更新成功返回更新行数
    * @throws SQLException
    * @see com.wugu.zhaopin.service.UserManager#addUser(com.wugu.zhaopin.vo.ZpUser)
    */
    @Override
    public int addUser(ZpUser record) throws SQLException
    {
        if (!checkUserExists(record.getUserId())){
            insertSelective(record);
            return 1;
        }
        else {
            return updateByPrimaryKeySelective(record);
        }
    }


}
