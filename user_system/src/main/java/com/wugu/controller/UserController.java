/**  
* @Title:  MainController.java
* @Package com.wugu.controller
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
package com.wugu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wugu.entity.User;
import com.wugu.service.UserService;

/**
 * @ClassName: MainController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-15 
 *
 */
@Controller
@RequestMapping("/userController")
public class UserController extends BaseController<User>
{
    @Autowired
    private UserService userService;
    /**
     * 
      * @Title: checkUser
      * @Description: 检查用户名密码是否正确
      * @author yangch
      * @date 2014-9-15 
      * @param res
      * @param req
      * @param user
      * @return
      * @throws
     */
    @RequestMapping("login.action")
    public ModelAndView checkUser(HttpServletResponse res, HttpServletRequest req, User user){
        setReqAndRes(req, res);
        
        if(null != user) user.setState("1");
        User u = userService.findByNameAndPwd(user);
        if(null == u) {
            this.getSession().setAttribute("msg", "用户名或密码不正确!");
            log.info("用户名或密码不正确!");
            return new ModelAndView("user/user_login");
        }
        
        this.getSession().setAttribute("loginUser", u);
        return new ModelAndView("facade/work");
    }
    @RequestMapping("registerUser")
    public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response, User user){
        setReqAndRes(request, response);
        userService.registerUser(user);
        return null;
    }
}
