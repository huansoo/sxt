package com.wugu.zhaopin.webapp.model.page;
import java.util.List;

/**
 * 
 * @author wind
 *
 */
public class PageManager{
	public PageManager()
	{
	}
		
	/**
	 * 删除order by
	 * 
	 * @param sql
	 *            String
	 * @return String
	 */
	private static String delOrderBy(String sql)
	{
		StringBuffer temp = new StringBuffer();
		sql = "(" + sql + ")";
		int position;
		String[] strArray = sql.split("order by");
		for (int i = 1; i < strArray.length; i++)
		{
			strArray[i] = ")";
		}
		for (int i = 0; i < strArray.length; i++)
		{
			temp.append(strArray[i]);
		}
		String result = temp.toString();
		if (temp.length() >= 2)
		{
			result = result.substring(1, result.length() - 1);
		}
		return result;
	}

	/**
	 * @desc  针对分页查询的 分页信息的包装
	 * @param pageInfo		修改设置 当前页/页面大小/页面分组大小  默认为PageConst中设定
	 * @param pageResult	当前页的查询结果
	 * @param count			满足查询条件 的总记录数
	 * @return
	 */
	public static PageWraper getPageWraper(PageInfo pageInfo, List pageResult, int count){
	  PageWraper pageWraper = new PageWraper();
	  pageWraper.setPageInfo(new PageInfo());
	  
	  if(pageResult == null || pageResult.size() < 1){
		  return pageWraper;
	  }
	  else{
		  pageInfo.setCount(count);
		  pageInfo = PageInfo.resetPageInfo(pageInfo);
		  pageWraper.setResult(pageResult);
		  pageWraper.setPageInfo(pageInfo);
	  }
	  return pageWraper;
	}
}
