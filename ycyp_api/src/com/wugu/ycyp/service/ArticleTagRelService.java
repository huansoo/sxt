/**  
* @Title:  ArticleTagRelService.java
* @Package com.wugu.ycyp.service
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-11 
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

import com.wugu.ycyp.entity.ArticleTagRel;
import com.wugu.ycyp.entity.ArticleTagRelExample;

/**
 * @ClassName: ArticleTagRelService
 * @Description: 文章标签关联服务
 * @author lijun
 * @date 2014-7-11 
 *
 */
public interface ArticleTagRelService
{
    /**
     * 
    * @Title: getArticleTagList
    * @Description: 获取文章标签关联列表
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    List<ArticleTagRel> getArticleTagList(ArticleTagRelExample example) throws SQLException;
    
    /**
     * 
    * @Title: insert
    * @Description: 新增文章关联标签
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int insert(ArticleTagRel record) throws SQLException;
    
    /**
     * 
    * @Title: update
    * @Description: 修改文章关联标签
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int update(ArticleTagRel record) throws SQLException;
    
    /**
     * 
    * @Title: delete
    * @Description: 删除文章关联标签
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    int delete(Long id) throws SQLException;
}
