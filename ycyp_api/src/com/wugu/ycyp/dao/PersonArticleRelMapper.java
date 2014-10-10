package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.PersonArticleRel;
import com.wugu.ycyp.entity.PersonArticleRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonArticleRelMapper {
    int countByExample(PersonArticleRelExample example);

    int deleteByExample(PersonArticleRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PersonArticleRel record);

    int insertSelective(PersonArticleRel record);

    List<PersonArticleRel> selectByExample(PersonArticleRelExample example);

    PersonArticleRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PersonArticleRel record, @Param("example") PersonArticleRelExample example);

    int updateByExample(@Param("record") PersonArticleRel record, @Param("example") PersonArticleRelExample example);

    int updateByPrimaryKeySelective(PersonArticleRel record);

    int updateByPrimaryKey(PersonArticleRel record);
}