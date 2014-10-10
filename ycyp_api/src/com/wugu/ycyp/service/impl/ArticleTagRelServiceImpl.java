/**  
* @Title:  ArticleTagRelServiceImpl.java
* @Package com.wugu.ycyp.service.impl
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
package com.wugu.ycyp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.ycyp.dao.ArticleTagRelMapper;
import com.wugu.ycyp.entity.ArticleTagRel;
import com.wugu.ycyp.entity.ArticleTagRelExample;
import com.wugu.ycyp.service.ArticleTagRelService;

/**
 * @ClassName: ArticleTagRelServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-7-11 
 *
 */
@Service("articleTagRelService")
public class ArticleTagRelServiceImpl implements ArticleTagRelService
{
    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;
    /* (非 Javadoc)
     * <p>Title: getArticleTagList</p>
     * <p>Description: </p>
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.ArticleTagRelService#getArticleTagList()
     */
    @Override
    public List<ArticleTagRel> getArticleTagList(ArticleTagRelExample example) 
            throws SQLException
    {
        return articleTagRelMapper.selectByExample(example);
    }

    /* (非 Javadoc)
     * <p>Title: insert</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.ArticleTagRelService#insert(com.wugu.ycyp.entity.ArticleTagRel)
     */
    @Override
    public int insert(ArticleTagRel record) throws SQLException
    {
        return articleTagRelMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: update</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.ArticleTagRelService#update(com.wugu.ycyp.entity.ArticleTagRel)
     */
    @Override
    public int update(ArticleTagRel record) throws SQLException
    {
        return articleTagRelMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: delete</p>
     * <p>Description: </p>
     * @param id
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.ArticleTagRelService#delete(int)
     */
    @Override
    public int delete(Long id) throws SQLException
    {
        return articleTagRelMapper.deleteByPrimaryKey(id);
    }

}
