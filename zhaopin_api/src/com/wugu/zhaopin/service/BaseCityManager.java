/**  
* @Title:  BaseCityManager.java
* @Package com.wugu.zhaopin.service
* @Description: 城市字典表接口
* @author lijun
* @date  2014-1-7 
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

import com.wugu.zhaopin.vo.BaseCity;
import com.wugu.zhaopin.vo.BaseCityCriteria;

/**
 * @ClassName: BaseCityManager
 * @Description: 城市字典表接口
 * @author lijun
 * @date 2014-1-7 
 *
 */
public interface BaseCityManager
{
    int countByExample(BaseCityCriteria example) throws SQLException;

    int deleteByExample(BaseCityCriteria example) throws SQLException;

    int deleteByPrimaryKey(int cityId) throws SQLException;

    void insert(BaseCity record) throws SQLException;

    void insertSelective(BaseCity record) throws SQLException;

    List<BaseCity> selectByExample(BaseCityCriteria example)
            throws SQLException;

    BaseCity selectByPrimaryKey(int cityId) throws SQLException;

    int updateByExampleSelective(BaseCity record,
            BaseCityCriteria example) throws SQLException;

    int updateByExample(BaseCity record, BaseCityCriteria example)
            throws SQLException;

    int updateByPrimaryKeySelective(BaseCity record) throws SQLException;

    int updateByPrimaryKey(BaseCity record) throws SQLException;
}
