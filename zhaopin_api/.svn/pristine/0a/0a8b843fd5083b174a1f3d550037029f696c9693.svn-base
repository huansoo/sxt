/**  
* @Title:  BaseDistrictManager.java
* @Package com.wugu.zhaopin.service
* @Description: 区字典表接口
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

import com.wugu.zhaopin.vo.BaseDistrict;
import com.wugu.zhaopin.vo.BaseDistrictCriteria;

/**
 * @ClassName: BaseDistrictManager
 * @Description: 区字典表接口
 * @author lijun
 * @date 2014-1-7 
 *
 */
public interface BaseDistrictManager
{
    int countByExample(BaseDistrictCriteria example) throws SQLException;

    int deleteByExample(BaseDistrictCriteria example) throws SQLException;

    int deleteByPrimaryKey(int districtId) throws SQLException;

    void insert(BaseDistrict record) throws SQLException;

    void insertSelective(BaseDistrict record) throws SQLException;

    List<BaseDistrict> selectByExample(BaseDistrictCriteria example)
            throws SQLException;

    BaseDistrict selectByPrimaryKey(int districtId) throws SQLException;

    int updateByExampleSelective(BaseDistrict record,
            BaseDistrictCriteria example) throws SQLException;

    int updateByExample(BaseDistrict record, BaseDistrictCriteria example)
            throws SQLException;

    int updateByPrimaryKeySelective(BaseDistrict record) throws SQLException;

    int updateByPrimaryKey(BaseDistrict record) throws SQLException;
}
