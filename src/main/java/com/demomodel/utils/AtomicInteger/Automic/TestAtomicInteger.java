	package com.demomodel.utils.AtomicInteger.Automic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
    private static final int THREADS_COUNT = 2;

    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void doubleValue() {
        atomicInteger.getAndUpdate(operand -> {
            if(operand % 2 == 0) {
                operand = operand + 1;
            } else {
                operand = operand + 2;
            }
            return operand;
        });
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i = 0; i< threads.length; i++) {
            threads[i] = new Thread(() -> {
                for(int i1 = 0; i1 < 1000; i1++) {
                    doubleValue();
                }
                countDownLatch.countDown();
            });
            threads[i].start();
        }

        countDownLatch.await();

        System.out.println(atomicInteger.get());
    }
}