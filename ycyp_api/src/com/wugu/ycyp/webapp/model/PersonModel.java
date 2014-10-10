/**  
* @Title:  PersonModel.java
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
 * @ClassName: PersonModel
 * @Description: 人物条件模型类
 * @author lijun
 * @date 2014-7-23 
 *
 */
public class PersonModel extends BaseModel
{
    private Long areaId;
    private Long userId;
    public Long getAreaId()
    {
        return areaId;
    }
    public void setAreaId(Long areaId)
    {
        this.areaId = areaId;
    }
    public Long getUserId()
    {
        return userId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}
