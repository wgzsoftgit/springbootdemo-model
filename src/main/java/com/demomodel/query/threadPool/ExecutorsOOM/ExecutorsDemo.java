package com.demomodel.query.threadPool.ExecutorsOOM;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
//正确创建线程池
//推荐使用guava提供的ThreadFactoryBuilder来创建线程池
public class ExecutorsDemo {
 
	
//	  ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
//		        new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
//	 
	  
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
        .setNameFormat("demo-pool-%d").build();
 
    private static ExecutorService pool = new ThreadPoolExecutor(5, 200,
        0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
 
    public static void main(String[] args) {
 
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            pool.execute(new SubThread());
        }
        pool.shutdown();
    }
}
//https://blog.csdn.net/yan88888888888888888/article/details/83927609