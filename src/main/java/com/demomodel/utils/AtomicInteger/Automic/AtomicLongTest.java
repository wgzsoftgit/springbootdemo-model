package com.demomodel.utils.AtomicInteger.Automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**在高并发情况下，LongAdder(累加器)比AtomicLong原子操作效率更高，LongAdder累加器是java8新加入的，参考以下压测代码
 * @description 压测AtomicLong的原子操作性能
 **/
public class AtomicLongTest implements Runnable {
 
    private static AtomicLong atomicLong = new AtomicLong(0);
 
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            atomicLong.incrementAndGet();
        }
    }
 
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(30);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            es.submit(new AtomicLongTest());
        }
        es.shutdown();
        //保证任务全部执行完
        while (!es.isTerminated()) { }
        long end = System.currentTimeMillis();
        System.out.println("AtomicLong add 耗时=" + (end - start));
        System.out.println("AtomicLong add result=" + atomicLong.get());
    }
}
