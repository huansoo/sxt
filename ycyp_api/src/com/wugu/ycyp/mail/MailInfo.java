package com.wugu.ycyp.mail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: MailInfo
* @Description: 邮件信息类
* @author yangch
*
 */
public class MailInfo implements Serializable{

	private static final long serialVersionUID = 7978358893754871565L;
	
	// 邮件接收者的地址
	private List<Person> toAdress = new ArrayList<Person>();
	// 抄送
	private List<Person> bccAdress = new ArrayList<Person>();
	// 暗送
	private List<Person> ccAdress = new ArrayList<Person>();
	// 邮件主题
	private String subject = "";
	// 邮件的文本内容
	private String content = "";
	// 邮件附件的文件名
	private List<String> atch = new ArrayList<String>();
	
	public List<Person> getToAdress() {
		return toAdress;
	}
	/**
	 * 添加收信人
	 * @param toAdress
	 */
	public void addToAdress(Person toAdress) {
		this.toAdress.add(toAdress);
	}
	/**
	 * 添加暗送人
	 * @param bccAdress
	 */
	public void addBccAdress(Person bccAdress) {
	    this.bccAdress.add(bccAdress);
	}
	/**
	 * 添加抄送人
	 * @param ccAdress
	 */
	public void addCcAdress(Person ccAdress) {
	    this.ccAdress.add(ccAdress);
	}
	/**
	 * 添加附件
	 */
	public void addAtch(String path) {
	    this.atch.add(path);
	}
	public List<Person> getBccAdress() {
		return bccAdress;
	}
	public List<Person> getCcAdress() {
		return ccAdress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getAtch() {
		return atch;
	}
	
	public String listToString(List<Person> list){
	    String str = "";
	    for (Person person : list)
        {
           str += "姓名=" + person.name;
           str += "邮箱地址=" + person.address;
           str += "     ";
        }
	    return str;
	}
	
	/**
	 * 收信人信息
	 * @author Administrator
	 */
	public static class Person implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 361815405618703809L;
		
		//姓名
		private String name;
		//地址
		private String address;
		
		public Person(){
		    super();
		}
		
		public Person(String name, String address) {
			super();
			this.name = name;
			this.address = address;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
	}
}
