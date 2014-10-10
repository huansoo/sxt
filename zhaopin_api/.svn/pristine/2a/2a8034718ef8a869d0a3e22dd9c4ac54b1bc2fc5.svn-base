/**  
* @Title:  ImportZhaopinData.java
* @Package com.wugu.zhaopin.tools
* @Description: TODO(用一句话描述该文件做什么)
* @author lijun
* @date  2014-1-26 
* @version V1.0  
* Update Logs:
* ****************************************************
* Name:
* Date:
* Description:
******************************************************
*/
package com.wugu.zhaopin.tools;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.service.BaseCityManager;
import com.wugu.zhaopin.service.BaseDistrictManager;
import com.wugu.zhaopin.service.BaseProvinceManager;
import com.wugu.zhaopin.service.CompanyManager;
import com.wugu.zhaopin.service.DictinaryManager;
import com.wugu.zhaopin.util.DateUtil;
import com.wugu.zhaopin.util.ExcelUtil;
import com.wugu.zhaopin.util.ObjectUtil;
import com.wugu.zhaopin.vo.BaseCity;
import com.wugu.zhaopin.vo.BaseCityCriteria;
import com.wugu.zhaopin.vo.BaseDistrict;
import com.wugu.zhaopin.vo.BaseDistrictCriteria;
import com.wugu.zhaopin.vo.BaseProvince;
import com.wugu.zhaopin.vo.BaseProvinceCriteria;
import com.wugu.zhaopin.vo.ZpCompanyContact;
import com.wugu.zhaopin.vo.ZpCompanyInfo;
import com.wugu.zhaopin.vo.ZpDictinary;
import com.wugu.zhaopin.vo.ZpDictinaryCriteria;
import com.wugu.zhaopin.vo.ZpPostInfo;
import com.wugu.zhaopin.webapp.model.ZpCompanyContactModel;
import com.wugu.zhaopin.webapp.model.ZpCompanyInfoModel;
import com.wugu.zhaopin.webapp.util.ContextUtil;

/**
 * @ClassName: ImportZhaopinData
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lijun
 * @date 2014-1-26 
 *
 */
