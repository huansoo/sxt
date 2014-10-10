/**  
* @Title:  AreaAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
* @Description: 区域服务适配器
* @author lijun
* @date  2014-7-17 
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

import com.wugu.ycyp.entity.Area;
import com.wugu.ycyp.entity.AreaExample;
import com.wugu.ycyp.entity.Specialty;
import com.wugu.ycyp.entity.page.PageInfo;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.AreaService;
import com.wugu.ycyp.webapp.model.AreaModel;

/**
 * @ClassName: AreaAdapter
 * @Description: 区域服务适配器
 * @author lijun
 * @date 2014-7-17 
 *
 */
@Component
public class AreaAdapter extends BaseAdapter
{
    @Autowired
    private AreaService areaService;
    
    /**
     * 
    * @Title: getList
    * @Description: 获取区域
    * @author lijun
    * @param json
    * @return
    * @throws Exception
    * @throws
     */
    public String getList(String json) throws Exception{
        AreaModel model = getModelFromJson(json, AreaModel.class);
        AreaExample example = new AreaExample();
        
        AreaExample.Criteria criteria = example.createCriteria();
        
        example.setPageInfo(new PageInfo());
        iniPageInfo(example.getPageInfo(), json);
        setStatusGeneralCondition(criteria);
        iniBaseCondition(criteria, json);
        example.setOrderByClause("create_time desc");
        
        if (model.getClassId() != null)
            criteria.andClassIdEqualTo(model.getClassId());
        
        PageWraper pw = areaService.getAreaList(example);
        
        return getJsonByPageWraper(pw);
        
    }
    
    /**
     * 
    * @Title: getRecyleList
    * @Description: 获取区域
    * @author lijun
    * @param json
    * @return
    * @throws Exception
    * @throws
     */
    public String getRecycleList(String json) throws Exception{
        AreaModel model = getModelFromJson(json, AreaModel.class);
        AreaExample example = new AreaExample();
        
        AreaExample.Criteria criteria = example.createCriteria();
        
        example.setPageInfo(new PageInfo());
        iniPageInfo(example.getPageInfo(), json);
        setStatusRecycleCondition(criteria);
        
        if (model.getClassId() != null)
            criteria.andClassIdEqualTo(model.getClassId());
        
        example.setOrderByClause("update_time desc");
        
        PageWraper pw = areaService.getAreaList(example);
        
        return getJsonByPageWraper(pw);
        
    }
    /**
     * 
    * @Title: insert
    * @Description: 添加地区
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(String json) throws SQLException{
        Area area = getModelFromJson(json, Area.class);
        return areaService.insert(area);
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
        Area area = getModelFromJson(json, Area.class);
        return areaService.update(area);
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
        Area area = new Area();
        area.setId(id);
        setStatusRecycle(area);
        return areaService.update(area);
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
        Area area = new Area();
        area.setId(id);
        setStatusDeleted(area);
        return areaService.update(area);
    }
    
    /**
     * 
    * @Title: restore
    * @Description: 恢复乡村
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer restore(Long id) throws SQLException{
        Area area = new Area();
        area.setId(id);
        setStatusGeneral(area);
        return areaService.update(area);
    }
    /**
     * 
    * @Title: getArea
    * @Description: 获取地区详情
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Area getArea(Long id) throws SQLException{
        AreaExample example = new AreaExample();
        AreaExample.Criteria criteria = example.createCriteria();
        
        criteria.andIdEqualTo(id);
        setStatusGeneralCondition(criteria);
        List<Area> list = areaService.getList(example);
        if (list != null && list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
