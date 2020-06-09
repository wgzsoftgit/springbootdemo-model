package com.demomodel.interfaceDesign;
/**
 * 通过注解获取相关的类-------
 * 通过反射获取相关的实现类的Object
 * 
 */
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.demomodel.interfaceDesign.interfaces.PersonAnnotationService;
import com.demomodel.interfaceDesign.notes.personInfo;

@Service
public class initContent implements ApplicationListener<ContextRefreshedEvent> {
 
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.err.println("com.interfaceDesign.initContent$$$$$$####/ApplicationListener<ContextRefreshedEvent>spring初始化完毕");
		// 通过注解获取相关的类-------
		Map<String, Object> map = getContent.getMapbeanwithAnnotion(personInfo.class);
		for (Map.Entry<String, Object> entrymap : map.entrySet()) {
			try {
				System.err.println("com.demomodel.interfaceDesign.initContentkey"+entrymap.getValue());
				// 通过反射获取相关的实现类的Object            &&
				Object object = getContent.getTarget(entrymap.getValue());
				if (object != null) {
					     //显现类的加入的注解
					PersonAnnotationService annotationService = (PersonAnnotationService) object;
					// 不为空的情况下，获取实现类的注解对象
					// 并把注解对象的注解字段当做map的Key,实现类Object当做值
					personInfo info = annotationService.getClass().getAnnotation(personInfo.class);
					//Map<'人+内容',‘实现类’>的形式保存-------最终的目的-----------------------------
					getContent.getPersonbeanmap.put(info.personInfo(), object);//Map<'人+内容',‘实现类’>的形式保存-------
					for(Entry<String, Object> entry : getContent.getPersonbeanmap.entrySet()){

					    String mapKey = entry.getKey();

					    Object mapValue = entry.getValue();

					    System.err.println("com.demomodel.interfaceDesign.initContent"+mapKey+"键值对:"+mapValue);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
//：https://blog.csdn.net/zxysshgood/java/article/details/78399980