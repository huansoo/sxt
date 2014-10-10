/**  
* @Title:  AreaServiceImpl.java
* @Package com.wugu.ycyp.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-8 
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

import com.wugu.ycyp.dao.AreaMapper;
import com.wugu.ycyp.entity.Area;
import com.wugu.ycyp.entity.AreaExample;
import com.wugu.ycyp.entity.page.PageManager;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.AreaService;

/**
 * @ClassName: AreaServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-7-8 
 *
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService
{
    @Autowired
    private AreaMapper areaMapper;
 
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

    /* (非 Javadoc)
    * <p>Title: getAreaList</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws Exception
    * @see com.wugu.ycyp.service.AreaService#getAreaList(com.wugu.ycyp.entity.AreaExample)
    */
    @Override
    public PageWraper getAreaList(AreaExample example) throws SQLException
    {
        Integer count = areaMapper.countByExample(example);
        List<Area> list = areaMapper.selectByExample(example);
        return PageManager.getPageWraper(example.getPageInfo(), list, count);
    }

    /* (非 Javadoc)
    * <p>Title: insert</p>
    * <p>Description: </p>
    * @param record
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.AreaService#insert(com.wugu.ycyp.entity.Area)
    */
    @Override
    public int insert(Area record) throws SQLException
    {
        return areaMapper.insert(record);
    }

    /* (非 Javadoc)
    * <p>Title: update</p>
    * <p>Description: </p>
    * @param record
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.AreaService#update(com.wugu.ycyp.entity.Area)
    */
    @Override
    public int update(Area record) throws SQLException
    {
        return areaMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
    * <p>Title: getArea</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.AreaService#getArea(com.wugu.ycyp.entity.AreaExample)
    */
    @Override
    public List<Area> getList(AreaExample example) throws SQLException
    {
        return areaMapper.selectByExample(example);
    }

}
