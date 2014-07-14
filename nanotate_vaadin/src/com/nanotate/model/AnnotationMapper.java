package com.nanotate.model;

import com.nanotate.model.Annotation;
import com.nanotate.model.AnnotationExample;
import com.nanotate.model.AnnotationWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnotationMapper {
    int countByExample(AnnotationExample example);

    int deleteByExample(AnnotationExample example);

    int deleteByPrimaryKey(String annotation_id);

    int insert(AnnotationWithBLOBs record);

    int insertSelective(AnnotationWithBLOBs record);

    List<AnnotationWithBLOBs> selectByExampleWithBLOBs(AnnotationExample example);

    List<Annotation> selectByExample(AnnotationExample example);

    AnnotationWithBLOBs selectByPrimaryKey(String annotation_id);

    int updateByExampleSelective(@Param("record") AnnotationWithBLOBs record, @Param("example") AnnotationExample example);

    int updateByExampleWithBLOBs(@Param("record") AnnotationWithBLOBs record, @Param("example") AnnotationExample example);

    int updateByExample(@Param("record") Annotation record, @Param("example") AnnotationExample example);

    int updateByPrimaryKeySelective(AnnotationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AnnotationWithBLOBs record);

    int updateByPrimaryKey(Annotation record);
}