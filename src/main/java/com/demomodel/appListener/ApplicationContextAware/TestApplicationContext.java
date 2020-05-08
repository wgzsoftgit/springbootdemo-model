package com.demomodel.appListener.ApplicationContextAware;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.demomodel.interfaceDesign.notes.personInfo;

@Component()
class TestApplicationContext implements ApplicationContextAware {
	 /**
     * 上下文对象实例
     */
    protected ApplicationContext applicationContext;
	
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
 //
    @PostConstruct
    public void init() throws Exception {
        //  获取personInfo注解的类    getBeansWithAnnotation-----------------获取注解的类--------------
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(personInfo.class);
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
        	System.err.println("org.springframework.context.TestApplicationContext#############################ApplicationContextAware的上下文###########"+entry);
//        	ApplicationContextAware的上下文personCoding2Serviceimpl=com.interfaceDesign.interfaces.Impl.PersonCoding2Serviceimpl@4248b963
//        	ApplicationContextAware的上下文personCodingServiceimpl=com.interfaceDesign.interfaces.Impl.PersonCodingServiceimpl@7f08caf
            // 根据注解的属性值判断
//            if (!TestSuper.class.isAssignableFrom(entry.getValue().getClass())) {
//                throw new RuntimeException(entry.getKey() + " - 未继承 TestTestSuper");
//            }
        }  
    }
	
    
    
    
}
//https://blog.csdn.net/baidu_36327010/java/article/details/84773726