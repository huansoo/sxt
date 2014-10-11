/**  
* @Title:  OrgController.java
* @Package com.wugu.controller
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
package com.wugu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wugu.dto.OrgDTO;
import com.wugu.entity.Org;
import com.wugu.service.OrgService;

/**
 * @ClassName: OrgController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
@Controller
@RequestMapping("/org")
public class OrgController extends BaseController<Org>
{
    @Autowired
    private OrgService orgService;
    
    @RequestMapping("getOrgList.action")
    public void getOrgList(HttpServletRequest req, HttpServletResponse res){
        setReqAndRes(req, res);
        Org rootOrg = orgService.getRootOrg();
        OrgDTO orgDTO = orgService.getOrgDTOList(rootOrg);
        try
        {
            this.myWriter(JSONArray.fromObject(orgDTO).toString());
            log.info("获取组织机构列表");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            log.error("error in process"+e.toString());
        }
    }
    /**
     * 
      * @Title: saveOrg
      * @Description: 新增组织机构
      * @author yangch
      * @date 2014-9-16 
      * @param req
      * @param res
      * @param pid
      * @throws
     */
    @RequestMapping("saveOrg")
    public void saveOrg(int pid){
        orgService.saveOrg(pid);
    }
    /**
     * 
      * @Title: preUpdate
      * @Description: 预修改
      * @author yangch
      * @date 2014-9-16 
      * @param id
      * @return
      * @throws
     */
    @RequestMapping("preUpdate")
    public ModelAndView preUpdate(HttpServletRequest req, HttpServletResponse res, int id){
        setReqAndRes(req, res);
        Org org = orgService.getOrgById(id);
        getSession().setAttribute("org", org);
        Org parentOrg = orgService.getOrgById(org.getPid());
        getSession().setAttribute("parentName", parentOrg ==null?"":parentOrg.getOname());
        return new ModelAndView("org/org_update");
    }
    /**
     * 
      * @Title: updateOrg
      * @Description: TODO(这里用一句话描述这个方法的作用)
      * @author yangch
      * @date 2014-9-16 
      * @return
      * @throws
     */
    @RequestMapping("updateOrg")
    public ModelAndView updateOrg(){
        
        return new ModelAndView();
    }
    /**
     * 
      * @Title: getZTreeOrg
      * @Description: TODO(这里用一句话描述这个方法的作用)
      * @author yangch
      * @date 2014-9-16 
      * @param req
      * @param res
      * @param id
      * @throws
     */
    @RequestMapping("getZTreeOrg")
    public void getZTreeOrg(HttpServletRequest req, HttpServletResponse res, int id){
        Org root = orgService.getRootOrg();
        
    }
    
}
