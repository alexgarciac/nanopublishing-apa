package com.nanotate.dao.model;

import com.nanotate.dao.model.TwitterPost;
import com.nanotate.dao.model.TwitterPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TwitterPostMapper {
    int countByExample(TwitterPostExample example);

    int deleteByExample(TwitterPostExample example);

    int deleteByPrimaryKey(Integer idtwitter_post);

    int insert(TwitterPost record);

    int insertSelective(TwitterPost record);

    List<TwitterPost> selectByExample(TwitterPostExample example);

    TwitterPost selectByPrimaryKey(Integer idtwitter_post);

    int updateByExampleSelective(@Param("record") TwitterPost record, @Param("example") TwitterPostExample example);

    int updateByExample(@Param("record") TwitterPost record, @Param("example") TwitterPostExample example);

    int updateByPrimaryKeySelective(TwitterPost record);

    int updateByPrimaryKey(TwitterPost record);
}