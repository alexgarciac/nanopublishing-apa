package com.nanotate.dao.model;

import com.nanotate.dao.model.Annotation;
import com.nanotate.dao.model.AnnotationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnotationMapper {

	int countByExample(AnnotationExample example);

	int deleteByExample(AnnotationExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Annotation record);

	int insertSelective(Annotation record);

	List<Annotation> selectByExample(AnnotationExample example);

	Annotation selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Annotation record,
			@Param("example") AnnotationExample example);

	int updateByExample(@Param("record") Annotation record,
			@Param("example") AnnotationExample example);

	int updateByPrimaryKeySelective(Annotation record);

	int updateByPrimaryKey(Annotation record);

	

	
}