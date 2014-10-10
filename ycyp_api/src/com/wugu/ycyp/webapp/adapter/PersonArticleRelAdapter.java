/**  
* @Title:  PersonArticleRelAdapter.java
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

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.Person;
import com.wugu.ycyp.entity.PersonArticleRel;
import com.wugu.ycyp.entity.PersonArticleRelExample;
import com.wugu.ycyp.service.PersonArticleRelService;
import com.wugu.ycyp.webapp.model.PersonArticleRelModel;

/**
 * @ClassName: PersonArticleRelAdapter
 * @Description: 人物关联文章适配器
 * @author lijun
 * @date 2014-7-23 
 *
 */
@Component
public class PersonArticleRelAdapter extends BaseAdapter
{
    @Autowired
    private PersonArticleRelService personArticleRelService;
    
    /**
     * 
    * @Title: getList
    * @Description: 获取人物关联文章列表
    * @author lijun
    * @param articleId
    * @return
    * @throws SQLException
    * @throws
     */
    public List<PersonArticleRel> getList(Long personId) throws SQLException{
        PersonArticleRelExample example = new PersonArticleRelExample();
        PersonArticleRelExample.Criteria criteria = example.createCriteria();
        
        criteria.andPersonIdEqualTo(personId);
        setStatusGeneralCondition(criteria);
        
        example.setOrderByClause("update_time desc");
        
        return personArticleRelService.getList(example);
    }
    
    /**
     * 
    * @Title: getList
    * @Description: 获取人物关联文章列表
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public List<PersonArticleRel> getList(String json) throws SQLException{
        PersonArticleRelExample example = new PersonArticleRelExample();
        PersonArticleRelExample.Criteria criteria = example.createCriteria();
        
        PersonArticleRelModel model = getModelFromJson(json, PersonArticleRelModel.class);
        
        if (model.getPersonId() != null)
            criteria.andPersonIdEqualTo(model.getPersonId());
        if (model.getArticleId() != null)
            criteria.andArticleIdEqualTo(model.getArticleId());
        
        setStatusGeneralCondition(criteria);
        
        example.setOrderByClause("update_time desc");
        
        return personArticleRelService.getList(example);
    }
    
    /**
     * 
    * @Title: clearRel
    * @Description: 清空人物关联文章
    * @author lijun
    * @param articleId
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer clearRel(Long personId)throws SQLException{
        Integer result = 0;
        List<PersonArticleRel> list = getList(personId);
        for (PersonArticleRel personArticleRel : list)
        {
            result += delete(personArticleRel.getId());
        }
        return result;
    }
    
    /**
     * 
    * @Title: getArticleTagRel
    * @Description: 根据ID获取关联文章
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public PersonArticleRel getPersonArticleRel(Long id) throws SQLException{
        PersonArticleRelExample example = new PersonArticleRelExample();
        PersonArticleRelExample.Criteria criteria = example.createCriteria();
        
        criteria.andIdEqualTo(id);
        setStatusGeneralCondition(criteria);
        
        List<PersonArticleRel> list = personArticleRelService.getList(example);
        
        if (list != null && list.size() > 0)
            return list.get(0);
        else
            return null;
    }
    
    /**
     * 
    * @Title: getListToString
    * @Description: 获取人物关联文章列表json字符串
    * @author lijun
    * @param articleId
    * @return
    * @throws SQLException
    * @throws
     */
    public String getListToString(Long personId) throws SQLException{
        List<PersonArticleRel> list = getList(personId);
        JSONArray arr = JSONArray.fromObject(list);
        return arr.toString();
    }
    
    /**
     * 
    * @Title: getListToString
    * @Description: 获取人物关联文章列表json字符串
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public String getListToString(String json) throws SQLException{
        List<PersonArticleRel> list = getList(json);
        JSONArray arr = JSONArray.fromObject(list);
        return arr.toString();
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增人物关联文章
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(String json) throws SQLException{
        PersonArticleRel record = getModelFromJson(json, PersonArticleRel.class);
        return insert(record);
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增人物关联文章
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(PersonArticleRel record) throws SQLException{
        return personArticleRelService.insert(record);
    }
    
    /**
     * 
    * @Title: batchInsert
    * @Description: 批量新增关联
    * @author lijun
    * @param person
    * @param articleIdList
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer batchInsert(Person person, Long[] articleIdList) throws SQLException{
        int result = 0;
        for (int i = 0; i < articleIdList.length; i ++){
            //json默认会把Long转成Integer
            Long articleId = articleIdList[i].longValue();
            
            PersonArticleRel record = new PersonArticleRel();
            record.setPersonId(person.getId());
            record.setArticleId(articleId);
            record.setCreateTime(person.getCreateTime());
            record.setUpdateTime(person.getUpdateTime());
            record.setType(person.getType());
            record.setOpId(person.getOpId());
            
            result += insert(record);
        }
        return result;
    }
    
    /**
     * 
    * @Title: update
    * @Description: 更新关联
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer update(String json) throws SQLException{
        PersonArticleRel personArticleRel = getModelFromJson(json, PersonArticleRel.class);
        return personArticleRelService.update(personArticleRel);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 删除关联-移到垃圾箱
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer recycle(Long id) throws SQLException{
        PersonArticleRel personArticleRel = new PersonArticleRel();
        personArticleRel.setId(id);
        setStatusRecycle(personArticleRel);
        return personArticleRelService.update(personArticleRel);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 彻底删除关联
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer delete(Long id) throws SQLException{
        PersonArticleRel personArticleRel = new PersonArticleRel();
        personArticleRel.setId(id);
        setStatusDeleted(personArticleRel);
        return personArticleRelService.update(personArticleRel);
    }
}
