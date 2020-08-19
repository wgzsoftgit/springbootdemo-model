package com.demomodel.P7.Conditional.EnvCondition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 * @1：这个用来指定当前使用的环境，此处假定当前使用的是开发环境，这个我们以后可以任意发挥，
 * 比如将这些放到配置文件中，此处方便演示效果。
 * @author wgz
 * @date 创建时间：2020年7月19日 下午7:39:51
 */
public class EnvCondition2 implements Condition {
@Override
public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata){
//当前需要使用的环境
EnvConditional.Env curEnv=EnvConditional.Env.PROD;//@1 PROD  DEV
//获取使用条件的类上的EnvCondition注解中对应的环境
EnvConditional.Env env=(EnvConditional.Env)metadata.getAllAnnotationAttributes(EnvConditional.class.getName()).get("value").get(0);
return env.equals(curEnv);
}

}
