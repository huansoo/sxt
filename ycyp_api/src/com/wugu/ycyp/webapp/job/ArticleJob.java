/**  
* @Title:  ArticleJob.java
* @Package com.wugu.ycyp.webapp.job
* @Description: 文章控制
* @author lijun
* @date  2014-7-4 
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

import com.wugu.ycyp.webapp.adapter.ArticleAdapter;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.Code;


/**
 * @ClassName: ArticleJob
 * @Description: 文章控制类
 * @author lijun
 * @date 2014-7-4 
 *
 */

@Controller("ArticleJob")
public class ArticleJob extends BaseJob
{
    @Autowired
    private ArticleAdapter articleAdapter;
    
    private String content = "文章";
    /**
     * 
    * @Title: getList
    * @Description: 获取新闻列表
    * @author lijun
    * @throws Exception
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
            
            String data = articleAdapter.getArticleList(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增新闻
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
            
            int data = articleAdapter.insert(json);
            
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
    * @Description: 修改新闻
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
            
            int data = articleAdapter.update(json);
            
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
    * @Description: 删除新闻-移到垃圾箱
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
            
            int data = articleAdapter.recycle(id);
            
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
    * @Description: 彻底删除新闻
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
            
            int data = articleAdapter.delete(id);
            
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
    * @Description: 恢复新闻
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
            
            int data = articleAdapter.restore(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("恢复" + content + "(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: getArticle
    * @Description: 获取新闻列表
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void getArticle() throws SQLException{
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        try {
            Long id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            String data = articleAdapter.getArticle(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
}
