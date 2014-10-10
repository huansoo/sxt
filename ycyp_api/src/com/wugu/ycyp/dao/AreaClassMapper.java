package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.AreaClass;
import com.wugu.ycyp.entity.AreaClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaClassMapper {
    int countByExample(AreaClassExample example);

    int deleteByExample(AreaClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AreaClass record);

    int insertSelective(AreaClass record);

    List<AreaClass> selectByExample(AreaClassExample example);

    AreaClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AreaClass record, @Param("example") AreaClassExample example);

    int updateByExample(@Param("record") AreaClass record, @Param("example") AreaClassExample example);

    int updateByPrimaryKeySelective(AreaClass record);

    int updateByPrimaryKey(AreaClass record);
}