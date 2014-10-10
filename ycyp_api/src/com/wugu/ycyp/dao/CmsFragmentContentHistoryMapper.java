package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.CmsFragmentContentHistory;
import com.wugu.ycyp.entity.CmsFragmentContentHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsFragmentContentHistoryMapper {
    int countByExample(CmsFragmentContentHistoryExample example);

    int deleteByExample(CmsFragmentContentHistoryExample example);

    int deleteByPrimaryKey(Long historyId);

    int insert(CmsFragmentContentHistory record);

    int insertSelective(CmsFragmentContentHistory record);

    List<CmsFragmentContentHistory> selectByExampleWithBLOBs(CmsFragmentContentHistoryExample example);

    List<CmsFragmentContentHistory> selectByExample(CmsFragmentContentHistoryExample example);

    CmsFragmentContentHistory selectByPrimaryKey(Long historyId);

    int updateByExampleSelective(@Param("record") CmsFragmentContentHistory record, @Param("example") CmsFragmentContentHistoryExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsFragmentContentHistory record, @Param("example") CmsFragmentContentHistoryExample example);

    int updateByExample(@Param("record") CmsFragmentContentHistory record, @Param("example") CmsFragmentContentHistoryExample example);

    int updateByPrimaryKeySelective(CmsFragmentContentHistory record);

    int updateByPrimaryKeyWithBLOBs(CmsFragmentContentHistory record);

    int updateByPrimaryKey(CmsFragmentContentHistory record);
}