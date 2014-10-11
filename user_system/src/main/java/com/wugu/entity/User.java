/**  
* @Title:  User.java
* @Package com.wugu.entity
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
package com.wugu.entity;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-15 
 *
 */
/**
* @ClassName: User
* @Description: TODO(这里用一句话描述这个类的作用)
* @author yangch
* @date 2014-9-24 
*
*/
public class User implements Serializable
{
    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */
    private static final long serialVersionUID = 1L;
    private int id;
    private String uname;
    private String pwd;
    private int empid;
    private String state;
    private String createTime;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getUname()
    {
        return uname;
    }
    public void setUname(String uname)
    {
        this.uname = uname;
    }
    public String getPwd()
    {
        return pwd;
    }
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
    public int getEmpid()
    {
        return empid;
    }
    public void setEmpid(int empid)
    {
        this.empid = empid;
    }
    public String getState()
    {
        return state;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public String getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    

}
