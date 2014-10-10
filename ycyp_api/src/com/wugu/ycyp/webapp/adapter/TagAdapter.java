/**  
* @Title:  TagAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
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
package com.wugu.ycyp.webapp.adapter;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.Tag;
import com.wugu.ycyp.entity.TagExample;
import com.wugu.ycyp.entity.page.PageInfo;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.TagService;
import com.wugu.ycyp.webapp.model.BaseModel;

/**
 * @ClassName: TagAdapter
 * @Description: 标签适配器
 * @author lijun
 * @date 2014-7-16 
 *
 */
@Component
public class TagAdapter extends BaseAdapter
{
    @Autowired
    private TagService tagService;
    
    /**
     * 
    * @Title: getList
    * @Description: 获取标签列表
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public String getList(String json) throws SQLException{
        BaseModel model = getModelFromJson(json, BaseModel.class);
        TagExample example = new TagExample();
        TagExample.Criteria criteria = example.createCriteria();
        example.setPageInfo(new PageInfo());
        iniPageInfo(example.getPageInfo(), json);
        setStatusGeneralCondition(criteria);
        iniBaseCondition(criteria, model);
        
        example.setOrderByClause("update_time desc");
        
        PageWraper pw = tagService.getList(example);
        
        try
        {
            return getJsonByPageWraper(pw);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
        catch (Exception ee){
            ee.printStackTrace();
        }
        return null;
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增标签
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(String json) throws SQLException{
        Tag tag = getModelFromJson(json, Tag.class);
        return tagService.insert(tag);
    }
    
    /**
     * 
    * @Title: update
    * @Description: 修改标签
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer update(String json) throws SQLException{
        Tag tag = getModelFromJson(json, Tag.class);
        return tagService.update(tag);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 删除标签-移到垃圾箱
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer recycle(Long id) throws SQLException{
        Tag tag = new Tag();
        tag.setId(id);
        setStatusRecycle(tag);
        return tagService.update(tag);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 彻底删除标签
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer delete(Long id) throws SQLException{
        Tag tag = new Tag();
        tag.setId(id);
        setStatusDeleted(tag);
        return tagService.update(tag);
    }
    
    /**
     * 
    * @Title: getTag
    * @Description: 获取标签详情
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Tag getTag(Long id) throws SQLException{
        TagExample example = new TagExample();
        TagExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        setStatusGeneralCondition(criteria);
        
        List<Tag> list = tagService.getListTag(example);
        if (list != null && list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
