package com.wugu.zhaopin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wugu.zhaopin.dao.AuditionInfoDAO;
import com.wugu.zhaopin.dao.ZpAuditionInfoDAO;
import com.wugu.zhaopin.service.AuditionInfoManager;
import com.wugu.zhaopin.vo.ZpAuditionInfo;
import com.wugu.zhaopin.vo.ZpAuditionInfoCriteria;
import com.wugu.zhaopin.webapp.model.AuditionInfoCriteria;
import com.wugu.zhaopin.webapp.model.page.PageWraper;

public class AuditionInfoManagerImpl implements AuditionInfoManager {
	private ZpAuditionInfoDAO auditioninfodao;
	private AuditionInfoDAO auditioninfodao2;
	
	public AuditionInfoDAO getAuditioninfodao2()
    {
        return auditioninfodao2;
    }

    public void setAuditioninfodao2(AuditionInfoDAO auditioninfodao2)
    {
        this.auditioninfodao2 = auditioninfodao2;
    }

    public ZpAuditionInfoDAO getAuditioninfodao() {
		return auditioninfodao;
	}

	public void setAuditioninfodao(ZpAuditionInfoDAO auditioninfodao) {
		this.auditioninfodao = auditioninfodao;
	}

	@Override
	public int countByExample(ZpAuditionInfoCriteria example) throws SQLException {
		return auditioninfodao.countByExample(example);
	}

	@Override
	public int deleteByExample(ZpAuditionInfoCriteria example)
			throws SQLException {
		return auditioninfodao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long auditionInfoId) throws SQLException {
		return auditioninfodao.deleteByPrimaryKey(auditionInfoId);
	}

	@Override
	public Long insert(ZpAuditionInfo record) throws SQLException {
		return auditioninfodao.insert(record);
	}

	@Override
	public Long insertSelective(ZpAuditionInfo record) throws SQLException {
		return auditioninfodao.insertSelective(record);
	}

	@Override
	public List<ZpAuditionInfo> selectByExample(ZpAuditionInfoCriteria example)
			throws SQLException {
		return auditioninfodao.selectByExample(example);
	}

	@Override
	public ZpAuditionInfo selectByPrimaryKey(Long auditionInfoId) throws SQLException {
		return auditioninfodao.selectByPrimaryKey(auditionInfoId);
	}

	@Override
	public int updateByExampleSelective(ZpAuditionInfo record,
			ZpAuditionInfoCriteria example) throws SQLException {
		return auditioninfodao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ZpAuditionInfo record, ZpAuditionInfoCriteria example)
			throws SQLException {
		return auditioninfodao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ZpAuditionInfo record)
			throws SQLException {
		return auditioninfodao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ZpAuditionInfo record) throws SQLException {
		return auditioninfodao.updateByPrimaryKey(record);
	}

    /* (非 Javadoc)
    * <p>Title: selectBypage</p>
    * <p>Description: </p>
    * @param example
    * @return
    * @throws SQLException
    * @see com.wugu.zhaopin.service.AuditionInfoManager#selectBypage(com.wugu.zhaopin.webapp.model.AuditionInfoCriteria)
    */
    @Override
    public PageWraper selectByPage(AuditionInfoCriteria example)
            throws SQLException
    {
        return auditioninfodao2.selectBypage(example);
    }

}
