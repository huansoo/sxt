package com.wugu.zhaopin.webapp.model;

import java.io.Serializable;

public class PostSearchModel extends BaseModel {
	private String keyWord;     	//关键字
	private Integer companyId;  	//公司ID
	private String excludingIds;	//不包含职位ID
	private Integer postType;   	//职位类型
	private Integer salary;     	//薪资
	private Integer workExprience;	//工作经验
	private Integer companyType; 	//公司类型
	private Integer startTime;		//查询开始时间
	private Integer finishTime;		//查询结束时间
	private Integer status;         //状态
    private String workAddress;		//地点
    private Integer educationBg;    //最低学历
	
	public Integer getEducationBg()
    {
        return educationBg;
    }
    public void setEducationBg(Integer educationBg)
    {
        this.educationBg = educationBg;
    }

    private Integer page = 1; 			//当前页
	private Integer pageSize = 20;		//分页大小
	
    public Integer getStatus()
    {
        return status;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getWorkAdress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getExcludingIds() {
		return excludingIds;
	}
	public void setExcludingIds(String excludingIds) {
		this.excludingIds = excludingIds;
	}
	public Integer getPostType() {
		return postType;
	}
	public void setPostType(Integer postType) {
		this.postType = postType;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getWorkExprience() {
		return workExprience;
	}
	public void setWorkExprience(Integer workExprience) {
		this.workExprience = workExprience;
	}
	public Integer getCompanyType() {
		return companyType;
	}
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public Integer getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Integer finishTime) {
		this.finishTime = finishTime;
	}
	
	private boolean isStringNull(String value){
	    return value == null || "".equals(value.trim()); 
	}
	
	public boolean isAllNull(){
	    return isStringNull(excludingIds)
	            && companyId == null 
	            && postType == null
	            && salary == null
	            && workExprience == null
	            && companyType == null
	            && startTime == null
	            && finishTime == null
	            && workAddress == null;
	}
}
