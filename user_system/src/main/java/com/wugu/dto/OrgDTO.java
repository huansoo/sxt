/**  
* @Title:  OrgDTO.java
* @Package com.wugu.dto
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
package com.wugu.dto;

import java.io.Serializable;
import java.util.HashSet;

/**
 * @ClassName: OrgDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-16 
 *
 */
public class OrgDTO implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */
    private static final long serialVersionUID = 1L;
    private int id;
    private String oname;
    private int pid;
    private String descript;
    private int leaf = 1;//默认值：1: 表示是叶子节点     0：表示不是叶子节点
    private String principal;
    private String state;//设置展开的状态 open  closed
    private HashSet<OrgDTO> children = new HashSet<OrgDTO>();
    public int getId()
    {
        return id;
    }
    public void setId(int id)
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
    public int getPid()
    {
        return pid;
    }
    public void setPid(int pid)
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
    public String getState()
    {
        return state;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public HashSet<OrgDTO> getChildren()
    {
        return children;
    }
    public void setChildren(HashSet<OrgDTO> children)
    {
        this.children = children;
    }
}
