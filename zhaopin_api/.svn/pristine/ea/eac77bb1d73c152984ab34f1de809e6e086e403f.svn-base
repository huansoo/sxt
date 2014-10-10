/**  
* @Title:  ResumeSearchModel.java
* @Package com.wugu.zhaopin.webapp.model
* @Description: 简历搜索条件
* @author lijun
* @date  2014-2-12 
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
 * @ClassName: ResumeSearchModel
 * @Description: 简历搜索条件
 * @author lijun
 * @date 2014-2-12 
 *
 */
public class ResumeSearchModel
{
    private String keyWord;         //关键字
    private Long userId;            //用户ID
    private String location;        //地点
    private Integer postType;       //职位类型
    private Integer educationBg;    //最低学历
    private Integer workExprience;  //工作经验
    private Integer sex;            //性别
    private Integer age;            //年龄
    private Integer startTime;      //查询开始时间
    private Integer finishTime;     //查询结束时间
    private Integer hopeSalary;     //期望薪资
    private Boolean hideOpenPart;   //是否过滤只对部分企业开放的简历
    
    public Boolean getHideOpenPart()
    {
        return hideOpenPart;
    }
    public void setHideOpenPart(Boolean hideOpenPart)
    {
        this.hideOpenPart = hideOpenPart;
    }

    public Integer getHopeSalary()
    {
        return hopeSalary;
    }
    public void setHopeSalary(Integer hopeSalary)
    {
        this.hopeSalary = hopeSalary;
    }

    private Integer page = 1;           //当前页
    private Integer pageSize = 20;      //分页大小
    
    public Integer getAge()
    {
        return age;
    }
    public void setAge(Integer age)
    {
        this.age = age;
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
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getPostType() {
        return postType;
    }
    public void setPostType(Integer postType) {
        this.postType = postType;
    }
    public Integer getEducationBg() {
        return educationBg;
    }
    public void setEducationBg(Integer educationBg) {
        this.educationBg = educationBg;
    }
    public Integer getWorkExprience() {
        return workExprience;
    }
    public void setWorkExprience(Integer workExprience) {
        this.workExprience = workExprience;
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
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
        return  userId == null 
                && postType == null
                && educationBg == null
                && workExprience == null
                && sex == null
                && startTime == null
                && finishTime == null
                && location == null;
    }
}