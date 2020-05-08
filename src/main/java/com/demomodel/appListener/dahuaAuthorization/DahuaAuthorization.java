/**
 * 
 */
package com.demomodel.appListener.dahuaAuthorization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 每次请求都会执行
 * @author zbj
 *
 */

//@Component("DahuaAuthorization")
public class DahuaAuthorization implements ApplicationListener<ApplicationEvent> {


	//当容器中发布此事件以后，调用方法就会触发
		@Override
		public void onApplicationEvent(ApplicationEvent event) {
			System.out.println("com.demomodel.appListener.dahuaAuthorization.DahuaAuthorization$$#####ApplicationEvent收到事件："+event);
			System.out.println("com.demomodel.appListener.dahuaAuthorization.DahuaAuthorization#####$$ApplicationEvent收到事件："+(event.getSource() instanceof XmlWebApplicationContext));
		}
	
	
	
	

}
