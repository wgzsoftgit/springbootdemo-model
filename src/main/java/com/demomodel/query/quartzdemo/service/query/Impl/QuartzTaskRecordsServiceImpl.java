package com.demomodel.query.quartzdemo.service.query.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomodel.query.quartzdemo.dao.QuartzTaskRecordsMapper;
import com.demomodel.query.quartzdemo.demo.QuartzTaskRecords;
import com.demomodel.query.quartzdemo.service.query.QuartzTaskRecordsService;

import java.util.List;

/**
 * @ClassName QuartzTaskRecordsServiceImpl
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/3
 * Version  1.0
 */
@Service
public class QuartzTaskRecordsServiceImpl implements QuartzTaskRecordsService {

    @Autowired
    private QuartzTaskRecordsMapper quartzTaskRecordsMapper;

    @Override
    public long addTaskRecords(QuartzTaskRecords quartzTaskRecords) {
        return quartzTaskRecordsMapper.insert(quartzTaskRecords);
    }

    @Override
    public Integer updateTaskRecords(QuartzTaskRecords quartzTaskRecords) {
        return quartzTaskRecordsMapper.updateByPrimaryKeySelective(quartzTaskRecords);
    }

    public List<QuartzTaskRecords> listTaskRecordsByTaskNo(String taskNo) {
        return quartzTaskRecordsMapper.getTaskRecordsByTaskNo(taskNo);
    }

    ;

}
