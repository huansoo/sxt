/**  
* @Title:  UserServiceImpl.java
* @Package com.wugu.ycyp.service.impl
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
package com.wugu.ycyp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.ycyp.dao.UserMapper;
import com.wugu.ycyp.entity.User;
import com.wugu.ycyp.entity.UserExample;
import com.wugu.ycyp.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户服务实现类
 * @author lijun
 * @date 2014-8-12 
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    /* (非 Javadoc)
     * <p>Title: getUserList</p>
     * <p>Description: 获取用户列表</p>
     * @param example
     * @return
     * @throws SQLException
     * @see com.wugu.ycyp.service.UserService#getUserList(com.wugu.ycyp.entity.UserExample)
     */
    @Override
    public List<User> getUserList(UserExample example) throws SQLException
    {
        return userMapper.selectByExample(example);
    }

}
