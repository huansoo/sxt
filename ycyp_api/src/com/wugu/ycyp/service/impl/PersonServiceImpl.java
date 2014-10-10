/**  
* @Title:  PersonServiceImpl.java
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

import com.wugu.ycyp.dao.PersonMapper;
import com.wugu.ycyp.entity.Person;
import com.wugu.ycyp.entity.PersonExample;
import com.wugu.ycyp.entity.page.PageManager;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.PersonService;

/**
 * @ClassName: PersonServiceImpl
 * @Description: 人物服务实现类
 * @author lijun
 * @date 2014-7-23 
 *
 */
@Service("personService")
public class PersonServiceImpl implements PersonService
{
    
    @Autowired
    private PersonMapper personMapper;
    /* (非 Javadoc)
     * <p>Title: getPersonList</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.PersonService#getPersonList(com.wugu.ycyp.entity.PersonExample)
     */
    @Override
    public PageWraper getList(PersonExample example) throws SQLException
    {
        int count = personMapper.countByExample(example);
        List<Person> list = personMapper.selectByExample(example);
        return PageManager.getPageWraper(example.getPageInfo(), list, count);
    }

    /* (非 Javadoc)
     * <p>Title: getList</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.PersonService#getList(com.wugu.ycyp.entity.PersonExample)
     */
    @Override
    public List<Person> getListWithContent(PersonExample example) throws SQLException
    {
        return personMapper.selectByExampleWithBLOBs(example);
    }

    /* (非 Javadoc)
     * <p>Title: insert</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.PersonService#insert(com.wugu.ycyp.entity.Person)
     */
    @Override
    public int insert(Person record) throws SQLException
    {
        return personMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: update</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.PersonService#update(com.wugu.ycyp.entity.Person)
     */
    @Override
    public int update(Person record) throws SQLException
    {
        return personMapper.updateByPrimaryKeySelective(record);
    }

}
