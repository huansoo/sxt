/**  
* @Title:  BaseAdapter.java
* @Package com.wugu.ycyp.webapp.adapter
* @Description: 文章控制适配器
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
package com.wugu.ycyp.webapp.adapter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.wugu.ycyp.entity.page.PageInfo;
import com.wugu.ycyp.entity.page.PageWraper;
import com.wugu.ycyp.util.ConstantUtil;
import com.wugu.ycyp.util.JsonUtil;
import com.wugu.ycyp.webapp.model.BaseModel;
import com.wugu.ycyp.webapp.util.Code;

/**
 * @ClassName: BaseAdapter
 * @Description: 适配器基类
 * @author lijun
 * @date 2014-7-10 
 *
 */
public class BaseAdapter
{
    /**
     * @throws Exception 
     * 
    * @Title: getJsonByPageWraper
    * @Description: 根据分页信息获取json数据
    * @author lijun
    * @param pw
    * @return
    * @throws
     */
    public String getJsonByPageWraper(PageWraper pw) throws Exception{
        
        JSONObject obj = JSONObject.fromObject(pw.getPageInfo());
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        String dataList = getDataList(pw.getResult());
        
        map.put("datalist", dataList);
        map.put("pageinfo", obj.toString());  
        
        JSONArray arr = JSONArray.fromObject(map);
        
        return arr.toString();
    }
    
    protected String getDataList(@SuppressWarnings("rawtypes") List list) throws Exception{
        JsonConfig config = Code.getJsonConfig();
        JSONArray arr = JSONArray.fromObject(list, config);
        return arr.toString();
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getModelFromJson(String json, Class<T> t){
        JSONObject obj = JSONObject.fromObject(json);
        return (T)JSONObject.toBean(obj, t);                
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getModelFromJson(String json, Class<T> t, 
            String[] filters, boolean isFilter){
        JSONObject obj = null;
        if (filters == null){
            obj = JSONObject.fromObject(json);
        }
        else {
            JsonConfig config = null;
            if(isFilter) {
                config = JsonUtil.configJson(filters);
            }
            else {
                String[] excludes = JsonUtil.getClassFields(t, filters);
                config = JsonUtil.configJson(excludes);
            }
            obj = JSONObject.fromObject(json, config);
        }
            
        return (T)JSONObject.toBean(obj, t);                
    }
    
    protected JsonConfig getConfig(){
        return Code.getJsonConfig();
    }
    
    /**
     * @throws Exception 
     * 
    * @Title: iniPageInfo
    * @Description: 设置页面条件
    * @author lijun
    * @param pageInfo
    * @param model
    * @throws
     */
    public void iniPageInfo(PageInfo pageInfo, BaseModel model){
        if (model.getPage() != null){
            pageInfo.setPage(model.getPage());
         }
         
         if (model.getPageSize() != null){
             pageInfo.setPageSize(model.getPageSize());
         }         
    }
    
    /**
     * 
    * @Title: iniPageInfo
    * @Description: 设置页面条件
    * @author lijun
    * @param pageInfo
    * @param json
    * @throws
     */
    public void iniPageInfo(PageInfo pageInfo, String json){
        BaseModel model = getModelFromJson(json, BaseModel.class);
        if (model.getPage() != null){
            pageInfo.setPage(model.getPage());
         }
         
         if (model.getPageSize() != null){
             pageInfo.setPageSize(model.getPageSize());
         }         
    }
    
    /**
     * 
    * @Title: iniBaseCondition
    * @Description: 设置基础条件：如数据状态、操作人ID、类型等
    * @author lijun
    * @param criteria
    * @param model
    * @throws
     */
    public void iniBaseCondition(Object criteria, BaseModel model){
         //数据状态
         if (model.getStatus() != null){
             setStatusConditon(criteria, model.getStatus());
         }
         else
             setStatusGeneralCondition(criteria);
        
         //操作人ID
         if (model.getOpId() != null){
             setMethodValue(criteria, "andOpIdEqualTo", model.getOpId());
         }
         
         //类型
         if (model.getType() != null){
             setMethodValue(criteria, "andTypeEqualTo", model.getType());
         }
    }
    
    /**
     * 
    * @Title: iniBaseCondition
    * @Description: 设置基础条件：如数据状态、操作人ID、类型等
    * @author lijun
    * @param criteria
    * @param json
    * @throws
     */
    public void iniBaseCondition(Object criteria, String json){
        BaseModel model = getModelFromJson(json, BaseModel.class);
        iniBaseCondition(criteria, model);
    }
    
    protected void setMethodValue(Object obj, String name, Object...value){
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods){
            if (method.getName().equalsIgnoreCase(name)){
                try
                {
                    method.invoke(obj, value);
                }                
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return;
            }
        } 
    }
    
    protected void setStatusConditon(Object criteria, Integer status) {
        setMethodValue(criteria, "andStatusEqualTo", status);
    }
    
    protected void setStatusModel(Object model, Integer status){
        setMethodValue(model, "setStatus", status);
    }
    
    /**
     * 
    * @Title: setStatusGeneral
    * @Description: 设置合法状态条件
    * @author lijun
    * @param criteria
    * @throws Exception
    * @throws
     */
    public void setStatusGeneralCondition(Object criteria){
        setStatusConditon(criteria, ConstantUtil.RECORD_STATUS_GENERAL);
    }
    /**
     * 
    * @Title: setStatusdelete
    * @Description: 设置删除状态条件
    * @author lijun
    * @param criteria
    * @throws Exception
    * @throws
     */
    public void setStatusRecycleCondition(Object criteria){
        setStatusConditon(criteria, ConstantUtil.RECORD_STATUS_RECYCLE);
    }
    /**
     * 
    * @Title: setStatusRecycle
    * @Description: 设置回收站状态条件
    * @author lijun
    * @param criteria
    * @throws Exception
    * @throws
     */
    public void setStatusRecycle(Object model){
        setStatusModel(model, ConstantUtil.RECORD_STATUS_RECYCLE);
    }
    
    /**
     * 
    * @Title: setStatusDeleted
    * @Description: 设置彻底删除状态条件
    * @author lijun
    * @param criteria
    * @throws Exception
    * @throws
     */
    public void setStatusDeleted(Object model){
        setStatusModel(model, ConstantUtil.RECORD_STATUS_DELETED);
    }
    
    /**
     * 
    * @Title: setStatusGeneral
    * @Description: 设置恢复状态
    * @author lijun
    * @param model
    * @throws
     */
    public void setStatusGeneral(Object model){
        setStatusModel(model, ConstantUtil.RECORD_STATUS_GENERAL);
    }
}
