/**  
* @Title:  PersonJob.java
* @Package com.wugu.ycyp.webapp.job
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-23 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.webapp.job;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wugu.ycyp.entity.Area;
import com.wugu.ycyp.entity.Person;
import com.wugu.ycyp.webapp.adapter.PersonAdapter;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.Code;

/**
 * @ClassName: PersonJob
 * @Description: 人物控制类
 * @author lijun
 * @date 2014-7-23 
 *
 */
@Controller("PersonJob")
public class PersonJob extends BaseJob
{
    @Autowired
    private PersonAdapter personAdapter;
    
    private String content = "人物";
   /**
     * 
    * @Title: getList
    * @Description: 获取人物列表
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void getList() throws Exception{
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                throw new Exception("query json missed!");
            }
            
            String data = personAdapter.getList(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: getRecycleList
    * @Description: 获取回收站人物列表
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void getRecycleList() throws Exception{
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                throw new Exception("query json missed!");
            }
            
            String data = personAdapter.getRecycleList(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    /**
     * 
    * @Title: insert
    * @Description: 新增人物
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void insert() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                throw new Exception("query json missed!");
            }
            
            logger.info("新增" + content + "，json内容：" + json);
            
            int data = personAdapter.insert(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("新增" + content + "出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: update
    * @Description: 修改人物
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void update() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                throw new Exception("query json missed!");
            }
            
            logger.info("修改" + content + "，json内容：" + json);
            
            int data = personAdapter.update(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("修改" + content + "出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: recycle
    * @Description: 删除人物-移到垃圾箱
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void delete() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        Long id = null;
        try {
            id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            logger.info("删除" + content + "，标识为：" + id);
            
            int data = personAdapter.recycle(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("删除" + content + "(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: completelyDelete
    * @Description: 彻底删除人物
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void completelyDelete() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        Long id = null;
        try {
            id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            logger.info("彻底删除" + content + "，标识为：" + id);
            
            int data = personAdapter.delete(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("彻底删除" + content + "(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: restore
    * @Description: 恢复人物
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void restore() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        Long id = null;
        try {
            id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            logger.info("恢复" + content + "，标识为：" + id);
            
            int data = personAdapter.restore(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("恢复" + content + "(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }    
    /**
     * 
    * @Title: getPerson
    * @Description: 获取人物详情
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void getPerson() throws SQLException{
        ApiResult<Person> result = new ApiResult<Person>();
        setResult(result);
        try {
            Long id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            Person data = personAdapter.getPerson(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
}
