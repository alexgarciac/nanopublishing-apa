package com.nanotate.dao.model;

import com.nanotate.dao.model.FacebookPost;
import com.nanotate.dao.model.FacebookPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FacebookPostMapper {
    int countByExample(FacebookPostExample example);

    int deleteByExample(FacebookPostExample example);

    int deleteByPrimaryKey(Integer idfacebook_post);

    int insert(FacebookPost record);

    int insertSelective(FacebookPost record);

    List<FacebookPost> selectByExample(FacebookPostExample example);

    FacebookPost selectByPrimaryKey(Integer idfacebook_post);

    int updateByExampleSelective(@Param("record") FacebookPost record, @Param("example") FacebookPostExample example);

    int updateByExample(@Param("record") FacebookPost record, @Param("example") FacebookPostExample example);

    int updateByPrimaryKeySelective(FacebookPost record);

    int updateByPrimaryKey(FacebookPost record);
}