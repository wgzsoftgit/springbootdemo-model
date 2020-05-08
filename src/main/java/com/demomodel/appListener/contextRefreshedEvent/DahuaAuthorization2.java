/**
 * 
 */
package com.demomodel.appListener.contextRefreshedEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;


/**
 * 
 * 只初始化一次   这个方法可能会执行多次！！
 * @author zbj
 *具体来说， 每加载完一次context，就会执行一次ContextRefreshedEvent

 * 而且每次执行，都会再执行一次parent的ContextRefreshedEvent

 * 也就是说，如果web.xml里面配置了两个Context，

 * 且两个Context都配置了ContextRefreshedEvent Listener，那么ContextRefreshedEvent会执行3次！

 * 而且更郁闷的是，后一个Context执行的两次ContextRefreshedEvent是一样的。
//https://blog.csdn.net/zollty/java/article/details/86137380
 */

@Component()
public class DahuaAuthorization2 implements ApplicationListener<ContextRefreshedEvent> {
    
	@Value("${ip}")
	private String ip;
	
	@Value("${port}")
	private int port;
	
	@Value("${userName}")
	private String userName;
	
	@Value("${password}")
	private String password;

	
	//当容器中发布此事件以后，方法触发
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2收到事件："+event);
		System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2收到事件："+(event.getSource() instanceof XmlWebApplicationContext));
		System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2收到事件："+(event.getApplicationContext().getDisplayName())+ "判读是否是根上下文"+event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext"));
		System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2##$$$ContextRefreshedListener execute......"+ip+port);

		System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2##$"+event.toString());

		System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2##$"+event.getTimestamp());
		
		
//		try {
//			//tokenPro("saads");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//只在初始化“根上下文”的时候执行
		if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")) {
			System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2收到事件3："+event);
			try {
        	    System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2############### Dahua login ############");
        	    String token = "sasdsdadsdsa";
        	    tokenPro(token);
        	    System.out.println("############### Dahua keep alive ############");
      
			} catch (Exception e) {
				e.printStackTrace();
			}
       } 
	
	
	
		//https://blog.csdn.net/zhanlanmg/java/article/details/46889955	
		try {
	           
            if (event.getSource() instanceof XmlWebApplicationContext) {
                if (((XmlWebApplicationContext) event.getSource()).getDisplayName().equals("Root WebApplicationContext")) {
                    //……你的代码
                	System.out.println("com.demomodel.appListener.contextRefreshedEvent.DahuaAuthorization2收到事件2："+event);
                }
            }
        } catch (Exception e) {
            //log.error("((XmlWebApplicationContext) applicationEvent.getSource()).getDisplayName() 执行失败，请检查Spring版本是否支持");
        }
	
	} 
	
	private static void tokenPro(String token) throws IOException {
		Properties pro=new Properties();
		pro.setProperty("token","wgz234563232233");
		try {
			File file=new File("src/main/resources/token.properties");
			OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file));
			pro.store(writer,"setToken");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
