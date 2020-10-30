package com.demomodel.query.threadPool;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.demomodel.bean.User;

/**
 * 多线程执行返回list的操作
 * @author wgz
 * @date 创建时间：2020年10月28日 上午10:46:06
 */
public class returnListExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		
		Future<List<User>> submit = newFixedThreadPool.submit(()->heServicelongshow("212121"));
	
		List<User> list = submit.get();
	}
	public static List<User> heServicelongshow(String userCode) {
		return null;
		
	}
}
