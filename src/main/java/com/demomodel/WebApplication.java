package com.demomodel;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.Filter;

import org.springframework.boot.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.demomodel.filter.midengFile.config.IdempotentFilter;
import com.demomodel.query.config.ScheduledUtil;
import com.demomodel.utils.httpHelp.file.HttpServletRequestReplacedFilter;


//,"com.demomodel.configure.doubledatasource.textdoubledatasource.master.map","com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.map"
@MapperScan({"com.demomodel.mysqlcontroller.mapper","com.demomodel.configure.doubledatasource.textdoubledatasource.master.map","com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.map","com.demomodel.query.config.ScheduledUtil","com.demomodel.query.Schedulequery.dao","com.demomodel.mybatisPlus.dao","com.demomodel.utils.mybatis.programme2.txt.com.zzg.springboot.mapper","com.demomodel.utils.Excel.map","com.demomodel.query.quartzdemo.dao"}) //扫描的mapper
@EnableScheduling  //声明定时任务
@SpringBootApplication
@ServletComponentScan    //让@WebFilter起作用
@EnableFeignClients   //启动fegin
@ComponentScan(basePackages = { "com" })
@EnableTransactionManagement //开启事务支持
@EnableWebMvc 
public class WebApplication {    

	public static void main(String[] args) {
		// 启动方式一：
		SpringApplication.run(WebApplication.class, args);
        // 启动方式二：
//      SpringApplication springApplication = new SpringApplication(WebApplication.class);
//      springApplication.setBannerMode(Banner.Mode.OFF);
//      springApplication.run(args);

//      // 启动方式三：
//      new SpringApplicationBuilder(WebApplication.class)
//              .bannerMode(Banner.Mode.OFF)
//              .build()
//              .run(args);
	}
	//配置拦截器    防止流丢失的拦截器
//	@Bean
//	public FilterRegistrationBean httpServletRequestReplacedRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		//&&  implements Filter
//		registration.setFilter(new HttpServletRequestReplacedFilter());//&& 防止流丢失的拦截器  HttpServletRequestReplacedFilter
//		registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//		registration.setName("httpServletRequestReplacedFilter");
//		registration.setOrder(1);
//		return registration;  
//	}
	
	

	/**   影响静态文件访问
	 * 初始化RequestMappingHandlerAdapter，并加载Http的Json转换器
	 * @return  RequestMappingHandlerAdapter 对象
	 */
//	@Bean(name="requestMappingHandlerAdapter") 
//	public HandlerAdapter initRequestMappingHandlerAdapter() {
//		//创建RequestMappingHandlerAdapter适配器
//		RequestMappingHandlerAdapter rmhd = new RequestMappingHandlerAdapter();
//		// HTTP JSON转换器
//		MappingJackson2HttpMessageConverter  jsonConverter 
//	        = new MappingJackson2HttpMessageConverter();
//		//MappingJackson2HttpMessageConverter接收JSON类型消息的转换
//		MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
//		List<MediaType> mediaTypes = new ArrayList<MediaType>();
//		mediaTypes.add(mediaType);
//		//加入转换器的支持类型
//		jsonConverter.setSupportedMediaTypes(mediaTypes);  
//		//往适配器加入json转换器
//		rmhd.getMessageConverters().add(jsonConverter);
//		return rmhd;
//	}

//https://blog.csdn.net/ykzhen2015/java/article/details/70669861
	
	
	
	//https://blog.csdn.net/qq_38801308/article/details/106015063?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase
	// 启动异步调用
	 @EnableAsync
	 @Configuration
	 class TaskPoolConfig {
	 // 核心线程数（setCorePoolSize）10：线程池创建时候初始化的线程数
	 // 最大线程数（setMaxPoolSize）20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
	 // 缓冲队列（setQueueCapacity）200：用来缓冲执行任务的队列
	 // 允许线程的空闲时间（setKeepAliveSeconds）60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
	 // 线程池名的前缀（setThreadNamePrefix）：设置好了之后可以方便我们定位处理任务所在的线程池
	 // 线程池对拒绝任务的处理策略（setRejectedExecutionHandler）：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute
	 // 方法的调用线程中运行被拒绝的任务（setWaitForTasksToCompleteOnShutdown）；如果执行程序已关闭，则会丢弃该任务
	 // setWaitForTasksToCompleteOnShutdown（true）该方法就是这里的关键，用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean，这样这些异步任务的销毁就会先于Redis线程池的销毁。
	 // 同时，这里还设置了setAwaitTerminationSeconds(60)，该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住。
//	 @Bean("taskExecutor")
//	 public Executor taskExecutor() {
//	 ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//	 executor.setCorePoolSize(10);  //同时执行的线程数为2，只有等待前一个线程结束才能执行一个新的线程
//	 executor.setMaxPoolSize(20);    //
//	 executor.setQueueCapacity(200);
//	 executor.setKeepAliveSeconds(60);
//	 executor.setThreadNamePrefix("taskExecutor-");
//	 executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//	 executor.setWaitForTasksToCompleteOnShutdown(true);
//	 executor.setAwaitTerminationSeconds(60);
//	 return executor;  
//	 }
	 }
}