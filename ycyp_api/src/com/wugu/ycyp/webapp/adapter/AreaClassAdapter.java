/**  
* @Title:  AreaClassAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
* @Description: 区域分类适配器
* @author lijun
* @date  2014-7-18 
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

import com.wugu.ycyp.entity.AreaClass;
import com.wugu.ycyp.entity.AreaClassExample;
import com.wugu.ycyp.entity.page.PageInfo;
import com.wugu.ycyp.service.AreaClassService;
import com.wugu.ycyp.util.ConstantUtil;
import com.wugu.ycyp.util.JsonUtil;
import com.wugu.ycyp.webapp.model.AreaClassModel;

/**
 * @ClassName: AreaClassAdapter
 * @Description: 区域分类适配器
 * @author lijun
 * @date 2014-7-18 
 *
 */
@Component
public class AreaClassAdapter extends BaseAdapter
{
    @Autowired
    private AreaClassService areaClassService;
    
    private List<AreaClass> getList(AreaClassModel model, String json) throws Exception{
        AreaClassExample example = new AreaClassExample();
        AreaClassExample.Criteria criteria = example.createCriteria();
        
        if (model.getId() != null)
            criteria.andIdEqualTo(model.getId());
        if (model.getParentId() != null)
            criteria.andParentIdEqualTo(model.getParentId());
        if (model.getId() == null && model.getParentId() == null){
            if (json != null){
                example.setPageInfo(new PageInfo());
                iniPageInfo(example.getPageInfo(), json);
            }
        }
        
        example.setOrderByClause("update_time desc");
        
        if (json != null)
            iniBaseCondition(criteria, json);
        else
        	setStatusGeneralCondition(criteria);//设置查询时status字段的值
        
        return areaClassService.getList(example);
        
    }
    /**
     * 
    * @Title: getList
    * @Description: 获取区域分类列表
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public List<AreaClass> getList(String json) throws Exception{
    	//将json字符串转化为实体
        AreaClassModel model = getModelFromJson(json, AreaClassModel.class);
        return getList(model, json);
    }
    
    /**
     * 
    * @Title: getListString
    * @Description: 获取区域列表json字符串
    * @author lijun
    * @param list
    * @return
    * @throws SQLException
    * @throws
     */
    public String getListString(String json) throws Exception{
        List<AreaClass> list = getList(json);
        return JsonUtil.beanListToJsonArray(list);
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 添加地区分类
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(String json) throws SQLException{
        AreaClass areaClass = getModelFromJson(json, AreaClass.class);
        //如果父节点为空，则赋值为默认父节点0
        if (areaClass.getParentId() == null)
            areaClass.setParentId(ConstantUtil.AREACLASS_FIRSTLEVEL_PARENTID);
        return areaClassService.insert(areaClass);
    }
    
    /**
     * 
    * @Title: update
    * @Description: 修改地区
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer update(String json) throws SQLException{
        AreaClass areaClass = getModelFromJson(json, AreaClass.class);
        return areaClassService.update(areaClass);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 删除地区-移到垃圾箱
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer recycle(Long id) throws SQLException{
        AreaClass areaClass = new AreaClass();
        areaClass.setId(id);
        setStatusRecycle(areaClass);
        return areaClassService.update(areaClass);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 彻底删除地区
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer delete(Long id) throws SQLException{
        AreaClass areaClass = new AreaClass();
        areaClass.setId(id);
        setStatusDeleted(areaClass);
        return areaClassService.update(areaClass);
    }
    
    /**
     * 
    * @Title: getAreaClass
    * @Description: 获取地区分类详情
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public AreaClass getAreaClass(Long id) throws Exception{
        AreaClassModel model = new AreaClassModel();
        model.setId(id.longValue());
        List<AreaClass> list = getList(model, null);
        
        if (list != null && list.size() > 0)
            return list.get(0);
        else 
            return null;
        
    }
    
    private List<AreaClass> getListByParentId(Long parentId) throws Exception{
        AreaClassModel model = new AreaClassModel();
        model.setParentId(parentId);
        return getList(model, null);
    }    
    
    /**
     * 
    * @Title: getListByParentId
    * @Description: 根据父节点获取区域分类列表
    * @author lijun
    * @param parentId
    * @return
    * @throws SQLException
    * @throws
     */
    public String getListJsonByParentId(Long parentId) throws Exception{
        List<AreaClass> list = getListByParentId(parentId);
        return JsonUtil.beanListToJsonArray(list);
    }
    
    /**
     * 
    * @Title: getProvinceList
    * @Description: 获取省份列表
    * @author lijun
    * @return
    * @throws Exception
    * @throws
     */
    public String getProvinceList() throws Exception{
        return getListJsonByParentId(ConstantUtil.AREACLASS_FIRSTLEVEL_PARENTID);
    }
    
    private List<AreaClass> getParentPath(Long id, 
            List<AreaClass> list) throws Exception{
        List<AreaClass> result = list;
        
        AreaClass areaClass = getAreaClass(id);
        if (areaClass != null)
            result.add(0, areaClass);
        else 
            return result;
        
        if (areaClass.getParentId() != ConstantUtil.AREACLASS_FIRSTLEVEL_PARENTID){
            return getParentPath(areaClass.getParentId(), result);
        }
        return result;
    }
    
    /**
     * 
    * @Title: getPath
    * @Description: 获取区域分类路径 省->市->区->街道（镇）->村
    * @author lijun
    * @param id
    * @return
    * @throws Exception
    * @throws
     */
    public String getPath(Long id) throws Exception{
        String path = "";
        List<AreaClass> list = new ArrayList<AreaClass>();
        
        list = getParentPath(id, list);
        
        path = JsonUtil.beanListToJsonArray(list);
        return path;
    }
}
