package com.demomodel.query.quartzdemo.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demomodel.query.quartzdemo.demo.QuartzTaskErrors;

@Mapper
@Repository
public interface QuartzTaskErrorsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuartzTaskErrors record);

    int insertSelective(QuartzTaskErrors record);

    QuartzTaskErrors selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuartzTaskErrors record);

    int updateByPrimaryKeyWithBLOBs(QuartzTaskErrors record);

    int updateByPrimaryKey(QuartzTaskErrors record);

    QuartzTaskErrors detailTaskErrors(String recordId);
}
