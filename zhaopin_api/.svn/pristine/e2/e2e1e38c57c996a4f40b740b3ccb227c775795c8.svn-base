package com.wugu.zhaopin.sms;

import com.wugu.zhaopin.commons.ValidateUtil;
import com.wugu.zhaopin.util.Base64Encry;


public class SMSServer {

	/**
	 * 广州志晴
	 */
	public static String PROVIDER_MOSI="MOSI";
	
	/**
	 * 短信服务提供商
	 */
	private String serverProvider;
	
	//短信服务的用户名
	private String userName;
	
	//短信服务的密码
	private String password ;
	
	//SOAPAction HTTP request header
	private String soapActionURI;
	
	
	public String getSoapActionURI()
    {
        return soapActionURI;
    }

    public void setSoapActionURI(String soapActionURL)
    {
        this.soapActionURI = soapActionURL;
    }

    public SMSServer() {
		super();
		this.serverProvider=PROVIDER_MOSI;
	}

	public SMSServer(String userName, String password, String soapActionURI) {
		super();
		this.serverProvider=PROVIDER_MOSI;
		this.userName = userName;
		this.soapActionURI = soapActionURI;
		try {
			this.password = Base64Encry.encryptBASE64(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			this.password = password;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getServerProvider() {
		return serverProvider;
	}

	public void setServerProvider(String serverProvider) {
		this.serverProvider = serverProvider;
	}
	
	private boolean isSopaUrlValid(String soapPreUrl){
        return (ValidateUtil.validateUrl(soapPreUrl) && 
                soapPreUrl.substring(soapPreUrl.length() - 1, soapPreUrl.length()).endsWith("/"));
	}
	public boolean isValid(){
	    return userName != null && password != null 
	            && soapActionURI != null && isSopaUrlValid(soapActionURI);
	}
	
}
