/**  
* @Title:  DbManager.java
* @Package com.wugu.ycyp.util
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-8-18 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: DbManager
 * @Description: 数据库工具
 * @author lijun
 * @date 2014-8-18 
 *
 */
public class DbManager
{
    /**
     * 
    * @Title: dbMysqlConnection
    * @Description: mysql数据库连接
    * @author lijun
    * @param host
    * @param port
    * @param dbaName
    * @param usName
    * @param psw
    * @return
    * @throws
     */
    public static Connection dbMysqlConnection(String host, String port, 
            String dbaName, String usName, String psw) 
    { 
        Connection dbconn = null;
        String driverName = "com.mysql.jdbc.Driver";
        String dbHost = host;//数据库的一些信息 
        String dbPort = port; 
        String dbName = dbaName; 
        String enCoding = "?useUnicode=true&characterEncoding=utf-8"; //解决MySql中文问题,要连续写不能空格 
        
        String userName = usName; 
        String Psw = psw; 
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + enCoding;
   
        try 
        { 
            Class.forName(driverName).newInstance(); 
            dbconn = DriverManager.getConnection(url, userName, Psw); 
        }catch(Exception e){ 
            System.out.println("url = " + url); //发生错误时，将连接数据库信息打印出来 
            System.out.println("userName = " + userName); 
            System.out.println("Psw" + Psw); 
            System.out.println("Exception: " + e.getMessage());//得到出错信息 
        } 
   
        return dbconn; 
    }
    
    public static ArrayList dbSelect(String tableName, ArrayList fields, 
            String selCondition, Connection dbconn) 
    { 
           ArrayList mapInList = new ArrayList();   

           String selFields = ""; 

           for (int i = 0; i<fields.size(); ++i) 
                  selFields += fields.get(i) + ", "; 

           String selFieldsTem = selFields.substring(0, selFields.length() - 2);//根据String的索引提取子串 
           try{ 
               Statement dbstate = dbconn.createStatement();
               ResultSet dbresult = null;
               String sql = "select " + selFieldsTem + " from " + tableName + selCondition; 
               System.out.println("sql = " + sql); 
                  
               try{
                   dbresult = dbstate.executeQuery(sql); 
               }catch(Exception err){ 
                   System.out.println("Sql = " + sql); 
                   System.out.println("Exception: " + err.getMessage()); 
               } 

               while(dbresult.next()){
                   Map selResult = new HashMap(); 
                   for (int i = 0; i<fields.size(); ++i){
                       String strField = (String)fields.get(i);
                       selResult.put(strField, dbresult.getString(strField)); 
                       //selResult.put("USERNAME", dbresult.getString("USERNAME")); 
                   }
                   mapInList.add(selResult); 
               } 

           }catch(Exception e){ 
               System.out.println("Exception: " + e.getMessage()); 
           } 
           return mapInList; 
    }
    
    public static boolean dbUpdate(String tabName, HashMap reCount, String upCondition, Connection dbconn) 
    { 
           boolean updateResult = false; 
           String Values = ""; 
           Iterator keyValues = reCount.entrySet().iterator(); 
           for(int i = 0; i<reCount.size(); ++i) 
           { 
               Map.Entry entry = (Map.Entry) keyValues.next(); 
               Object key = entry.getKey(); 
               Object value = entry.getValue(); 
               Values += key + "=" + "'" + value + "'" + ", "; 
           } 
           String updateValues = Values.substring(0, Values.length() - 2); 
           String sql = "update " + tabName + " set " + updateValues + " " + upCondition; 
           try 
           { 
               System.out.println(sql);
               Statement dbstate = dbconn.createStatement();
               dbstate.executeUpdate(sql); 
               updateResult = true; 
           }catch(Exception err){ 
               System.out.println("sql = " + sql); 
               System.out.println("Exception: " + err.getMessage()); 
           } 
           if (updateResult) 
                  return true; 
           else 
                  return false; 
    }
}
