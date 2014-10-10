/**  
* @Title:  Specialty.java
* @Package com.wugu.ycyp.service
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-22 
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

import com.wugu.ycyp.entity.Specialty;
import com.wugu.ycyp.entity.SpecialtyExample;
import com.wugu.ycyp.entity.page.PageWraper;

/**
 * @ClassName: Specialty
 * @Description: 特产服务接口
 * @author lijun
 * @date 2014-7-22 
 *
 */
public interface SpecialtyService
{
    /**
     * 
    * @Title: getSpecialtyList
    * @Description: 获取特产列表（分页）
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    PageWraper getSpecialtyList(SpecialtyExample example) throws SQLException;
    /**
     * 
    * @Title: getList
    * @Description: 获取特产列表
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    List<Specialty> getList(SpecialtyExample example) throws SQLException;
    /**
     * 
    * @Title: insert
    * @Description: 添加特产
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int insert(Specialty record) throws SQLException;
    /**
     * 
    * @Title: update
    * @Description: 修改特产
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int update(Specialty record) throws SQLException;
}
