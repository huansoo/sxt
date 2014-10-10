package com.wugu.zhaopin.webapp.job;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.commons.DataUtil;
import com.wugu.zhaopin.commons.HttpUtil;
import com.wugu.zhaopin.service.BaseCityManager;
import com.wugu.zhaopin.service.BaseDistrictManager;
import com.wugu.zhaopin.service.BaseProvinceManager;
import com.wugu.zhaopin.service.CompanyManager;
import com.wugu.zhaopin.service.DictinaryManager;
import com.wugu.zhaopin.service.impl.CompanyManagerImpl;
import com.wugu.zhaopin.vo.BaseCity;
import com.wugu.zhaopin.vo.BaseCityCriteria;
import com.wugu.zhaopin.vo.BaseDistrict;
import com.wugu.zhaopin.vo.BaseDistrictCriteria;
import com.wugu.zhaopin.vo.BaseProvince;
import com.wugu.zhaopin.vo.BaseProvinceCriteria;
import com.wugu.zhaopin.vo.ZpDictinaryCriteria;
import com.wugu.zhaopin.webapp.api.Code;
import com.wugu.zhaopin.webapp.model.ApiResult;
import com.wugu.zhaopin.vo.ZpDictinary;
import com.wugu.zhaopin.webapp.util.JobUtil;
import com.wugu.zhaopin.cache.MemCachedMaker;

/**
 * 
* @ClassName: DictinaryJob
* @Description: 字典应用类
* @author lijun
* @date 2013-12-25 下午4:50:27
*
 */
public class DictinaryJob extends BaseJob {
	private DictinaryManager dictinarymanager;
	private BaseProvinceManager baseprovincemanager;
	private BaseCityManager basecitymanager;
	private BaseDistrictManager basedistrictmanager;
	
	private static final String METHODNAME_GETDICBYPARENTID = "getdicbyparentid_";
	private static final String METHODNAME_GETALLDICTINARY  = "getallditionary_";
	private static final String METHODNAME_GETDICITEMBYROWID  = "getdicitembyrowid_";
	private static final String METHODNAME_GETDICITEMBYDICID  = "getdicitembydicid_";
	private static final String METHODNAME_GETPROVINCEBYID  = "getprovincebyid_";
	private static final String METHODNAME_GETPROVINCEALL  = "getprovinceall_";
    private static final String METHODNAME_GETCITYBYPROVINCE  = "getcitybyprovince_";
    private static final String METHODNAME_GETCITYBYID  = "getcitybyid_";	
    private static final String METHODNAME_GETDISTRICTBYCITY  = "getdistrictbycity_";
    private static final String METHODNAME_GETDISTRICTBYID  = "getdistrictbyid_";   
    
	public DictinaryManager getDictinaryManager() {
		if (dictinarymanager == null){
			dictinarymanager = (DictinaryManager)getBeanEx("dictinarymanager", DictinaryManager.class);
		}
		return dictinarymanager;
	}
	
    public BaseProvinceManager getProvinceManager() {
        if (baseprovincemanager == null){
            baseprovincemanager = (BaseProvinceManager)getBeanEx("baseprovincemanager", BaseProvinceManager.class);
        }
        return baseprovincemanager;
    }  
	
    public BaseCityManager getCityManager() {
        if (basecitymanager == null){
            basecitymanager = (BaseCityManager)getBeanEx("basecitymanager", BaseCityManager.class);
        }
        return basecitymanager;
    }  
    
    public BaseDistrictManager getDistrictManager() {
        if (basedistrictmanager == null){
            basedistrictmanager = (BaseDistrictManager)getBeanEx("basedistrictmanager", BaseDistrictManager.class);
        }
        return basedistrictmanager;
    }  
    
