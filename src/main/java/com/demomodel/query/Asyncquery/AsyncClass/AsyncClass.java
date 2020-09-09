package com.demomodel.query.Asyncquery.AsyncClass;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 将一个类声明为异步类，那么这个类对外暴露的方法全部成为异步方法。
 * 与异步方法的区别是这里的注解是加到类上，异步方法的注解是加到方法上。仅此而已
 * @DESC 
 * @author guchuang
 *
 */
@Async
@Service
public class AsyncClass {
    public AsyncClass() {
        MyLog.info("-------------------------init AsyncClass--------------------");
    }
    volatile int index = 0;
    public void foo() throws InterruptedException {
        MyLog.info("asyncclass foo, index:" + index);
       Thread.sleep(99990);
       System.err.println("任务1");
    }
    public void foo(int i) throws InterruptedException {
        this.index = i;
        MyLog.info("asyncclass foo, index:" + i);
        Thread.sleep(1000);
        System.err.println("任务2");
    }
    public void bar(int i) throws InterruptedException {
        this.index = i;
        MyLog.info("asyncclass bar, index:" + i);
        Thread.sleep(3000);
        System.err.println("任务3");
    }
}