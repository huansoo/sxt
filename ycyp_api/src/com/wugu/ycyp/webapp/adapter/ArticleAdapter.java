/**  
* @Title:  ArticleAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
* @Description: 文章数据适配
* @author lijun
* @date  2014-7-10 
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wugu.ycyp.entity.Article;
import com.wugu.ycyp.entity.ArticleExample;
import com.wugu.ycyp.entity.ArticleExampleEx;
import com.wugu.ycyp.entity.ArticleExampleEx.CriteriaEx;
import com.wugu.ycyp.entity.ArticleTagRel;
import com.wugu.ycyp.entity.page.PageInfo;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.service.ArticleService;
import com.wugu.ycyp.util.ConstantUtil;
import com.wugu.ycyp.util.JsonUtil;
import com.wugu.ycyp.webapp.model.ArticleModel;
import com.wugu.ycyp.webapp.model.BaseModel;

/**
 * @ClassName: ArticleAdapter
 * @Description: 文章查询适配器
 * @author lijun
 * @date 2014-7-10 
 *
 */
@Component("articleAdapter")
public class ArticleAdapter extends BaseAdapter
{
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleTagRelAdapter articleTagRelAdapter;
    
    //文章对象中不包含的属性
    private String[] excludeFields = {"tagIdList", "tagNameList"};

