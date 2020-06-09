package com.demomodel.fmiaosha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.utils.RedisLoack.util.miaosha.RedisLock;
@RestController
@RequestMapping("RedisLockTest-Controller")
public class RedisLockTestController {
	private static final String LOCK_KEY = "lock";
	//redis key：GOODS_COUNT_KEY存的商品名   value 商品数量  
	private static final String GOODS_COUNT_KEY = "goods_count";
	
	@Autowired
	RedisLock redisLock;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@GetMapping("buy")
	public String buy(){
		//竞争锁，获得锁签名
		String lockSign = redisLock.lock(LOCK_KEY);
		System.out.println(lockSign);
		Integer count;
		try {
			System.err.println(redisTemplate);
			count = (Integer) redisTemplate.opsForValue().get(GOODS_COUNT_KEY);
			if (count <= 0) {
				System.err.println("商品售完");
				return "商品售完";
			}
			count = redisTemplate.opsForValue().decrement(GOODS_COUNT_KEY).intValue();
			System.err.println("秒杀成功,库存:" + count);
		}finally {
			//根据锁签名来释放锁，防止误释放
			redisLock.unlock(LOCK_KEY, lockSign);
		}
		return count+"";
	}
	//https://blog.csdn.net/qq_32099833/java/article/details/103881721
}
