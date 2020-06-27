package com.demomodel.appListener.contextRefreshedEvent;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.demomodel.interfaceDesign.interfaces.Impl.PersonCoding2Serviceimpl;
import com.demomodel.interfaceDesign.notes.personInfo;

/**
 * spring初始化完成后   获取注解
 * 反射拿到类的的公共方法 
 * 执行方法
 * @author zbj
 *
 */

//@Component()
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {
	private static Logger log = LoggerFactory.getLogger(ApplicationContextListener.class);
private ServletContext servletContext;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		System.err.println("com.demomodel.appListener.contextRefreshedEvent.ApplicationContextListener######spring初始化完毕::我的父容器为："+contextRefreshedEvent.getApplicationContext().getParent());
		
		// root application context
		if (null == contextRefreshedEvent.getApplicationContext().getParent()) {///root application context 没有parent，他就是老大.  
			//log.debug();
			System.err.println("com.demomodel.appListener.contextRefreshedEvent.ApplicationContextListener>>>>> spring初始化完毕 <<<<<");
			
			// spring初始化完毕后，通过反射调用所有使用BaseService注解的initMapper方法                             ------------------------------获取注解的方法的;类--------------------------
			Map<String, Object> baseServices = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(personInfo.class);
			for (Object service : baseServices.values()) {
				//log.debug(">>>>> {}.initMapper()", service.getClass().getName());
				System.err.println("com.demomodel.appListener.contextRefreshedEvent.ApplicationContextListener>>>>> {}拿到有personInfo该注解的类"+service.getClass().getName());
				try {
					//反射获取方法 class.getMethod 作用是获得对象所声明的公开方法
					//初始化完成后加载执行的方法   public-----------反射执行方法-----------   
					Method initMapper = service.getClass().getMethod("testPrint");
					initMapper.invoke(service);
				} catch (Exception e) {
					log.error("com.demomodel.appListener.contextRefreshedEvent.ApplicationContextListener初始化BaseService的initMapper方法异常", e);
					e.printStackTrace();
				}
			}
			// 系统入口初始化，业余草：www.xttblog.com    ------------------------------------------------获取指定类的类型的JavaBean-----------------
			Map<String, PersonCoding2Serviceimpl> baseInterfaceBeans = contextRefreshedEvent.getApplicationContext().getBeansOfType(PersonCoding2Serviceimpl.class);
			for (Object service : baseInterfaceBeans.values()) {
			//          	log.debug(">>>>> {}.init()", service.getClass().getName());
				System.err.println("com.demomodel.appListener.contextRefreshedEvent.ApplicationContextListener>>>>> {}.init()"+service.getClass().getName());
				try {
					Method init = service.getClass().getMethod("testPrint");
					init.invoke(service);
				} catch (Exception e) {
					log.error("com.demomodel.appListener.contextRefreshedEvent.ApplicationContextListener初始化BaseInterface的init方法异常", e);
					e.printStackTrace();
				}
			}
		}else {
//			String ctxPath = servletContext.getContextPath();
//
//			//读取全部资源
//			LinkedHashMap<String, SysResource> AllResourceMap = sysResourceService.getAllResourcesMap();
//			BeetlUtils.addBeetlSharedVars(Constant.CACHE_ALL_RESOURCE,AllResourceMap);
//
//			//初始化任务调度
//			maintainTaskDefinitionService.initTask();
//
//			logger.info("根路径:"+ctxPath);
//
//			logger.info("初始化系统资源:(key:" + Constant.CACHE_ALL_RESOURCE
//			+ ",value:Map<资源url, SysResource>)");
		}
	}
}