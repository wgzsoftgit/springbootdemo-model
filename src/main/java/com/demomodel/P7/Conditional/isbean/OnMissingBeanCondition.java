package com.demomodel.P7.Conditional.isbean;

		 
		import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
		import org.springframework.context.annotation.Condition;
		import org.springframework.context.annotation.ConditionContext;
		import org.springframework.context.annotation.ConfigurationCondition;
		import org.springframework.core.type.AnnotatedTypeMetadata;
		 
		import java.util.Map;
	
/**
 * Condition接口类型的条件会对这两个阶段都有效，解析阶段的时候
 * @author wgz
 * @date 创建时间：2020年7月19日 下午8:07:03
 */
		public class OnMissingBeanCondition implements Condition{
		@Override
		public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata){
		//获取bean工厂
		ConfigurableListableBeanFactory beanFactory=context.getBeanFactory();
		
		//判断容器中是否存在Service类型的bean
      //  boolean existsService = !beanFactory.getBeansOfType(IService.class).isEmpty();
		//从容器中获取IService类型bean
		Map<String,IService>serviceMap=beanFactory.getBeansOfType(IService.class);
		//判断serviceMap是否为空
		return serviceMap.isEmpty();
		}
	}	 
		

