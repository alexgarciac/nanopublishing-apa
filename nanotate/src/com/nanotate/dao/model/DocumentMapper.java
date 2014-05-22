package com.nanotate.dao.model;

import com.nanotate.dao.model.Document;
import com.nanotate.dao.model.DocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    int countByExample(DocumentExample example);

    int deleteByExample(DocumentExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(Document record);

    int insertSelective(Document record);

    List<Document> selectByExample(DocumentExample example);

    Document selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}