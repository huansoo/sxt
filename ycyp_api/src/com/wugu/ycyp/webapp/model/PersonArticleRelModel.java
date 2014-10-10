/**  
* @Title:  PersonArticleRelModel.java
* @Package com.wugu.ycyp.webapp.model
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
package com.wugu.ycyp.webapp.model;

/**
 * @ClassName: PersonArticleRelModel
 * @Description: 人物关联文章条件模型类
 * @author lijun
 * @date 2014-7-23 
 *
 */
public class PersonArticleRelModel extends BaseModel
{
    /*
     * 关联人物ID
     */
    private Long personId;
    
    /*
     * 关联文章ID
     */
    private Long articleId;

    public Long getPersonId()
    {
        return personId;
    }

    public void setPersonId(Long personId)
    {
        this.personId = personId;
    }

    public Long getArticleId()
    {
        return articleId;
    }

    public void setArticleId(Long articleId)
    {
        this.articleId = articleId;
    }
    
    
}
