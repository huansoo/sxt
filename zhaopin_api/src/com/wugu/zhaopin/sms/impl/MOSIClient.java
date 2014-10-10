/**  
* @Title:  MOSIClient.java
* @Package com.wugu.zhaopin.sms.impl
* @Description: 广州志晴短信接口
* @author lijun
* @date  2014-1-9 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.sms.impl;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException; 

import com.wugu.zhaopin.commons.ConverStr;
import com.wugu.zhaopin.commons.ValidateUtil;


/**
 * @ClassName: MOSIClient
 * @Description: 广州志晴短信接口类
 * @author lijun
 * @date 2014-1-9 
 *
 */
public class MOSIClient
{
    private static final String METHOD_MT = "mt"; //发送短信方法字符串
    private static final String METHOD_BALANCE = "balance"; //查询余额方法字符串
    private static final String METHOD_GXMT = "gxmt"; //个性短信方法字符串
    private static final String METHOD_SENDSMSAUTO = "SendSMS"; //自动发送短信方法字符串
    private static final String METHOD_RECEIVESMS = "recsms"; //接收短信方法字符串
    private static final String METHOD_GETALLINFO = "GetAllInfo"; //获取全部短信方法字符串
    
    private static final String[] ErrorInfoList = {"发送成功","用户名或密码错误","发送短信余额不足","参数有误","权限受限","Ip失败","内部数据库错误"}; //错误代码
    private static final List<String> ErrorIndexList = Arrays.asList(new String[]{"0", "-1", "-2", "-6", "-7", "-8", "-11"}); //错误代码
    
    private static final String RESULT_EXTSTRING = "<{method}Result>(.*)</{method}Result>"; //返回结果xml节点名称
    
    private StringBuilder soapXmlStr;
    /*
     * webservice服务器定义
     */
    private String serviceURL = "http://sms.4006555441.com/webservice.asmx";

    private String userName = null;// 用户名 wugu

    private String password = null;// 密码 888888
    
    private String soapActionUrl = null;//"http://tempuri.org/"; //soap地址
    
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSoapPreUrl()
    {
        return soapActionUrl;
    }

    public void setSoapPreUrl(String soapPreUrl)
    {
        if (ValidateUtil.validateUrl(soapPreUrl) && 
                soapPreUrl.substring(soapPreUrl.length() - 1, soapPreUrl.length()).endsWith("/"))
            this.soapActionUrl = soapPreUrl;
        else
            this.soapActionUrl = null;
    }
   
    private void iniSoapXml(){
        soapXmlStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        soapXmlStr.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        soapXmlStr.append("<soap:Body>");
        soapXmlStr.append("<{method} xmlns=\"" + soapActionUrl + "\">");
        soapXmlStr.append("<Sn>" + userName + "</Sn>");
        soapXmlStr.append("<Pwd>" + password + "</Pwd>");
        soapXmlStr.append("</{method}>");
        soapXmlStr.append("</soap:Body>");
        soapXmlStr.append("</soap:Envelope>");
    }
    
    public MOSIClient(String userName, String password, String soapActionUrl){     
        this.userName = userName;
        this.password = password;
        this.soapActionUrl = soapActionUrl;
        soapXmlStr = new StringBuilder();
        iniSoapXml();
    }
    
    private HttpURLConnection post(String soapAction, String xml){
        URL url;
        try{
            url = new URL(serviceURL);
            URLConnection connection = url.openConnection();
            HttpURLConnection httpconn = (HttpURLConnection) connection;
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            bout.write(xml.getBytes("utf-8"));
            byte[] b = bout.toByteArray();
            httpconn.setRequestProperty("Content-Length", String
                    .valueOf(b.length));
//            httpconn.setRequestProperty("Content-Type",
//                    "text/xml; charset=utf-8");
            httpconn.setRequestProperty("Content-Type","text/xml; charset=utf-8"); 
            httpconn.setRequestProperty("contentType", "utf-8");
            httpconn.setRequestProperty("SOAPAction", soapAction);
            httpconn.setRequestMethod("POST");
            httpconn.setDoInput(true);
            httpconn.setDoOutput(true);
    
            OutputStream out = httpconn.getOutputStream();
            out.write(b);
            out.close();
            
            return httpconn;
        }
        catch (Exception e){
            e.printStackTrace(); 
           return null; 
        }
        
    }
    
