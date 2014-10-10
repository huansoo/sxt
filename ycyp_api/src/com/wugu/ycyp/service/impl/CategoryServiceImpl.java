/**  
* @Title:  CategoryServiceImpl.java
* @Package com.wugu.ycyp.service.impl
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
package com.wugu.ycyp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.ycyp.dao.CategoryMapper;
import com.wugu.ycyp.entity.Category;
import com.wugu.ycyp.entity.CategoryExample;
import com.wugu.ycyp.service.CategoryService;

/**
 * @ClassName: CategoryServiceImpl
 * @Description: 特产分类服务实现类
 * @author lijun
 * @date 2014-7-22 
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryMapper categoryMapper;
    /* (非 Javadoc)
     * <p>Title: getList</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.CategoryService#getList(com.wugu.ycyp.entity.CategoryExample)
     */
    @Override
    public List<Category> getList(CategoryExample example) throws SQLException
    {
        return categoryMapper.selectByExample(example);
    }

    /* (非 Javadoc)
     * <p>Title: insert</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.CategoryService#insert(com.wugu.ycyp.entity.Category)
     */
    @Override
    public int insert(Category record) throws SQLException
    {
        return categoryMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: update</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.CategoryService#update(com.wugu.ycyp.entity.Category)
     */
    @Override
    public int update(Category record) throws SQLException
    {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

}
