package com.demomodel.P7.Conditional.EnvCondition;


		 
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.annotation.Configuration;

		
/**
 * 让3个配置类分别在不同环境中生效，会在这些配置类上面使用上面自定义的@EnvConditional注解来做条件限定。
每个配置类中通过@Bean来定义一个名称为name的bean，一会通过输出这个bean来判断哪个配置类生效了。
		 * @author wgz
		 * @date 创建时间：2020年7月19日 下午7:34:13
		 */
		@Configuration
		@EnvConditional(EnvConditional.Env.PROD)//@1
		public class ProdBeanConfig {
@Bean
public String name() {return "我是生产环境!";}
		}


