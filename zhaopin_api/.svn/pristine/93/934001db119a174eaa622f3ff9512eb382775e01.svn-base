/**  
* @Title:  BaseAreaManagerImpl.java
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

import com.wugu.zhaopin.dao.BaseAreaDAO;
import com.wugu.zhaopin.service.BaseAreaManager;
import com.wugu.zhaopin.vo.BaseArea;
import com.wugu.zhaopin.vo.BaseAreaCriteria;

/**
 * @ClassName: BaseAreaManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-7 
 *
 */
public class BaseAreaManagerImpl implements BaseAreaManager
{
    private BaseAreaDAO baseareadao;
    
    public BaseAreaDAO getBaseareadao() {
        return baseareadao;
    }

    public void setBaseareadao(BaseAreaDAO baseareadao) {
        this.baseareadao = baseareadao;
    }

    @Override
    public int countByExample(BaseAreaCriteria example) throws SQLException {
        return baseareadao.countByExample(example);
    }

    @Override
    public int deleteByExample(BaseAreaCriteria example)
            throws SQLException {
        return baseareadao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(int areaID) throws SQLException {
        return baseareadao.deleteByPrimaryKey(areaID);
    }

    @Override
    public void insert(BaseArea record) throws SQLException {
        baseareadao.insert(record);
    }

    @Override
    public void insertSelective(BaseArea record) throws SQLException {
        baseareadao.insertSelective(record);
    }

    @Override
    public List<BaseArea> selectByExample(BaseAreaCriteria example)
            throws SQLException {
        return baseareadao.selectByExample(example);
    }

    @Override
    public BaseArea selectByPrimaryKey(int areaID) throws SQLException {
        return baseareadao.selectByPrimaryKey(areaID);
    }

    @Override
    public int updateByExampleSelective(BaseArea record,
            BaseAreaCriteria example) throws SQLException {
        return baseareadao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(BaseArea record, BaseAreaCriteria example)
            throws SQLException {
        return baseareadao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseArea record)
            throws SQLException {
        return baseareadao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseArea record) throws SQLException {
        return baseareadao.updateByPrimaryKey(record);
    }
}
