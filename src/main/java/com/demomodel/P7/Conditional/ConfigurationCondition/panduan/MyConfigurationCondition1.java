package com.demomodel.P7.Conditional.ConfigurationCondition.panduan;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.demomodel.P7.Conditional.ConfigurationCondition.Service;
/**
 * 让条件判断在bean注册阶段才起效。
 * @author wgz
 * @date 创建时间：2020年7月22日 下午4:07:08
 */
public class MyConfigurationCondition1 implements ConfigurationCondition{
		@Override
		public ConfigurationPhase getConfigurationPhase(){
			//PARSE_CONFIGURATION  解析配置       REGISTER_BEAN  注册bean
			return ConfigurationPhase.REGISTER_BEAN;//@1    @1：指定条件在bean注册阶段，这个条件才有效
		}
	//	ConfigurationClassPostProcessor configurationClassPostProcessor; //处理Condition
		@Override
		public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata){
		//获取spring容器
		ConfigurableListableBeanFactory beanFactory=context.getBeanFactory();
		//判断容器中是否存在Service类型的bean
		boolean existsService=!beanFactory.getBeansOfType(Service.class).isEmpty();
		return existsService;
		}
		}

