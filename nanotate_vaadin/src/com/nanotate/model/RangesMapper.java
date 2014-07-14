package com.nanotate.model;

import com.nanotate.model.Ranges;
import com.nanotate.model.RangesExample;
import com.nanotate.model.RangesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RangesMapper {
    int countByExample(RangesExample example);

    int deleteByExample(RangesExample example);

    int deleteByPrimaryKey(RangesKey key);

    int insert(Ranges record);

    int insertSelective(Ranges record);

    List<Ranges> selectByExample(RangesExample example);

    Ranges selectByPrimaryKey(RangesKey key);

    int updateByExampleSelective(@Param("record") Ranges record, @Param("example") RangesExample example);

    int updateByExample(@Param("record") Ranges record, @Param("example") RangesExample example);

    int updateByPrimaryKeySelective(Ranges record);

    int updateByPrimaryKey(Ranges record);
}