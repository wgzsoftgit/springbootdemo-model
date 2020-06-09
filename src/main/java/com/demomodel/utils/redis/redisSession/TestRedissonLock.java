package com.demomodel.utils.redis.redisSession;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Service
public class TestRedissonLock{
    
    //@Autowired
    private RedissonClient redissonClient;

    public void cameraCallback() {
        
        RLock rlock = redissonClient.getLock("redisson:lock:personId" + 123);

//设置锁超时时间，防止异常造成死锁
        rlock.lock(20, TimeUnit.SECONDS);
        
        try{
            //执行业务逻辑
            Thread.sleep(10000);
            System.out.println(123);
            
        } catch(Exception e){
            
        }finally{
            rlock.unlock();
        }
        
    }
    

}
