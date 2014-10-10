/**  
* @Title:  PersonInfoManagerImpl.java
* @Package com.wugu.zhaopin.service.impl
* @Description: 个人用户基本信息服务实现
* @author lijun
* @date  2013-12-26 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpPersonInfoDAO;
import com.wugu.zhaopin.service.PersonInfoManager;
import com.wugu.zhaopin.vo.ZpPersonInfo;
import com.wugu.zhaopin.vo.ZpPersonInfoCriteria;

/**
 * @ClassName: PersonInfoManagerImpl
 * @Description: 个人用户基本信息服务实现类
 * @author lijun
 * @date 2013-12-26 
 *
 */
public class PersonInfoManagerImpl implements PersonInfoManager
{
    private ZpPersonInfoDAO personinfodao;
    
    public ZpPersonInfoDAO getPersoninfodao() {
        return personinfodao;
    }

    public void setPersoninfodao(ZpPersonInfoDAO personinfodao) {
        this.personinfodao = personinfodao;
    }

    @Override
    public int countByExample(ZpPersonInfoCriteria example) throws SQLException {
        return personinfodao.countByExample(example);
    }

    @Override
    public int deleteByExample(ZpPersonInfoCriteria example)
            throws SQLException {
        return personinfodao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long userId) throws SQLException {
        return personinfodao.deleteByPrimaryKey(userId);
    }

    @Override
    public void insert(ZpPersonInfo record) throws SQLException {
        personinfodao.insert(record);
    }

    @Override
    public void insertSelective(ZpPersonInfo record) throws SQLException {
        personinfodao.insertSelective(record);
    }

    @Override
    public List<ZpPersonInfo> selectByExample(ZpPersonInfoCriteria example)
            throws SQLException {
        return personinfodao.selectByExample(example);
    }

    @Override
    public ZpPersonInfo selectByPrimaryKey(Long userId) throws SQLException {
        return personinfodao.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByExampleSelective(ZpPersonInfo record,
            ZpPersonInfoCriteria example) throws SQLException {
        return personinfodao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ZpPersonInfo record, ZpPersonInfoCriteria example)
            throws SQLException {
        return personinfodao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZpPersonInfo record)
            throws SQLException {
        return personinfodao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZpPersonInfo record) throws SQLException {
        return personinfodao.updateByPrimaryKey(record);
    }

    /* (非 Javadoc)
    * <p>Title: addPerson</p>
    * <p>Description: 添加个人用户基本信息，如果个人用户存在更新，否则插入 </p>
    * @param record
    * @return 插入成功返回1，更新成功返回更新行数
    * @throws SQLException
    * @see com.wugu.zhaopin.service.PersonInfoManager#addPerson(com.wugu.zhaopin.vo.ZpPersonInfo)
    */
    @Override
    public int addPerson(ZpPersonInfo record) throws SQLException
    {
        if (selectByPrimaryKey(record.getUserId()) == null){
            insertSelective(record);
            return 1;
        }
        else 
            return updateByPrimaryKeySelective(record);
    }


}
