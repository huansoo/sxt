package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.commons.ConstantUtil;
import com.wugu.zhaopin.dao.ZpResumeInfoDAO;
import com.wugu.zhaopin.service.PersonInfoManager;
import com.wugu.zhaopin.service.ResumeInfoManager;
import com.wugu.zhaopin.service.UserManager;
import com.wugu.zhaopin.vo.ZpPersonInfo;
import com.wugu.zhaopin.vo.ZpPersonInfoCriteria;
import com.wugu.zhaopin.vo.ZpResumeInfo;
import com.wugu.zhaopin.vo.ZpResumeInfoCriteria;
import com.wugu.zhaopin.vo.ZpUser;
import com.wugu.zhaopin.webapp.model.ResumeInfoCriteria;
import com.wugu.zhaopin.webapp.model.ResumeReportCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;
import com.wugu.zhaopin.util.ObjectUtil;

public class ResumeInfoManagerImpl implements ResumeInfoManager {
	private ZpResumeInfoDAO resumeinfodao;
	private PersonInfoManager personInfoManager;
	private UserManager userManager;
	
	public UserManager getUserManager()
    {
        return userManager;
    }

    public void setUserManager(UserManager userManager)
    {
        this.userManager = userManager;
    }

    public PersonInfoManager getPersonInfoManager()
    {
        return personInfoManager;
    }

    public void setPersonInfoManager(PersonInfoManager personInfoManager)
    {
        this.personInfoManager = personInfoManager;
    }
    
    public ZpResumeInfoDAO getResumeinfodao() {
		return resumeinfodao;
	}

	public void setResumeinfodao(ZpResumeInfoDAO resumeinfodao) {
		this.resumeinfodao = resumeinfodao;
	}

	@Override
	public int countByExample(ZpResumeInfoCriteria example) throws SQLException {
		return resumeinfodao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpResumeInfoCriteria example)
			throws SQLException {
		return resumeinfodao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long resumeId) throws SQLException {
		return resumeinfodao.deleteByPrimaryKey(resumeId);
	}

	@Override
	public Long insert(ZpResumeInfo record) throws Exception  {	    
	    return resumeinfodao.insert(record);
	}
    
	@Override
    public Long insert(ZpResumeInfo record, boolean addUser) throws Exception  {
        if (!addUser){
            return insertSelective(record); 
        }
        
        Integer result = 1;
        
        //更新user信息及person个人信息
        //if (record.getUserId() != null){
            ZpPersonInfo person = new ZpPersonInfo();
            ZpUser user = new ZpUser();
            //从简历信息数据中复制用户信息
            ObjectUtil.Copy(record, person);  
            ObjectUtil.Copy(record, user);
            //增加username字段，不需要获取realName
            //user.setUserName(user.getRealName());
            user.setType(ConstantUtil.USER_TYPE_PERSON);
            //如果用户信息不存在，新增一个用户 ,新增一个个人用户基本信息   
            //先增加person信息，返回UserID后，再新增User信息
            result = personInfoManager.addPerson(person);
            if (result > 0){
                result = userManager.addUser(user);
            }
            else
                throw new Exception("新增用户信息失败！");
        //}
        Long lResult = 0L;
        //添加简历信息
        if (result > 0)
            lResult = insertSelective(record);
        else 
            throw new Exception("新增个人简历信息失败！"); 
        
        return lResult;
    }
	
	@Override
	public Long insertSelective(ZpResumeInfo record) throws SQLException {
		return resumeinfodao.insertSelective(record);
	}
	
	public void setPersonInfo(ZpPersonInfo person, ZpResumeInfo resume){
	    resume.setBirthDate(person.getBirthDate());
	    resume.setEducationBg(person.getEducationBg());
	    resume.setEmail(person.getEmail());
	    resume.setFixedTel(person.getFixedTel());
	    resume.setGender(person.getGender());
	    resume.setMobileTel(person.getMobileTel());
	    resume.setPhoto(person.getPhoto());
	    resume.setRealName(person.getRealName());
	    resume.setResidence(person.getResidence());
	    resume.setWorkTime(person.getWorkTime());
	}

	@Override
	public List<ZpResumeInfo> selectByExample(ZpResumeInfoCriteria example)
			throws Exception {
	    List<ZpResumeInfo> list = resumeinfodao.selectByExample(example);
	    if (list.size() > 0){
	        ZpPersonInfo person = personInfoManager.selectByPrimaryKey(list.get(0).getUserId());
           if (person == null){
               System.out.println("ID为‘" + list.get(0).getUserId() + "'的个人用户基本信息不存在！");
               throw new Exception("个人用户基本信息不存在！");
           }
	        for (int i =0; i < list.size(); i++){
	            setPersonInfo(person, list.get(i)); 
	        }
	    }
		return list;
	}

