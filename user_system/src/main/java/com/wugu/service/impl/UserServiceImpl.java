/**  
* @Title:  UserServiceImpl.java
* @Package com.wugu.service.impl
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
package com.wugu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wugu.dao.UserDao;
import com.wugu.entity.User;
import com.wugu.mail.MailInfo;
import com.wugu.mail.MailSender;
import com.wugu.mail.MailServer;
import com.wugu.service.UserService;
import com.wugu.utils.FileUtils;
import com.wugu.utils.PropertiesUtils;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-15 
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    /* (非 Javadoc)
    * <p>Title: checkUser</p>
    * <p>Description: </p>
    * @param user
    * @return
    * @see com.wugu.service.UserService#checkUser(com.wugu.entity.User)
    */
    public User findByNameAndPwd(User user)
    {
        System.out.println("我被执行了-----");
       return userDao.findByNameAndPwd(user);
    }

    /* (非 Javadoc)
    * <p>Title: findByUserId</p>
    * <p>Description: </p>
    * @param id
    * @return
    * @see com.wugu.service.UserService#findByUserId(java.lang.String)
    */
    public User findByUserId(String id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (非 Javadoc)
    * <p>Title: findAll</p>
    * <p>Description: </p>
    * @return
    * @see com.wugu.service.UserService#findAll()
    */
    public List<User> findAll()
    {
        return null;
    }
    
    public void sendByTemplate(String templatePath){
        
    }

    /* (非 Javadoc)
    * <p>Title: registerUser</p>
    * <p>Description: </p>
    * @see com.wugu.service.UserService#registerUser()
    */
    public void registerUser(User user)
    {
        MailInfo info = new MailInfo();
        info.setSubject("测试邮箱激活用户");
        info.setContent("我是测试邮件......");
        info.addAtch("E:\\吾谷网\\账号.txt");
        MailInfo.Person person = new MailInfo.Person();
        person.setAddress("991622230@qq.com");
        info.addToAdress(person);
        sendByTemplate(info, "pages\\registerActive.html", user);
    }
    
    public void sendByTemplate(MailInfo info, String templatePath, User user){
        Properties config = PropertiesUtils.getMailProperties();
        String serverAddress = config.getProperty("serverAddress");
        String password = config.getProperty("password");
        String smtp = config.getProperty("stmp");
        String sendName = config.getProperty("sendName");
        MailServer server = new MailServer(smtp, serverAddress, sendName, password, templatePath);
        String msgContent = FileUtils.resolveFileToString(server.getTemplatePath());
        Map<String, String> map = new HashMap<String, String>();
        map.put("{userName}", user.getUname());
        //点击此超链接可以修改数据库中用户state状态，改为激活状态，即完成邮箱激活功能.
        map.put("{url_rencai}", "http://localhost:9080/user_system/userController/login.action");
        msgContent = FileUtils.replaceTemplateKeys(map, msgContent);
        info.setContent(msgContent);
        MailSender sender = new MailSender(server);
        try {
            sender.sendMail(info);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
