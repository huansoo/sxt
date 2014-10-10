/**
 * 
 */
package com.wugu.zhaopin.webapp.action;

import java.io.IOException;
import java.sql.SQLException;

import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.service.UserManager;
import com.wugu.zhaopin.webapp.model.ApiResult;

/**
 * @author Sean
 * 
 */
public class UserAction extends BaseAction {

	private static final long serialVersionUID = -6245981612905654162L;
	private UserManager usermanager;

	public UserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}

	public void checkUserExists() throws IOException, SQLException {
		Long userid = 0L;
		ApiResult<Integer> apiresult = new ApiResult<Integer>();
		try {
			userid = Long.parseLong(getRequest().getParameter("userid"));
			int result = 0;//usermanager.checkUserExists(userid);
			apiresult.setData(result);
		} catch (Exception ex) {
			apiresult.setStatus(500);
			apiresult.setData(0);
			apiresult.setException(ex.toString());
		}
		HttpUtil.responseJson(apiresult, getResponse());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wugu.zhaopin.webapp.action.BaseAction#getModel()
	 */
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wugu.zhaopin.webapp.action.BaseAction#setModel(java.lang.Object)
	 */
	@Override
	public void setModel(Object o) {
		// TODO Auto-generated method stub

	}

}
