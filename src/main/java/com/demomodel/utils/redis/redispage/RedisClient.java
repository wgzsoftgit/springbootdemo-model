package com.demomodel.utils.redis.redispage;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
/**
 * Redis 客户端集群版
 *
 */
public class RedisClient{
	
	private static  JedisPool jedisPool;
	
	static {
		   JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	        jedisPoolConfig.setMaxIdle(10);
	        jedisPoolConfig.setMaxWaitMillis(1000);
	        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
	        jedisPoolConfig.setBlockWhenExhausted(false);
	        // 是否启用pool的jmx管理功能, 默认true  
	        jedisPoolConfig.setJmxEnabled(true); 
	      //  JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);//有密码的连接
	         jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 10000); //无密码连接
		
		
			}
 
	public static  String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}
 
	public static  String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get(key);
		jedis.close();
		return result;
	}
 
	/**
	 * 数据 Hash
	 * @param key
	 * @param item
	 * @param value
	 * @return
	 */
	public static Long hset(String key, String item, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(key, item, value);
		jedis.close();
		return result;
	}
 
	public static  String hget(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hget(key, item);
		jedis.close();
		return result;
	}
	
	/**
	 * Redis Hmget 命令用于返回哈希表中，一个或多个给定字段的值。
		如果指定的字段不存在于哈希表，那么返回一个 nil 值。
	 * @param key
	 * @param item
	 * @return 一个包含多个给定字段关联值的表，表值的排列顺序和指定字段的请求顺序一样。
	 */
	public static  List<String> hmget(String key, String... item) {
		Jedis jedis = jedisPool.getResource();
		List<String> result = jedis.hmget(key, item);
		jedis.close();
		return result;
	}
 
	public static  Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}
 
	public static  Long decr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.decr(key);
		jedis.close();
		return result;
	}
 
	public static Long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}
 
	public static Long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}
 
	public static Long hdel(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(key, item);
		jedis.close();
		return result;
	}
 
	public static Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}
	
	public static Long rpush(String key, String... strings) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.rpush(key, strings);
		jedis.close();
		return result;
	}
 
	/**
	 * Redis Lrange 返回列表中指定区间内的元素，区间以偏移量 START 和 END 指定。 其中 0 表示列表的第一个元素， 1 表示列表的第二个元素，以此类推。 
	 * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 * @param string
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> lrange(String key, int start, int end) {
		Jedis jedis = jedisPool.getResource();
		List<String> result = jedis.lrange(key, start, end);
		jedis.close();
		return result;
	}
 
	/**
	 * 从列表中从头部开始移除count个匹配的值。如果count为零，所有匹配的元素都被删除。如果count是负数，内容从尾部开始删除。
	 * @param string
	 * @param string2
	 * @param i
	 */
	public static Long lrem(String key, Long count, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.lrem(key, count, value);
		jedis.close();
		return result;
	}
 
	/**
	 * Redis Zadd 命令用于将一个或多个成员元素及其分数值加入到有序集当中。
		如果某个成员已经是有序集的成员，那么更新这个成员的分数值，并通过重新插入这个成员元素，来保证该成员在正确的位置上。
		分数值可以是整数值或双精度浮点数。
		如果有序集合 key 不存在，则创建一个空的有序集并执行 ZADD 操作。
		当 key 存在但不是有序集类型时，返回一个错误。
	 * @param string
	 * @param i
	 * @param string2
	 * @return 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
	 */
	public static Long zadd(String key, double score, String member) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.zadd(key, score, member);
		jedis.close();
		return result;
	}
	
	/**
	 * Redis Zrevrangebyscore 返回有序集中指定分数区间内的所有的成员。有序集成员按分数值递减(从大到小)的次序排列。
		具有相同分数值的成员按字典序的逆序(reverse lexicographical order )排列。
		除了成员按分数值递减的次序排列这一点外， ZREVRANGEBYSCORE 命令的其他方面和 ZRANGEBYSCORE 命令一样。
	 * @param key
	 * @param max
	 * @param min
	 * @param offset
	 * @param count
	 * @return 指定区间内，带有分数值(可选)的有序集成员的列表。
	 */
	public static Set<String> zrevrangebyscore(String key, String max, String min, int offset, int count){
		Jedis jedis = jedisPool.getResource();
		Set<String> zrevrangeByScore = jedis.zrevrangeByScore(key, max, min, offset, count);
		
		
		jedis.close();
		return zrevrangeByScore;
	}
 
}