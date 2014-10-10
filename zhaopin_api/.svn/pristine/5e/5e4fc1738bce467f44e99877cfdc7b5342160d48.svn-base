package com.wugu.zhaopin.webapp.model.page;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
public class PageWraper implements  Serializable{
	private PageInfo pageInfo=new PageInfo();
	private List result=new ArrayList();
	public void setpage(int page,int pageSize){
		pageInfo.setPage(page);
		pageInfo.setPageSize(pageSize);
	}
	/**
	 * @return
	 */
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	/**
	 * @return
	 */
	public List getResult() {
		return result;
	}
	/**
	 * @param info
	 */
	public void setPageInfo(PageInfo info) {
		pageInfo = info;
	}	
	/**
	 * @param list
	 */
	public void setResult(List list) {
		result = list;
	}
}