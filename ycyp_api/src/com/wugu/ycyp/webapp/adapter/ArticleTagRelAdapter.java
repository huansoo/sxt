/**  
* @Title:  ArticleTagRelAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-11 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.webapp.adapter;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.Article;
import com.wugu.ycyp.entity.ArticleTagRel;
import com.wugu.ycyp.entity.ArticleTagRelExample;
import com.wugu.ycyp.service.ArticleTagRelService;

/**
 * @ClassName: ArticleTagRelAdapter
 * @Description: 文章标签关联表适配器
 * @author lijun
 * @date 2014-7-11 
 *
 */
@Component("articleTagRelAdapter")
public class ArticleTagRelAdapter extends BaseAdapter
{
    @Autowired
    private ArticleTagRelService articleTagRelService;
    
    /**
     * 
    * @Title: getList
    * @Description: 获取文章关联标签列表
    * @author lijun
    * @param articleId
    * @return
    * @throws SQLException
    * @throws
     */
    public List<ArticleTagRel> getList(Long articleId) throws SQLException{
        ArticleTagRelExample example = new ArticleTagRelExample();
        ArticleTagRelExample.Criteria criteria = example.createCriteria();
        
        criteria.andArticleIdEqualTo(articleId);
        setStatusGeneralCondition(criteria);
        
        example.setOrderByClause("update_time desc");
        return articleTagRelService.getArticleTagList(example);
    }
    
    /**
     * 
    * @Title: clearRel
    * @Description: 清空文章关联的标签
    * @author lijun
    * @param articleId
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer clearRel(Long articleId)throws SQLException{
        Integer result = 0;
        List<ArticleTagRel> list = getList(articleId);
        for (ArticleTagRel articleTagRel : list)
        {
            result += delete(articleTagRel.getId());
        }
        return result;
    }
    
    /**
     * 
    * @Title: getArticleTagRel
    * @Description: 根据ID获取关联标签
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public ArticleTagRel getArticleTagRel(Long id) throws SQLException{
        ArticleTagRelExample example = new ArticleTagRelExample();
        ArticleTagRelExample.Criteria criteria = example.createCriteria();
        
        criteria.andIdEqualTo(id);
        setStatusGeneralCondition(criteria);
        
        List<ArticleTagRel> list = articleTagRelService.getArticleTagList(example);
        
        if (list != null && list.size() > 0)
            return list.get(0);
        else
            return null;
    }
    
    /**
     * 
    * @Title: getListToString
    * @Description: 获取文章关联标签列表json字符串
    * @author lijun
    * @param articleId
    * @return
    * @throws SQLException
    * @throws
     */
    public String getListToString(Long articleId) throws SQLException{
        List<ArticleTagRel> list = getList(articleId);
        JSONArray arr = JSONArray.fromObject(list);
        return arr.toString();
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增文章关联标签
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(String json) throws SQLException{
        ArticleTagRel record = getModelFromJson(json, ArticleTagRel.class);
        return insert(record);
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增文章关联标签
    * @author lijun
    * @param record
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer insert(ArticleTagRel record) throws SQLException{
        return articleTagRelService.insert(record);
    }
    
    /**
     * 
    * @Title: batchInsert
    * @Description: 批量新增关联
    * @author lijun
    * @param article
    * @param tagIdList
    * @param tagNameList
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer batchInsert(Article article, Long[] tagIdList, 
            String[] tagNameList) throws SQLException{
        int result = 0;
        for (int i = 0; i < tagIdList.length; i ++){
            //json默认会把Long转成Integer
            Long id = tagIdList[i];
            String tagName = "未知";
            if (tagNameList.length > i){
                tagName = tagNameList[i];
            }
            
            ArticleTagRel record = new ArticleTagRel();
            record.setTagId(id);
            record.setTagName(tagName);
            record.setArticleId(article.getId());
            record.setCreateTime(article.getCreateTime());
            record.setUpdateTime(article.getUpdateTime());
            record.setType(article.getType());
            record.setOpId(article.getOpId());
            
            result += insert(record);
        }
        return result;
    }
    
    /**
     * 
    * @Title: update
    * @Description: 更新关联
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer update(String json) throws SQLException{
        ArticleTagRel articleTagRel = getModelFromJson(json, ArticleTagRel.class);
        return articleTagRelService.update(articleTagRel);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 删除关联-移到垃圾箱
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer recycle(Long id) throws SQLException{
        ArticleTagRel articleTagRel = new ArticleTagRel();
        articleTagRel.setId(id);
        setStatusRecycle(articleTagRel);
        return articleTagRelService.update(articleTagRel);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 彻底删除关联
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer delete(Long id) throws SQLException{
        ArticleTagRel articleTagRel = new ArticleTagRel();
        articleTagRel.setId(id);
        setStatusDeleted(articleTagRel);
        return articleTagRelService.update(articleTagRel);
    }
}
