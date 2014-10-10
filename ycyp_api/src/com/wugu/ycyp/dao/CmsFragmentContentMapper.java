package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.CmsFragmentContent;
import com.wugu.ycyp.entity.CmsFragmentContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsFragmentContentMapper {
    int countByExample(CmsFragmentContentExample example);

    int deleteByExample(CmsFragmentContentExample example);

    int deleteByPrimaryKey(Integer contentId);

    int insert(CmsFragmentContent record);

    int insertSelective(CmsFragmentContent record);

    List<CmsFragmentContent> selectByExampleWithBLOBs(CmsFragmentContentExample example);

    List<CmsFragmentContent> selectByExample(CmsFragmentContentExample example);

    CmsFragmentContent selectByPrimaryKey(Integer contentId);

    int updateByExampleSelective(@Param("record") CmsFragmentContent record, @Param("example") CmsFragmentContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CmsFragmentContent record, @Param("example") CmsFragmentContentExample example);

    int updateByExample(@Param("record") CmsFragmentContent record, @Param("example") CmsFragmentContentExample example);

    int updateByPrimaryKeySelective(CmsFragmentContent record);

    int updateByPrimaryKeyWithBLOBs(CmsFragmentContent record);

    int updateByPrimaryKey(CmsFragmentContent record);
}