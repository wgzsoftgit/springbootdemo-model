package com.demomodel.utils.redis.jedisCluster;
import java.util.HashSet;
	import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	/**
	 * 每个configuration的代码,都对应xml一部分配置
	 * @author admin
	 */
	import redis.clients.jedis.HostAndPort;
	import redis.clients.jedis.JedisCluster;
	import redis.clients.jedis.JedisPoolConfig;
	import redis.clients.jedis.JedisShardInfo;
	import redis.clients.jedis.ShardedJedisPool;
//工具类中需要使用@Autowired注入需用到的实例，则改工具类需用@Component注解标明	
/**
 * redis集群的获取  配置 JedisCluster
 * 
 *#redis集群的配置  application.properties
spring.redis.cluster.nodes=127.0.0.1:6379,42.0.32.1:6379
spring.redis.cluster.maxTotal=200
spring.redis.cluster.maxIdle=8
spring.redis.cluster.minIdle=2 
 * @author wgz
 * @date 创建时间：2020年5月31日 下午4:59:37
 */
	@Configuration
	@ConfigurationProperties(prefix="spring.redis.cluster")
	public class RedisClusterConfig {
		private String nodes;
		private Integer maxTotal;  
		private Integer maxIdle;
		private Integer minIdle;
		public String getNodes() {
			return nodes;
		}
		public void setNodes(String nodes) {
			this.nodes = nodes;
		}
		public Integer getMaxTotal() {
			return maxTotal;
		}
		public void setMaxTotal(Integer maxTotal) {
			this.maxTotal = maxTotal;
		}
		public Integer getMaxIdle() {
			return maxIdle;
		}
		public void setMaxIdle(Integer maxIdle) {
			this.maxIdle = maxIdle;
		}
		public Integer getMinIdle() {
			return minIdle;
		}
		public void setMinIdle(Integer minIdle) {
			this.minIdle = minIdle;
		}
	//集群的配置
		
		//@Bean//初始化方法构造一个jedisCluster对象
		//@Qualifier("JedisCluster2")
		public JedisCluster init(){
			try{
				Set<HostAndPort> set=new HashSet<HostAndPort>();
				//"10.9.39.13:8000,10.9.39.13:8001"
				String[] node = nodes.split(",");
				for (String hostAndPort : node) {  
					//"10.9.39.13:8000",解析ip和port
					String host=hostAndPort.split(":")[0]; 
					int port=Integer.parseInt
							(hostAndPort.split(":")[1]);
					set.add(new HostAndPort(host,port));
				}
				//利用其它属性,编写config对象
				JedisPoolConfig config=new JedisPoolConfig();
				config.setMaxTotal(maxTotal);
				config.setMaxIdle(maxIdle);
				config.setMinIdle(minIdle);  
				System.err.println(config);
				JedisCluster jedisCluster = new JedisCluster(set,config);
				System.err.println(jedisCluster);
				return jedisCluster;
						
			}catch(Exception e){  
				//说明构造过程出现了一些问题,一般是因为没有提供
				//redis相关配置
				//return null;
			e.printStackTrace();
				return null;
			}
			
			}
	}
//blog.csdn.net/yang134679/java/article/details/92809058