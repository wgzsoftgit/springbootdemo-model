package com.demomodel.query.quartzdemo.service.query;


import java.util.List;

import com.demomodel.query.quartzdemo.demo.QuartzTaskRecords;

public interface QuartzTaskRecordsService {
/**
 * 添加记录  定时任务执行情况记录表
 * @param quartzTaskRecords
 * @return
 */
    long addTaskRecords(QuartzTaskRecords quartzTaskRecords);

    Integer updateTaskRecords(QuartzTaskRecords quartzTaskRecords);

    List<QuartzTaskRecords> listTaskRecordsByTaskNo(String taskNo);

}