public class ImportZhaopinData
{
    private static final String[] tableName = {"职位信息（每个公司对应多个职位）", "企业基本信息"};
    private static final String[][] postCol = {
        {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
        {"companyName", "name", "workExprience", "recruitNum", "educationBg", "duty", "salary", "welfare", "workAddress", "workAddress", "workAddress", "address", "contactMan", "fixedTel", "mobileTel", "email"},
        {"", "", "1", "", "2", "", "4", "", "", "", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "base_Province", "base_City", "base_District", "", "", "", "", ""},
        {"1", "1", "2", "1", "2", "1", "2", "1", "1", "1", "1", "1", "1", "1", "1", "1"}};
    private static final String[][] companyInfo = {
        {"0", "1", "2", "3", "4", "5"}, 
        {"name", "companyType", "scaleId", "introduce", "siteUrl", "license"},
        {"", "3", "5", "", "", ""},
        {"", "", "", "", "", ""},
        {"1", "2", "2", "2", "1", "1"}};
    private static final String[][] companyCont = {
        {"6", "7", "8", "9", "10", "11", "12", "13"}, 
        {"contactMan", "fixedTel", "email", "location", "location", "location", "address", "mobileTel"},
        {"", "", "", "", "", "", "", ""},
        {"", "", "", "base_Province", "base_City", "base_District", "", ""},
        {"1", "1", "1", "1", "1", "1", "1", "1"}};
    
    private static final Integer postStartRow = 1;
    private static final Integer CompanyStartRow = 1;
    private static final Integer UserInfoStartRow = 3;
    
    private DictinaryManager dictinarymanager;
    private BaseProvinceManager baseprovincemanager;
    private BaseCityManager basecitymanager;
    private BaseDistrictManager basedistrictmanager;
    private CompanyManager companymanager;
    
    public <T> T getBeanEx(String beanId, Class<T> t){
        T bean = (T)ContextUtil.getContext().getBean(beanId, t);
        return bean;
    }
    
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
    
    public CompanyManager getCompanyManager() {
        if (companymanager == null){
            companymanager = (CompanyManager)getBeanEx("companymanager", CompanyManager.class);
        }
        return companymanager;
    }
    
    private RowInfo getRowInfo(Integer col, String[][] arr){
        RowInfo rowInfo = new RowInfo();
        for (int i = 0; i < arr[0].length; i++){
            Integer index = Integer.parseInt(arr[0][i]);
            if (col == index){
                rowInfo.setIndex(index);
                rowInfo.setName(arr[1][i]);
                if (arr[2][i] != "")
                    rowInfo.setDicParent(Integer.parseInt(arr[2][i]));
                rowInfo.setTableName(arr[3][i]);
                if (arr[4][i] != "")
                    rowInfo.setType(Integer.parseInt(arr[4][i]));
            }            
        }
        return rowInfo;
    }
    
    private ZpDictinary getDicItemByParentIdAndDic_Id(Integer parentId, String value) 
            throws IOException, SQLException {
        ZpDictinaryCriteria example = new ZpDictinaryCriteria();
        example.createCriteria().andParentIdEqualTo(parentId).andDicValueEqualTo(value);
        List<ZpDictinary> list = getDictinaryManager().selectByExample(example);
        if (list.size() > 0){
            ZpDictinary item = list.get(0);
            return item;
        }
        else {
            return null;
        }
    }
    
    private Integer getDicValue(Integer dicParent, String value){
        Integer result = 0;        
        try
        {
            ZpDictinary dic = getDicItemByParentIdAndDic_Id(dicParent, value);
            if (dic != null)
                result = dic.getDicId();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return result;
    }
    
    private String getAddressValue(String tableName, String value){
        String result = "";
        
        try
        {        
            if (tableName == "base_Province"){
                
                BaseProvinceCriteria example = new BaseProvinceCriteria();
                example.createCriteria().
                                andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN).
                                andProvincenameLike("%" + value + "%");
                
                List <BaseProvince> list = getProvinceManager().selectByExample(example);
                if (list.size() > 0)
                    result = list.get(0).getProvinceid().toString() + ",";                
            }
            else if (tableName == "base_City"){
                BaseCityCriteria example = new BaseCityCriteria();
                example.createCriteria().
                                andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN).
                                andCitynameLike("%" + value + "%");
                
                List <BaseCity> list = getCityManager().selectByExample(example);
                if (list.size() > 0)
                    result = list.get(0).getCityid().toString() + ",";
            }            
            else if (tableName == "base_District"){
                BaseDistrictCriteria example = new BaseDistrictCriteria();
                example.createCriteria().
                                andStatusNotEqualTo(ConstantUtil.RECORDDELETESIGN).
                                andDistrictnameLike("%" + value + "%");
                
                List <BaseDistrict> list = getDistrictManager().selectByExample(example);
                if (list.size() > 0)
                    result = list.get(0).getDistrictid().toString() + ",";
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return result;
    }
    
    private void setValue(RowInfo rowInfo, Object value, JSONObject json){
       
       if (rowInfo.dicParent != -1)
           json.element(rowInfo.name, getDicValue(rowInfo.dicParent, (String)value)) ;
       else if (rowInfo.tableName != null && !"".equals(rowInfo.tableName) && value != null){
           if (value == null)
               json.element(rowInfo.name, json.getString(rowInfo.name) + "" + ",");
           else
               json.element(rowInfo.name, json.getString(rowInfo.name) + (String)value + ",");
       }
       else 
           json.element(rowInfo.name, value);
    }
    
    private void setDefaultValue(JSONObject json){
        json.element("createTime", DateUtil.getCurrentTimes());
        json.element("updateTime", DateUtil.getCurrentTimes());
        json.element("status", 1);
    }
    
    public static <T> T getModelFromJson(String json, Class<T> t){
        JSONObject obj = JSONObject.fromObject(json);
        @SuppressWarnings("unchecked")
        T model = (T)JSONObject.toBean(obj, t);
        return model;               
    }
    
    private Long getUserId(String companyName, List list){
        if (companyName == null || "".equals(companyName))
            return 0L;
        for (int i = UserInfoStartRow; i < list.size(); i++){
            List row = (List)list.get(i);
            if (companyName.equals(row.get(0)))
                return Long.parseLong((String)(row.get(2)));
        }
        return 0L;
    }
    
    private Integer insertCompany(List row, Long userId){
        Integer companyId = 0;
        
        if (row.get(0) == null || "".equals(row.get(0)))
           return companyId;
        
        ZpCompanyInfoModel company = new ZpCompanyInfoModel();
        ZpCompanyContactModel contact = new ZpCompanyContactModel();
        company.setCompanyContact(contact);
        company.setUserId(userId);
        
        JSONObject json_company = JSONObject.fromObject(company);

        for (int i = 0; i < row.size(); i++)
        {
           RowInfo rowInfo = getRowInfo(i, companyInfo); 
           if (rowInfo.name != null && rowInfo.name != "")
               setValue(rowInfo, row.get(i), json_company);
        }
        setDefaultValue(json_company);
        
        Long contactId = setContact(row, json_company.getJSONObject("companyContact"));
        
        //json对象转换成java对象
        ZpCompanyInfoModel companyinfomodel = getModelFromJson(json_company.toString(), ZpCompanyInfoModel.class); 
        ZpCompanyContactModel companycontactmodel = companyinfomodel.getCompanyContact();
        
        ZpCompanyInfo companyinfo = new ZpCompanyInfo();
        ZpCompanyContact companyContact = new ZpCompanyContact();
        
        //对象赋值
        try
        {
            ObjectUtil.Copy(companyinfomodel, companyinfo);
            ObjectUtil.Copy(companycontactmodel, companyContact);           
            System.out.println(json_company.toString());
            companyId = getCompanyManager().insert(companyinfo, companyContact);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return companyId;
    }
    
    private Long setContact(List row, JSONObject json){
        for (int i = 0; i < row.size(); i++)
        {
           RowInfo rowInfo = getRowInfo(i, companyCont); 
           if (rowInfo.name != null && rowInfo.name != "")
               setValue(rowInfo, row.get(i), json);
        }
        setDefaultValue(json);
        
        return 0L;
    }
    
    private void insertPostRow(List row, Integer companyId) throws SQLException {
        ZpPostInfo post = new ZpPostInfo();
        post.setCompanyId(companyId.intValue());
        JSONObject json = JSONObject.fromObject(post);
        
        for (int i = 0; i < row.size(); i++)
        {
           RowInfo rowInfo = getRowInfo(i, postCol); 
           if (rowInfo.name != null && rowInfo.name != "")
               setValue(rowInfo, row.get(i), json);
        }
        setDefaultValue(json);        
        
        post = getModelFromJson(json.toString(), ZpPostInfo.class);
        System.out.println(json.toString());
        getCompanyManager().insert(post);
    }
    
    private void insertPost(String companyName, Integer companyId, List list) throws SQLException{
        for (int i = postStartRow; i < list.size(); i++)
        {
            List row = (List)list.get(i);
            if (!row.get(0).equals(companyName))
                continue;
            insertPostRow(row, companyId);            
        }        
    }
    
    public void importData(String fileName) throws Exception{
        List list = ExcelUtil.readExcel(fileName);
        if (list == null || list.size() < 2) 
            throw new Exception("文件不合法！");
        
        List postList = (List) list.get(0);
        List compList = (List) list.get(1);
        List userList = (List) list.get(2);
        for (int i = CompanyStartRow; i < compList.size(); i++){
            List row = (List)compList.get(i);
            String companyName = (String)row.get(0);
            if (companyName == null || "".equals(companyName))
                continue;
            Long userId = getUserId(companyName, userList);
            Integer companyId = insertCompany(row, userId);
            insertPost(companyName, companyId, postList);
        }
    }    
    
    public static void main(String[] args) throws Exception{
        ImportZhaopinData data = new ImportZhaopinData();   
        data.importData("E:\\work\\文档\\招聘网站\\document\\zhaopin\\企业职位数据1.23.xls");
        
//        JSONObject json = JSONObject.fromObject(data.getRowInfo(1, companyInfo));
//        json.accumulate("companyName", "adasdaf");
//        json.element("2222", 2222);
//        System.out.println(json.toString());
    }
    
    public class RowInfo{
        private Integer index;
        private String name;
        private Integer dicParent = -1;
        private String tableName = "";
        private Integer type = -1;
        
        public Integer getType()
        {
            return type;
        }
        public void setType(Integer type)
        {
            this.type = type;
        }
        public Integer getIndex()
        {
            return index;
        }
        public void setIndex(Integer index)
        {
            this.index = index;
        }
        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public Integer getDicParent()
        {
            return dicParent;
        }
        public void setDicParent(Integer dicParent)
        {
            this.dicParent = dicParent;
        }
        public String getTableName()
        {
            return tableName;
        }
        public void setTableName(String tableName)
        {
            this.tableName = tableName;
        }
    }
}
