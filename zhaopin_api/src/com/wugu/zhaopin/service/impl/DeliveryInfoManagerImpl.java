package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.ZpDeliveryInfoDAO;
import com.wugu.zhaopin.service.DeliveryInfoManager;
import com.wugu.zhaopin.vo.ZpDeliveryInfo;
import com.wugu.zhaopin.vo.ZpDeliveryInfoCriteria;
import com.wugu.zhaopin.webapp.model.DeliveryInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;
/**
 * 
* @ClassName: DeliveryInfoManagerImpl
* @Description: 简历投递情况服务实现
* @author lijun
* @date 2013-12-25 下午1:09:30
*
 */
public class DeliveryInfoManagerImpl implements DeliveryInfoManager
{
    private ZpDeliveryInfoDAO deliveryinfodao;
    
    public ZpDeliveryInfoDAO getDeliveryinfodao() {
        return deliveryinfodao;
    }

    public void setDeliveryinfodao(ZpDeliveryInfoDAO DeliveryInfodao) {
        this.deliveryinfodao = DeliveryInfodao;
    }

    @Override
    public int countByExample(ZpDeliveryInfoCriteria example) throws SQLException {
        return deliveryinfodao.countByExample(example);
    }

    @Override
    public int deleteByExample(ZpDeliveryInfoCriteria example)
            throws SQLException {
        return deliveryinfodao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long resumeId) throws SQLException {
        return deliveryinfodao.deleteByPrimaryKey(resumeId);
    }

    @Override
    public Long insert(ZpDeliveryInfo record) throws SQLException {
        return deliveryinfodao.insert(record);
    }

    @Override
    public Long insertSelective(ZpDeliveryInfo record) throws SQLException {
        return deliveryinfodao.insertSelective(record);
    }

    @Override
    public List<ZpDeliveryInfo> selectByExample(ZpDeliveryInfoCriteria example)
            throws SQLException {
        return deliveryinfodao.selectByExample(example);
    }

    @Override
    public ZpDeliveryInfo selectByPrimaryKey(Long resumeId) throws SQLException {
        return deliveryinfodao.selectByPrimaryKey(resumeId);
    }

    @Override
    public int updateByExampleSelective(ZpDeliveryInfo record,
            ZpDeliveryInfoCriteria example) throws SQLException {
        return deliveryinfodao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ZpDeliveryInfo record, ZpDeliveryInfoCriteria example)
            throws SQLException {
        return deliveryinfodao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZpDeliveryInfo record)
            throws SQLException {
        return deliveryinfodao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZpDeliveryInfo record) throws SQLException {
        return deliveryinfodao.updateByPrimaryKey(record);
    }

    /* (非 Javadoc)
    * <p>Title: selectBypage</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.DeliveryInfoManager#selectBypage(com.wugu.zhaopin.webapp.model.DeliveryInfoCriteria)
    */
    @Override
    public PageWraper selectByPage(DeliveryInfoCriteria example)
            throws SQLException
    {
        return deliveryinfodao.selectByPage(example);
    }

}
