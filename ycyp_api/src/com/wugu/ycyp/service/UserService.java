/**  
* @Title:  UserService.java
* @Package com.wugu.ycyp.service
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
package com.wugu.ycyp.service;

import java.sql.SQLException;
import java.util.List;

import com.wugu.ycyp.entity.User;
import com.wugu.ycyp.entity.UserExample;

/**
 * @ClassName: UserService
 * @Description: 用户服务接口
 * @author lijun
 * @date 2014-8-12 
 *
 */
public interface UserService
{
    /**
     * 
    * @Title: getUserList
    * @Description: 获取用户列表
    * @author lijun
    * @param example
    * @return
    * @throws SQLException
    * @throws
     */
    List<User> getUserList(UserExample example) throws SQLException;
}
