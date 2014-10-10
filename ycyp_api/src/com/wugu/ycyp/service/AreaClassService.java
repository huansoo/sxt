/**  
* @Title:  AreaClassService.java
* @Package com.wugu.ycyp.service
* @Description: 地区分类服务
* @author lijun
* @date  2014-7-18 
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

import com.wugu.ycyp.entity.AreaClass;
import com.wugu.ycyp.entity.AreaClassExample;

/**
 * @ClassName: AreaClassService
 * @Description: 地区分类服务接口
 * @author lijun
 * @date 2014-7-18 
 *
 */
public interface AreaClassService
{
    /**
     * 
    * @Title: getList
    * @Description: 获取区域分类列表
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    List<AreaClass> getList(AreaClassExample example) throws SQLException;
    /**
     * 
    * @Title: insert
    * @Description: 添加区域分类
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int insert(AreaClass record) throws SQLException;
    
    /**
     * 
    * @Title: update
    * @Description: 修改区域分类
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int update(AreaClass record) throws SQLException;
}
