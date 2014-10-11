/**  
* @Title:  UserDao.java
* @Package com.wugu.dao
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
package com.wugu.dao;

import java.util.List;

import com.wugu.entity.User;

/**
 * @ClassName: UserDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-15 
 *
 */
public interface UserDao
{
    public User findByNameAndPwd(User user);
}
