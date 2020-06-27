package com.demomodel.query.quartzdemo.service.query;

import com.demomodel.query.quartzdemo.demo.QuartzTaskErrors;

public interface QuartzTaskErrorsService {
    Integer addTaskErrorRecord(QuartzTaskErrors quartzTaskErrors);

    QuartzTaskErrors detailTaskErrors(String recordId);
}
