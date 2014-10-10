/**  
* @Title:  ArticleExampleEx.java
* @Package com.wugu.ycyp.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-14 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.ycyp.entity;

/**
 * @ClassName: ArticleExampleEx
 * @Description: 文章数据服务扩展类
 * @author lijun
 * @date 2014-7-14 
 *
 */
public class ArticleExampleEx extends ArticleExample
{
    @Override
    protected Criteria createCriteriaInternal() {
        CriteriaEx criteria = new CriteriaEx();
        return criteria;
    }
    
    public static class CriteriaEx extends Criteria{
        protected CriteriaEx() {
            super();
        }
        
        /**
         * 
        * @Title: andContentLike
        * @Description: 增加文章内容查询方法
        * @author lijun
        * @param value
        * @return
        * @throws
         */
        public Criteria andContentLike(String value){
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this; 
        }
    }    
}
