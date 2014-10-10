/**  
* @Title:  BaseAreaManager.java
* @Package com.wugu.zhaopin.service
* @Description: 街道字典表接口
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

import com.wugu.zhaopin.vo.BaseArea;
import com.wugu.zhaopin.vo.BaseAreaCriteria;

/**
 * @ClassName: BaseAreaManager
 * @Description: 街道字典表接口
 * @author lijun
 * @date 2014-1-7 
 *
 */
public interface BaseAreaManager
{
    int countByExample(BaseAreaCriteria example) throws SQLException;

    int deleteByExample(BaseAreaCriteria example) throws SQLException;

    int deleteByPrimaryKey(int areaID) throws SQLException;

    void insert(BaseArea record) throws SQLException;

    void insertSelective(BaseArea record) throws SQLException;

    List<BaseArea> selectByExample(BaseAreaCriteria example)
            throws SQLException;

    BaseArea selectByPrimaryKey(int areaID) throws SQLException;

    int updateByExampleSelective(BaseArea record,
            BaseAreaCriteria example) throws SQLException;

    int updateByExample(BaseArea record, BaseAreaCriteria example)
            throws SQLException;

    int updateByPrimaryKeySelective(BaseArea record) throws SQLException;

    int updateByPrimaryKey(BaseArea record) throws SQLException;
}
