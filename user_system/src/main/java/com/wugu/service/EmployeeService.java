/**  
* @Title:  EmployeeService.java
* @Package com.wugu.service
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
package com.wugu.service;

import java.util.List;

import com.wugu.dto.EmployeeDTO;
import com.wugu.entity.Employee;

/**
 * @ClassName: EmployeeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
public interface EmployeeService
{
    public List<EmployeeDTO> getOnEmployeeList(Employee employee);
}
