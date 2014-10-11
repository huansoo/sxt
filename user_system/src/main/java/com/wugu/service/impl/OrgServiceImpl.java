/**  
* @Title:  OrgServiceImpl.java
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

import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.dao.OrgDao;
import com.wugu.dto.OrgDTO;
import com.wugu.dto.ZtreeDTO;
import com.wugu.entity.Org;
import com.wugu.service.OrgService;
import com.wugu.utils.Constants;

/**
 * @ClassName: OrgServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
@Service("orgService")
public class OrgServiceImpl implements OrgService
{
    private static final Logger log = Logger.getLogger(OrgServiceImpl.class);
    @Autowired
    private OrgDao orgDao;
    /* (非 Javadoc)
    * <p>Title: getOrgList</p>
    * <p>Description: </p>获取组织机构列表
    * @return
    * @see com.wugu.service.OrgService#getOrgList()
    */
    public OrgDTO getOrgDTOList(Org org)
    {
        OrgDTO rootDTO = new OrgDTO();
        rootDTO.setId(org.getId());
        rootDTO.setLeaf(0);
        rootDTO.setOname(org.getOname());
        rootDTO.setPid(org.getPid());
        rootDTO.setPrincipal(org.getPrincipal());
        rootDTO.setState("open");
        rootDTO.setDescript(org.getDescript());
        List<Org> orgList = orgDao.getOrgListByPid(org.getId());
        HashSet<OrgDTO> children = new HashSet<OrgDTO>();
        for(Org childOrg: orgList){
            children.add(getOrgDTOList(childOrg));
        }
        rootDTO.setChildren(children);
        return rootDTO;
    }
    /* (非 Javadoc)
    * <p>Title: getRootOrg</p>
    * <p>Description: </p> 获取跟组织机构
    * @param rootOrgId
    * @return
    * @see com.wugu.service.OrgService#getRootOrg(int)
    */
    public Org getRootOrg()
    {
        List<Org> orgList =  orgDao.getOrgListByPid(Constants.ROOT_ORG_ID);
        if(null != orgList && !orgList.isEmpty()){
            return orgList.get(0);
        }
        return createRootOrg();
    }
    /**
     * 
      * @Title: createRootOrg
      * @Description: 创建根机构
      * @author yangch
      * @date 2014-9-16 
      * @return
      * @throws
     */
    public Org createRootOrg(){
        Org org = new Org();
        org.setPid(Constants.ROOT_ORG_ID);
        org.setDescript("初始化根节点");
        org.setOname("初始化根节点");
        org.setLeaf(0);
        saveOrg(org);
        log.info("保存初始化节点");
        return org;
    }
    /**
     * 
      * @Title: saveOrg
      * @Description: TODO(这里用一句话描述这个方法的作用)
      * @author yangch
      * @date 2014-9-16 
      * @param pid
      * @throws
     */
    public void saveOrg(int pid){
        Org org = new Org(0, "新增组织机构", pid, "新增组织机构", 1, "");
        saveOrg(org);
        log.info("新增组织机构");
    }
    /* (非 Javadoc)
    * <p>Title: saveOrg</p>
    * <p>Description: </p>
    * @param org
    * @see com.wugu.service.OrgService#saveOrg(com.wugu.entity.Org)
    */
    public void saveOrg(Org org)
    {
        this.orgDao.saveOrg(org);;
    }
    /* (非 Javadoc)
    * <p>Title: getOrgById</p>
    * <p>Description: </p>
    * @param id
    * @see com.wugu.service.OrgService#getOrgById(int)
    */
    public Org getOrgById(int id)
    {
        return orgDao.getOrgById(id);
    }
    /* (非 Javadoc)
    * <p>Title: getZtreeDTO</p>
    * <p>Description: </p>
    * @param root
    * @param id
    * @return
    * @see com.wugu.service.OrgService#getZtreeDTO(com.wugu.entity.Org, int)
    */
    public ZtreeDTO getZtreeDTO(Org root, int id, int parentId)
    {
        ZtreeDTO dto = new ZtreeDTO();
        dto.setId(root.getId());
        dto.setName(root.getOname());
        dto.setLeaf(root.getLeaf());
        dto.setOpen(true);
        dto.setParentId(root.getPid());
//        if(root.getId() == ){
//            dto.setChecked(true);
//        }
        HashSet<ZtreeDTO> nodes = new HashSet<ZtreeDTO>();
        List<Org> orgList = orgDao.getOrgListByPid(root.getId());
        return null;
    }
}
