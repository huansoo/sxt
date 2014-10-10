package com.wugu.zhaopin.cache;

import java.util.Date;
import javax.servlet.http.HttpServletResponse;

import com.danga.MemCached.MemCachedClient;
import com.rc.service.client.util.RandomGUID;
import com.wugu.zhaopin.cache.CookieUtils;

public class HttpSessionUtil{
	private static MemCachedClient memClient = MemCached.getmcc();
	public static String setAttribute(HttpServletResponse response,String key,Object value){	
		RandomGUID random = new RandomGUID();
		String guid="";
		if(random!=null)
			guid = random.toString();
		
		memClient.set(guid, value,new Date(30*60*1000));//默认缓存半个小时
		
		CookieUtils.setCookie(response, key, guid, 60*60*24);
		return guid;
	}
		
	public static Object getAttribute(String key){
		return memClient.get(key);
	}
	
	public static boolean deleteMemContent(String key){
		return memClient.delete(key);
	}
	
	public static String setMemCache(Object value,int times){	
		RandomGUID random = new RandomGUID();
		String guid="";
		if(random!=null)
			guid = random.toString();
		
		if(times==0)
			memClient.set(guid, value);
		else
			memClient.set(guid, value,new Date(times*60*1000));//指定缓存时间
				
		return guid;
	}
		
	public static void main(String[] args){
		//System.out.println(setAttribute("123"));
	}
		
}
