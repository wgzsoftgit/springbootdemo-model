package com.demomodel.teaffic.map;

import com.demomodel.teaffic.dao.TraffickingNarcotics;
import com.demomodel.teaffic.dao.TraffickingNarcoticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TraffickingNarcoticsMapper {
    long countByExample(TraffickingNarcoticsExample example);

    int deleteByExample(TraffickingNarcoticsExample example);

    int insert(TraffickingNarcotics record);

    int insertSelective(TraffickingNarcotics record);

    List<TraffickingNarcotics> selectByExample(TraffickingNarcoticsExample example);

    int updateByExampleSelective(@Param("record") TraffickingNarcotics record, @Param("example") TraffickingNarcoticsExample example);

    int updateByExample(@Param("record") TraffickingNarcotics record, @Param("example") TraffickingNarcoticsExample example);
}