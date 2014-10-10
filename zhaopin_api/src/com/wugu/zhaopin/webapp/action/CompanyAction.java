package com.wugu.zhaopin.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.wugu.zhaopin.service.CompanyManager;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoCriteria;
import com.wugu.zhaopin.webapp.util.JobUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

public class CompanyAction extends BaseAction {

	private CompanyManager companymanager;
	
	public CompanyManager getCompanymanager() {
		return companymanager;
	}

	public void setCompanymanager(CompanyManager companymanager) {
		this.companymanager = companymanager;
	}
	
	public void getCompanyInfoByID() throws IOException, SQLException {
		
		String companyID = this.getRequest().getParameter("CompanyID");
		Integer CompanyID = Integer.parseInt(companyID);
		
		ZpCompanyInfoModel companyinfo = companymanager.selectCompanyByPrimaryKey(CompanyID);
		
		PrintWriter out = null;
		this.getResponse().setContentType("text/html;charset=utf-8");// 解决中文乱码
		out = this.getResponse().getWriter();

		out.close();		
	}

	public String getCompanyInfoLikeName() throws IOException, SQLException {
		
		String companyName = this.getRequest().getParameter("CompanyName");
		
		ZpCompanyInfoCriteria companyinfoct = new ZpCompanyInfoCriteria();
		companyinfoct.createCriteria().andNameLike("%" +companyName+"%");
		
		List<ZpCompanyInfoModel> list = companymanager.selectByExample(companyinfoct);
		
		JsonConfig config = JobUtil.getJsonConfig();
		JSONArray json = JSONArray.fromObject(list, config);
		
		
		PrintWriter out = null;
		this.getResponse().setContentType("text/html;charset=utf-8");// 解决中文乱码
		out = this.getResponse().getWriter();

		out.print(json.toString());
		out.close();
		
		return "getCompanyByID";
	}
	
	@Override
	public Object getModel() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setModel(Object o) {
		// TODO 自动生成的方法存根

	}

}
