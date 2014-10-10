/**  
* @Title:  PersonArticleRelServiceImpl.java
* @Package com.wugu.ycyp.service.impl
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
package com.wugu.ycyp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.ycyp.dao.PersonArticleRelMapper;
import com.wugu.ycyp.entity.PersonArticleRel;
import com.wugu.ycyp.entity.PersonArticleRelExample;
import com.wugu.ycyp.service.PersonArticleRelService;

/**
 * @ClassName: PersonArticleRelServiceImpl
 * @Description: 人物关联文章服务实现类
 * @author lijun
 * @date 2014-7-23 
 *
 */
@Service("personArticleRelService")
public class PersonArticleRelServiceImpl implements PersonArticleRelService
{
    @Autowired
    private PersonArticleRelMapper personArticleRelMapper;
    
    /* (非 Javadoc)
     * <p>Title: getList</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.PersonArticleRelService#getArticleTagList(com.wugu.ycyp.entity.PersonArticleRelExample)
     */
    @Override
    public List<PersonArticleRel> getList(
            PersonArticleRelExample example) throws SQLException
    {
        return personArticleRelMapper.selectByExample(example);
    }

    /* (非 Javadoc)
     * <p>Title: insert</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.PersonArticleRelService#insert(com.wugu.ycyp.entity.PersonArticleRel)
     */
    @Override
    public int insert(PersonArticleRel record) throws SQLException
    {
        return personArticleRelMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: update</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.PersonArticleRelService#update(com.wugu.ycyp.entity.PersonArticleRel)
     */
    @Override
    public int update(PersonArticleRel record) throws SQLException
    {
        return personArticleRelMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: delete</p>
     * <p>Description: </p>
     * @param id
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.PersonArticleRelService#delete(java.lang.Long)
     */
    @Override
    public int delete(Long id) throws SQLException
    {
        return personArticleRelMapper.deleteByPrimaryKey(id);
    }

}
