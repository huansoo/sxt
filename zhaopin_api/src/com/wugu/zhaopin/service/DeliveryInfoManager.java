/**  
* @Title:  DeliveryInfoManager.java
* @Package com.wugu.zhaopin.service
* @Description: TODO(用一句话描述该文件做什么)
* @author Dangzhang
* @date  2013-12-25 下午1:03:58
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

import com.wugu.zhaopin.vo.ZpDeliveryInfo;
import com.wugu.zhaopin.vo.ZpDeliveryInfoCriteria;
import com.wugu.zhaopin.webapp.model.DeliveryInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

/**
 * @ClassName: DeliveryInfoManager
 * @Description: 简历投递信息服务
 * @author lijun
 * @date 2013-12-25 下午1:03:58
 *
 */
public interface DeliveryInfoManager
{
    int countByExample(ZpDeliveryInfoCriteria example) throws SQLException;

    int deleteByExample(ZpDeliveryInfoCriteria example) throws SQLException;

    int deleteByPrimaryKey(Long deliveryInfoId) throws SQLException;

    Long insert(ZpDeliveryInfo record) throws SQLException;

    Long insertSelective(ZpDeliveryInfo record) throws SQLException;

    List<ZpDeliveryInfo> selectByExample(ZpDeliveryInfoCriteria example)
            throws SQLException;

    ZpDeliveryInfo selectByPrimaryKey(Long resumeId) throws SQLException;

    int updateByExampleSelective(ZpDeliveryInfo record,
            ZpDeliveryInfoCriteria example) throws SQLException;

    int updateByExample(ZpDeliveryInfo record, ZpDeliveryInfoCriteria example)
            throws SQLException;

    int updateByPrimaryKeySelective(ZpDeliveryInfo record) throws SQLException;

    int updateByPrimaryKey(ZpDeliveryInfo record) throws SQLException;
    
    PageWraper selectByPage(DeliveryInfoCriteria example) throws SQLException;
}
