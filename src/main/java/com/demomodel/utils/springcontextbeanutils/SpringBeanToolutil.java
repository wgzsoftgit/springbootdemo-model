package com.demomodel.utils.springcontextbeanutils;



import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.lang.Assert;
/**
 * 工具类获取
 * @author wgz
 * @date 创建时间：2020年5月7日 下午8:27:23
 */
@Component
public class SpringBeanToolutil implements ApplicationContextAware {
    /**
     * 上下文对象实例
     */
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    /**
     * 获取applicationContext
     * @return
     */
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     * @param name
     * @return
     */
    public Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(String name,Class<T> clazz){
        Assert.hasText(name,"name为空");
        return getApplicationContext().getBean(name, clazz);
    }
    
//    if(message == null || message.equals("")){
//
//    	　　throw new IllegalArgumentException("输入信息错误!");
//
//    	}
//  
//    	用Assert工具类上面的代码可以简化为：
//
//    	Assert.hasText(message, "输入信息错误!");
}
//https://blog.csdn.net/LJY_SUPER/java/article/details/78813516