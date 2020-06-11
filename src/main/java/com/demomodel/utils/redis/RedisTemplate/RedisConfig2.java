package com.demomodel.utils.redis.RedisTemplate;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

// 自定义配置  RedisTemplate<String, Object> 
@Configuration
public class RedisConfig2 {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);  
        //使用fastjson序列化
     //   FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);    // key采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer); // hash的key也采用String的序列化方式
        template.setValueSerializer(jackson2JsonRedisSerializer);  // value也采用String的序列化方式
        template.setHashValueSerializer(jackson2JsonRedisSerializer); // hash的value序列化方式采用jackson
        template.afterPropertiesSet();
        return template;
    }
    
//    @Bean
//    public RedisTemplate redisTemplate23(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
//        redisTemplate.setDefaultSerializer(fastJsonRedisSerializer);//设置默认的Serialize，包含 keySerializer & valueSerializer
//
//        //redisTemplate.setKeySerializer(fastJsonRedisSerializer);//单独设置keySerializer
//        //redisTemplate.setValueSerializer(fastJsonRedisSerializer);//单独设置valueSerializer
//        return redisTemplate;
//    }
    
    
    /**
     * Spring提供了默认的StringSerializer和JdkSerializer，第一个很简单，
     * 就是通过String.getBytes()来实现的。而且在Redis中，所有存储的值都是字符串类型的。所以这种方法保存后，
     * 通过Redis-cli控制台，是可以清楚的查看到我们保存了什么key,value是什么。但是对
     * 于JdkSerializationRedisSerializer来说，这个序列化方法就是Jdk提供的了。首先要求我们要被序列化的类继承
     * 自Serializeable接口，然后通过，然后通过Jdk对象序列化的方法保存
     * 
     * keySerializer:这个是对key的默认序列化器。默认值是StringSerializer。

valueSerializer:这个是对value的默认序列化器，默认值是取自DefaultSerializer的JdkSerializationRedisSerializer。

hashKeySerializer:对hash结构数据的hashkey序列化器，默认值是取自DefaultSerializer的JdkSerializationRedisSerializer。

hashValueSerializer：对hash结构数据的hashvalue序列化器，默认值是取自DefaultSerializer的JdkSerializationRedisSerializer。
     * 
     */
       
    
  
    @Bean
   // @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;  
    }
    /**
     * Redis事务没有回滚操
     * 在SpringDataRedis当中通过RedisTemplate的SessionCallback中来支持(否则事务不生效)。
     * discard的话不需要自己代码处理，callback返回null，成的话，返回非null，
     * 依据这个来判断事务是否成功(没有抛异常)。
     */
//    @Bean
//    public StringRedisTemplate redisTemplate() {
//      StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory());
//      // explicitly enable transaction support
//      template.setEnableTransactionSupport(true);
//      return template;
//    }
    /**
     * redisTemplate.setEnableTransactionSupport(true); 中启用 Redis 事务时得到一个惨痛的教训
     * ：Redis 会在运行几天后开始返回垃圾数据，导致数据严重损坏
     * 
     * 在进行 Redis 操作或 RedisCallback 后，Spring 并没有自动关闭 Redis 连接，而事实上它是应该关闭的。
 如果再次使用未关闭的连接，可能会从意想不到的 Redis 密钥返回垃圾数据。有意思的是，如果在 RedisTemplate 中把
 事务支持设为 false，这一问题就不会出现了。
我们发现，我们可以先在 Spring 语境里配置一个 PlatformTransactionManager
（例如 DataSourceTransactionManager），然后再用 @Transactional 注释来声明 Redis 事务的范围，
让 Spring 自动关闭 Redis 连接。
根据这一经验，我们相信，在 Spring 里配置两个单独的 RedisTemplate 是很好的做法：
其中一个 RedisTemplates 的事务设为 false，用于大多数 Redis 操作，另一个 RedisTemplates 的事务已激活，
仅用于 Redis 事务。当然必须要声明 PlatformTransactionManager 和 @Transactional，以防返回垃圾数值。
另外，我们还发现了 Redis 事务和关系数据库事务（在本例中，即 JDBC）相结合的不利之处。混合型事务的表现和预想的不太一样
     */
//    @Bean
//    public RedisTemplate redisTemplate2(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<StringRedisSerializer, Serializable> rt = new RedisTemplate<>();
//        rt.setConnectionFactory(redisConnectionFactory);
//        StringRedisSerializer stringSerializer = new StringRedisSerializer();
//        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
//        RedisHashKeySerializer redisHashKeySerializer = new RedisHashKeySerializer();
//        rt.setKeySerializer(stringSerializer);
//        rt.setValueSerializer(jdkSerializationRedisSerializer);
//        rt.setHashKeySerializer(redisHashKeySerializer);
//        rt.setHashValueSerializer(jdkSerializationRedisSerializer);
//        rt.afterPropertiesSet();
//    rt.setEnableTransactionSupport(true); //是否启用事务支持   info clients 查看redis连接  可以用@Transactional控制
//    return rt;
//    }
}
//https://blog.csdn.net/weixin_43365369/java/article/details/96869661