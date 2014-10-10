/**  
* @Title:  AreaModel.java
* @Package com.wugu.ycyp.webapp.model
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-7-17 
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
 * @ClassName: AreaModel
 * @Description: 区域条件模型
 * @author lijun
 * @date 2014-7-17 
 *
 */
public class AreaModel extends BaseModel
{
    /**
    * @Fields classId : TODO(用一句话描述这个变量表示什么)
    */
    private Long classId;

    public Long getClassId()
    {
        return classId;
    }

    public void setClassId(Long classId)
    {
        this.classId = classId;
    }
}
