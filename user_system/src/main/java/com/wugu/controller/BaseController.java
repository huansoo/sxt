/**  
* @Title:  BaseController.java
* @Package com.wugu.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author yangch
* @date  2014-9-15 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName: BaseController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-15 
 *
 */
public abstract class BaseController<T>
{
    protected transient final Logger log = Logger.getLogger(getClass());
    protected HttpServletRequest req;
    protected HttpServletResponse res;
    protected HttpSession session ;
    protected static ApplicationContext ac;
    /**
     * 
      * @Title: myWriter
      * @Description: 向前台返回json的方法
      * @author yangch
      * @date 2014-9-15 
      * @param json
      * @throws IOException
      * @throws
     */
    protected void myWriter( String json) throws IOException{
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = res.getWriter();
        writer.write(json);
        log.info(json);
        writer.close();
    }
    public HttpServletRequest getReq()
    {
        return req;
    }
    public void setReq(HttpServletRequest req)
    {
        this.req = req;
    }
    public HttpServletResponse getRes()
    {
        return res;
    }
    public void setRes(HttpServletResponse res)
    {
        this.res = res;
    }
    protected void setReqAndRes(HttpServletRequest req, HttpServletResponse res){
        this.req = req;
        this.res = res;
    }
    public HttpSession getSession()
    {
        return this.req.getSession();
    }
    public void setSession(HttpSession session)
    {
        this.session = session;
    }
}
