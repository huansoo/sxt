/**  
* @Title:  CategoryService.java
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

import com.wugu.ycyp.entity.Category;
import com.wugu.ycyp.entity.CategoryExample;

/**
 * @ClassName: CategoryService
 * @Description: 特产分类服务接口
 * @author lijun
 * @date 2014-7-22 
 *
 */
public interface CategoryService
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
    List<Category> getList(CategoryExample example) throws SQLException;
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
    int insert(Category record) throws SQLException;
    
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
    int update(Category record) throws SQLException;
}
