package com.wugu.zhaopin.cache;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.wugu.zhaopin.cache.MemCached;
import com.wugu.zhaopin.commons.MD5Util;
/**
 * 
* @ClassName: MemCachedMaker
* @Description: 应用缓存存取数据
* @author lijun
* @date 2013-12-26 
*
 */
public abstract class MemCachedMaker {
	private static MemCachedClient memClient = MemCached.getmcc();
	
	/**
	 * 
	* @Title: set
	* @Description: 设置对象缓存
	* @author lijun
	* @param key
	* @param value
	* @throws
	 */
	public  static void set(String key,Object value){
		if(key==null || key.equals("")) return;
        System.out.println("设置缓存对象 Key键值:“" + key + "”");
        String md5Key = MD5Util.MD5Encode(key); 
        System.out.println("设置缓存对象 Key加密:“" + md5Key + "”");
		memClient.set(md5Key, value);
	}
	public  static void set(String key,Object value,int times){
		if(key==null || key.equals("")) return;
        System.out.println("设置缓存对象 Key键值:“" + key + "”");
        String md5Key = MD5Util.MD5Encode(key); 
        System.out.println("设置缓存对象 Key加密:“" + md5Key + "”");
		memClient.set(md5Key, value, new Date(times) );
		
	}
	
	/**
	 * 
	* @Title: get
	* @Description: 获得对象缓存
	* @author lijun
	* @param key
	* @return
	* @throws
	 */
	public  static Object get(String key){
	    System.out.println("获取缓存对象 Key键值:“" + key + "”");
	    String md5Key = MD5Util.MD5Encode(key); 
	    System.out.println("获取缓存对象 Key加密:“" + md5Key + "”");
		return memClient.get(md5Key);
	}
	/**
	 * 
	* @Title: hasCache
	* @Description: 判断是否存在缓存
	* @author lijun
	* @param key
	* @return
	* @throws
	 */
	public static boolean hasCache(String key) {
	    return memClient.keyExists(MD5Util.MD5Encode(key));
	}
	/**
	 * 
	* @Title: remove
	* @Description: 删除 指定缓存
	* @author lijun
	* @param key
	* @throws
	 */
	public static void remove(String key){
		memClient.delete(MD5Util.MD5Encode(key));
	}
}
