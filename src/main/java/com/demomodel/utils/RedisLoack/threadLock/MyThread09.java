package com.demomodel.utils.RedisLoack.threadLock;
public class MyThread09 extends Thread {

    public String flag;
    public Object lock1 = null;
    public Object lock2 = null;

    public MyThread09(String flag, Object lock1, Object lock2) {
        this.flag = flag;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        if(flag.equals("a")) {
            synchronized (lock1) {
                System.out.println("=== print A");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("=== print A again");
                }
            }
        }
        if(flag.equals("b")) {
            synchronized (lock2) {
                System.out.println("=== print B");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("=== print B again");
                }
            }
        }
    }

    public static void main(String[] args) {
        // lock1,lock2作为锁，或者说临界区资源
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread threadA = new MyThread09("a", lock1, lock2);
        Thread threadB = new MyThread09("b", lock1, lock2);
        threadA.start();
        threadB.start();
    }
}

//运行结果：
//=== print A
//=== print B
//（程序无法停止）