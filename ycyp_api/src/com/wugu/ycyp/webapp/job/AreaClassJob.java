/**  
* @Title:  AreaClassJob.java
* @Package com.wugu.ycyp.webapp.job
* @Description: 区域分类控制类
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
package com.wugu.ycyp.webapp.job;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wugu.ycyp.entity.AreaClass;
import com.wugu.ycyp.webapp.adapter.AreaClassAdapter;
import com.wugu.ycyp.webapp.model.ApiResult;
import com.wugu.ycyp.webapp.util.Code;

/**
 * @ClassName: AreaClassJob
 * @Description: 区域分类控制类
 * @author lijun
 * @date 2014-7-18 
 *
 */
@Controller("AreaClassJob")
public class AreaClassJob extends BaseJob
{
    @Autowired
    private AreaClassAdapter areaClassAdapter;
    
    /**
     * 
    * @Title: getAreaList
    * @Description: 获取区域分类列表
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void getList() throws Exception{
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                logger.error("参数“json”丢失！");
                throw new Exception("query json missed!");
            }
            
            String data = areaClassAdapter.getListString(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: insert
    * @Description: 新增区域分类
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void insert() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                throw new Exception("query json missed!");
            }
            
            logger.info("新增区域分类，json内容：" + json);
            
            int data = areaClassAdapter.insert(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("新增区域分类出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: update
    * @Description: 修改区域分类
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void update() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        try {
            String json = getQueryString(Code.PARAMTER_JSON);
            if (json == null){
                throw new Exception("query json missed!");
            }
            
            logger.info("修改区域分类，json内容：" + json);
            
            int data = areaClassAdapter.update(json);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("修改区域分类出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: recycle
    * @Description: 删除区域分类-移到垃圾箱
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void delete() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        Long id = null;
        try {
            id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            logger.info("删除区域分类，标识为：" + id);
            
            int data = areaClassAdapter.recycle(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("删除区域分类(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: completelyDelete
    * @Description: 彻底删除区域分类
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void completelyDelete() throws SQLException{
        ApiResult<Integer> result = new ApiResult<Integer>();
        setResult(result);
        Long id = null;
        try {
            id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            logger.info("彻底删除区域分类，标识为：" + id);
            
            int data = areaClassAdapter.delete(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            logger.error("彻底删除区域分类(标识为“" + id + "”）出错：" + ex.toString());
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: getAreaClass
    * @Description: 获取区域分类详情
    * @author lijun
    * @throws SQLException
    * @throws
     */
    public void getAreaClass() throws SQLException{
        ApiResult<AreaClass> result = new ApiResult<AreaClass>();
        setResult(result);
        try {
            Long id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            AreaClass data = areaClassAdapter.getAreaClass(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: getProvinceList
    * @Description: 获取省份列表
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void getProvinceList() throws Exception{
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        try {
            String data = areaClassAdapter.getProvinceList();
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
    
    /**
     * 
    * @Title: getPath
    * @Description: 获取区域分类路径
    * @author lijun
    * @throws Exception
    * @throws
     */
    public void getPath() throws Exception{
        ApiResult<String> result = new ApiResult<String>();
        setResult(result);
        try {
            Long id = getQueryLong(Code.PARAMTER_ID);
            if (id == null){
                throw new Exception("query id missed!");
            }
            
            String data = areaClassAdapter.getPath(id);
            
            result.setSuccessData(data);
        } catch (Exception ex) {
            result.setExceptionData(ex.toString());
            ex.printStackTrace();
        }
    }
}
