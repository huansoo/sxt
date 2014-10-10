
/**  
* @Title:  DepartJob.java
* @Package com.wugu.ycyp.webapp.job
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
package com.wugu.ycyp.webapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wugu.ycyp.webapp.adapter.DepartmentAdapter;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.Code;

/**
 * @ClassName: DepartmentJob
 * @Description: 部门有关的操作
 * @author yangch
 * @date 2014-9-12 
 *
 */
@Controller("DepartmentJob")
public class DepartmentJob extends BaseJob{
    
    @Autowired
    private DepartmentAdapter departmentAdapter;
    
    public void getList(){
        ApiResult<String> apiResult = new ApiResult<String>();
        setResult(apiResult);
        
        try
        {
            Long deptId = getQueryLong(Code.PARAMTER_ID);
            String data = null;
            
            if(null == deptId){
                data = departmentAdapter.getList();
            }else{
                data = departmentAdapter.getList(deptId);
            }
            apiResult.setSuccessData(data);
        }
        catch (Exception e)
        {
            apiResult.setExceptionData(e.toString());
            e.getStackTrace();
        }
    }

}
