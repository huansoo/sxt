/**  
* @Title:  OrgDao.java
* @Package com.wugu.dao
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
package com.wugu.dao;

import java.util.List;

import com.wugu.entity.Org;

/**
 * @ClassName: OrgDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
public interface OrgDao
{
    
    public List<Org> getOrgListByPid(int pid); 
    public int saveOrg(Org org);
    public Org getOrgById(int iid);
}