	@Override
	public ZpResumeInfo selectByPrimaryKey(Long resumeId) throws Exception {
	    ZpResumeInfo result = resumeinfodao.selectByPrimaryKey(resumeId);
	    if (result != null){
	       ZpPersonInfo person = personInfoManager.selectByPrimaryKey(result.getUserId()); 
	       if (person == null){
	           System.out.println("ID为‘" + result.getUserId() + "'的个人用户基本信息不存在！");
	           throw new Exception("个人用户基本信息不存在！");
	       }
	       setPersonInfo(person, result);
	    }
	        
		return result;
	}
	
	public List<ZpPersonInfo> selectPersonByExmaple(ZpPersonInfoCriteria example)
	        throws SQLException {
           return personInfoManager.selectByExample(example); 
    }

	@Override
	public int updateByExampleSelective(ZpResumeInfo record,
			ZpResumeInfoCriteria example) throws SQLException {
		return resumeinfodao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpResumeInfo record, ZpResumeInfoCriteria example)
			throws SQLException {
		return resumeinfodao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpResumeInfo record)
			throws SQLException {
		return resumeinfodao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpResumeInfo record) throws SQLException {
		return resumeinfodao.updateByPrimaryKey(record);
	}

    /* (非 Javadoc)
    * <p>Title: updateByPrimaryKeySelective</p>
    * <p>Description: </p>
    * @param record
    * @param updateUser
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.ResumeInfoManager#updateByPrimaryKeySelective(com.wugu.zhaopin.vo.ZpResumeInfo, boolean)
    */
    @Override
    public int updateByPrimaryKeySelective(ZpResumeInfo record,
            boolean updateUser) throws Exception
    {
        if (!updateUser){
            return updateByPrimaryKeySelective(record); 
        }
        
        Integer result = 1;
        
        if (record.getUserId() != null){
            ZpPersonInfo person = new ZpPersonInfo();
            ZpUser user = new ZpUser();
            //从简历信息数据中复制用户信息
            ObjectUtil.Copy(record, person);  
            ObjectUtil.Copy(record, user);
            user.setUserName(user.getRealName());
            user.setType(ConstantUtil.USER_TYPE_PERSON);
            //如果用户信息不存在，新增一个用户 ,新增一个个人用户基本信息      
            result = userManager.addUser(user);
            if (result > 0)
                result = personInfoManager.addPerson(person);
            else
                throw new Exception("修改用户信息失败！");
        }
        
        Long lResult = 0L;
        //添加简历信息
        if (result > 0){
            result = updateByPrimaryKeySelective(record);
        }
        else 
            throw new Exception("修改个人用户基本信息失败！"); 
        
        return result;
    }

    /* (非 Javadoc)
    * <p>Title: countByExample</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.ResumeInfoManager#countByExample(com.wugu.zhaopin.webapp.model.ResumeInfoCriteria)
    */
    @Override
    public int countByExample(ResumeInfoCriteria example) throws SQLException
    {
        return resumeinfodao.countByExample(example);
    }

    /* (非 Javadoc)
    * <p>Title: selectBypage</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.ResumeInfoManager#selectBypage(com.wugu.zhaopin.webapp.model.ResumeInfoCriteria)
    */
    @Override
    public PageWraper selectBypage(ResumeInfoCriteria example)
            throws SQLException
    {
        return resumeinfodao.selectBypage(example);
    }

    /* (非 Javadoc)
    * <p>Title: getLastResumeCount</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.ResumeInfoManager#getLastResumeCount(com.wugu.zhaopin.webapp.model.ResumeInfoCriteria)
    */
    @Override
    public int getLastResumeCount(ResumeInfoCriteria example)
            throws SQLException
    {
        return resumeinfodao.getLastResumeCount(example);
    }

    /* (非 Javadoc)
    * <p>Title: getLastResumeList</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.ResumeInfoManager#getLastResumeList(com.wugu.zhaopin.webapp.model.ResumeInfoCriteria)
    */
    @Override
    public PageWraper getLastResumeList(ResumeInfoCriteria example)
            throws SQLException
    {
        return resumeinfodao.getLastResumeList(example);
    }

    /* (非 Javadoc)
    * <p>Title: getResumeReportCount</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.ResumeInfoManager#getResumeReportCount(com.wugu.zhaopin.webapp.model.ResumeReportCriteria)
    */
    @Override
    public int getResumeReportCount(ResumeReportCriteria example)
            throws SQLException
    {
        return resumeinfodao.getResumeReportCount(example);
    }

    /* (非 Javadoc)
    * <p>Title: getResumeReport</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.ResumeInfoManager#getResumeReport(com.wugu.zhaopin.webapp.model.ResumeReportCriteria)
    */
    @Override
    public PageWraper getResumeReport(ResumeReportCriteria example)
            throws SQLException
    {
        return resumeinfodao.getResumeReport(example);
    }

}