	private List getDicByParentId(Integer parentId)  throws  IOException, SQLException{
		List<ZpDictinary> list = null;
		
		String key = METHODNAME_GETDICBYPARENTID + parentId.toString();
		if (MemCachedMaker.hasCache(key)){
		    return (List<ZpDictinary>)MemCachedMaker.get(key);
		}
		else {		
    		ZpDictinaryCriteria example = new ZpDictinaryCriteria();
    		example.createCriteria().andParentIdEqualTo(parentId);
    		example.setOrderByClause("order_index");
    		
    		list = getDictinaryManager().selectByExample(example);
    		MemCachedMaker.set(key, list, ConstantUtil.DEFAULT_CATCHE_TIME);
    		return list;
		}
	}
	
	private List getAllDic() throws IOException, SQLException{
		List<ZpDictinary> list = null;
		
		String key = METHODNAME_GETALLDICTINARY;
		
        if (MemCachedMaker.hasCache(key)){
            return (List<ZpDictinary>)MemCachedMaker.get(key);
        }
        else {      
            ZpDictinaryCriteria example = new ZpDictinaryCriteria();
            
            list = getDictinaryManager().selectByExample(example);
            
            MemCachedMaker.set(key, list, ConstantUtil.DEFAULT_CATCHE_TIME);
            
            return list;
        }
		
	}
	
