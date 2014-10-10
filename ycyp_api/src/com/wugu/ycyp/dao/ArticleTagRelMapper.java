package com.wugu.ycyp.dao;

import com.wugu.ycyp.entity.ArticleTagRel;
import com.wugu.ycyp.entity.ArticleTagRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleTagRelMapper {
    int countByExample(ArticleTagRelExample example);

    int deleteByExample(ArticleTagRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleTagRel record);

    int insertSelective(ArticleTagRel record);

    List<ArticleTagRel> selectByExample(ArticleTagRelExample example);

    ArticleTagRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleTagRel record, @Param("example") ArticleTagRelExample example);

    int updateByExample(@Param("record") ArticleTagRel record, @Param("example") ArticleTagRelExample example);

    int updateByPrimaryKeySelective(ArticleTagRel record);

    int updateByPrimaryKey(ArticleTagRel record);
}