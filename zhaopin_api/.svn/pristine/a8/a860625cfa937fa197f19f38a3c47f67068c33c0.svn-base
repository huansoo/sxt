/**  
* @Title:  BaseDistrictManagerImpl.java
* @Package com.wugu.zhaopin.service.impl
* @Description: TODO(用一句话描述该文件做什么)
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
package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.BaseDistrictDAO;
import com.wugu.zhaopin.service.BaseDistrictManager;
import com.wugu.zhaopin.vo.BaseDistrict;
import com.wugu.zhaopin.vo.BaseDistrictCriteria;

/**
 * @ClassName: BaseDistrictManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-7 
 *
 */
public class BaseDistrictManagerImpl implements BaseDistrictManager
{
    private BaseDistrictDAO basedistrictdao;
    
    public BaseDistrictDAO getBasedistrictdao() {
        return basedistrictdao;
    }

    public void setBasedistrictdao(BaseDistrictDAO basedistrictdao) {
        this.basedistrictdao = basedistrictdao;
    }

    @Override
    public int countByExample(BaseDistrictCriteria example) throws SQLException {
        return basedistrictdao.countByExample(example);
    }

    @Override
    public int deleteByExample(BaseDistrictCriteria example)
            throws SQLException {
        return basedistrictdao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(int districtId) throws SQLException {
        return basedistrictdao.deleteByPrimaryKey(districtId);
    }

    @Override
    public void insert(BaseDistrict record) throws SQLException {
        basedistrictdao.insert(record);
    }

    @Override
    public void insertSelective(BaseDistrict record) throws SQLException {
        basedistrictdao.insertSelective(record);
    }

    @Override
    public List<BaseDistrict> selectByExample(BaseDistrictCriteria example)
            throws SQLException {
        return basedistrictdao.selectByExample(example);
    }

    @Override
    public BaseDistrict selectByPrimaryKey(int districtId) throws SQLException {
        return basedistrictdao.selectByPrimaryKey(districtId);
    }

    @Override
    public int updateByExampleSelective(BaseDistrict record,
            BaseDistrictCriteria example) throws SQLException {
        return basedistrictdao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(BaseDistrict record, BaseDistrictCriteria example)
            throws SQLException {
        return basedistrictdao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseDistrict record)
            throws SQLException {
        return basedistrictdao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseDistrict record) throws SQLException {
        return basedistrictdao.updateByPrimaryKey(record);
    }
}
