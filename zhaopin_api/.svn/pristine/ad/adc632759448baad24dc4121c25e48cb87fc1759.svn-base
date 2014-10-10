/**
 * 
 */
package com.wugu.zhaopin.webapp.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * @author Sean
 *
 */
public class MyContextLoaderListener extends ContextLoaderListener {
	@Override
    public void contextInitialized(ServletContextEvent event){
        super.contextInitialized(event);
        ServletContext context = event.getServletContext();
         //获取web环境下的ApplicationContext
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        //将ApplicationContext，set到ContextUtil的静态变量context
        ContextUtil.setContext(ctx);
    }       
}
