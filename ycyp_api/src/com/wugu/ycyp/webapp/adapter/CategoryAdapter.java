/**  
* @Title:  CategoryAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
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
package com.wugu.ycyp.webapp.adapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.Category;
import com.wugu.ycyp.entity.CategoryExample;
import com.wugu.ycyp.service.CategoryService;
import com.wugu.ycyp.util.ConstantUtil;
import com.wugu.ycyp.util.JsonUtil;
import com.wugu.ycyp.webapp.model.CategoryModel;

/**
 * @ClassName: CategoryAdapter
 * @Description: 特产分类适配器
 * @author lijun
 * @date 2014-7-22 
 *
 */
@Component
public class CategoryAdapter extends BaseAdapter
{
    @Autowired
    private CategoryService categoryService;
    
    private List<Category> getList(CategoryModel model) throws Exception{
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        
        if (model.getId() != null)
            criteria.andIdEqualTo(model.getId());
        if (model.getParentId() != null)
            criteria.andParentIdEqualTo(model.getParentId());
        
        if (model.getId() == null && model.getParentId() == null){
            if (model.getPage() == null && model.getPageSize() == null){
                throw new Exception("请传入分页信息！");
            }
        }
        
        example.setOrderByClause("update_time desc");
        setStatusGeneralCondition(criteria);
        
        return categoryService.getList(example);
        
    }
    /**
     * 
    * @Title: getList
    * @Description: 获取特产分类列表
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public List<Category> getList(String json) throws Exception{
        CategoryModel model = getModelFromJson(json, CategoryModel.class);
        return getList(model);
    }
    
    /**
     * 
    * @Title: getListString
    * @Description: 获取特产分类列表json字符串
    * @author lijun
    * @param list
    * @return
    * @throws SQLException
    * @throws
     */
    public String getListString(String json) throws Exception{
        List<Category> list = getList(json);
        return JsonUtil.beanListToJsonArray(list);
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 添加分类
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(String json) throws SQLException{
        Category category = getModelFromJson(json, Category.class);
        //如果父节点为空，则赋值为默认父节点0
        if (category.getParentId() == null)
            category.setParentId(ConstantUtil.CATEGORY_FIRSTLEVEL_PARENTID);
        return categoryService.insert(category);
    }
    
    /**
     * 
    * @Title: update
    * @Description: 修改分类
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer update(String json) throws SQLException{
        Category areaClass = getModelFromJson(json, Category.class);
        return categoryService.update(areaClass);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 删除分类-移到垃圾箱
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer recycle(Long id) throws SQLException{
        Category areaClass = new Category();
        areaClass.setId(id);
        setStatusRecycle(areaClass);
        return categoryService.update(areaClass);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 彻底删除分类
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer delete(Long id) throws SQLException{
        Category areaClass = new Category();
        areaClass.setId(id);
        setStatusDeleted(areaClass);
        return categoryService.update(areaClass);
    }
    
    /**
     * 
    * @Title: getCategory
    * @Description: 获取特产分类详情
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Category getCategory(Long id) throws Exception{
        CategoryModel model = new CategoryModel();
        model.setId(id);
        List<Category> list = getList(model);
        
        if (list != null && list.size() > 0)
            return list.get(0);
        else 
            return null;
        
    }
    
    private List<Category> getListByParentId(Long parentId) throws Exception{
        CategoryModel model = new CategoryModel();
        model.setParentId(parentId);
        return getList(model);
    }    
    
    /**
     * 
    * @Title: getListByParentId
    * @Description: 根据父节点获取特产分类列表
    * @author lijun
    * @param parentId
    * @return
    * @throws SQLException
    * @throws
     */
    public String getListJsonByParentId(Long parentId) throws Exception{
        List<Category> list = getListByParentId(parentId);
        return JsonUtil.beanListToJsonArray(list);
    }
    
    /**
     * 
    * @Title: getFirstClassList
    * @Description: 获取省份列表
    * @author lijun
    * @return
    * @throws Exception
    * @throws
     */
    public String getFirstClassList() throws Exception{
        return getListJsonByParentId(ConstantUtil.CATEGORY_FIRSTLEVEL_PARENTID);
    }
    
    private List<Category> getParentPath(Long id, 
            List<Category> list) throws Exception{
        List<Category> result = list;
        
        Category category = getCategory(id);
        if (category != null)
            result.add(0, category);
        else 
            return result;
        if (category.getParentId() != ConstantUtil.CATEGORY_FIRSTLEVEL_PARENTID){
            return getParentPath(category.getParentId(), result);
        }
        return result;
    }
    
    /**
     * 
    * @Title: getPath
    * @Description: 获取特产分类路径
    * @author lijun
    * @param id
    * @return
    * @throws Exception
    * @throws
     */
    public String getPath(Long id) throws Exception{
        String path = "";
        List<Category> list = new ArrayList<Category>();
        
        list = getParentPath(id, list);
        
        path = JsonUtil.beanListToJsonArray(list);
        return path;
    }
}
