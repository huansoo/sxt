package com.wugu.zhaopin.webapp.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.springframework.mail.SimpleMailMessage;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.ModelDriven;
import com.wugu.zhaopin.webapp.model.BaseModel;

/**
 * 
 * @author 
 * @version 1.0.0.1  
 */

public abstract class BaseAction extends ActionSupport implements ModelDriven{
	private static final long serialVersionUID = -1495026132945839258L;
	public static final String CANCEL = "cancel";
    protected transient final Log log = LogFactory.getLog(getClass());
    protected String from = null;
    protected String cancel = null;
    protected String delete = null;
    protected String save = null;

    protected SimpleMailMessage message = null;
    protected String templateName = null;
    private final String ACTION_LIST_SESSION = "ACTION_LIST_SESSION";
    private String errorMessage="";
    
    public void saveMessage(String msg) {
        List messages = (List) getRequest().getSession().getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList();
        }
        messages.add(msg);
        getRequest().getSession().setAttribute("messages", messages);
    }
    
    /**
     * 
     * 在某页进行操作后返回该页
     *
     */
    public void returnPage(BaseModel model){
		if(StringUtils.isNotEmpty(model.getUseSession())){
			BaseModel sessionModel = (BaseModel)this.getSession().getAttribute(ACTION_LIST_SESSION);
			if( sessionModel != null ){
				sessionModel.setResult(model.getResult());
				this.setModel(sessionModel);
			}
		}else{
			this.getSession().setAttribute(ACTION_LIST_SESSION, model);
		}
    }
    
    /**
     * Convenience method to get the Configuration HashMap
     * from the servlet context.
     *
     * @return the user's populated form from the session
     */
    public Map getConfiguration() {
        Map config = (HashMap) getRequest().getSession().getServletContext()
                               .getAttribute("");
        // so unit tests don't puke when nothing's been set
        if (config == null) {
            return new HashMap();
        }
        return config;
    }
    
    /**
     * Convenience method to get the request
     * @return current request
     */
    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();  
    }
    
    /**
     * Convenience method to get the response
     * @return current response
     */
    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }
    
    /**
     * Convenience method to get the session
     */
    public HttpSession getSession() {
    	return getRequest().getSession();
    }
    
    
    public void setMessage(SimpleMailMessage message) {
        this.message = message;
    }
    
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    
    /**
     * Convenience method for setting a "from" parameter to indicate the last
     * page.
     * @param from
     */
    public void setFrom(String from) {
        this.from = from;
    }
    
    public void setCancel(String cancel) {
    	this.cancel = cancel;
    }
    
    public void setDelete(String delete) {
        this.delete = delete;
    }
    
    public void setSave(String save) {
        this.save = save;
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork.ModelDriven#getModel()
     */
    public abstract Object getModel();
    
    /**
     * @Desc ADD THIS METHOD FOR UNITTEST
     */
    public abstract void setModel( Object o);

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}  
}