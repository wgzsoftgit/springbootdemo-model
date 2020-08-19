package com.demomodel.utils.logs;

import org.apache.log4j.Logger;
/**
 * <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.12</version>
</dependency>
 * @author wgz
 * @date 创建时间：2020年7月20日 上午11:10:37
 */
public class Demo {
    private static Logger logger = Logger.getLogger(Demo.class);
    
    public static void main(String[] args) throws Exception {
        // debug级别的信息  
        logger.debug("This is debug message.");  
        // info级别的信息  
        logger.info("This is info message.");  
        // error级别的信息  
        logger.error("This is error message."); 
    }
}
//https://www.jianshu.com/p/eb4ac2571c94