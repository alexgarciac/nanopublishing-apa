package com.nanotate.dao.model;

import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(String username);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(String username);

	int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example);

	int updateByExample(@Param("record") User record,
			@Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);}