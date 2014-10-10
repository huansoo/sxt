/**  
* @Title:  AuditionInfoDAO.java
* @Package com.wugu.zhaopin.dao
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-1-3 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.dao;

import java.sql.SQLException;

import com.wugu.zhaopin.webapp.model.AuditionInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

/**
 * @ClassName: AuditionInfoDAO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-3 
 *
 */
public interface AuditionInfoDAO
{
    int countByExample(AuditionInfoCriteria example) throws SQLException;
    
    PageWraper selectBypage(AuditionInfoCriteria example) throws SQLException;

}
