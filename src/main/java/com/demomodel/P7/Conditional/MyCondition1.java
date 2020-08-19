package com.demomodel.P7.Conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.demomodel.P7.Conditional.isbean.IService;
/**会在  解析   和  bean注册都生效
 * 在配置类上面使用@Conditional，这个注解的value指定的Condition当有一个为false的时候，
 * spring就会跳过处理这个配置类。
 * @author wgz
 * @date 创建时间：2020年7月19日 下午4:22:47
 */
public class MyCondition1  implements Condition {
//阻止配置类的处理    return false;
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		//return true;  //阻止配置类的处理 
		
		//获取spring容器
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//判断容器中是否存在Service类型的bean
boolean existsService = !beanFactory.getBeansOfType(IService.class).isEmpty();
return existsService;
		
	}

}
/**
 配置类的处理会依次经过2个阶段：配置类解析阶段和bean注册阶段，Condition接口类型的条件会对这两个阶段都有效，
 解析阶段的时候，容器中是还没有Service这个bean的，配置类中通过@Bean注解定义的bean在
 bean注册阶段才会被注册到spring容器，所以BeanConfig2在解析阶段去容器中是看不到Service这个bean的，
 所以就被拒绝了。
————————————————
版权声明：本文为CSDN博主「路人甲Java」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/likun557/article/details/105108901
*/