package com.wugu.zhaopin.webapp.filter;

/**  
 * @Title: CharacterEncodingFilter.java
 * @Description: 
 * @author 
 * @date 
 * @version V1.0  
 */

import javax.servlet.*;
import java.io.*;
public class CharacterEncodingFilter implements Filter{
		private FilterConfig filterConfig;
		private String encoding=null;
	   
	   public void init(FilterConfig filterConfig){
	      this.filterConfig=filterConfig;
	      encoding=filterConfig.getInitParameter("encoding");
	   }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
				request.setCharacterEncoding(encoding);
				chain.doFilter(request,response);
	}

	public void destroy() {
		
	}
	
}