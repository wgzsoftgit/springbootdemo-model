package com.demomodel.filter.midengFile.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.demomodel.utils.redis.JedisPool.conf.RedisUtil;

import redis.clients.jedis.JedisCluster;

public class SimpleLock {

	@Autowired
	RedisUtil redisUtil;
	private String key;
	public SimpleLock(String string, RedisUtil jedisCluster) {
		this.key=string;
		this.redisUtil=jedisCluster;
	}

	public void wrap(Runnable runnable) {
	  
	}

}
