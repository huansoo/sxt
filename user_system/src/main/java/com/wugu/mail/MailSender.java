package com.wugu.mail;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.wugu.mail.MailInfo.Person;
import com.wugu.utils.Base64Encry;

/**
 * 
* @ClassName: MailSender
* @Description: 邮件发送工具类
* @author lijun
* @date 2014-1-15 
*
 */
public class MailSender {
	
	private MailServer server;
	private static Logger log = Logger.getLogger(MailSender.class);
	
	public MailSender(MailServer server) {
		super();
		this.server = server;
	}

	public MailServer getServer() {
		return server;
	}

	public void setServer(MailServer server) {
		this.server = server;
	}
	
	private Address[] getAddressArr(List<Person> list) throws Exception{
	    Address[] to = new Address[list.size()];
        for(int i = 0 ;i < list.size(); i++ ){
            Person p = list.get(i);
            if(p.getName() == null){
                to[i] = new InternetAddress(p.getAddress());
            }else{
                to[i] = new InternetAddress(p.getAddress(), MimeUtility.encodeText(p.getName(), MimeUtility.mimeCharset("utf-8"), null));
            }
        }
	    return to;
	}
	
	private void setRecipients_TO(Message mailMessage, MailInfo mailInfo) throws Exception{
        // 创建邮件的接收者地址，并设置到邮件消息中
        if(mailInfo.getToAdress().size() == 0){
            throw new Exception("至少要有一个收件人");
        }
        
        Address[] to = getAddressArr(mailInfo.getToAdress());
        
        mailMessage.setRecipients(Message.RecipientType.TO, to);	    
	}
	
	private void setRecipients_CC(Message mailMessage, MailInfo mailInfo) throws Exception{
        //添加抄送
        if(mailInfo.getCcAdress().size() > 0){
            Address[] cc = getAddressArr(mailInfo.getCcAdress());
            mailMessage.setRecipients(Message.RecipientType.CC, cc);
            log.info("邮件抄送地址：" + mailInfo.listToString(mailInfo.getCcAdress()));
        }	    
	}
	
	private void setRecipients_BCC(Message mailMessage, MailInfo mailInfo) throws Exception{
	    //添加暗送
        if(mailInfo.getBccAdress().size() > 0){
            Address[] bcc = getAddressArr(mailInfo.getBccAdress());            
            
            mailMessage.setRecipients(Message.RecipientType.BCC, bcc);
            log.info("邮件暗送地址：" + mailInfo.listToString(mailInfo.getBccAdress()));
        }	    
	}
	
	private void setHTMLPart(Message mailMessage, MailInfo mailInfo) throws Exception{
        // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();       
        
        //添加附件
        if(mailInfo.getAtch().size() > 0){
            for(String s : mailInfo.getAtch()){
                MimeBodyPart mbp = new MimeBodyPart(); 
                FileDataSource fds = new FileDataSource(s);
                mbp.setDataHandler(new DataHandler(fds));
                mbp.setFileName(MimeUtility.encodeWord(fds.getName(), "GB2312", null));
                mainPart.addBodyPart(mbp);
            }
            log.info("邮件附件地址：" + mailInfo.getAtch().toString());
        }
        
        // 设置HTML内容
        MimeBodyPart html = new MimeBodyPart();
        html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        
        // 将MiniMultipart对象设置为邮件内容
        mailMessage.setContent(mainPart);
        mailMessage.setSentDate(new Date());	    
	}
	
	private void sendMail_in(MailInfo mailInfo)throws Exception{
        Properties pro = server.getProperties();
        MailAuth auth = null;
        try
        {
            if (server.isValidate()) {
                String pass = Base64Encry.decryptBASE64(server.getPassword());
                auth = new MailAuth(server.getServerAddress(),
                        server.getPassword());
            }
            
            Session sendMailSession = Session.getDefaultInstance(pro, auth);
            Message mailMessage = new MimeMessage(sendMailSession);
            
            log.info("………………开始发送邮件………………");
            // 设置邮件消息的主题
            mailMessage.setSubject(MimeUtility.encodeText(mailInfo.getSubject(), MimeUtility.mimeCharset("utf-8"), null));
            log.info("邮件主题：" + mailInfo.getSubject());
            
            // 创建邮件发送者地址        
            Address from = new InternetAddress(server.getServerAddress(), 
                        MimeUtility.encodeText(server.getSendName(), MimeUtility.mimeCharset("utf-8"), null));
            mailMessage.setFrom(from);
            
            log.info("邮件接收者地址：" + mailInfo.listToString(mailInfo.getToAdress()));
            //设置邮件的接收者地址
            setRecipients_TO(mailMessage, mailInfo);
            
            //添加抄送
            setRecipients_CC(mailMessage, mailInfo);     
            
            //添加暗送
            setRecipients_BCC(mailMessage, mailInfo);
            
            //添加HTML相关内容，包括内容和附件等
            setHTMLPart(mailMessage, mailInfo);
            
            // 发送邮件
            Transport.send(mailMessage);
            log.info("………………邮件发送成功………………");                    
        }
        catch (Exception e)
        {
            log.error("邮件发送失败：" + e);
        }
	}

	/**
	 * 
	* @Title: sendMail
	* @Description: 发送邮件
	* @author lijun
	* @param mailInfo 邮件信息对象
	* @throws Exception
	* @throws
	 */
	public void sendMail(MailInfo mailInfo)throws Exception{
		if((server == null)||(server.getServerHost() == null)
				||(server.getServerAddress() == null)||(server.getPassword() == null)
				){
			throw new Exception("邮件服务器为空或者配置不全");
		}
		
		sendMail_in(mailInfo);
	}
	
	/**
	 * 
	* @ClassName: MailAuth
	* @Description: 邮件权限类
	* @author lijun
	* @date 2014-1-15 
	*
	 */
	static class MailAuth extends Authenticator{
		String userName = null;   
	    String password = null;   
	        
	    public MailAuth(){   
	    }   
	    public MailAuth(String username, String password) {    
	        this.userName = username;    
	        this.password = password;    
	    }    
	    protected PasswordAuthentication getPasswordAuthentication(){   
	        return new PasswordAuthentication(userName, password);   
	    }   
	}
	
	public static void main(String[] args) throws Exception {
		MailServer server = new MailServer("smtp.exmail.qq.com","yangchuanhuan@wugu.com.cn","吾谷网","huan813805", "/webapps/zhaopin/WEB-INF/pages/companyMailContent.html");
		MailSender sender = new MailSender(server);
		MailInfo mailInfo = new MailInfo();
		
		mailInfo.setSubject("偶是测试啊，有木有");    
	    mailInfo.setContent("<html><body><h1>偶是测试啊，有木有</h1></body></html>"); //<html><body><h1></h1></body></html>
	    mailInfo.addToAdress(new Person("杨传环", "yangchuanhuan@wugu.com.cn"));
	    mailInfo.addCcAdress(new Person("杨传环", "991622230@qq.com"));
	    mailInfo.addBccAdress(new Person("杨传环", "huansoo@163.com"));
	    mailInfo.addAtch("D:\\work\\ARCH4系统架构设计说明书.doc");
	    
	    JSONObject obj = JSONObject.fromObject(mailInfo);
	    System.out.println(obj.toString());
	    
		sender.sendMail(mailInfo);
	}
}
