package com.demomodel.mybatis.ThreadPoolUtilMybatis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware{
 
	private static ApplicationContext applicationContext;
	//使用时必须类名的开头字母转小写
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
    /**
     * 转换首字母小写
     *
     * @param str
     * @return
     */
//    public static String lowerFirstCapse(String str) {
//        char[] chars = str.toCharArray();
//        chars[0] += 32;
//        return String.valueOf(chars);
//    }
 
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
 
 
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
 
	@Override
	public  void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.err.println("测试多线程操作"+"com.demomodel.mybatis.ThreadPoolUtilMybatis.util.ApplicationContextProvider");
		 this.applicationContext  = applicationContext;
	}
 
}
//https://blog.csdn.net/qq_36090711/java/article/details/79165577