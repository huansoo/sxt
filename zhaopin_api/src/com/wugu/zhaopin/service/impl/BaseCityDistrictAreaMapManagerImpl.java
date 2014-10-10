/**  
* @Title:  BaseCityDistrictAreaMapManagerImpl.java
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

import com.wugu.zhaopin.dao.BaseCityDistrictAreaMapDAO;
import com.wugu.zhaopin.service.BaseCityDistrictAreaMapManager;
import com.wugu.zhaopin.vo.BaseCityDistrictAreaMap;
import com.wugu.zhaopin.vo.BaseCityDistrictAreaMapCriteria;

/**
 * @ClassName: BaseCityDistrictAreaMapManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-7 
 *
 */
public class BaseCityDistrictAreaMapManagerImpl implements
        BaseCityDistrictAreaMapManager
{
    private BaseCityDistrictAreaMapDAO basecitydistrictareamapdao;
    
    public BaseCityDistrictAreaMapDAO getBasecitydistrictareamapdao() {
        return basecitydistrictareamapdao;
    }

    public void setBasecitydistrictareamapdao(BaseCityDistrictAreaMapDAO basecitydistrictareamapdao) {
        this.basecitydistrictareamapdao = basecitydistrictareamapdao;
    }

    @Override
    public int countByExample(BaseCityDistrictAreaMapCriteria example) throws SQLException {
        return basecitydistrictareamapdao.countByExample(example);
    }

    @Override
    public int deleteByExample(BaseCityDistrictAreaMapCriteria example)
            throws SQLException {
        return basecitydistrictareamapdao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(int id) throws SQLException {
        return basecitydistrictareamapdao.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(BaseCityDistrictAreaMap record) throws SQLException {
        basecitydistrictareamapdao.insert(record);
    }

    @Override
    public void insertSelective(BaseCityDistrictAreaMap record) throws SQLException {
        basecitydistrictareamapdao.insertSelective(record);
    }

    @Override
    public List<BaseCityDistrictAreaMap> selectByExample(BaseCityDistrictAreaMapCriteria example)
            throws SQLException {
        return basecitydistrictareamapdao.selectByExample(example);
    }

    @Override
    public BaseCityDistrictAreaMap selectByPrimaryKey(int id) throws SQLException {
        return basecitydistrictareamapdao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(BaseCityDistrictAreaMap record,
            BaseCityDistrictAreaMapCriteria example) throws SQLException {
        return basecitydistrictareamapdao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(BaseCityDistrictAreaMap record, BaseCityDistrictAreaMapCriteria example)
            throws SQLException {
        return basecitydistrictareamapdao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseCityDistrictAreaMap record)
            throws SQLException {
        return basecitydistrictareamapdao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseCityDistrictAreaMap record) throws SQLException {
        return basecitydistrictareamapdao.updateByPrimaryKey(record);
    }
}
