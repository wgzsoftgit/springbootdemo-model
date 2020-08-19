 package com.demomodel.P7.Conditional.ConditionDesc.asc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Condition5 implements Condition ,Ordered  { //@2

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		System.err.println(this.getClass().getName());
        return true;
	}

	@Override
	public int getOrder() { //@3
		// TODO Auto-generated method stub
		return 0;
	}

}
