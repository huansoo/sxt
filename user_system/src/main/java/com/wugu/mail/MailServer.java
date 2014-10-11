package com.wugu.mail;

import java.util.Properties;

import com.wugu.utils.Base64Encry;
import com.wugu.utils.InfoUtil;

public class MailServer {

	//stmp 地址
	private String serverHost;
	
	//端口
	private String serverPort = "25";
	
	// 邮件发送者的地址
	private String serverAddress;
	
	//发送者名称
	private String sendName;

	// 密码
	private String password;
	
	// 是否需要身份验证
	private boolean validate = true;
	
	//模板地址
	private String templatePath;
	
	public String getTemplatePath()
    {
        return templatePath;
    }

    public void setTemplatePath(String templatePath)
    {
        String path = InfoUtil.getClassPath();
        path = path.replace("classes", templatePath);
        this.templatePath = path;
    }

    public MailServer() {
		super();
	}

	public MailServer(String serverHost, String serverAddress, String sendName,
			String password, String templatePath) {
		super();
		this.serverHost = serverHost;
		this.serverAddress = serverAddress;
		this.sendName = sendName;
		if(templatePath != null){
		    String path = InfoUtil.getClassPath();
	        path = path.replace("classes", templatePath);
	        this.templatePath = path;
		}
		try {
			this.password = Base64Encry.decryptBASE64(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得邮件会话属性
	 */
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.serverHost);
		p.put("mail.smtp.port", this.serverPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			this.password = Base64Encry.decryptBASE64(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getSendName() {
		if(sendName==null){
			sendName="System";
		}
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	
}
