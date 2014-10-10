/**  
* @Title:  BaseProvinceManagerImpl.java
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

import com.wugu.zhaopin.dao.BaseProvinceDAO;
import com.wugu.zhaopin.service.BaseProvinceManager;
import com.wugu.zhaopin.vo.BaseProvince;
import com.wugu.zhaopin.vo.BaseProvinceCriteria;

/**
 * @ClassName: BaseProvinceManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-7 
 *
 */
public class BaseProvinceManagerImpl implements BaseProvinceManager
{
    private BaseProvinceDAO baseprovincedao;
    
    public BaseProvinceDAO getBaseprovincedao() {
        return baseprovincedao;
    }

    public void setBaseprovincedao(BaseProvinceDAO baseprovincedao) {
        this.baseprovincedao = baseprovincedao;
    }

    @Override
    public int countByExample(BaseProvinceCriteria example) throws SQLException {
        return baseprovincedao.countByExample(example);
    }

    @Override
    public int deleteByExample(BaseProvinceCriteria example)
            throws SQLException {
        return baseprovincedao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(int provinceId) throws SQLException {
        return baseprovincedao.deleteByPrimaryKey(provinceId);
    }

    @Override
    public void insert(BaseProvince record) throws SQLException {
        baseprovincedao.insert(record);
    }

    @Override
    public void insertSelective(BaseProvince record) throws SQLException {
        baseprovincedao.insertSelective(record);
    }

    @Override
    public List<BaseProvince> selectByExample(BaseProvinceCriteria example)
            throws SQLException {
        return baseprovincedao.selectByExample(example);
    }

    @Override
    public BaseProvince selectByPrimaryKey(int provinceId) throws SQLException {
        return baseprovincedao.selectByPrimaryKey(provinceId);
    }

    @Override
    public int updateByExampleSelective(BaseProvince record,
            BaseProvinceCriteria example) throws SQLException {
        return baseprovincedao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(BaseProvince record, BaseProvinceCriteria example)
            throws SQLException {
        return baseprovincedao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseProvince record)
            throws SQLException {
        return baseprovincedao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseProvince record) throws SQLException {
        return baseprovincedao.updateByPrimaryKey(record);
    }
}