	/**
	 * 
	* @Title: getDictinary
	* @Description: 根据字典类型获取字典列表,返回Json格式数据
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getDictinary() throws  IOException, SQLException{
		ApiResult<String> apiresult = new ApiResult<String>();
		try {
			String parentIdStr = getQueryString("parentId");
			Integer parentId = getQueryInt("parentId");
			
			List<ZpDictinary> list = null;
			if(parentIdStr == null || parentIdStr.equals("-1")){
				list = getAllDic();
			}
			else {
				list = getDicByParentId(parentId);			
			}			

			JsonConfig config = JobUtil.getJsonConfig();
			JSONArray jsonArr = JSONArray.fromObject(list, config);	
			
			apiresult.setCode(Code.Succes);
			apiresult.setStatus(200);
			apiresult.setData(jsonArr.toString());
		} catch (Exception ex) {
			apiresult.setStatus(500);
			apiresult.setData("");
			apiresult.setException(ex.toString());
            ex.printStackTrace();
		}
		HttpUtil.responseJson(apiresult, getResponse());	
	}
	
	/**
	 * 
	* @Title: getDictinaryMap
	* @Description: 以键值对的形式返回字典
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
    public void getDictinaryMap() throws  IOException, SQLException{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            String parentIdStr = getQueryString("parentId");
            Integer parentId = getQueryInt("parentId");
            
            List<ZpDictinary> list = null;
            Map map = new HashMap();
            if(parentIdStr == null || parentIdStr.equals("-1")){
                list = getAllDic();
                
                for (ZpDictinary dic : list)
                {
                   map.put(dic.getRowId().toString(), dic);
                }
            }
            else {
                list = getDicByParentId(parentId);          
                for (ZpDictinary dic : list)
                {
                   map.put(dic.getDicId().toString(), dic);
                }
            }           

            JsonConfig config = JobUtil.getJsonConfig();
            JSONArray jsonArr = JSONArray.fromObject(map, config); 
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(jsonArr.toString());
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());    
    }
	
	private ZpDictinary getDicItemByRowId(Integer rowId) throws  IOException, SQLException{
        String key = METHODNAME_GETDICITEMBYROWID + rowId.toString();
        
        if (MemCachedMaker.hasCache(key)){
            return (ZpDictinary)MemCachedMaker.get(key);
        }
        else {      	    
            ZpDictinary dicItem = getDictinaryManager().selectByPrimaryKey(rowId);
            
            MemCachedMaker.set(key, dicItem, ConstantUtil.DEFAULT_CATCHE_TIME);
            
            return dicItem;
        }
	}
	
	private ZpDictinary getDicItemByParentIdAndDic_Id(Integer parentId, Integer dicId) 
			throws IOException, SQLException {
        String key = METHODNAME_GETDICITEMBYDICID + parentId.toString() + "_" + dicId.toString();
        
        if (MemCachedMaker.hasCache(key)){
            return (ZpDictinary)MemCachedMaker.get(key);
        }
        else {              
    		ZpDictinaryCriteria example = new ZpDictinaryCriteria();
    		example.createCriteria().andParentIdEqualTo(parentId).andDicIdEqualTo(dicId);
    		List<ZpDictinary> list = getDictinaryManager().selectByExample(example);
    		if (list.size() > 0){
    		    ZpDictinary item = list.get(0);
    		    MemCachedMaker.set(key, item, ConstantUtil.DEFAULT_CATCHE_TIME);
    			return item;
    		}
    		else {
    			return null;
    		}
        }
	}
	
	private List<BaseDistrict> getDistrictList(Integer cityId, Integer districtId) 
	        throws IOException, SQLException {
	    BaseDistrictCriteria example = new BaseDistrictCriteria();
	    BaseDistrictCriteria.Criteria criteria = example.createCriteria().
                andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        if (cityId != null)
            criteria.andCityidEqualTo(cityId);
        else if (districtId != null)
            criteria.andDistrictidEqualTo(districtId);
        example.setOrderByClause("districtid");
        
        return getDistrictManager().selectByExample(example);       
	}
	
	private List<BaseDistrict> getDistrictListByCity(Integer cityId)
	        throws IOException, SQLException {
        String key = METHODNAME_GETDISTRICTBYCITY + cityId.toString();
        if (MemCachedMaker.hasCache(key)){
            return (List<BaseDistrict>)MemCachedMaker.get(key);
        }
        else {
           List<BaseDistrict> list = getDistrictList(cityId, null);
           MemCachedMaker.set(key, list, ConstantUtil.DEFAULT_CATCHE_TIME);
           return list;
        }      
	    
	}

    private BaseDistrict getDistrictById(Integer districtId)
            throws IOException, SQLException {
        String key = METHODNAME_GETDISTRICTBYID + districtId.toString();
        if (MemCachedMaker.hasCache(key)){
            return (BaseDistrict)MemCachedMaker.get(key);
        }
        else {
            List<BaseDistrict> list = getDistrictList(null, districtId);
            BaseDistrict district = list.size() > 0?list.get(0) : null;
            MemCachedMaker.set(key, district, ConstantUtil.DEFAULT_CATCHE_TIME);
            return district;             
        }        
    }
    
    /**
     * 
    * @Title: getDistrictListByCity
    * @Description: 根据城市ID获取所有区列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getDistrictListByCity() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Integer cityId = getQueryInt(JobUtil.PARAMTER_CITY_ID);
            
            if(getQueryString(JobUtil.PARAMTER_CITY_ID) == null) {
                throw new Exception("query cityid missed!");
            }
            
            List<BaseDistrict> list = getDistrictListByCity(cityId);
            
            String json = getListJson(list);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
        
    }
    
    /**
     * 
    * @Title: getDistrictById
    * @Description: 根据区ID获取区信息实例
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getDistrictById() 
            throws IOException, SQLException {
        ApiResult<BaseDistrict> apiresult = new ApiResult<BaseDistrict>();
        try {
            Integer districtId = getQueryInt(JobUtil.PARAMTER_DISTRICT_ID);
            if(getQueryString(JobUtil.PARAMTER_DISTRICT_ID) == null) {
                throw new Exception("query districtid missed!");
            }  
            
            BaseDistrict item = getDistrictById(districtId);

            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(item);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(null);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
	/**
	 * 
	* @Title: getDicItemByKey
	* @Description: 根据rowId或者parentId和dicId获取单个字典,返回Json格式数据
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getDicItemByKey() throws IOException, SQLException {
		ApiResult<ZpDictinary> apiresult = new ApiResult<ZpDictinary>();
		try {
			String rowIdStr = getQueryString("rowId");
			Integer rowId = getQueryInt("rowId");
			String parentIdStr = getQueryString("parentId");
			Integer parentId = getQueryInt("parentId");
			String dicIdStr = getQueryString("dicId");
			Integer dicId = getQueryInt("dicId");
			if(rowId == null && (parentId == null || dicId == null)) {
				throw new Exception("query key missed!");
			}	
			
			ZpDictinary item = null;
			if(rowIdStr != null && !rowIdStr.equals("-1")){
				item = getDicItemByRowId(rowId);
			}
			else {
				item = getDicItemByParentIdAndDic_Id(parentId, dicId);			
			}			

			apiresult.setCode(Code.Succes);
			apiresult.setStatus(200);
			apiresult.setData(item);
		} catch (Exception ex) {
			apiresult.setStatus(500);
			apiresult.setData(null);
			apiresult.setException(ex.toString());
            ex.printStackTrace();
		}
		HttpUtil.responseJson(apiresult, getResponse());		
	}
	
	private List<BaseCity> getCityList(Integer provinceId, Integer cityId) 
	        throws IOException, SQLException {
        BaseCityCriteria example = new BaseCityCriteria();
        BaseCityCriteria.Criteria criteria = example.createCriteria().
                        andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        if (provinceId != null)
            criteria.andProvinceidEqualTo(provinceId);
        else if (cityId != null)
            criteria.andCityidEqualTo(cityId);
        example.setOrderByClause("cityid");
        
        return getCityManager().selectByExample(example);	    
	}
	
	private List<BaseCity> getCityListByProvince(Integer provinceId) 
	        throws IOException, SQLException {
	    String key = METHODNAME_GETCITYBYPROVINCE + provinceId.toString();
	    if (MemCachedMaker.hasCache(key)){
	        return (List<BaseCity>)MemCachedMaker.get(key);
	    }
	    else {
	       List<BaseCity> list = getCityList(provinceId, null);
	       MemCachedMaker.set(key, list, ConstantUtil.DEFAULT_CATCHE_TIME);
	       return list;
	    }	    
	}

    private BaseCity getCityById(Integer cityId) 
            throws IOException, SQLException {
        String key = METHODNAME_GETCITYBYID + cityId.toString();
        if (MemCachedMaker.hasCache(key)){
            return (BaseCity)MemCachedMaker.get(key);
        }
        else {
            List<BaseCity> list = getCityList(null, cityId);
            BaseCity city = list.size() > 0?list.get(0) : null;
            MemCachedMaker.set(key, city, ConstantUtil.DEFAULT_CATCHE_TIME);
            return city;             
        }
    }
    
    /**
     * 
    * @Title: getCityByProvince
    * @Description: 根据省份ID获取所在省城市列表
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getCityListByProvince() throws IOException, SQLException{
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            Integer provinceId = getQueryInt(JobUtil.PARAMTER_PROVINCE_ID);
            
            if(getQueryString(JobUtil.PARAMTER_PROVINCE_ID) == null) {
                throw new Exception("query provinceId missed!");
            }
            
            List<BaseCity> list = getCityListByProvince(provinceId);
            
            String json = getListJson(list);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
        
    }
    
    /**
     * 
    * @Title: getCityById
    * @Description: 根据城市ID获取城市信息实例
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getCityById() throws IOException, SQLException{
        ApiResult<BaseCity> apiresult = new ApiResult<BaseCity>();
        try {
            Integer cityId = getQueryInt(JobUtil.PARAMTER_CITY_ID);
            if(getQueryString(JobUtil.PARAMTER_CITY_ID) == null) {
                throw new Exception("query cityid missed!");
            }  
            
            BaseCity item = getCityById(cityId);

            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(item);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(null);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());           
    }
	
	private List<BaseProvince> getProvinceList(Integer provinceId)
	        throws IOException, SQLException {
        BaseProvinceCriteria example = new BaseProvinceCriteria();
        if (provinceId != null)
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN).
                andProvinceidEqualTo(provinceId);
        else 
            example.createCriteria().andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN);
        example.setOrderByClause("provinceid");
        
        return getProvinceManager().selectByExample(example);
	}
	
	private BaseProvince getProvinceById(Integer provinceId) 
	        throws IOException, SQLException {	
	    String key = METHODNAME_GETPROVINCEBYID + provinceId.toString();
	    if (MemCachedMaker.hasCache(key))
	        return (BaseProvince)MemCachedMaker.get(key);
	    else {
    	    List<BaseProvince> list = getProvinceList(provinceId);
    	    
    	    if (list.size() > 0){
    	        MemCachedMaker.set(key, list.get(0), ConstantUtil.DEFAULT_CATCHE_TIME);
    	        return list.get(0);
    	    }
    	    else
    	        return null;
	    }
	}
	
	@SuppressWarnings("unchecked")
    private List<BaseProvince> getProvinceAllList()
	        throws IOException, SQLException {
	    String key = METHODNAME_GETPROVINCEALL;
	    if (MemCachedMaker.hasCache(key)){
	        return (List<BaseProvince>)MemCachedMaker.get(key);
	    }
	    else {
	        List<BaseProvince> list = getProvinceList(null);
	        MemCachedMaker.set(key, list, ConstantUtil.DEFAULT_CATCHE_TIME);
	        return list;
	    }
	}

    /**
     * 
    * @Title: getProvinceAll
    * @Description: 获取全部省份数据
    * @author lijun
    * @throws IOException
    * @throws SQLException
    * @throws
     */
    public void getProvinceAll() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            List<BaseProvince> list = getProvinceAllList();
            
