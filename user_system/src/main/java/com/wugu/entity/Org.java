/**  
* @Title:  Org.java
* @Package com.wugu.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author yangch
* @date  2014-9-16 
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
 * @ClassName: Org
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
public class Org implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */
    private static final long serialVersionUID = 1L;   
    private Integer id;
    private String oname;
    private Integer pid;
    private String descript;
    private int leaf;
    private String principal;
    
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getOname()
    {
        return oname;
    }
    public void setOname(String oname)
    {
        this.oname = oname;
    }
    public Integer getPid()
    {
        return pid;
    }
    public void setPid(Integer pid)
    {
        this.pid = pid;
    }
    public String getDescript()
    {
        return descript;
    }
    public void setDescript(String descript)
    {
        this.descript = descript;
    }
    public int getLeaf()
    {
        return leaf;
    }
    public void setLeaf(int leaf)
    {
        this.leaf = leaf;
    }
    public String getPrincipal()
    {
        return principal;
    }
    public void setPrincipal(String principal)
    {
        this.principal = principal;
    }
    /**
    * <p>Title: </p>
    * <p>Description: </p>
    * @author yangch
    * @param id
    * @param oname
    * @param pid
    * @param descript
    * @param leaf
    * @param principal
    */
    public Org(int id, String oname, int pid, String descript, int leaf,
            String principal)
    {
        super();
        this.id = id;
        this.oname = oname;
        this.pid = pid;
        this.descript = descript;
        this.leaf = leaf;
        this.principal = principal;
    }
    /**
    * <p>Title: </p>
    * <p>Description: </p>
    * @author yangch
    */
    public Org()
    {
        super();
    }
    
}
