/**  
* @Title:  UserService.java
* @Package com.wugu.service
* @Description: TODO(用一句话描述该文件做什么)
* @author yangch
* @date  2014-9-15 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.service;

import java.util.List;

import com.wugu.entity.User;

/**
 * @ClassName: UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-15 
 *
 */
public interface UserService
{
    public User findByNameAndPwd(User user);
    public User findByUserId(String id);
    public List<User> findAll();
    public void registerUser(User user);
}
