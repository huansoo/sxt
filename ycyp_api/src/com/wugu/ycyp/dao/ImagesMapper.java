package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.Images;
import com.wugu.ycyp.entity.ImagesExample;
import com.wugu.ycyp.entity.ImagesWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImagesMapper {
    int countByExample(ImagesExample example);

    int deleteByExample(ImagesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImagesWithBLOBs record);

    int insertSelective(ImagesWithBLOBs record);

    List<ImagesWithBLOBs> selectByExampleWithBLOBs(ImagesExample example);

    List<Images> selectByExample(ImagesExample example);

    ImagesWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImagesWithBLOBs record, @Param("example") ImagesExample example);

    int updateByExampleWithBLOBs(@Param("record") ImagesWithBLOBs record, @Param("example") ImagesExample example);

    int updateByExample(@Param("record") Images record, @Param("example") ImagesExample example);

    int updateByPrimaryKeySelective(ImagesWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ImagesWithBLOBs record);

    int updateByPrimaryKey(Images record);
}