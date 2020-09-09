package com.demomodel.utils.AtomicInteger.Automic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 
 * 通过多次测试，我们可以看到只有AtomicInteger能够真正保证最终结果永远是2000。关于volatile的文章
 * @author wgz
 * @date 创建时间：2020年8月25日 下午5:23:17
 */
public class TestAtomicInteger2 {
    private static final int THREADS_COUNT = 2;

    public static int count = 0;
    public static volatile int countVolatile = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void increase() {
        count++;//运算（比如自增）并不是原子性的
        countVolatile++;
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i = 0; i< threads.length; i++) {
            threads[i] = new Thread(() -> {
                for(int i1 = 0; i1 < 1000; i1++) {
                    increase();
                }
                countDownLatch.countDown();
            });
            threads[i].start();
        }

        countDownLatch.await();

        System.out.println(count);
        System.out.println(countVolatile);
        System.out.println(atomicInteger.get());
    }
}