/**  
* @Title:  TagJob.java
* @Package com.wugu.ycyp.webapp.job
* @Description: 标签控制类
* @author lijun
* @date  2014-7-16 
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

import com.wugu.ycyp.entity.Tag;
import com.wugu.ycyp.webapp.adapter.TagAdapter;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.Code;

/**
 * @ClassName: TagJob
 * @Description: 标签控制类
 * @author lijun
 * @date 2014-7-16 
 *
 */
@Controller("TagJob")
public class TagJob extends BaseJob
{
    @Autowired
    private TagAdapter tagAdapter;
    
    private String content = "标签";
    /**
     * 
    * @Title: getList
    * @Description: 获取标签列表
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
            
            String data = tagAdapter.getList(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增标签
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
            
            int data = tagAdapter.insert(json);
            
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
    * @Description: 修改标签
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
            
            int data = tagAdapter.update(json);
            
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
    * @Description: 删除标签-移到垃圾箱
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
            
            int data = tagAdapter.recycle(id);
            
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
    * @Description: 彻底删除标签
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
            
            int data = tagAdapter.delete(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("彻底删除" + content + "(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: getTag
    * @Description: 获取标签详情
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void getTag() throws SQLException{
        ApiResult<Tag> result = new ApiResult<Tag>();
        setResult(result);
        try {
            Long id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            Tag data = tagAdapter.getTag(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
}
