package com.demomodel.query.TaskExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//配置文件    定义线程数
@Configuration
@ComponentScan
public class SchedulerConfig{
 
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);  //定义线程数量
        taskScheduler.initialize();
        return taskScheduler;
    }
}
//https://blog.csdn.net/sinat_37807255/java/article/details/89635793