/**  
* @Title:  AreaClassModel.java
* @Package com.wugu.ycyp.webapp.model
* @Description: 区域分类条件模型
* @author lijun
* @date  2014-7-18 
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
 * @ClassName: AreaClassModel
 * @Description: 区域分类条件模型类
 * @author lijun
 * @date 2014-7-18 
 *
 */
public class AreaClassModel extends BaseModel
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
