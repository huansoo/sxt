/**  
* @Title:  UserAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
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
package com.wugu.ycyp.webapp.adapter;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.User;
import com.wugu.ycyp.entity.UserExample;
import com.wugu.ycyp.service.UserService;
import com.wugu.ycyp.webapp.model.UserModel;

/**
 * @ClassName: UserAdapter
 * @Description: 用户数据适配器
 * @author lijun
 * @date 2014-8-12 
 *
 */
@Component
public class UserAdapter extends BaseAdapter
{
    @Autowired
    private UserService userService;
    
    /**
     * 
    * @Title: getUserList
    * @Description: 根据用户名获取用户列表
    * @author lijun
    * @param userName
    * @return
    * @throws SQLException
    * @throws
     */
    public List<User> getUserList(String json) throws SQLException{
        UserExample example = new UserExample();
        UserModel model = getModelFromJson(json, UserModel.class);
        UserExample.Criteria criteria = example.createCriteria();
        
        setStatusGeneralCondition(criteria);
        iniBaseCondition(criteria, json);
        
        if (model.getUserName() != null)
            criteria.andUserNameEqualTo(model.getUserName());
        if (model.getId() != null){
            criteria.andIdEqualTo(model.getId());
        }
        
        example.setOrderByClause("update_time desc");
        
        return userService.getUserList(example);
    }
    
    /**
     * 
    * @Title: login
    * @Description: 判断登陆
    * @author lijun
    * @param userName
    * @param password
    * @return
    * @throws SQLException
    * @throws
     */
    public boolean login(String json) throws SQLException{
        UserModel model = getModelFromJson(json, UserModel.class);
        List<User> list = getUserList(json);
        if (list != null && list.size() > 0){
            User user = list.get(0);
            return user.getPassword().equals(model.getPassword());            
        }
        return false;
    }
}
