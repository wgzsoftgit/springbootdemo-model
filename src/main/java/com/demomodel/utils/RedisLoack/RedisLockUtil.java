package com.demomodel.utils.RedisLoack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
 
import java.util.Collections;
 
/**
 * @Author: jelly
 * @Description: redis分布式锁
 * 测试ok
 * @Date: 2019/5/24 10:20 AM
 */
@Component
public class RedisLockUtil {
	@Autowired
	private JedisPool jedisPool;
	
    /**
     * 加锁
     * @param key 锁KEY
     * @param value 锁拥有者
     * @param expire 过期时间
     */
    public static boolean tryLock(String key, String value, int expire) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost");
            String result = jedis.set(key, value, "NX", "EX", expire);
            return "OK".equals(result);
        } catch (Exception e) {
            throw e;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
 
    /**
     * 解锁
     * @param key 锁KEY
     * @param value 锁拥有者
     * @return
     */
    public static boolean unLock(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = new Jedis("localhost");
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = jedis.eval(script, Collections.singletonList(key),
                    Collections.singletonList(value));
            if (Long.valueOf(1L).equals(result)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
//https://blog.csdn.net/Mr_BJL/java/article/details/91566030