package com.wugu.zhaopin.cache;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	public CookieUtils() {
	}

	/**
	 * 
	* @Title: getCookieValue
	* @Description: 根据Cookie名称得到Cookie的值，没有返回Null
	* @author lijun
	* @param request
	* @param name
	* @return
	* @throws
	 */
	public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie cookie = getCookie(request, name);
		if (cookie != null) {
			return cookie.getValue();
		} else {
			return null;
		}
	}

	/**
	 * 
	* @Title: getCookie
	* @Description: 根据Cookie名称得到Cookie对象，不存在该对象则返回Null
	* @author lijun
	* @param request
	* @param name
	* @return
	* @throws
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null || name == null || name.length() == 0)
			return null;
		Cookie cookie = null;
		for (int i = 0; i < cookies.length; i++) {
			if (!cookies[i].getName().equals(name))
				continue;
			cookie = cookies[i];
			if (request.getServerName().equals(cookie.getDomain()))
				break;
		}
		return cookie;
	}

	/**
	 * 
	* @Title: deleteCookie
	* @Description: 删除指定Cookie
	* @author lijun
	* @param response
	* @param cookie
	* @throws
	 */
	public static void deleteCookie(HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			cookie.setPath("/");
			cookie.setValue("");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}

	/**
	 * 
	* @Title: deleteCookie
	* @Description: 删除指定Cookie
	* @author lijun
	* @param response
	* @param cookie
	* @param domain
	* @throws
	 */
	public static void deleteCookie(HttpServletResponse response, Cookie cookie, String domain) {
		if (cookie != null) {
			cookie.setPath("/");
			cookie.setValue("");
			cookie.setMaxAge(0);
			cookie.setDomain(domain);
			response.addCookie(cookie);
		}
	}

	/**
	 * 
	* @Title: setCookie
	* @Description: 添加一条新的Cookie信息，默认有效时间为一个月
	* @author lijun
	* @param response
	* @param name
	* @param value
	* @throws
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 0x278d00);
	}

	/**
	 * 
	* @Title: setCookie
	* @Description: 添加一条新的Cookie信息，可以设置其最长有效时间(单位：秒)
	* @author lijun
	* @param response
	* @param name
	* @param value
	* @param maxAge
	* @throws
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		if (value == null)
			value = "";
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge,String domain) {
		if (value == null)
			value = "";
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * 
	* @Title: setCookie
	* @Description: 添加一条新的Cookie信息，可以设置其Name，Value，MaxAge，Path，Domain(单位：秒)
	* @author lijun
	* @param response
	* @param name
	* @param value
	* @param maxAge
	* @param path
	* @param domain
	* @throws
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge, String path, String domain) {
		if (value == null)
			value = "";
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath(path);
		if (domain != null && domain.trim().length() > 0) {
			cookie.setDomain(domain);
		}
		response.addCookie(cookie);
	}
}
