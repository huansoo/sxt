/**  
* @Title:  ArticleService.java
* @Package com.wugu.ycyp.service
* @Description: 新闻服务
* @author lijun
* @date  2014-7-10 
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

import com.wugu.ycyp.entity.Article;
import com.wugu.ycyp.entity.ArticleExample;
import com.wugu.ycyp.entity.page.PageWraper;

/**
 * @ClassName: ArticleService
 * @Description: 新闻服务类
 * @author lijun
 * @date 2014-7-10 
 *
 */
public interface ArticleService
{
    /**
     * 
    * @Title: getList
    * @Description: 获取新闻列表
    * @author lijun
    * @param example
    * @return 列表
    * @throws Exception
    * @throws
     */
    public PageWraper getList(ArticleExample example) throws SQLException;
    
    /**
     * 
    * @Title: insert
    * @Description: 新增新闻
    * @author lijun
    * @param article
    * @return 新闻ID
    * @throws Exception
    * @throws
     */
    public int insert(Article article) throws SQLException;
    
    /**
     * 
    * @Title: update
    * @Description: 修改新闻
    * @author lijun
    * @param article
    * @param example
    * @return 修改影响行数
    * @throws Exception
    * @throws
     */
    public int update(Article article) throws SQLException;
    /**
     * 
    * @Title: delete
    * @Description: 删除新闻
    * @author lijun
    * @param example
    * @return 删除行数
    * @throws SQLException
    * @throws
     */
    public int delete(ArticleExample example) throws SQLException;
    
    /**
     * 
    * @Title: getListWithText
    * @Description: 获取新闻内容
    * @author lijun
    * @param example
    * @return 返回新闻
    * @throws SQLException
    * @throws
     */
    public List<Article> getListWithContent(ArticleExample example) throws SQLException;
}
