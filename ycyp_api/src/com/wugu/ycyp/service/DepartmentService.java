/**  
* @Title:  DepartmentService.java
* @Package com.wugu.ycyp.service
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
package com.wugu.ycyp.service;

import com.wugu.ycyp.entity.DepartmentExample;
import com.wugu.ycyp.entity.page.PageWraper;

/**
 * @ClassName: DepartmentService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-12 
 *
 */
public interface DepartmentService
{
    public PageWraper getList(DepartmentExample example);
    public int countByExample(DepartmentExample departmentExample);
}
