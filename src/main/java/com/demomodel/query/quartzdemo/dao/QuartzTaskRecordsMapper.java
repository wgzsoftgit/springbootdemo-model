package com.demomodel.query.quartzdemo.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demomodel.query.quartzdemo.demo.QuartzTaskRecords;

import java.util.List;

@Mapper
@Repository
public interface QuartzTaskRecordsMapper {
    int deleteByPrimaryKey(Long id); 
/**
 *   insert into quartz_task_records (taskNo, timeKeyValue,
      executeTime, taskStatus, failcount, 
      failReason, createTime, lastModifyTime
      )
    values (#{taskno,jdbcType=VARCHAR}, #{timekeyvalue,jdbcType=VARCHAR},
      #{executetime,jdbcType=BIGINT}, #{taskstatus,jdbcType=VARCHAR}, #{failcount,jdbcType=INTEGER}, 
      #{failreason,jdbcType=VARCHAR}, #{createtime,jdbcType=BIGINT}, #{lastmodifytime,jdbcType=BIGINT}
      )
 * @param record
 * @return
 */
    long insert(QuartzTaskRecords record);

    int insertSelective(QuartzTaskRecords record);

    QuartzTaskRecords selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuartzTaskRecords record);

    int updateByPrimaryKey(QuartzTaskRecords record);
/**
 *  select
        <include refid="Base_Column_List"/>
        from quartz_task_records where taskNo = #{taskNo} order by createTime desc;
 * @param taskNo
 * @return
 */
    List<QuartzTaskRecords> getTaskRecordsByTaskNo(String taskNo);
}
