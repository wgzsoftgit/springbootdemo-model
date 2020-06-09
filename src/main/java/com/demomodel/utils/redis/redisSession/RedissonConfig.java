package com.demomodel.utils.redis.redisSession;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson配置
 * 目前使用的是腾讯云的单节点redis，所以暂时配置单服务
 * spring:
  redis:
    host: 127.0.0.1 
    port: 6379
    password: 
 * 
 *
 */
//@Configuration
public class RedissonConfig {

   // @Value("${spring.redis.host}")
    private String host;
    
  //  @Value("${spring.redis.port}")
    private String port;
    
   // @Value("${spring.redis.password}")
    private String password;
    
    
   // @Bean
    public RedissonClient getRedisson(){
        
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password);
        //添加主从配置
//        config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});
        RedissonClient create = Redisson.create(config);
        System.err.println("com.demomodel.utils.redis.redisSession.RedissonConfig"+create);
        return create;
    }
    
}