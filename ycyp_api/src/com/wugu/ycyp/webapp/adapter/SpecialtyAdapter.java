/**  
* @Title:  SpecialAdapter.java
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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.Article;
import com.wugu.ycyp.entity.Specialty;
import com.wugu.ycyp.entity.SpecialtyExample;
import com.wugu.ycyp.entity.page.PageInfo;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.SpecialtyService;
import com.wugu.ycyp.webapp.model.SpecialtyModel;

/**
 * @ClassName: SpecialAdapter
 * @Description: 特产适配器
 * @author lijun
 * @date 2014-7-22 
 *
 */
@Component
public class SpecialtyAdapter extends BaseAdapter
{
    @Autowired
    private SpecialtyService specialtyService;
    
    /**
     * 
    * @Title: getList
    * @Description: 获取特产
    * @author lijun
    * @param json
    * @return
    * @throws Exception
    * @throws
     */
    public String getList(String json) throws Exception{
        SpecialtyModel model = getModelFromJson(json, SpecialtyModel.class);
        SpecialtyExample example = new SpecialtyExample();
        
        SpecialtyExample.Criteria criteria = example.createCriteria();
        
        example.setPageInfo(new PageInfo());
        iniPageInfo(example.getPageInfo(), json);
        setStatusGeneralCondition(criteria);
        iniBaseCondition(criteria, json);
        
        if (model.getAreaId() != null)
            criteria.andAreaIdEqualTo(model.getAreaId());
        if (model.getCategoryId() != null)
            criteria.andCategoryIdEqualTo(model.getCategoryId());
        
        example.setOrderByClause("create_time desc");
        
        PageWraper pw = specialtyService.getSpecialtyList(example);
        
        return getJsonByPageWraper(pw);
        
    }
    
    /**
     * 
    * @Title: getRecycleList
    * @Description: 获取回收站列表
    * @author lijun
    * @param json
    * @return
    * @throws Exception
    * @throws
     */
    public String getRecycleList(String json) throws Exception{
        SpecialtyModel model = getModelFromJson(json, SpecialtyModel.class);
        SpecialtyExample example = new SpecialtyExample();
        
        SpecialtyExample.Criteria criteria = example.createCriteria();
        
        example.setPageInfo(new PageInfo());
        iniPageInfo(example.getPageInfo(), json);
        setStatusRecycleCondition(criteria);
        
        if (model.getAreaId() != null)
            criteria.andAreaIdEqualTo(model.getAreaId());
        if (model.getCategoryId() != null)
            criteria.andCategoryIdEqualTo(model.getCategoryId());
        
        example.setOrderByClause("update_time desc");
        
        PageWraper pw = specialtyService.getSpecialtyList(example);
        
        return getJsonByPageWraper(pw);
        
    }
    /**
     * 
    * @Title: insert
    * @Description: 添加特产
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(String json) throws SQLException{
        Specialty specialty = getModelFromJson(json, Specialty.class);
        return specialtyService.insert(specialty);
    }
    
    /**
     * 
    * @Title: update
    * @Description: 修改特产
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer update(String json) throws SQLException{
        Specialty specialty = getModelFromJson(json, Specialty.class);
        return specialtyService.update(specialty);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 删除特产-移到垃圾箱
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer recycle(Long id) throws SQLException{
        Specialty specialty = new Specialty();
        specialty.setId(id);
        setStatusRecycle(specialty);
        return specialtyService.update(specialty);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 彻底删除特产
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer delete(Long id) throws SQLException{
        Specialty specialty = new Specialty();
        specialty.setId(id);
        setStatusDeleted(specialty);
        return specialtyService.update(specialty);
    }
    
    /**
     * 
    * @Title: restore
    * @Description: 恢复特产
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer restore(Long id) throws SQLException{
        Specialty specialty = new Specialty();
        specialty.setId(id);
        setStatusGeneral(specialty);
        return specialtyService.update(specialty);
    }
    /**
     * 
    * @Title: getSpecialty
    * @Description: 获取特产详情
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Specialty getSpecialty(Long id) throws SQLException{
        SpecialtyExample example = new SpecialtyExample();
        SpecialtyExample.Criteria criteria = example.createCriteria();
        
        criteria.andIdEqualTo(id);
        setStatusGeneralCondition(criteria);
        List<Specialty> list = specialtyService.getList(example);
        if (list != null && list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
