package com.demomodel.configure.Qps;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 带过期时间的缓存
 *
 * @author wulf
 * @since 2020/04/21
 */
public class ExpiredCache {

    // 缓存key=接口名，value=接口调用量、过期时间戳
    private Map<String, CacheNode> cache = new ConcurrentHashMap<>();// 重入锁
    private ReentrantLock lock = new ReentrantLock();

    // 失效队列
    private PriorityQueue<CacheNode> queue = new PriorityQueue<>();

    // 启动定时任务，每秒清理一次过期缓存
    private final static ScheduledExecutorService scheduleExe = new ScheduledThreadPoolExecutor(10);

    // 构造函数中启动定时任务，执行对已过期缓存的清理工作，每秒执行一次
    public ExpiredCache() {
        scheduleExe.scheduleAtFixedRate(new CleanExpireCacheTask(), 1L, 1L, TimeUnit.SECONDS);
    }

    /**
     * 内部类，清理过期缓存对象
     */
    private class CleanExpireCacheTask implements Runnable {

        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();
            // 取出队列中的队头元素，对已过期的元素执行清除计划，剩下没有过期则退出
            while (true) {
                lock.lock();
                try {
                	//检索但不删除此队列的头，如果此队列为空，则返回null。
                    CacheNode cacheNode = queue.peek();
                    // 已经把队列清空了，或者所有过期元素已清空了，退出
                    if (cacheNode == null || cacheNode.getExpireTime() > currentTime) {
                        return;
                    }

                    // 开始大清理了
                    cache.remove(cacheNode.getKey());
                    queue.poll();//检索并删除此队列的头，如果此队列为空，则返回null
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * 根据缓存key获取values
     *
     * @param cacheKey
     * @return
     */
    public CacheNode getCacheNode(String cacheKey) {
        return cache.get(cacheKey);
    }

    /**
     * 加入缓存，设置存活时间
     *
     * @param cacheKey
     * @param ttl      缓存的存活时间
     *                 return
     */
    public AtomicLong set(String cacheKey, long ttl) {

        // 若缓存中已存在缓存节点，不需要更新过期时间，仅更新QPS值
        CacheNode oldNode = cache.get(cacheKey);
        if (oldNode != null) {
            AtomicLong oldQps = oldNode.getCallQuantity();
            oldQps.incrementAndGet();
        } else {
            // 否则新创建CacheNode对象，失效时间=当前时间+缓存存活时间
            AtomicLong qps = new AtomicLong(1);
            CacheNode newNode = new CacheNode(cacheKey, qps, System.currentTimeMillis() + ttl * 1000);

            // 放入缓存，加入过期队列
            cache.put(cacheKey, newNode);
            queue.add(newNode);  //存入  失效队列
        }
        return cache.get(cacheKey).getCallQuantity();
    }

}