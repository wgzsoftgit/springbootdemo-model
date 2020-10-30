package com.demomodel.query.threadGroup;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterDemo3 {
	 
    public static void main(String[] args) throws InterruptedException {
    	
    	//这个构造方法可以指定每秒向桶中放几个令牌  比方说上面的代码create(5)，那么每秒放置5个令牌
        RateLimiter rateLimiter = RateLimiter.create(5);//设置QPS为5  
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }
        System.out.println("----------");
        //可以随时调整速率，我们将qps调整为10
        rateLimiter.setRate(10);
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }
    }
}