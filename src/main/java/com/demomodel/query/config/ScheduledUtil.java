package com.demomodel.query.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.demomodel.query.config.controller.MyDynamicTask;
//scheduledTaskRegistrar  原始配置可以一直执行
//通过controller控制           修改配置文件只执行一次
@Component
//@Service
public class ScheduledUtil implements SchedulingConfigurer {

    private static Logger log = LoggerFactory.getLogger(MyDynamicTask.class);

    private  String cron="0/9 0 0 * * ?";

    private String name="测试2";

    public String getName() {
        return name;   
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(doTask(), getTrigger());
    }

    /**
     * 业务执行方法
     * @return
     */
    private Runnable doTask() {
        return new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // 业务逻辑
                log.info("com.demomodel.query.config.ScheduledUtil"+name+",时间为:" + simpleDateFormat.format(new Date()));
            }
        };
    }

    /**
     * 业务触发器
     * @return
     */
    private Trigger getTrigger() {
        return new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 触发器
                CronTrigger trigger = new CronTrigger(cron);
                return trigger.nextExecutionTime(triggerContext);
            }
        };
    }

	
}
//https://blog.csdn.net/xm526489770/java/article/details/82183817