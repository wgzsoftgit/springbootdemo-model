package com.demomodel.fmiaosha.RateLimiter;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class RateLimiterController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  //，如果每秒超过了2个请求，就阻塞等待。
    private static final RateLimiter rateLimiter = RateLimiter.create(2);

     
    
    
    
    /**
     * tryAcquire尝试获取permit，默认超时时间是0，意思是拿不到就立即返回false
     */
    @RequestMapping("/sayHello")
    public String sayHello() {
    	//等待不友好
    	 System.out.println("等待时间" + rateLimiter.acquire());  //加入就可以阻塞  抢购场景限流
        if (rateLimiter.tryAcquire()) { //  一次拿1个
            System.out.println(sdf.format(new Date()));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("limit");
        }
        return "hello";
    }
    
    /** 
     * tryAcquire(long timeout, TimeUnit unit) 
     * 从RateLimiter 获取许可如果该许可可以在不超过timeout的时间内获取得到的话， 
     * 或者如果无法在timeout 过期之前获取得到许可的话，那么立即返回false（无需等待） 
     */  
    @RequestMapping("/buy")  
    public Object miao(int count, String code) {  
        //判断能否在1秒内得到令牌，如果不能则立即返回false，不会阻塞程序  
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {  
            System.out.println("短期无法获取令牌，真不幸，排队也瞎排");  
            return "失败";  
        }  
//        if (goodInfoService.update(code, count) > 0) {  
//            System.out.println("购买成功");  
//            return "成功";  
//        }  
        System.out.println("数据不足，失败");  
        return "失败";  
    }  

    /**
     * acquire拿不到就等待，拿到为止
     */
    @RequestMapping("/sayHi")
    public String sayHi() {
        rateLimiter.acquire(5); //  一次拿5个
        System.out.println(sdf.format(new Date()));
        return "hi";
    }
    

}