package com.nanotate.dao.model;

import com.nanotate.dao.model.Annotation;
import com.nanotate.dao.model.AnnotationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.nanotate.dao.model.AnnotationWithBLOBs;

public interface AnnotationMapper {

	int countByExample(AnnotationExample example);

	int deleteByExample(AnnotationExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AnnotationWithBLOBs record);

	int insertSelective(AnnotationWithBLOBs record);

	List<AnnotationWithBLOBs> selectByExampleWithBLOBs(AnnotationExample example);

	List<Annotation> selectByExample(AnnotationExample example);

	AnnotationWithBLOBs selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") AnnotationWithBLOBs record,
			@Param("example") AnnotationExample example);

	int updateByExampleWithBLOBs(@Param("record") AnnotationWithBLOBs record,
			@Param("example") AnnotationExample example);

	int updateByExample(@Param("record") Annotation record,
			@Param("example") AnnotationExample example);

	int updateByPrimaryKeySelective(AnnotationWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(AnnotationWithBLOBs record);

	int updateByPrimaryKey(Annotation record);}