/**  
* @Title:  DepartmentServiceImpl.java
* @Package com.wugu.ycyp.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author yangch
* @date  2014-9-12 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.ycyp.dao.DepartmentMapper;
import com.wugu.ycyp.entity.Department;
import com.wugu.ycyp.entity.DepartmentExample;
import com.wugu.ycyp.entity.page.PageManager;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.DepartmentService;

/**
 * @ClassName: DepartmentServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-12 
 *
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    private DepartmentMapper departmentMapper;
    /* (非 Javadoc)
    * <p>Title: getList</p>
    * <p>Description: </p> 根据条件查询部门，如果Example中属性值为空，则查询所有部门
    * @param department
    * @return
    * @see com.wugu.ycyp.service.DepartmentService#getList(com.wugu.ycyp.entity.Department)
    */
    @Override
    public PageWraper getList(DepartmentExample example)
    {
        int count = countByExample(example);
        List<Department> list = departmentMapper.selectByExample(example);
        return PageManager.getPageWraper(example.getPageInfo(), list, count);
    }
    @Override
    public int countByExample(DepartmentExample example){
        return departmentMapper.countByExample(example);
    }
}
