package org.nanotate.model;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nanotate.model.Ranges;
import org.nanotate.model.RangesExample;
import org.nanotate.model.RangesKey;

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