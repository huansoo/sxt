/**  
* @Title:  TagJob.java
* @Package com.wugu.zhaopin.webapp.job
* @Description: 简历标签
* @author lijun
* @date  2014-1-23 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.webapp.job;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;

import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.service.TagManager;
import com.wugu.zhaopin.vo.ZpTag;
import com.wugu.zhaopin.vo.ZpTagCriteria;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.webapp.util.JobUtil;

/**
 * @ClassName: TagJob
 * @Description: 简历标签
 * @author lijun
 * @date 2014-1-23 
 *
 */
public class TagJob extends BaseJob
{
    private TagManager tagManager; 
    
    private static final String METHODNAME_GETALLTAG  = "getalltag_";
    
    public TagManager getTagManager(){
        if(tagManager == null){
            tagManager = (TagManager) getBean("tagmanager", TagManager.class);
        }
        return tagManager;        
    }
    
    private List<ZpTag> getTagAllList()
            throws IOException, SQLException {
        ZpTagCriteria example = new ZpTagCriteria();
        
        ZpTagCriteria.Criteria Criteria = example.createCriteria();
        
        Criteria.andStatusEqualTo(ConstantUtil.RECORDVILIDSIGN);
        //加排序条件 按更新时间倒序排列
        example.setOrderByClause("update_time desc");
        
        List<ZpTag> list = getTagManager().selectByExample(example);
        
        return list;
    }   
    
    /**
     * 
    * @Title: getTagList
    * @Description: 获取所有合法简历标签
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getTagList() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            List<ZpTag> list = getTagAllList();
            
            JSONArray arr = JSONArray.fromObject(list);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(arr.toString());
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    private ZpTag getTagById(Integer tagId)
            throws IOException, SQLException {
        ZpTagCriteria example = new ZpTagCriteria();
        
        ZpTagCriteria.Criteria Criteria = example.createCriteria();
        
        Criteria.andStatusEqualTo(ConstantUtil.RECORDVILIDSIGN).andTagIdEqualTo(tagId);
        
        List<ZpTag> list = getTagManager().selectByExample(example);
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    } 
    
    /**
     * 
    * @Title: getTagById
    * @Description: 根据标签ID获取标签对象
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getTagById() throws IOException, SQLException {
        ApiResult<ZpTag> apiresult = new ApiResult<ZpTag>();
        try {
            Integer tagId = getQueryInt(JobUtil.PARAMTER_TAG_ID);
            if(tagId == null){
                throw new Exception("query tagid missed!");
            }
            
            ZpTag tag = getTagById(tagId);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(tag);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(null);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }      
}
