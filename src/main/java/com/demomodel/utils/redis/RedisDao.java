package com.demomodel.utils.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.demomodel.utils.redis.JedisPool.util.RedisUtilsyn;

/**
 * Redis访问工具类
 * @author zhaoheng
 * @date   2018年8月10日
 */
@Component
public class RedisDao {
	protected static Logger LOG = LoggerFactory.getLogger(RedisDao.class);
    /**
     * 注入时指定K、V类型都为String
     */
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 比较两个对象是否是同一个对象
     */
    public boolean compare () {
        LOG.info("redisTemplate的hashcode：{}", redisTemplate.hashCode());
        LOG.info("stringRedisTemplate的hashcode：{}", stringRedisTemplate.hashCode());
        LOG.info("equal()的结果：{}", redisTemplate.equals(stringRedisTemplate));
        return redisTemplate == stringRedisTemplate;
    }   
}
//https://blog.csdn.net/zhaoheng314/java/article/details/81564166