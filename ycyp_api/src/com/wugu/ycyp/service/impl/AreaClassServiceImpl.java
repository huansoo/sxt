/**  
* @Title:  AreaClassServiceImpl.java
* @Package com.wugu.ycyp.service.impl
* @Description: 区域分类服务实现类
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
package com.wugu.ycyp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.ycyp.dao.AreaClassMapper;
import com.wugu.ycyp.entity.AreaClass;
import com.wugu.ycyp.entity.AreaClassExample;
import com.wugu.ycyp.service.AreaClassService;

/**
 * @ClassName: AreaClassServiceImpl
 * @Description: 区域分类服务实现类
 * @author lijun
 * @date 2014-7-18 
 *
 */
@Service("areaClassService")
public class AreaClassServiceImpl implements AreaClassService
{
    @Autowired
    private AreaClassMapper areaClassMapper;
    /* (非 Javadoc)
    * <p>Title: getList</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.AreaClassService#getList(com.wugu.ycyp.entity.AreaClassExample)
    */
    @Override
    public List<AreaClass> getList(AreaClassExample example)
            throws SQLException
    {
        return areaClassMapper.selectByExample(example);
    }

    /* (非 Javadoc)
    * <p>Title: insert</p>
    * <p>Description: </p>
    * @param record
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.AreaClassService#insert(com.wugu.ycyp.entity.AreaClass)
    */
    @Override
    public int insert(AreaClass record) throws SQLException
    {
        return areaClassMapper.insertSelective(record);
    }

    /* (非 Javadoc)
    * <p>Title: update</p>
    * <p>Description: </p>
    * @param record
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.AreaClassService#update(com.wugu.ycyp.entity.AreaClass)
    */
    @Override
    public int update(AreaClass record) throws SQLException
    {
        return areaClassMapper.updateByPrimaryKeySelective(record);
    }

}
