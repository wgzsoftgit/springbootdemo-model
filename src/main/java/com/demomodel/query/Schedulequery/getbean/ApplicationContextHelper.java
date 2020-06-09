package com.demomodel.query.Schedulequery.getbean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHelper implements ApplicationContextAware {
 
    private static ApplicationContext applicationContext;
 
    public ApplicationContextHelper() {
    }
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      System.err.println("从数据库获取定时任务条件"+"com.demomodel.query.Schedulequery.getbean.ApplicationContextHelper");
    	ApplicationContextHelper.applicationContext = applicationContext;
    }
 //根据名需要类名的首字母转小写
    public static Object getBean(String beanName) {
        return applicationContext != null?applicationContext.getBean(beanName):null;
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
}
//https://blog.csdn.net/xcc_2269861428/java/article/details/99996185