package com.demomodel.P7.Conditional.EnvCondition;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;
/**
 * @1：注意这个注解比较特别，这个注解上面使用到了@Conditional注解，
 * 这个地方使用到了一个自定义Conditione类：EnvCondition2
@2：枚举，表示环境，定义了3个环境
@3：这个参数用指定环境
上面这个注解一会我们会用在不同环境的配置类上面
 * @author wgz
 * @date 创建时间：2020年7月19日 下午7:17:35
 */
@Conditional(EnvCondition2.class)//@1  &&
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnvConditional{
	//环境(测试环境、开发环境、生产环境)
enum Env{//@2
	TEST,DEV,PROD
}

//环境
Env value() default Env.DEV;//@3
}