package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.PageView;
import com.wugu.ycyp.entity.PageViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageViewMapper {
    int countByExample(PageViewExample example);

    int deleteByExample(PageViewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PageView record);

    int insertSelective(PageView record);

    List<PageView> selectByExample(PageViewExample example);

    PageView selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PageView record, @Param("example") PageViewExample example);

    int updateByExample(@Param("record") PageView record, @Param("example") PageViewExample example);

    int updateByPrimaryKeySelective(PageView record);

    int updateByPrimaryKey(PageView record);
}