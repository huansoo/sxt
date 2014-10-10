/**  
* @Title:  AreaService.java
* @Package com.wugu.ycyp.service
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-8 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.ycyp.entity.Area;
import com.wugu.ycyp.entity.AreaExample;
import com.wugu.ycyp.entity.page.PageWraper;

/**
 * @ClassName: AreaService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-7-8 
 *
 */
public interface AreaService
{
    /**
     * 
    * @Title: getAreaList
    * @Description: 分页查找并返回地区信息列表
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    PageWraper getAreaList(AreaExample example) throws SQLException;
    
    /**
     * 
    * @Title: insert
    * @Description: 添加地区
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int insert(Area record) throws SQLException;
    
    /**
     * 
    * @Title: update
    * @Description: 修改地区
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int update(Area record) throws SQLException;
    
    /**
     * 
    * @Title: getList
    * @Description: 不分页获取地区列表
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    List<Area> getList(AreaExample example) throws SQLException;
}
