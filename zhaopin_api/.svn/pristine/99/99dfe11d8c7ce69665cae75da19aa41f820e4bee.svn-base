/**  
* @Title:  ToolJob.java
* @Package com.wugu.zhaopin.webapp.job
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-1-27 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.webapp.job;

import java.io.IOException;
import java.sql.SQLException;

import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.tools.ImportZhaopinData;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.webapp.util.JobUtil;

/**
 * @ClassName: ToolJob
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-27 
 *
 */
public class ToolJob extends BaseJob
{
    public void doImport() throws IOException, SQLException {
        Integer result = 0;
        ApiResult<Integer> apiresult = new ApiResult<Integer>();
        try {
            ImportZhaopinData data = new ImportZhaopinData();  
            
            data.importData("E:\\work\\文档\\招聘网站\\document\\zhaopin\\企业职位数据1.23.xls");
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(result);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(0);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());
    }
}
