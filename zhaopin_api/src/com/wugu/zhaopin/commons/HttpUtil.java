package com.wugu.zhaopin.commons;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.wugu.zhaopin.webapp.model.ApiResult;

public class HttpUtil {
	public static void responseJson(ApiResult<?> res,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(res.toJsonString());
		out.close();
	}
}
