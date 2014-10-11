/**  
* @Title:  OrgService.java
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

import com.wugu.dto.OrgDTO;
import com.wugu.dto.ZtreeDTO;
import com.wugu.entity.Org;

/**
 * @ClassName: OrgService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
public interface OrgService
{
    public OrgDTO getOrgDTOList(Org org);
    public Org getRootOrg();
    public Org createRootOrg();
    public void saveOrg(Org org);
    public void saveOrg(int pid);
    public Org getOrgById(int id);
    public ZtreeDTO getZtreeDTO(Org root, int id, int parentId);
}
