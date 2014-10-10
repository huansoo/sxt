/**  
* @Title:  CategoryModel.java
* @Package com.wugu.ycyp.webapp.model
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-22 
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
 * @ClassName: CategoryModel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-7-22 
 *
 */
public class CategoryModel extends BaseModel
{
    private Long parentId;
    

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }
}
