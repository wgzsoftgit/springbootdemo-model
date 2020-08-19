 package com.demomodel.P7.Conditional.ConditionDesc.asc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Condition6 implements Condition ,PriorityOrdered  {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		System.err.println(this.getClass().getName());
        return true;
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1000;
	}

}
