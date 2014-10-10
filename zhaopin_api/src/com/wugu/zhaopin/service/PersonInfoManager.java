/**  
* @Title:  PersonInfoManager.java
* @Package com.wugu.zhaopin.service
* @Description: 个人用户信息服务
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
package com.wugu.zhaopin.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.vo.ZpPersonInfo;
import com.wugu.zhaopin.vo.ZpPersonInfoCriteria;

/**
 * @ClassName: PersonInfoManager
 * @Description: 个人用户信息服务
 * @author lijun
 * @date 2013-12-26 
 *
 */
public interface PersonInfoManager{
    int countByExample(ZpPersonInfoCriteria example) throws SQLException;

    int deleteByExample(ZpPersonInfoCriteria example) throws SQLException;

    int deleteByPrimaryKey(Long userId) throws SQLException;

    void insert(ZpPersonInfo record) throws SQLException;

    void insertSelective(ZpPersonInfo record) throws SQLException;

    List<ZpPersonInfo> selectByExample(ZpPersonInfoCriteria example)
            throws SQLException;

    ZpPersonInfo selectByPrimaryKey(Long userId) throws SQLException;

    int updateByExampleSelective(ZpPersonInfo record,
            ZpPersonInfoCriteria example) throws SQLException;

    int updateByExample(ZpPersonInfo record, ZpPersonInfoCriteria example)
            throws SQLException;

    int updateByPrimaryKeySelective(ZpPersonInfo record) throws SQLException;

    int updateByPrimaryKey(ZpPersonInfo record) throws SQLException;
    
    /**
     * 
    * @Title: addPerson
    * @Description: 添加个人用户基本信息，如果个人用户存在更新，否则插入
    * @author lijun
    * @param record
    * @return 插入成功返回1，更新成功返回更新行数
    * @throws SQLException
    * @throws
     */
    int addPerson(ZpPersonInfo record) throws SQLException;
}
