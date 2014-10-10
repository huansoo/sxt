package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.Specialty;
import com.wugu.ycyp.entity.SpecialtyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecialtyMapper {
    int countByExample(SpecialtyExample example);

    int deleteByExample(SpecialtyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Specialty record);

    int insertSelective(Specialty record);

    List<Specialty> selectByExampleWithBLOBs(SpecialtyExample example);

    List<Specialty> selectByExample(SpecialtyExample example);

    Specialty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Specialty record, @Param("example") SpecialtyExample example);

    int updateByExampleWithBLOBs(@Param("record") Specialty record, @Param("example") SpecialtyExample example);

    int updateByExample(@Param("record") Specialty record, @Param("example") SpecialtyExample example);

    int updateByPrimaryKeySelective(Specialty record);

    int updateByPrimaryKeyWithBLOBs(Specialty record);

    int updateByPrimaryKey(Specialty record);
}