/**  
* @Title:  TagService.java
* @Package com.wugu.ycyp.service
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
package com.wugu.ycyp.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.ycyp.entity.Tag;
import com.wugu.ycyp.entity.TagExample;
import com.wugu.ycyp.entity.page.PageWraper;

/**
 * @ClassName: TagService
 * @Description: 标签服务接口
 * @author lijun
 * @date 2014-7-16 
 *
 */
public interface TagService
{
    PageWraper getList(TagExample example) throws SQLException;
    List<Tag> getListTag(TagExample example) throws SQLException;
    int insert(Tag record) throws SQLException;
    int update(Tag record) throws SQLException;
    int delete(Long id) throws SQLException;
}
