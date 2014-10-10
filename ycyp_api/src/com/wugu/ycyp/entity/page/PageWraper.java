package com.wugu.ycyp.entity.page;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
public class PageWraper implements  Serializable{

    private static final long serialVersionUID = 6146862992514086545L;
    private PageInfo pageInfo=new PageInfo();
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
    public void setResult(List list) {
		result = list;
	}
}