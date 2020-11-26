package com.demomodel.aop.aspe;
import com.alibaba.fastjson.JSON;
import com.demomodel.aop.Target.Log;
import com.google.common.base.Stopwatch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description //请求参数aop
 **/
@Component
//@Order(10)//值越小优先级越高，优先级高的先执行
@Aspect
@Slf4j
public class RequestParameterAop {

    /**
     * @Description: 定义需要拦截的切面
     * @Pointcut("execution(* com.*.controller.*Controller.*(..))")
     * @Return: void
     **/
    @Pointcut("execution(* com.demomodel.aop.aspe.*Controller.*(..))")
    public void methodArgs() {}
    
    // 所有被注解@LogTime的方法
   	@Pointcut("@annotation(LogTime)")
      public void LogTimePoint() {}
      
      // 组合以上所有切入点
      @Pointcut("servicePoint()||daoPoint()||LogTimePoint()")
      public void allPoints() {}

    @Around("methodArgs()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;

        Stopwatch stopwatch = Stopwatch.createStarted();
       
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
           
            if( request.getParameter("sunn") !=null) {
            	 String parameter = request.getParameter("sunn");
            	 System.err.println(parameter);
            }
            
            BufferedReader reader = request.getReader();
    		// 读取json数据
    		StringBuffer buffer = new StringBuffer();
    		String s;
    		while ((s = reader.readLine()) != null) {
    			buffer.append(s);
    		}

    		String json = buffer.toString();
    		System.out.println("json:" + json);
            
            
            
            // ip地址
            String ipAddr = getRemoteHost(request); //127.0.0.1
            // 请求路径
            String requestUrl = request.getRequestURL().toString();//http://localhost:9093/aopRequest/aop

            // 获取请求参数进行打印
            Signature signature = joinPoint.getSignature();//String com.demomodel.aop.aspe.AoptextController.aop(HttpServletRequest,test1)
            MethodSignature methodSignature = (MethodSignature) signature;

            //类的路径
            String targetName = joinPoint.getTarget().getClass().getName();//com.demomodel.aop.aspe.AoptextController
            //处理请求参数
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String methodName = joinPoint.getSignature().getName();//aop 方法名
            String operationType = "";
            String operationName = "";
             for (Method method : methods) {
                 if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                     if (clazzs.length == arguments.length) {
                         operationType = method.getAnnotation(Log.class).operationType();
                         operationName = method.getAnnotation(Log.class).operationName();
                         break;
                    }
                }
            }
            // 类名
            // swagger中文注释名
           // String classCommentName = methodSignature.getMethod().getDeclaringClass().getAnnotation(Api.class).tags()[0];
            String[] sourceName = signature.getDeclaringTypeName().split("\\."); //[com, demomodel, aop, aspe, AoptextController]
          //  String className = sourceName[sourceName.length - 1] + "[" + classCommentName +"]";

            // 方法名
            // swagger中文注释名
//            String methodCommentName = methodSignature.getMethod().getAnnotation(ApiOperation.class).value();
            String methodName2 = signature.getName();  //+ "[" + methodCommentName + "]";//aop

            // 参数名数组
            String[] parameterNames = ((MethodSignature) signature).getParameterNames();//[request, user]
            // 构造参数组集合
            List<Object> argList = new ArrayList<>();
            for (Object arg : joinPoint.getArgs()) {
                // request/response无法使用toJSON
                if (arg instanceof HttpServletRequest) {
                    argList.add("request");
                } else if (arg instanceof HttpServletResponse) {
                    argList.add("response");
                } else {
                    argList.add(JSON.toJSON(arg));//{"name":"\"as\"","age":"12"}
                }
            }

            stopwatch.stop();
            long timeConsuming = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            result = joinPoint.proceed();
            
            
            log.error("请求源IP【{}】 -> 请求URL【{}】\n{} -> {} -> 请求耗时：[{}]毫秒 \n请求参数：{} -> {}\n请求结果：{}",
                    ipAddr, requestUrl,
                //    className, 
                //    methodName,
                   timeConsuming,
                    JSON.toJSON(parameterNames), JSON.toJSON(argList),
                    JSON.toJSON(result));
        
        
        } catch (Exception e) {
            log.error("参数获取失败: {}", e.getMessage());
        }

        return result;
    }

    /**
     * 获取目标主机的ip
     * @param request
     * @return
     */
    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.contains("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

}