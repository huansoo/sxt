package com.wugu.zhaopin.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.wugu.zhaopin.webapp.action.BaseAction;


/**
 * @Title: helloAction.java
 * @Description:
 * @author 
 * @date 
 * @version V1.0
 */

public class HelloAction extends BaseAction {
	private Condition model = new Condition();


	/**
	 * 
	 * 
	 * @return
	 */
	public String showHello() throws IOException {
		
		PrintWriter out = this.getResponse().getWriter();
		
		JSONObject json = new JSONObject();
		
		json.element("id", "11111");
		json.element("name", "lijun");
		
		out.print(json.toString());
		out.close();		
	
		return "toHello";
	}


	public class Condition {
		private Integer id;
		private Integer fid;
		private Integer sid;
		private String name;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getFid() {
			return fid;
		}

		public void setFid(Integer fid) {
			this.fid = fid;
		}

		public Integer getSid() {
			return sid;
		}

		public void setSid(Integer sid) {
			this.sid = sid;
		}
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}

	@Override
	public void setModel(Object o) {
		// TODO Auto-generated method stub
		this.model = (Condition) o;
	}

}
