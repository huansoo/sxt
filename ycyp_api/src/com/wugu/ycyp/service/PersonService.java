/**  
* @Title:  PersonService.java
* @Package com.wugu.ycyp.service
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
package com.wugu.ycyp.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.ycyp.entity.Person;
import com.wugu.ycyp.entity.PersonExample;
import com.wugu.ycyp.entity.page.PageWraper;

/**
 * @ClassName: PersonService
 * @Description: 人物服务接口
 * @author lijun
 * @date 2014-7-23 
 *
 */
public interface PersonService
{
    /**
     * 
    * @Title: getSpecialtyList
    * @Description: 获取人物列表（分页）
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    PageWraper getList(PersonExample example) throws SQLException;
    /**
     * 
    * @Title: getList
    * @Description: 获取人物列表（不分页）
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    List<Person> getListWithContent(PersonExample example) throws SQLException;
    /**
     * 
    * @Title: insert
    * @Description: 添加人物
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int insert(Person record) throws SQLException;
    /**
     * 
    * @Title: update
    * @Description: 修改人物
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    int update(Person record) throws SQLException;
}
