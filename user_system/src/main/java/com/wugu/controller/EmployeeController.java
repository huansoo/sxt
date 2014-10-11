/**  
* @Title:  EmployeeController.java
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
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wugu.dto.EmployeeDTO;
import com.wugu.entity.Employee;
import com.wugu.service.EmployeeService;

/**
 * @ClassName: EmployeeController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController<Employee>
{
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping("getOnEmployeeList")
    public void getOnEmployeeList(HttpServletRequest request, HttpServletResponse response, Employee employee){
        setReqAndRes(request, response);
        List<EmployeeDTO> list = employeeService.getOnEmployeeList(employee);
        try
        {
            log.info(JSONArray.fromObject(list).toString());
            this.myWriter(JSONArray.fromObject(list).toString());
            log.info("success!!!!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            log.error(e.toString());
        }
    }
}
