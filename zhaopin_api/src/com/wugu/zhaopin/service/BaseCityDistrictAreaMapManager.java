/**  
* @Title:  BaseCityDistrictAreaMap.java
* @Package com.wugu.zhaopin.service
* @Description: 城市区域街道映射字典表接口
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

import com.wugu.zhaopin.vo.BaseCityDistrictAreaMap;
import com.wugu.zhaopin.vo.BaseCityDistrictAreaMapCriteria;

/**
 * @ClassName: BaseCityDistrictAreaMap
 * @Description: 城市区域街道映射字典表接口
 * @author lijun
 * @date 2014-1-7 
 *
 */
public interface BaseCityDistrictAreaMapManager
{
    int countByExample(BaseCityDistrictAreaMapCriteria example) throws SQLException;

    int deleteByExample(BaseCityDistrictAreaMapCriteria example) throws SQLException;

    int deleteByPrimaryKey(int id) throws SQLException;

    void insert(BaseCityDistrictAreaMap record) throws SQLException;

    void insertSelective(BaseCityDistrictAreaMap record) throws SQLException;

    List<BaseCityDistrictAreaMap> selectByExample(BaseCityDistrictAreaMapCriteria example)
            throws SQLException;

    BaseCityDistrictAreaMap selectByPrimaryKey(int id) throws SQLException;

    int updateByExampleSelective(BaseCityDistrictAreaMap record,
            BaseCityDistrictAreaMapCriteria example) throws SQLException;

    int updateByExample(BaseCityDistrictAreaMap record, BaseCityDistrictAreaMapCriteria example)
            throws SQLException;

    int updateByPrimaryKeySelective(BaseCityDistrictAreaMap record) throws SQLException;

    int updateByPrimaryKey(BaseCityDistrictAreaMap record) throws SQLException;
}
