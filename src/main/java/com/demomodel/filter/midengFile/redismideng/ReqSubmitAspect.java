package com.demomodel.filter.midengFile.redismideng;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demomodel.utils.RedisLoack.RedisLockUtil;
import com.demomodel.utils.RedisLoack.util.miaosha.RedisLock;
import com.demomodel.utils.createid.SnowflakeIdWorker;

import lombok.extern.slf4j.Slf4j;

/**
 * 接口幂等性的 -- 分布式锁实现  
 * 
 */
@Slf4j
@Aspect
@Component
@Order(5)
public class ReqSubmitAspect {

    @Autowired
    private RedisLockUtil redisLock;

    @Pointcut("@annotation(com.demomodel.filter.midengFile.redismideng.CacheLock)")
    public void idePointCut() {
    }

    @Around("idePointCut()") 
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 使用分布式锁 机制-实现
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        CacheLock ide = method.getAnnotation(CacheLock.class);
        int lockSeconds = ide.expire();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
       //  AssertUtils.notNull(request, "request can not null");

        // 获取请求的凭证，本项目中使用的JWT,可对应修改
        String token = request.getHeader("Token");
        String requestURI = request.getRequestURI();

        String key = getIdeKey(token, requestURI);
        String clientId = SnowflakeIdWorker.generateId()+"";
        
        // 获取锁
        // >4并发就会报错
        boolean lock = RedisLockUtil.tryLock(key, clientId, lockSeconds);
        log.info("tryLock key = [{}], clientId = [{}]", key, clientId);

        if (lock) {
            log.info("tryLock success, key = [{}], clientId = [{}]", key, clientId);
            // 获取锁成功
            Object result;
            try {
                // 执行进程
                result = joinPoint.proceed();
            } finally {
                // 解锁
                RedisLockUtil.unLock(key, clientId);
                log.info("releaseLock success, key = [{}], clientId = [{}]", key, clientId);
            }
            return result;
        } else {
            // 获取锁失败，认为是重复提交的请求
            log.info("tryLock fail, key = [{}]", key);
            throw  new RuntimeException("重复请求，请稍后再试!");
        }
    }

    private String getIdeKey(String token, String requestURI) {
        return token + requestURI;
    }
}