package com.demomodel.utils.RedisLoack;


import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
 
/**
 * 每次使用时，要new一个新的lock使用
 */
 
public class RedisLock {
    // 锁名称
    private String lockName; 
 
    // 锁超时时间
    private long time;
 
    private static final String KEY_PREFIX = "BusinessName:lock:";
 
    private long randomValue;
   // @Resource(name = "dellockScript")
    private DefaultRedisScript redisScript; //DefaultRedisScript加载lua脚本
  //  @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;
 
    private boolean locked;
 
    private RedisLock(String lockName, long time, RedisTemplate redisTemplate, DefaultRedisScript redisScript) {
        this.lockName = KEY_PREFIX + lockName;
        this.time = time;
        this.redisTemplate = redisTemplate;
        this.redisScript = redisScript;
        this.randomValue = UUID.randomUUID().getLeastSignificantBits();
    }
 
    public static RedisLock NewRedisLock(String lockName, long time, RedisTemplate redisTemplate,
            DefaultRedisScript redisScript) {
        return new RedisLock(lockName, time, redisTemplate, redisScript);
    }
 
    public boolean tryLock() {
        boolean success = redisTemplate.opsForValue().setIfAbsent(lockName, randomValue);
        // setIfAbsent对应redis的setNX方法
        
        locked = success;
        if (success) {
            redisTemplate.expire(lockName, time, TimeUnit.SECONDS);
        }
        return success;
    }
 
    public void unLock() {
        if(locked){
            redisTemplate.execute(redisScript, Collections.singletonList(lockName), randomValue);
        }
 
    }
 
}
//https://blog.csdn.net/gongzi2311/java/article/details/64922765