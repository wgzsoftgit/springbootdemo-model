package com.demomodel.utils.redis.redispage;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 *从redis倒序取   值  
 * @author wgz
 * @date 创建时间：2020年9月14日 上午11:07:51
 */
public class redisPage{
	
	public static void main(String[] args) {
		redisPage.sortedSetPagenation();
	}
		public static void sortedSetPagenation(){
			for  ( int  i =  1 ; i <=  10 ; i+=1) {  
				// 初始化CommentId索引 SortSet
				RedisClient.zadd("topicId", i, "commentId"+i);
				// 初始化Comment数据 Hash
				RedisClient.hset("Comment_Key","commentId"+i, "comment content ......."+i);
			}  
			// 倒序取 从0条开始取 5条 Id 数据
			Set<String> sets =  RedisClient.zrevrangebyscore("topicId", "80", "1", 2, 5);
			String[] items = new String[]{};
			System.out.println(sets.toString());
       // 根据id取comment数据
			List<String> list = RedisClient.hmget("Comment_Key", sets.toArray(items));
			for(String str : list){
				System.out.println(str);
			}
		}
}

