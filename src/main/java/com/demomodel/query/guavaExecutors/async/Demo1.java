package com.demomodel.query.guavaExecutors.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import lombok.extern.slf4j.Slf4j;
/**异步执行任务完毕之后回调
 ListeningExecutorService的submit方法用来异步执行一个任务，
 返回ListenableFuture，ListenableFuture接口继承于juc中的Future接口，
 对Future做了扩展，使其带有监听的功能。调用submit.addListener可以在执行的任务上添加监听器，
 当任务执行完毕之后会回调这个监听器中的方法。

ListenableFuture的get方法会阻塞当前线程直到任务执行完毕。
 * @author wgz
 * @date 创建时间：2020年8月21日 下午4:59:12
 */
@Slf4j
public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService delegate = Executors.newFixedThreadPool(5);
        try {
            ListeningExecutorService executorService = MoreExecutors.listeningDecorator(delegate);
           
            
            //异步执行一个任务
            ListenableFuture<Integer> submit = executorService.submit(() -> {
                log.info("{}", System.currentTimeMillis());
                //休眠2秒，默认耗时
                TimeUnit.SECONDS.sleep(2);
                log.info("{}", System.currentTimeMillis());
                return 10;
            });
            
            //当任务执行完毕之后回调对应的方法
            submit.addListener(() -> {
                log.info("任务执行完毕了，我被回调了");
            }, MoreExecutors.directExecutor());
            //get方法会阻塞当前线程直到任务执行完毕
            log.info("{}", submit.get());
        } finally {
            delegate.shutdown();
        }
    }
}