            String json = getListJson(list);
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(json);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
    
    private String getListJson(List list){
        JsonConfig config = JobUtil.getJsonConfig();
        JSONArray jsonArr = JSONArray.fromObject(list, config); 
        
        return jsonArr.toString();
    }
    
	/**
	 * 
	* @Title: getProvinceById
	* @Description: 根据省份ID获取省份数据
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getProvinceById() throws IOException, SQLException {
        ApiResult<BaseProvince> apiresult = new ApiResult<BaseProvince>();
        try {
            Integer provinceId = getQueryInt(JobUtil.PARAMTER_PROVINCE_ID);
            if(getQueryString(JobUtil.PARAMTER_PROVINCE_ID) == null) {
                throw new Exception("query provinceId missed!");
            }  
            
            BaseProvince item = getProvinceById(provinceId);

            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(item);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData(null);
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
	
	/**
	 * 
	* @Title: getAddressById 
	* @Description: 根据ID返回地址，id使用逗号分隔，如果-1，则不返回
	* @author lijun
	* @throws IOException
	* @throws SQLException
	* @throws
	 */
	public void getAddressById() throws IOException, SQLException {
        ApiResult<String> apiresult = new ApiResult<String>();
        try {
            String result = "";
            String ids = getQueryString(JobUtil.PARAMTER_ADDRESS_IDS);
            if(getQueryString(JobUtil.PARAMTER_ADDRESS_IDS) == null) {
                throw new Exception("query ids missed!");
            }  
            
            //id格式：省,市,区
            String[] arr = ids.split(",");
            System.out.println(arr.length);
            if (arr.length < 3)
                throw new Exception("地址ID非法！");
            //获取省份名称
            if (!arr[0].equals("-1")){
                BaseProvince province =  getProvinceById(DataUtil.toInt(arr[0]));
                if (province == null)
                    throw new Exception("省份ID“" + arr[0] + "”非法！");
                result = province.getProvincename();
                
                //获取市名称
                if (!arr[1].equals("-1")){
                    BaseCity city = getCityById(DataUtil.toInt(arr[1]));
                    if (city == null)
                        throw new Exception("市ID“" + arr[1] + "”非法！");
                    result += "," + city.getCityname();
                    
                    //获取区名称
                    if (!arr[2].equals("-1")){
                        BaseDistrict district = getDistrictById(DataUtil.toInt(arr[2]));
                        if (district == null)
                            throw new Exception("区/县ID“" + arr[2] + "”非法！");
                        result += "," + district.getDistrictname();
                    }
                }
            }
            
            apiresult.setCode(Code.Succes);
            apiresult.setStatus(200);
            apiresult.setData(result);
        } catch (Exception ex) {
            apiresult.setStatus(500);
            apiresult.setData("");
            apiresult.setException(ex.toString());
            ex.printStackTrace();
        }
        HttpUtil.responseJson(apiresult, getResponse());        
    }
}
