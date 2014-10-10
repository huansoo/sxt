/**  
* @Title:  ArticleServiceImpl.java
* @Package com.wugu.ycyp.service.impl
* @Description: TODO(用一句话描述该文件做什么)
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
package com.wugu.ycyp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.ycyp.dao.ArticleMapper;
import com.wugu.ycyp.entity.Article;
import com.wugu.ycyp.entity.ArticleExample;
import com.wugu.ycyp.entity.page.PageManager;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.ArticleService;

/**
 * @ClassName: ArticleServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-7-10 
 *
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService
{
    @Autowired
    private ArticleMapper articleMapper;
    
    /* (非 Javadoc)
     * <p>Title: getList</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws Exception
     * @see com.wugu.ycyp.service.ArticleService#getList(com.wugu.ycyp.entity.ArticleExample)
     */
    @Override
    public PageWraper getList(ArticleExample example) throws SQLException
    {
        PageWraper pw = null;
        
        int count = articleMapper.countByExample(example);        
        List<Article> list = articleMapper.selectByExample(example);        
        pw = PageManager.getPageWraper(example.getPageInfo(), list, count);
        
        return pw;
    }

    /* (非 Javadoc)
     * <p>Title: insert</p>
     * <p>Description: </p>
     * @param article
     * @return
     * @throws Exception
     * @see com.wugu.ycyp.service.ArticleService#insert(com.wugu.ycyp.entity.Article)
     */
    @Override
    public int insert(Article record) throws SQLException
    {
        return articleMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: update</p>
     * <p>Description: </p>
     * @param article
     * @param example
     * @return
     * @throws Exception
     * @see com.wugu.ycyp.service.ArticleService#update(com.wugu.ycyp.entity.Article, com.wugu.ycyp.entity.ArticleExample)
     */
    @Override
    public int update(Article record) throws SQLException
    {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: delete</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws Exception
     * @see com.wugu.ycyp.service.ArticleService#delete(com.wugu.ycyp.entity.ArticleExample)
     */
    @Override
    public int delete(ArticleExample example) throws SQLException
    {
        return articleMapper.deleteByExample(example);
    }

    /* (非 Javadoc)
     * <p>Title: getListWithText</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws Exception
     * @see com.wugu.ycyp.service.ArticleService#getListWithText(com.wugu.ycyp.entity.ArticleExample)
     */
    @Override
    public List<Article> getListWithContent(ArticleExample example)
            throws SQLException
    {
        return articleMapper.selectByExampleWithBLOBs(example);
    }

}
