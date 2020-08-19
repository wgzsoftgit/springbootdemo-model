package com.demomodel.configure.Qps;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demomodel.utils.netip.IpUtil;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class CdrAsept {
    private final static SimpleDateFormat SF = new SimpleDateFormat("yyyyMMddHHmmss");

    // 话单格式：接口名称|话单记录时间|接口时延|调用方IP|本地IP|用户ID|用户名|源语言|目标语言|结果码|QPS
    private final static String CDR_FORMAT = "{}|{}|{}|{}|{}|{}|{}|{}|{}|{}|{}";

    // 过期缓存
    private ExpiredCache expiredCache = new ExpiredCache();   //&& 

   // @Around("execution(* com.wlf.translateprovider.controller.TranslateController.*(..))")
    
    @Around("execution(* getResult*(..))")
    public Object recordCdr(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        String startDate = SF.format(new Date(startTime));

        // 白名单校验
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        String localIp = IpUtil.getLocalRealIp();
        String remoteIp = IpUtil.getIpAddrByRequest(httpServletRequest);
      //  TranslateCdr cdr = new TranslateCdr();
      //  cdr.setRemoteIp(remoteIp);  //存入远程ip
      //  CdrThreadLocal.setTranslateCdr(cdr);

        // 获取接口名
        String requestPath = httpServletRequest.getRequestURI();
        String cacheKey = requestPath.substring(requestPath.lastIndexOf("/") + 1, requestPath.length());
//
//        在切面中只需set一下，如果这时缓存有数据，就累加统计数，没有就设置统计数为1，
//        再get出来的得到QPS。但这里为了兼顾吞吐量，让接口的调用不受QPS统计的影响，
//        并没有在切面或者过期缓存的set方法加锁，因此对两个并发时间很短的接口，统计数会相同。
        // 设置过期时间为1秒
        long qps = expiredCache.set(cacheKey, 1).get();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.err.println("com.demomodel.configure.Qps.CdrAsept"+qps);
      //  cdr = CdrThreadLocal.getTranslateCdr();
//        if (cdr != null) {
//            log.error(CDR_FORMAT, cacheKey, startDate, endTime - startTime, remoteIp, localIp, cdr.getUserId(),
//                    cdr.getUserName(), cdr.getFrom(), cdr.getTo(), cdr.getResultCode(), qps);
      
 //       }
      //  CdrThreadLocal.delThreadLocal();
        return result;
    }
}