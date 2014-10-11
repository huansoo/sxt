/**  
* @Title:  EmployeeDTO.java
* @Package com.wugu.dto
* @Description: TODO(用一句话描述该文件做什么)
* @author yangch
* @date  2014-9-17 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.dto;

import java.util.List;

/**
 * @ClassName: EmployeeDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-17 
 *
 */
public class EmployeeDTO
{
    private int id;
    private String ename;
    private String ruzhiTime;
    private String orgName;
    private List<String> jobNames;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getEname()
    {
        return ename;
    }
    public void setEname(String ename)
    {
        this.ename = ename;
    }
    public String getRuzhiTime()
    {
        return ruzhiTime;
    }
    public void setRuzhiTime(String ruzhiTime)
    {
        this.ruzhiTime = ruzhiTime;
    }
    public String getOrgName()
    {
        return orgName;
    }
    public void setOrgName(String orgName)
    {
        this.orgName = orgName;
    }
    public List<String> getJobNames()
    {
        return jobNames;
    }
    public void setJobNames(List<String> jobNames)
    {
        this.jobNames = jobNames;
    }
}
