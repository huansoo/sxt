/**  
* @Title:  PersonArticleRelJob.java
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

import com.wugu.ycyp.entity.PersonArticleRel;
import com.wugu.ycyp.webapp.adapter.PersonArticleRelAdapter;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.Code;

/**
 * @ClassName: PersonArticleRelJob
 * @Description: 人物关联文章控制类
 * @author lijun
 * @date 2014-7-23 
 *
 */
@Controller("PersonArticleRelJob")
public class PersonArticleRelJob extends BaseJob
{
    @Autowired
    private PersonArticleRelAdapter personArticleAdapterp;
    private String content = "人物关联文章";
    
    /**
     * 
    * @Title: getList
    * @Description: 获取人物关联文章列表
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void getList() throws SQLException{
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                throw new Exception("query json missed!");
            }
            
            String data = personArticleAdapterp.getListToString(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: getPersonArticleRel
    * @Description: 根据id获取人物关联文章
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void getPersonArticleRel() throws SQLException{
        ApiResult<PersonArticleRel> result = new ApiResult<PersonArticleRel>();
        setResult(result);
        try {
            Long id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            PersonArticleRel data = personArticleAdapterp.getPersonArticleRel(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增关联
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void insert()throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                throw new Exception("query json missed!");
            }
            
            logger.info("新增" + content + "，json内容：" + json);
            
            Integer data = personArticleAdapterp.insert(json);
            
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
    * @Description: 修改关联
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
            
            int data = personArticleAdapterp.update(json);
            
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
    * @Description: 删除关联-移到垃圾箱
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
            
            int data = personArticleAdapterp.recycle(id);
            
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
    * @Description: 彻底删除关联
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
            
            int data = personArticleAdapterp.delete(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("彻底删除" + content + "(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
}
