 package com.demomodel.P7.Conditional.ConditionDesc.asc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
@Order(1)  //@1
public class Condition4 implements Condition  {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		System.err.println(this.getClass().getName());
        return true;
	}

}
