package com.demomodel.query.threadPool;
import java.util.concurrent.*;

/**
 * 线程池测试类
 */
public class ThreadPoolTest {

    /**
     * 多线程的任务类
     */
    static class Task implements Runnable{
    
        //线程id
        private int id;

        //线程id，构造入参
        public Task(int id){
            this.id = id;
        }

        //run()方法，打印线程执行方法
        @Override
        public void run() {
            System.out.println("当前正在执行任务的线程：" + Thread.currentThread().getName() + "，线程编号为：" + id);
        }
        
    }


    /**
     * 用线程池执行多线程任务
     */
    public static void main(String[] args) {
    
        //新建一个ThreadPoolExecutor线程池对象
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        //循环并发多个线程
        for (int i = 0; i < 10000; i++) {
            //ThreadPoolExecutor的execute方法
            executor.execute(new ThreadPoolTest.Task(i));
        }

        //多线程任务执行完毕，关闭线程池
        executor.shutdown();
        
    }

}
//https://blog.csdn.net/weixin_39448458/java/article/details/83627530