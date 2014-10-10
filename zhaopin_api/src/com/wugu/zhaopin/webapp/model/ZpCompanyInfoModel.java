package com.wugu.zhaopin.webapp.model;

import java.io.Serializable;

public class ZpCompanyInfoModel implements Serializable {
	
	private ZpCompanyContactModel companyContact;

	public ZpCompanyContactModel getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(ZpCompanyContactModel companyContact) {
		this.companyContact = companyContact;
	}

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.company_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Integer companyId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.name
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Long userId;
	
	private String userName;
	
	public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    private String name;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.introduce
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private String introduce;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.industry_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private String industryId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.company_type
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Integer companyType;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.scale_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Integer scaleId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.license
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private String license;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.site_url
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private String siteUrl;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.type
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Integer type;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.status
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Integer status;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.create_time
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Integer createTime;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.update_time
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Integer updateTime;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column zp_company_info.op_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	private Long opId;
	
	/**
	 * 新的简历数量
	 */
	private Long newDeliveryCount;
	
	/**
	 * 验证方式 1：手机 2：邮件 3：图片
	 */
	private Integer verifyType;

	public Integer getVerifyType()
    {
        return verifyType;
    }

    public void setVerifyType(Integer verifyType)
    {
        this.verifyType = verifyType;
    }

    public Long getNewDeliveryCount()
    {
        return newDeliveryCount;
    }

    public void setNewDeliveryCount(Long newDeliveryCount)
    {
        this.newDeliveryCount = newDeliveryCount;
    }

    /**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.company_id
	 * @return  the value of zp_company_info.company_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.company_id
	 * @param companyId  the value for zp_company_info.company_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.name
	 * @return  the value of zp_company_info.name
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.name
	 * @param name  the value for zp_company_info.name
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.introduce
	 * @return  the value of zp_company_info.introduce
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.introduce
	 * @param introduce  the value for zp_company_info.introduce
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.industry_id
	 * @return  the value of zp_company_info.industry_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public String getIndustryId() {
		return industryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.industry_id
	 * @param industryId  the value for zp_company_info.industry_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.company_type
	 * @return  the value of zp_company_info.company_type
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Integer getCompanyType() {
		return companyType;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.company_type
	 * @param companyType  the value for zp_company_info.company_type
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.scale_id
	 * @return  the value of zp_company_info.scale_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Integer getScaleId() {
		return scaleId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.scale_id
	 * @param scaleId  the value for zp_company_info.scale_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.license
	 * @return  the value of zp_company_info.license
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.license
	 * @param license  the value for zp_company_info.license
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.site_url
	 * @return  the value of zp_company_info.site_url
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public String getSiteUrl() {
		return siteUrl;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.site_url
	 * @param siteUrl  the value for zp_company_info.site_url
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.type
	 * @return  the value of zp_company_info.type
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.type
	 * @param type  the value for zp_company_info.type
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.status
	 * @return  the value of zp_company_info.status
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.status
	 * @param status  the value for zp_company_info.status
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.create_time
	 * @return  the value of zp_company_info.create_time
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Integer getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.create_time
	 * @param createTime  the value for zp_company_info.create_time
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.update_time
	 * @return  the value of zp_company_info.update_time
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Integer getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.update_time
	 * @param updateTime  the value for zp_company_info.update_time
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column zp_company_info.op_id
	 * @return  the value of zp_company_info.op_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public Long getOpId() {
		return opId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column zp_company_info.op_id
	 * @param opId  the value for zp_company_info.op_id
	 * @ibatorgenerated  Wed Dec 18 15:16:23 CST 2013
	 */
	public void setOpId(Long opId) {
		this.opId = opId;
	}
}