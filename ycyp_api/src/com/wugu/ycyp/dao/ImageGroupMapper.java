package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.ImageGroup;
import com.wugu.ycyp.entity.ImageGroupExample;
import com.wugu.ycyp.entity.ImageGroupWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageGroupMapper {
    int countByExample(ImageGroupExample example);

    int deleteByExample(ImageGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImageGroupWithBLOBs record);

    int insertSelective(ImageGroupWithBLOBs record);

    List<ImageGroupWithBLOBs> selectByExampleWithBLOBs(ImageGroupExample example);

    List<ImageGroup> selectByExample(ImageGroupExample example);

    ImageGroupWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImageGroupWithBLOBs record, @Param("example") ImageGroupExample example);

    int updateByExampleWithBLOBs(@Param("record") ImageGroupWithBLOBs record, @Param("example") ImageGroupExample example);

    int updateByExample(@Param("record") ImageGroup record, @Param("example") ImageGroupExample example);

    int updateByPrimaryKeySelective(ImageGroupWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ImageGroupWithBLOBs record);

    int updateByPrimaryKey(ImageGroup record);
}