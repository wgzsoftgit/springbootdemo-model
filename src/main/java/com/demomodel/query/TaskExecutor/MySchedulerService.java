package com.demomodel.query.TaskExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MySchedulerService{
 
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
    @Autowired
    private TaskScheduler scheduler;  //taskScheduler &&自己配置的com.demomodel.query.TaskExecutor.SchedulerConfig

    public void doSchedulerTask(Integer age) {
        scheduler.schedule(() -> System.out.println(age+"com.demomodel.query.TaskExecutor.MySchedulerService"+age+Thread.currentThread().getName() + ": " + format.format(new Date())),
                new CronTrigger("*/1 * * * * ?"));
    }
    
}
//https://blog.csdn.net/sinat_37807255/java/article/details/89635793