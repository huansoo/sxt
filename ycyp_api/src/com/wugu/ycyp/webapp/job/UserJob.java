/**  
* @Title:  UserJob.java
* @Package com.wugu.ycyp.webapp.job
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-8-12 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.webapp.job;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wugu.ycyp.service.UserService;
import com.wugu.ycyp.webapp.adapter.UserAdapter;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.Code;

/**
 * @ClassName: UserJob
 * @Description: 用户控制类
 * @author lijun
 * @date 2014-8-12 
 *
 */
@Controller("UserJob")
public class UserJob extends BaseJob
{
    @Autowired
    private UserAdapter userAdapter;
    
    /**
     * 
    * @Title: Login
    * @Description: 用户登陆验证
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void Login() throws SQLException{
        ApiResult<Boolean> result = new ApiResult<Boolean>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                logger.error("参数“json”丢失！");
                throw new Exception("query json missed!");
            }
            
            Boolean data = userAdapter.login(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    /**
     * 
      * @Title: register
      * @Description: 用户注册
      * @author yangch
      * @date 2014-9-23 
      * @throws
     */
    public void register(){
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        
    }
    
}
