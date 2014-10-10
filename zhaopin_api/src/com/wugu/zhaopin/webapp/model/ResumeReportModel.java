/**  
* @Title:  ResumeReportModel.java
* @Package com.wugu.zhaopin.webapp.model
* @Description: 简历搜索json对象
* @author lijun
* @date  2014-3-10 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.webapp.model;

/**
 * @ClassName: ResumeReportModel
 * @Description: 简历搜索json对象
 * @author lijun
 * @date 2014-3-10 
 *
 */
public class ResumeReportModel extends BaseModel
{
   /* 一、timeType
    1：简历创建时间
    2：简历更新时间
    3：最后投递时间
    二、startTime
    开始时间
    三、endTime
    结束时间
    四、keyType
    1：简历名称（模糊）resume
    2：简历ID
    3：期望职位
    4：求职类别
    五、keyWord
    关键字
    六、publicMan
    发布人（模糊）
    七、order
            排序字段名
   orderType
        1：倒序
        2：正序
    八、pageSize
    页面大小
    九、page
    第几页
     十   求职类别
  */
    Integer timeType ;
    Integer startTime;
    Integer endTime;
    Integer keyType;
    String keyWord;
    String publicMan;
    String order;
    Integer orderType;
    Integer pageSize = 20;
    Integer page = 1;
    Integer auditionStatus;
    Integer resumeStatus;
    String workAddress;
    Integer resumeTags;
    String userName;
    
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public Integer getResumeTags()
    {
        return resumeTags;
    }
    public void setResumeTags(Integer resumeTags)
    {
        this.resumeTags = resumeTags;
    }
    
    public String getWorkAddress()
    {
        return workAddress;
    }
    public void setWorkAddress(String workAddress)
    {
        this.workAddress = workAddress;
    }
    public Integer getAuditionStatus()
    {
        return auditionStatus;
    }
    public void setAuditionStatus(Integer auditionStatus)
    {
        this.auditionStatus = auditionStatus;
    }
    public Integer getResumeStatus()
    {
        return resumeStatus;
    }
    public void setResumeStatus(Integer resumeStatus)
    {
        this.resumeStatus = resumeStatus;
    }
    public Integer getTimeType()
    {
        return timeType;
    }
    public void setTimeType(Integer timeType)
    {
        this.timeType = timeType;
    }
    public Integer getStartTime()
    {
        return startTime;
    }
    public void setStartTime(Integer startTime)
    {
        this.startTime = startTime;
    }
    public Integer getEndTime()
    {
        return endTime;
    }
    public void setEndTime(Integer endTime)
    {
        this.endTime = endTime;
    }
    public Integer getKeyType()
    {
        return keyType;
    }
    public void setKeyType(Integer keyType)
    {
        this.keyType = keyType;
    }
    public String getKeyWord()
    {
        return keyWord;
    }
    public void setKeyWord(String keyWord)
    {
        this.keyWord = keyWord;
    }
    public String getPublicMan()
    {
        return publicMan;
    }
    public void setPublicMan(String publicMan)
    {
        this.publicMan = publicMan;
    }
    public String getOrder()
    {
        return order;
    }
    public void setOrder(String order)
    {
        this.order = order;
    }
    public Integer getOrderType()
    {
        return orderType;
    }
    public void setOrderType(Integer orderType)
    {
        this.orderType = orderType;
    }
    public Integer getPageSize()
    {
        return pageSize;
    }
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
    public Integer getPage()
    {
        return page;
    }
    public void setPage(Integer page)
    {
        this.page = page;
    }  

}
