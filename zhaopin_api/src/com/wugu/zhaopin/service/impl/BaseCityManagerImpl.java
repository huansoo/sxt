/**  
* @Title:  BaseCityManagerImpl.java
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

import com.wugu.zhaopin.dao.BaseCityDAO;
import com.wugu.zhaopin.service.BaseCityManager;
import com.wugu.zhaopin.vo.BaseCity;
import com.wugu.zhaopin.vo.BaseCityCriteria;

/**
 * @ClassName: BaseCityManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-7 
 *
 */
public class BaseCityManagerImpl implements BaseCityManager
{
    private BaseCityDAO basecitydao;
    
    public BaseCityDAO getBasecitydao() {
        return basecitydao;
    }

    public void setBasecitydao(BaseCityDAO basecitydao) {
        this.basecitydao = basecitydao;
    }

    @Override
    public int countByExample(BaseCityCriteria example) throws SQLException {
        return basecitydao.countByExample(example);
    }

    @Override
    public int deleteByExample(BaseCityCriteria example)
            throws SQLException {
        return basecitydao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(int cityId) throws SQLException {
        return basecitydao.deleteByPrimaryKey(cityId);
    }

    @Override
    public void insert(BaseCity record) throws SQLException {
        basecitydao.insert(record);
    }

    @Override
    public void insertSelective(BaseCity record) throws SQLException {
        basecitydao.insertSelective(record);
    }

    @Override
    public List<BaseCity> selectByExample(BaseCityCriteria example)
            throws SQLException {
        return basecitydao.selectByExample(example);
    }

    @Override
    public BaseCity selectByPrimaryKey(int cityId) throws SQLException {
        return basecitydao.selectByPrimaryKey(cityId);
    }

    @Override
    public int updateByExampleSelective(BaseCity record,
            BaseCityCriteria example) throws SQLException {
        return basecitydao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(BaseCity record, BaseCityCriteria example)
            throws SQLException {
        return basecitydao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseCity record)
            throws SQLException {
        return basecitydao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseCity record) throws SQLException {
        return basecitydao.updateByPrimaryKey(record);
    }
}
