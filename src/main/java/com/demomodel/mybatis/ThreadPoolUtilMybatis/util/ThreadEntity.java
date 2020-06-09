package com.demomodel.mybatis.ThreadPoolUtilMybatis.util;

import java.util.Map;

public class ThreadEntity{
	private String MethodName;
	
	private Class<?> clazz;
	
	private  Map<String, Object> condition;
	
	public String getMethodName() {
		return MethodName;
	}
	public void setMethodName(String methodName) {
		MethodName = methodName;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	public Map<String, Object> getCondition() {
		return condition;
	}
	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}
 
	
//	public T getConditionEntity() {
//		return conditionEntity;
//	}
//	public void setConditionEntity(T conditionEntity) {
//		this.conditionEntity = conditionEntity;
//	}
 
}
//https://blog.csdn.net/qq_36090711/java/article/details/79165577