package com.demomodel.query.TaskExecutor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledTest {
 
    //还是得在main方法里才有效啊，启动spring容器就有效，在Junit的@Test方法里没有效果。
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfig.class);
        MySchedulerService mySchedulerService = context.getBean(MySchedulerService.class);
        mySchedulerService.doSchedulerTask(1);
        mySchedulerService.doSchedulerTask(22);
    } 
}
//https://blog.csdn.net/sinat_37807255/java/article/details/89635793