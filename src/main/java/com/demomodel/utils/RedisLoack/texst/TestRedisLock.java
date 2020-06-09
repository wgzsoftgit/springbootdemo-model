package com.demomodel.utils.RedisLoack.texst;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.utils.RedisLoack.RedisLock;
import com.demomodel.utils.RedisLoack.RedisLockUtil;
import com.demomodel.utils.RedisLoack.RedisLockUtils;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
 
@Controller
@RequestMapping("TestRedisLock")
public class TestRedisLock  {
 @Autowired
 RedisLockUtil redisLockUtil;
 @Autowired
 RedisLockUtils redisLockUtils;
	
	
    //@Resource(name = "redisTemplate")
	// @Autowired
    private RedisTemplate redisTemplate;
 
  // @Resource(name = "dellockScript")
   // @Autowired
    private DefaultRedisScript dellockScript;
    @RequestMapping("testRedis")
    @ResponseBody
 public  void main() throws InterruptedException {
	// TestRedisLock testRedisLock=new TestRedisLock();
	// testRedisLock.testRedisLock();
	 
	 boolean tryLock = redisLockUtil.tryLock("saa","123",1000);  //测试ok
	 System.out.println(tryLock);
	// boolean unLock = redisLockUtil.unLock("saa","123");
	// System.out.println(unLock);
	 System.out.println( redisLockUtils.setLock("saa2","123",1000));
	 System.out.println( redisLockUtils.get("saa2"));
	 List<String> key=Arrays.asList("saa", "saa2");
	 List<String> value=Arrays.asList("123", "123");
	// System.out.println( redisLockUtils.releaseLock("saa2","123"));
	 //System.out.println( redisLockUtils.releaseLockList(key,value));
	 
}
   
    public void testRedisLock() throws InterruptedException {
        RedisLock lock = RedisLock.NewRedisLock("test",1000,redisTemplate,dellockScript);
        try {
            boolean success = lock.tryLock();
            System.out.println(success);
        }finally {
            lock.unLock();
        }
    }
 
    @Test
    public void testMulRedisLock() throws InterruptedException {
        final RedisLock lock1 = RedisLock.NewRedisLock("test",1000,redisTemplate,dellockScript);
        final RedisLock lock2 = RedisLock.NewRedisLock("test",1000,redisTemplate,dellockScript);
        Runnable task1 = new Runnable() {
            @Override public void run() {
                try {
                    boolean success = lock1.tryLock();
                    System.out.println("task1" + success);
                    TimeUnit.SECONDS.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    lock1.unLock();
                }
            }
        };
 
        Runnable task2 = new Runnable() {
            @Override public void run() {
                try {
                    boolean success = lock2.tryLock();
                    System.out.println("task2"+success);
                    TimeUnit.SECONDS.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    lock2.unLock();
                }
            }
        };
 
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(task1);
        executorService.submit(task2);
        TimeUnit.SECONDS.sleep(15);
    }
}

//：https://blog.csdn.net/gongzi2311/java/article/details/64922765