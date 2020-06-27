package com.demomodel.query.quartzdemo.service.query.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomodel.query.quartzdemo.dao.QuartzTaskErrorsMapper;
import com.demomodel.query.quartzdemo.demo.QuartzTaskErrors;
import com.demomodel.query.quartzdemo.service.query.QuartzTaskErrorsService;

/**
 * @ClassName QuartzTaskErrorsServiceImpl
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/3
 * Version  1.0
 */
@Service
public class QuartzTaskErrorsServiceImpl implements QuartzTaskErrorsService {

    @Autowired
    private QuartzTaskErrorsMapper quartzTaskErrorsMapper;

    @Override
    public Integer addTaskErrorRecord(QuartzTaskErrors quartzTaskErrors) {
        return quartzTaskErrorsMapper.insert(quartzTaskErrors);
    }

    @Override
    public QuartzTaskErrors detailTaskErrors(String recordId) {
        return quartzTaskErrorsMapper.detailTaskErrors(recordId);
    }

}
