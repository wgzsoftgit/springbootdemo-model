package com.demomodel.query;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


//@Component注解用于对那些比较中立的类进行注释；
//相对与在持久层、业务层和控制层分别采用 @Repository、@Service 和 @Controller 对分层中的类进行注释
@Component
//@EnableScheduling // 1.开启定时任务
//@EnableAsync // 2.开启多线程
public class MultithreadScheduleTask {

	@Value("${ip}")  //读取application.yml
	private String ip;
	
	@Value("${port}")
	private int port;
	
	@Value("${userName}")   //一般不要取/会拿到电脑系统用户名
	private String userName;
	
	@Value("${password}")
	private String password;
//
//	@Async
//	@Scheduled(fixedDelay = 10000) // 间隔1秒 -----》1000
//	public void first() throws InterruptedException {
//		System.out.println(
//				"第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
//		System.out.println();
//		Thread.sleep(1000 * 10);
//	}
//
//	@Async
//	@Scheduled(fixedDelay = 200000)
//	public void second() {
//		System.out.println(
//				"第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
//		System.err.println("配置"+ip+port+userName+password);
//		System.out.println();
//	}
	//成功异步执行定时任务
//	@Async
//	@Scheduled(fixedDelay = 200000)
//	public void second2() throws Exception {
//		taskComponent.test1();
//		taskComponent.test2();
//		taskComponent.test3();
//		System.out.println();
//	}
	
}
