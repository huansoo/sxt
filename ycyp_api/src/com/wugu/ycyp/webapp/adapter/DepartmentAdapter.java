/**  
* @Title:  Department.java
* @Package com.wugu.ycyp.webapp.adapter
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
package com.wugu.ycyp.webapp.adapter;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.Department;
import com.wugu.ycyp.entity.DepartmentExample;
import com.wugu.ycyp.entity.page.PageInfo;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.DepartmentService;
import com.wugu.ycyp.util.ConstantUtil;
import com.wugu.ycyp.util.JsonUtil;

/**
 * @ClassName: Department
 * @Description: 部门信息处理相关类
 * @author yangch
 * @date 2014-9-12 
 *
 */
@Component
public class DepartmentAdapter extends BaseAdapter
{
    @Autowired
    private DepartmentService departmentService;
    /**
     * 
      * @Title: getList
      * @Description: 根据model中有值的属性做为条件，查询部门
      * @author yangch
      * @date 2014-9-12 
      * @param model
      * @return
      * @throws
     */
    public List<Department> getListByModel(Department model){
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        
        //如果部门id不为空，说明是根据id查询该部门
        if(null != model && model.getId() != null){
            criteria.andIdEqualTo(model.getId());
        }
        example.setOrderByClause("update_time desc");
        setStatusGeneralCondition(criteria);
//        return departmentService.getList(example);
        return null;
    }
    /**
     * 
      * @Title: getList
      * @Description: 查询所有的部门
      * @author yangch
      * @date 2014-9-12 
      * @return
      * @throws
     */
    public String getList(){
        DepartmentExample example = new DepartmentExample();
        example.setPageInfo(new PageInfo(2, 2, 5));
        DepartmentExample.Criteria criteria1 = example.or();
        criteria1.andDeptNameLike("%吾谷%");
        example.setOrderByClause("status desc");
//        setStatusGeneralCondition(criteria);
//        criteria1.andStatusEqualTo(ConstantUtil.RECORD_STATUS_GENERAL);
//        DepartmentExample.Criteria criteria2 = example.or();
//        criteria2.andDeptDescLike("%吾谷%");
//        criteria2.andStatusEqualTo(ConstantUtil.RECORD_STATUS_GENERAL);
       PageWraper pw = departmentService.getList(example);
       //return JsonUtil.beanListToJsonArray(this.getListByModel(null));
       try
            {
                return getJsonByPageWraper(pw);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
       return null;
    }
    /**
     * 
      * @Title: getList
      * @Description: 通过部门id，获取该部门信息
      * @author yangch
      * @date 2014-9-12 
      * @param id
      * @return
      * @throws
     */
    public String getList(Long id){
        Department dept = new Department();
        dept.setId(id);
        
        List<Department> list = this.getListByModel(dept);
        if(null != list && list.size() >0){
            
            return JsonUtil.beanToJson(list.get(0)); 
            
        }
        return null;
    }
}