    private String getResult(String method, String soapXmlStr){
        String xmlStr = soapXmlStr.replace("{method}", method);

        String result = "";
        String soapAction = soapActionUrl + method;
        try {
            HttpURLConnection httpconn = post(soapAction, xmlStr);
            InputStreamReader isr = new InputStreamReader(httpconn
                    .getInputStream(), "utf-8");
            BufferedReader in = new BufferedReader(isr);
            String inputLine;
            while (null != (inputLine = in.readLine())) {
                Pattern pattern = Pattern
                        .compile(RESULT_EXTSTRING.replace("{method}", method));
                Matcher matcher = pattern.matcher(inputLine);
                while (matcher.find()) {
                    result = matcher.group(1);
                }
            }
            System.out.println(in.toString());
            in.close();
            //System.out.println(result);
            //result = ConverStr.converStr.changeCharset(result, "utf-8", "utf-8");
            //result = result;
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }        
    }
    
    private String call(String method, String soapXmlStr){
        return getResult(method, soapXmlStr);
    }
    
    /**
     * 
    * @Title: balance
    * @Description: 获取剩余短信条数 
    * @author lijun
    * @return 返回剩余短信条数，出错返回0
    * @throws
     */
    public Integer balance() {
        String result = call(METHOD_BALANCE, soapXmlStr.toString());
        return Integer.valueOf(result);
    }
    
    /**
     * 
    * @Title: mt
    * @Description: 发送短信
    * @author lijun
    * @param mobile 手机号 多个手机以小写逗号隔开
    * @param content 内容
    * @return
    * @throws Exception
    * @throws
     */
    public String mt(String mobile, String content) throws Exception {
        StringBuilder soapXmlStr_mt = new StringBuilder();
        String newContent = new String(content.getBytes("utf-8"), "utf-8");
        soapXmlStr_mt.append(soapXmlStr);
        soapXmlStr_mt.insert(soapXmlStr_mt.indexOf("</{method}>"), "<mobile>" + mobile + "</mobile>");
        soapXmlStr_mt.insert(soapXmlStr_mt.indexOf("</{method}>"), "<content>" + newContent + "</content>");
        
        return call(METHOD_MT, soapXmlStr_mt.toString()); 
    }   
    
    /**
     * 
    * @Title: sendSMSAuto
    * @Description: 定时发送短信
    * @author lijun
    * @param mobile 手机号 多个手机以小写逗号隔开
    * @param content 内容
    * @param sTime 定时时间 (格式如2010-11-11 11:11:00)
    * @return
    * @throws Exception
    * @throws
     */
    public String sendSMSAuto(String mobile, String content, String sTime) throws Exception {
        StringBuilder soapXmlStr_mt = new StringBuilder();
        String newContent = new String(content.getBytes("utf-8"), "utf-8");
        soapXmlStr_mt.append(soapXmlStr);
        soapXmlStr_mt.insert(soapXmlStr_mt.indexOf("</{method}>"), "<mobile>" + mobile + "</mobile>");
        soapXmlStr_mt.insert(soapXmlStr_mt.indexOf("</{method}>"), "<content>" + newContent + "</content>");
        soapXmlStr_mt.insert(soapXmlStr_mt.indexOf("</{method}>"), "<stime>" + sTime + "</stime>");        
        return call(METHOD_SENDSMSAUTO, soapXmlStr_mt.toString()); 
    }   
    
    /**
     * 
    * @Title: recsms
    * @Description: 接收信息
    * @author lijun
    * @return 成功返回：ID，手机号，内容，时间
    * @throws
     */
    public String recsms(){
        return call(METHOD_RECEIVESMS, soapXmlStr.toString()); 
    }
    
    /**
     * 
    * @Title: GetAllInfo
    * @Description: 获取账户信息
    * @author lijun
    * @return xml字符串 <UserInfo xmlns=""><Result>0</Result><Sn>wugu</Sn><Balance>14</Balance><Agent>阿冰</Agent><Port></Port><Signature>【吾谷网】</Signature><Flag>True</Flag></UserInfo>
    * @throws
     */
    public String GetAllInfo(){
        return call(METHOD_GETALLINFO, soapXmlStr.toString());  
    }
    
    /**
     * 
    * @Title: getErrorInfo
    * @Description: 获取返回值错误信息
    * @author lijun
    * @param code
    * @return
    * @throws
     */
    public static String getErrorInfo(String code){
        int index = ErrorIndexList.indexOf(code);
        return ErrorInfoList[index];
    }
    
    public static void main(String[] arg) throws Exception{
        MOSIClient client = new MOSIClient("SDK-ZQ-WG-0699", "888888", "http://tempuri.org/");
        
        System.out.println(client.GetAllInfo());
//        String urlStr = "http://tempuri.org/";
//        if (ValidateUtil.validateUrl(urlStr) && urlStr.substring(urlStr.length() - 1, urlStr.length()).endsWith("/"))
//            System.out.println( "url 正确");        
//        else
//            System.out.println( "url 不可用");
        
    }
}