/**  
* @Title:  EmployeeServiceImpl.java
* @Package com.wugu.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author yangch
* @date  2014-9-16 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.dao.EmployeeDao;
import com.wugu.dto.EmployeeDTO;
import com.wugu.entity.Employee;
import com.wugu.service.EmployeeService;

/**
 * @ClassName: EmployeeServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDao employeeDao;

    /* (非 Javadoc)
    * <p>Title: getOnEmployeeList</p>
    * <p>Description: </p>
    * @param employee
    * @return
    * @see com.wugu.service.EmployeeService#getOnEmployeeList(com.wugu.entity.Employee)
    */
    public List<EmployeeDTO> getOnEmployeeList(Employee employee)
    {
        List<EmployeeDTO> list = employeeDao.getOnEmployeeList(employee);
        return list;
    }

}
