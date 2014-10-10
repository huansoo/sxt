/**  
* @Title:  BaseModel.java
* @Package com.wugu.ycyp.webapp.model
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-10 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.webapp.model;

/**
 * @ClassName: BaseModel
 * @Description: 模型基类
 * @author lijun
 * @date 2014-7-10 
 *
 */
public class BaseModel
{
    private Integer page;
    private Integer pageSize;
    private Long id;
    private Integer status;
    private Integer opId;
    private Integer updateTime;
    private Integer type;
    
    public Integer getType()
    {
        return type;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }
    public int getUpdateTime()
    {
        return updateTime;
    }
    public void setUpdateTime(int updateTime)
    {
        this.updateTime = updateTime;
    }
    public Integer getStatus()
    {
        return status;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    public Integer getOpId()
    {
        return opId;
    }
    public void setOpId(Integer opId)
    {
        this.opId = opId;
    }
    public Integer getPage()
    {
        return page;
    }
    public void setPage(Integer page)
    {
        this.page = page;
    }
    public Integer getPageSize()
    {
        return pageSize;
    }
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
}
