/**  
* @Title:  TagServiceImpl.java
* @Package com.wugu.ycyp.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-16 
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

import com.wugu.ycyp.dao.TagMapper;
import com.wugu.ycyp.entity.Tag;
import com.wugu.ycyp.entity.TagExample;
import com.wugu.ycyp.entity.page.PageManager;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.TagService;

/**
 * @ClassName: TagServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-7-16 
 *
 */
@Service("tagService")
public class TagServiceImpl implements TagService
{

    @Autowired
    TagMapper tagMapper;
    /* (非 Javadoc)
    * <p>Title: getList</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.TagService#getList(com.wugu.ycyp.entity.TagExample)
    */
    @Override
    public PageWraper getList(TagExample example) throws SQLException
    {
        PageWraper pw = null;
        int count = tagMapper.countByExample(example); 
        
        List<Tag> list = tagMapper.selectByExample(example);
        pw = PageManager.getPageWraper(example.getPageInfo(), list, count);
        
        return pw;
    }

    /* (非 Javadoc)
    * <p>Title: insert</p>
    * <p>Description: </p>
    * @param record
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.TagService#insert(com.wugu.ycyp.entity.Tag)
    */
    @Override
    public int insert(Tag record) throws SQLException
    {
        return tagMapper.insertSelective(record);
    }

    /* (非 Javadoc)
    * <p>Title: update</p>
    * <p>Description: </p>
    * @param record
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.TagService#update(com.wugu.ycyp.entity.Tag)
    */
    @Override
    public int update(Tag record) throws SQLException
    {
        return tagMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
    * <p>Title: delete</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.TagService#delete(com.wugu.ycyp.entity.TagExample)
    */
    @Override
    public int delete(Long id) throws SQLException
    {
        return tagMapper.deleteByPrimaryKey(id);
    }

    /* (非 Javadoc)
    * <p>Title: getListTag</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.TagService#getListTag(com.wugu.ycyp.entity.TagExample)
    */
    @Override
    public List<Tag> getListTag(TagExample example) throws SQLException
    {
        return tagMapper.selectByExample(example);
    }

 

}
