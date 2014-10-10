package com.wugu.ycyp.webapp.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.wugu.ycyp.webapp.model.ApiResult;

public class HttpUtil {
	public static void responseJson(ApiResult<?> res,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(res.toJsonString());
		out.close();
	}
}
