/**  
* @Title:  ArticleModel.java
* @Package com.wugu.ycyp.webapp.model
* @Description: TODO(用一句话描述该文件做什么)
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
package com.wugu.ycyp.webapp.model;

import java.util.List;

/**
 * @ClassName: ArticleModel
 * @Description: 新闻查询条件模型
 * @author lijun
 * @date 2014-7-10 
 *
 */
public class ArticleModel extends BaseModel
{
    private String keyWord; //关键字
    private Integer beginTime; //起始日期
    private Integer endTime; //结束日期
    private List<Long> tagIdList; //标签标识列表
    private List<String> tagNameList; //标签名称列表
    private Integer type;//类型
    
    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public List<Long> getTagIdList()
    {
        return tagIdList;
    }

    public void setTagIdList(List<Long> tagIdList)
    {
        this.tagIdList = tagIdList;
    }

    public List<String> getTagNameList()
    {
        return tagNameList;
    }

    public void setTagNameList(List<String> tagNameList)
    {
        this.tagNameList = tagNameList;
    }


    public String getKeyWord()
    {
        return keyWord;
    }

    public void setKeyWord(String keyWord)
    {
        this.keyWord = keyWord;
    }

    public Integer getBeginTime()
    {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime)
    {
        this.beginTime = beginTime;
    }

    public Integer getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Integer endTime)
    {
        this.endTime = endTime;
    }
    
}
