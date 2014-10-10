package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.Recommend;
import com.wugu.ycyp.entity.RecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {
    int countByExample(RecommendExample example);

    int deleteByExample(RecommendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendExample example);

    Recommend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}