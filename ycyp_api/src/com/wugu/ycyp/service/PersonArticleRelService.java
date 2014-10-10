/**  
* @Title:  PersonArticleRelService.java
* @Package com.wugu.ycyp.service
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-23 
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

import com.wugu.ycyp.entity.PersonArticleRel;
import com.wugu.ycyp.entity.PersonArticleRelExample;

/**
 * @ClassName: PersonArticleRelService
 * @Description: 人物关联文章服务接口
 * @author lijun
 * @date 2014-7-23 
 *
 */
public interface PersonArticleRelService
{
    /**
     * 
    * @Title: getArticleTagList
    * @Description: 获取人物关联文章列表
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    List<PersonArticleRel> getList(PersonArticleRelExample example) throws SQLException;
    
    /**
     * 
    * @Title: insert
    * @Description: 新增人物关联文章
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int insert(PersonArticleRel record) throws SQLException;
    
    /**
     * 
    * @Title: update
    * @Description: 修改人物关联文章
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int update(PersonArticleRel record) throws SQLException;
    
    /**
     * 
    * @Title: delete
    * @Description: 删除人物关联文章
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    int delete(Long id) throws SQLException;
}
