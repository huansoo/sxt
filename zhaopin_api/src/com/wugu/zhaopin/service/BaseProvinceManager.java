/**  
* @Title:  BaseProvinceManager.java
* @Package com.wugu.zhaopin.service
* @Description: 省份字典表接口
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

import com.wugu.zhaopin.vo.BaseProvince;
import com.wugu.zhaopin.vo.BaseProvinceCriteria;

/**
 * @ClassName: BaseProvinceManager
 * @Description: 省份字典表接口
 * @author lijun
 * @date 2014-1-7 
 *
 */
public interface BaseProvinceManager
{
    int countByExample(BaseProvinceCriteria example) throws SQLException;

    int deleteByExample(BaseProvinceCriteria example) throws SQLException;

    int deleteByPrimaryKey(int provinceId) throws SQLException;

    void insert(BaseProvince record) throws SQLException;

    void insertSelective(BaseProvince record) throws SQLException;

    List<BaseProvince> selectByExample(BaseProvinceCriteria example)
            throws SQLException;

    BaseProvince selectByPrimaryKey(int provinceId) throws SQLException;

    int updateByExampleSelective(BaseProvince record,
            BaseProvinceCriteria example) throws SQLException;

    int updateByExample(BaseProvince record, BaseProvinceCriteria example)
            throws SQLException;

    int updateByPrimaryKeySelective(BaseProvince record) throws SQLException;

    int updateByPrimaryKey(BaseProvince record) throws SQLException;
}
