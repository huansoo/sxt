/**  
* @Title:  AuditionInfoDAOImpl.java
* @Package com.wugu.zhaopin.dao.impl
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
package com.wugu.zhaopin.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.wugu.zhaopin.dao.AuditionInfoDAO;
import com.wugu.zhaopin.webapp.model.AuditionInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageManager;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

/**
 * @ClassName: AuditionInfoDAOImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-3 
 *
 */
public class AuditionInfoDAOImpl implements AuditionInfoDAO
{
    private SqlMapClient sqlMapClient;
    
    public AuditionInfoDAOImpl(SqlMapClient sqlMapClient)
    {
        super();
        this.sqlMapClient = sqlMapClient;
    }

    /* (非 Javadoc)
     * <p>Title: countByExample</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws SQLException
     * @see com.wugu.zhaopin.dao.AuditionInfoDAO#countByExample(com.wugu.zhaopin.webapp.model.ZpAuditionInfoCriteria)
     */
    @Override
    public int countByExample(AuditionInfoCriteria example)
            throws SQLException
    {
        Integer count = (Integer) sqlMapClient.queryForObject(
                "audition.countByExample", example);
        return count;
    }

    /* (非 Javadoc)
     * <p>Title: selectBypage</p>
     * <p>Description: </p>
     * @param example
     * @return
     * @throws SQLException
     * @see com.wugu.zhaopin.dao.AuditionInfoDAO#selectBypage(com.wugu.zhaopin.webapp.model.ZpAuditionInfoCriteria)
     */
    @Override
    public PageWraper selectBypage(AuditionInfoCriteria example)
            throws SQLException
    {
        PageWraper pw = null;
        
        int count = countByExample(example);
        List list = sqlMapClient.queryForList("audition.selectByExample", example);
        
        pw = PageManager.getPageWraper(example.getPageInfo(), list, count);
        return pw;
    }

}
