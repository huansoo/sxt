/**  
* @Title:  SpecialtyServiceImpl.java
* @Package com.wugu.ycyp.service.impl
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
package com.wugu.ycyp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.ycyp.dao.SpecialtyMapper;
import com.wugu.ycyp.entity.Specialty;
import com.wugu.ycyp.entity.SpecialtyExample;
import com.wugu.ycyp.entity.page.PageManager;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.SpecialtyService;

/**
 * @ClassName: SpecialtyServiceImpl
 * @Description: 特产服务实现类
 * @author lijun
 * @date 2014-7-22 
 *
 */
@Service("specialtyService")
public class SpecialtyServiceImpl implements SpecialtyService
{

    @Autowired
    private SpecialtyMapper specialtyMapper;
    /* (非 Javadoc)
     * <p>Title: getList</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.SpecialtyService#getList(com.wugu.ycyp.entity.SpecialtyExample)
     */
    @Override
    public List<Specialty> getList(SpecialtyExample example)
            throws SQLException
    {
        return specialtyMapper.selectByExampleWithBLOBs(example);
    }

    /* (非 Javadoc)
     * <p>Title: insert</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.SpecialtyService#insert(com.wugu.ycyp.entity.Specialty)
     */
    @Override
    public int insert(Specialty record) throws SQLException
    {
        return specialtyMapper.insertSelective(record);
    }

    /* (非 Javadoc)
     * <p>Title: update</p>
     * <p>Description: </p>
     * @param record
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.SpecialtyService#update(com.wugu.ycyp.entity.Specialty)
     */
    @Override
    public int update(Specialty record) throws SQLException
    {
        return specialtyMapper.updateByPrimaryKeySelective(record);
    }

    /* (非 Javadoc)
    * <p>Title: getSpecialtyList</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.ycyp.service.SpecialtyService#getSpecialtyList(com.wugu.ycyp.entity.SpecialtyExample)
    */
    @Override
    public PageWraper getSpecialtyList(SpecialtyExample example)
            throws SQLException
    {
        Integer count = specialtyMapper.countByExample(example);
        List<Specialty> list = specialtyMapper.selectByExample(example);
        return PageManager.getPageWraper(example.getPageInfo(), list, count);
    }

}
