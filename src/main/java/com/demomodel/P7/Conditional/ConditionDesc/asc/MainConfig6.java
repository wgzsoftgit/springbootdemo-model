package com.demomodel.P7.Conditional.ConditionDesc.asc;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
/**
 * 是因为spring解析整个配置类的过程中，有好几个地方都会执行条件判断。

咱们只用关注前3行，可以看出输出的属性和@Conditional中value值的顺序是一样的
 * @author wgz
 * @date 创建时间：2020年7月22日 上午9:31:45
 */
@Configuration
@Conditional({Condition4.class, Condition5.class, Condition6.class})//@5
public class MainConfig6 {
}