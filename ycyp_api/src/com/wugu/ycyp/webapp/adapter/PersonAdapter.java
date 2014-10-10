/**  
* @Title:  PersonAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
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
package com.wugu.ycyp.webapp.adapter;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.Area;
import com.wugu.ycyp.entity.AreaExample;
import com.wugu.ycyp.entity.Person;
import com.wugu.ycyp.entity.PersonExample;
import com.wugu.ycyp.entity.page.PageInfo;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.PersonService;
import com.wugu.ycyp.webapp.model.AreaModel;
import com.wugu.ycyp.webapp.model.PersonModel;

/**
 * @ClassName: PersonAdapter
 * @Description: 人物服务适配器
 * @author lijun
 * @date 2014-7-23 
 *
 */
@Component("personAdapter")
public class PersonAdapter extends BaseAdapter
{
    @Autowired
    private PersonService personService;
    
    /**
     * 
    * @Title: getList
    * @Description: 获取人物
    * @author lijun
    * @param json
    * @return
    * @throws Exception
    * @throws
     */
    public String getList(String json) throws Exception{
        PersonModel model = getModelFromJson(json, PersonModel.class);
        PersonExample example = new PersonExample();
        
        PersonExample.Criteria criteria = example.createCriteria();
        
        example.setPageInfo(new PageInfo());
        iniPageInfo(example.getPageInfo(), json);
        setStatusGeneralCondition(criteria);
        iniBaseCondition(criteria, json);
        
        if (model.getAreaId() != null)
            criteria.andAreaIdEqualTo(model.getAreaId());
        if (model.getUserId() != null)
            criteria.andUserIdEqualTo(model.getUserId());
        
        example.setOrderByClause("update_time desc");
        
        PageWraper pw = personService.getList(example);
        
        return getJsonByPageWraper(pw);
        
    }
    
    /**
     * 
    * @Title: getRecyleList
    * @Description: 获取回收站人物列表
    * @author lijun
    * @param json
    * @return
    * @throws Exception
    * @throws
     */
    public String getRecycleList(String json) throws Exception{
        PersonModel model = getModelFromJson(json, PersonModel.class);
        PersonExample example = new PersonExample();
        
        PersonExample.Criteria criteria = example.createCriteria();
        
        example.setPageInfo(new PageInfo());
        iniPageInfo(example.getPageInfo(), json);
        setStatusRecycleCondition(criteria);
        
        if (model.getAreaId() != null)
            criteria.andAreaIdEqualTo(model.getAreaId());
        if (model.getUserId() != null)
            criteria.andUserIdEqualTo(model.getUserId());
        
        example.setOrderByClause("update_time desc");
        
        PageWraper pw = personService.getList(example);
        
        return getJsonByPageWraper(pw);        
    }

    /**
     * 
    * @Title: insert
    * @Description: 添加人物
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(String json) throws SQLException{
        Person person = getModelFromJson(json, Person.class);
        return personService.insert(person);
    }
    
    /**
     * 
    * @Title: update
    * @Description: 修改人物
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer update(String json) throws SQLException{
        Person person = getModelFromJson(json, Person.class);
        return personService.update(person);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 删除人物-移到垃圾箱
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer recycle(Long id) throws SQLException{
        Person person = new Person();
        person.setId(id);
        setStatusRecycle(person);
        return personService.update(person);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 彻底删除人物
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer delete(Long id) throws SQLException{
        Person person = new Person();
        person.setId(id);
        setStatusDeleted(person);
        return personService.update(person);
    }
    
    /**
     * 
    * @Title: restore
    * @Description: 恢复人物
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer restore(Long id) throws SQLException{
        Person person = new Person();
        person.setId(id);
        setStatusGeneral(person);
        return personService.update(person);
    }

    /**
     * 
    * @Title: getPerson
    * @Description: 获取人物详情
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Person getPerson(Long id) throws SQLException{
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria();
        
        criteria.andIdEqualTo(id);
        setStatusGeneralCondition(criteria);
        List<Person> list = personService.getListWithContent(example);
        if (list != null && list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
