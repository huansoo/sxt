/**  
* @Title:  ArticleTagRelJob.java
* @Package com.wugu.ycyp.webapp.job
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-15 
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

import com.wugu.ycyp.entity.ArticleTagRel;
import com.wugu.ycyp.webapp.adapter.ArticleTagRelAdapter;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.Code;

/**
 * @ClassName: ArticleTagRelJob
 * @Description: 文章标签管理控制类
 * @author lijun
 * @date 2014-7-15 
 *
 */
@Controller("ArticleTagRelJob")
public class ArticleTagRelJob extends BaseJob
{
    @Autowired
    ArticleTagRelAdapter articleTagRelAdapter;
    private String content = "文章";
    /**
     * 
    * @Title: getList
    * @Description: 获取文章关联标签列表
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void getList() throws SQLException{
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        try {
            Long articleId = getQueryLong(Code.PARAMTER_ARTICLE_ID);
            if (articleId == null){
                throw new Exception("query articleId missed!");
            }
            
            String data = articleTagRelAdapter.getListToString(articleId);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: getArticleTagRel
    * @Description: 根据id获取关联标签
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void getArticleTagRel() throws SQLException{
        ApiResult<ArticleTagRel> result = new ApiResult<ArticleTagRel>();
        setResult(result);
        try {
            Long id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            ArticleTagRel data = articleTagRelAdapter.getArticleTagRel(id);
            
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
            
            Integer data = articleTagRelAdapter.insert(json);
            
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
            
            int data = articleTagRelAdapter.update(json);
            
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
            
            int data = articleTagRelAdapter.recycle(id);
            
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
            
            int data = articleTagRelAdapter.delete(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("彻底删除" + content + "(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
}