    /**
     * @throws SQLException 
     * 
    * @Title: getArticleList
    * @Description: 获取新闻列表字符串
    * @author lijun
    * @return
    * @throws
     */
    public String getArticleList(String json) throws SQLException{
        ArticleExampleEx example = new ArticleExampleEx();        

        ArticleModel model = getModelFromJson(json, ArticleModel.class);
        BaseModel baseModel = getModelFromJson(json, BaseModel.class);
        //初始化页面信息,此句可不要，因为在PageManager中还会再次初始化
        example.setPageInfo(new PageInfo());
        iniPageInfo(example.getPageInfo(), baseModel);
        
        //关键字查询需要查询标题、简介、内容
        //每个criteria内的条件都是and关系，criteria之间是or关系
        //因此需要创建三个criteria，在每个criteria里添加重复的基本条件
        //然后再添加关键字查询条件，分别是标题、简介和内容
        //标题
        ArticleExampleEx.CriteriaEx criteria1 = (CriteriaEx) example.or();       
        setSameSearchCondition(criteria1, model, baseModel); 
        
        if (model.getKeyWord() != null && !model.getKeyWord().trim().equals("")){
            //标题查询
            if (model.getKeyWord() != null){
                String value = "%" + model.getKeyWord() + "%";
                criteria1.andTitleLike(value);
            }       
            //简介
            ArticleExampleEx.CriteriaEx criteria2 = (CriteriaEx) example.or();       
            setSameSearchCondition(criteria2, model, baseModel);   
            //简介查询
            if (model.getKeyWord() != null){
                String value = "%" + model.getKeyWord() + "%";
                criteria2.andBriefLike(value);
            }       
            //内容
            ArticleExampleEx.CriteriaEx criteria3 = (CriteriaEx) example.or();       
            setSameSearchCondition(criteria3, model, baseModel);   
            //内容查询
            if (model.getKeyWord() != null){
                String value = "%" + model.getKeyWord() + "%";
                criteria3.andContentLike(value);
            } 
        }
            
        example.setOrderByClause(" status ASC, update_time DESC ");
        
        PageWraper pw = articleService.getList(example);
        
        try
        {
            return getJsonByPageWraper(pw);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
        catch (Exception ee){
            ee.printStackTrace();
        }
        return null;
    }
    
    @Override
    public String getDataList(@SuppressWarnings("rawtypes") List listOld) 
            throws SQLException{
        @SuppressWarnings("unchecked")
        List<Article> list = (List<Article>)listOld;
        List<Object> listNew = new ArrayList<Object>();
        
        for (Iterator<Article> iterator = list.iterator(); iterator.hasNext();)
        {
            Article article = (Article) iterator.next();
            JSONObject obj = getTagData(article);
            listNew.add(obj);
        }
        JSONArray arr = JSONArray.fromObject(listNew);
        return arr.toString();
    }
    
    private JSONObject getTagData(Article article) throws SQLException{
        Long id = article.getId();
        JSONObject obj = JSONObject.fromObject(article);
        
        //获取文章标签列表
        List<ArticleTagRel> relList = articleTagRelAdapter.getList(id);            
        List<Long> tagIdList = new ArrayList<Long>();
        List<String> tagNameList = new ArrayList<String>();
        //把标签列表附加到文章上
        for (Iterator<ArticleTagRel> iterator2 = relList.iterator(); iterator2.hasNext();)
        {
            ArticleTagRel articleTagRel = (ArticleTagRel) iterator2.next();
            Long tagId = articleTagRel.getTagId();
            tagIdList.add(tagId);
            String tagName = articleTagRel.getTagName();
            tagNameList.add(tagName);
        }
        obj.put("tagIdList", tagIdList);
        obj.put("tagNameList", tagNameList);
        return obj;
    }
    
    /**
     * 
    * @Title: insertArticle
    * @Description: 添加新闻
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public int insert(String json) throws SQLException{
        //过滤tagIdList 和tagNameList 属性
        JsonConfig config = JsonUtil.configJson(excludeFields);
        JSONObject obj = JSONObject.fromObject(json, config);
        
        Article article = (Article)JSONObject.toBean(obj, Article.class);
        int id = articleService.insert(article);
        if (id > 0) {
            //过滤Article类属性
            String[] articleFields = JsonUtil.getClassFields(Article.class, excludeFields);
            config = JsonUtil.configJson(articleFields);
            obj = JSONObject.fromObject(json, config);
            
            Long[] tagIdList = JsonUtil.jsonToLongArray(obj.getString(excludeFields[0]));
            String[] tagNameList = JsonUtil.jsonToStringArray(obj.getString(excludeFields[1]));
            //ArticleModel model = (ArticleModel) JSONObject.toBean(obj, ArticleModel.class);
            if (tagIdList != null && tagNameList != null){
                //清空文章关联的标签
                articleTagRelAdapter.clearRel(article.getId());
                
                //添加文章关联标签
                articleTagRelAdapter.batchInsert(article, 
                        tagIdList, tagNameList);
            }
            return article.getId().intValue();
        }
        return id;
    }
    
   
    /**
     * 
    * @Title: update
    * @Description: 修改新闻
    * @author lijun
    * @param json
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer update(String json) throws SQLException{
        Article article = getModelFromJson(json, Article.class);
        return articleService.update(article);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 删除新闻-移到垃圾箱
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer recycle(Long id) throws SQLException{
        Article article = new Article();
        article.setId(id);
        setStatusRecycle(article);
        return articleService.update(article);
    }
    
    /**
     * 
    * @Title: delete
    * @Description: 彻底删除新闻
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer delete(Long id) throws SQLException{
        Article article = new Article();
        article.setId(id);
        setStatusDeleted(article);
        return articleService.update(article);
    }
    
    /**
     * 
    * @Title: restore
    * @Description: 恢复新闻
    * @author lijun
    * @param id
    * @return
    * @throws SQLException
    * @throws
     */
    public Integer restore(Long id) throws SQLException{
        Article article = new Article();
        article.setId(id);
        setStatusGeneral(article);
        return articleService.update(article);
    }
    
    /**
     * 
    * @Title: getArticle
    * @Description: 获取文章详情
    * @author lijun
    * @param id
    * @return 文章详情
    * @throws SQLException
    * @throws
     */
    public String getArticle(Long id) throws SQLException{
        ArticleExample example = new ArticleExample();
        
        example.createCriteria()
            .andIdEqualTo(id)
            .andStatusEqualTo(ConstantUtil.RECORD_STATUS_GENERAL);
        
        List<Article> list = articleService.getListWithContent(example);
        
        if (list != null && list.size() > 0){
            Article article = (Article) list.get(0);
            
            return getTagData(article).toString();
        }
        else
            return null;
    }
    
    private void setSameSearchCondition(
            ArticleExampleEx.CriteriaEx criteria, ArticleModel model, BaseModel baseModel){
        iniBaseCondition(criteria, baseModel);
        
        if (model.getBeginTime() != null)
            criteria.andUpdateTimeGreaterThanOrEqualTo(model.getBeginTime());
        if (model.getEndTime() != null)
            criteria.andUpdateTimeLessThanOrEqualTo(model.getEndTime());
        if (model.getId() != null)
            criteria.andIdEqualTo(model.getId());
        if (model.getType() != null)
            criteria.andTypeEqualTo(model.getType());
    }
}
