package com.demomodel.fmiaosha;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

//@Component
public class RedisLockXuhang {
	//@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	//存key 和签名 
	private ConcurrentMap<String, String> keyMap = new ConcurrentHashMap<>(16);
	//存key 和续命线程
	private ConcurrentMap<String, ContinueThread> threadMap = new ConcurrentHashMap<>(16);

	//加锁成功的同时，会得到一个锁签名，根据keySign来释放锁
	public String lock(String key){
		ValueOperations<String, Object> forValue = redisTemplate.opsForValue();
		System.out.println(forValue);
		String keySign = UUID.randomUUID().toString();
//		//锁超时10s 10s后未释放锁，其他线程可以竞争
		while (!forValue.setIfAbsent(key, keySign, 10, TimeUnit.SECONDS)) {
			//竞争锁失败，暂时让出CPU资源
			Thread.yield();
		}	
		//竞争锁成功
		keyMap.put(key, keySign);

		//守护线程续命
		ContinueThread continueThread = new ContinueThread(key, keySign);
		continueThread.setDaemon(true);
		threadMap.put(key, continueThread);
		continueThread.start();
		return keySign;
	}

	//释放锁
	public void unlock(String key, String keySign) {
		String s = keyMap.get(key);
		if (!keySign.equals(s)) {
			//不是我加的锁，不能释放
			return;
		}
		//是我加的锁，可以释放
		redisTemplate.delete(key);
		//续命线程停止
		ContinueThread thread = threadMap.get(key);
		if (thread != null) {
			thread.stopThread();
		}
	}

	//续命线程内部类
	private class ContinueThread extends Thread {
		private boolean stop = false;
		private String key;
		private String keySign;

		public ContinueThread(String key,String keySign) {
			super("Thread-"+UUID.randomUUID().toString());
			this.key = key;
			this.keySign = keySign;
		}

		public void stopThread(){
			this.stop = true;
		}

		@Override
		public void run() {
			while (!stop) {
				System.err.println(!isInterrupted());
				try {
					//3s续一次命
					Thread.sleep(10000/3);
				} catch (InterruptedException e) {}
				System.err.println("续命...");
				redisTemplate.opsForValue().set(key, keySign, 10, TimeUnit.SECONDS);
			}
		}
	}
}
//https://blog.csdn.net/qq_32099833/java/article/details/103881721
//https://blog.csdn.net/qq_32099833/article/details/103881721?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase