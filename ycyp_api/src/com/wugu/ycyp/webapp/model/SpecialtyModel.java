/**  
* @Title:  SpecialtyModel.java
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
 * @ClassName: SpecialtyModel
 * @Description: 特产条件模型
 * @author lijun
 * @date 2014-7-22 
 *
 */
public class SpecialtyModel extends BaseModel
{
    private Long areaId;
    private Long categoryId;
    public Long getAreaId()
    {
        return areaId;
    }
    public void setAreaId(Long areaId)
    {
        this.areaId = areaId;
    }
    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }
    
}
