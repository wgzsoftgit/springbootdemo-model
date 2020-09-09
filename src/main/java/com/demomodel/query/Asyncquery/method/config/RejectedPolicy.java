package com.demomodel.query.Asyncquery.method.config;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import com.demomodel.query.Asyncquery.AsyncClass.MyLog;


/**
 * 线程池满之后的处理策略类
 * @DESC 
 * @author guchuang
 *
 */
public class RejectedPolicy implements RejectedExecutionHandler {
    public RejectedPolicy() { }

    /**
     * 向线程池中添加线程被拒绝时会调用这个方法。一般拒绝是因为线程池满了
     *
     * @param r 被拒绝的任务
     * @param e 拒绝这个任务的线程池
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        MyLog.info("one thread is rejected, i will deal it一个线程被拒绝，我会处理它");
        if (!e.isShutdown()) {
            r.run();
        }
    }
}