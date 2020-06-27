package com.demomodel.teaffic.map;

import com.demomodel.teaffic.dao.InvolvedTerrorPoints;
import com.demomodel.teaffic.dao.InvolvedTerrorPointsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvolvedTerrorPointsMapper {
    long countByExample(InvolvedTerrorPointsExample example);

    int deleteByExample(InvolvedTerrorPointsExample example);

    int insert(InvolvedTerrorPoints record);

    int insertSelective(InvolvedTerrorPoints record);

    List<InvolvedTerrorPoints> selectByExample(InvolvedTerrorPointsExample example);

    int updateByExampleSelective(@Param("record") InvolvedTerrorPoints record, @Param("example") InvolvedTerrorPointsExample example);

    int updateByExample(@Param("record") InvolvedTerrorPoints record, @Param("example") InvolvedTerrorPointsExample example);
}