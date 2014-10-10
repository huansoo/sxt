package com.wugu.zhaopin.vo;

import java.io.Serializable;

public class Company implements Serializable {
	public ZpCompanyContact companycontact;
	public ZpCompanyInfo companyinfo;

	public ZpCompanyInfo getCompanyinfo() {
		return companyinfo;
	}

	public void setCompanyinfo(ZpCompanyInfo companyinfo) {
		this.companyinfo = companyinfo;
	}

	public ZpCompanyContact getCompanycontact() {
		return companycontact;
	}

	public void setCompanycontact(ZpCompanyContact companycontact) {
		this.companycontact = companycontact;
	}
	
}
