/**
 * 
 */
package com.wugu.ycyp.webapp.util;

import org.springframework.context.ApplicationContext;

/**
 * @author Sean
 *
 */
public class ContextUtil {
	private static ApplicationContext context;
	/**
	 * 获取当前请求的ApplicationContext
	 * @getContext   
	 */
    public static ApplicationContext getContext() {
        return context;
    }
    /**
	 * 设置当前请求的ApplicationContext
	 * @getContext   
	 */
    public static void setContext(ApplicationContext aContext) {
        context = aContext;
        
    }
}
