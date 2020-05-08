package com.demomodel.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;


/**
 * 该注解是在单实例bean是使用，当使用@Scope注解的singleton属性时，bean的实例会在IOC容器创建的时候被加载，
 * 但是如果在创建bean的时候加上@lazy注解，则bean的实例会在第一次使用的时候被创建。
 * @author wgz
 * @date 创建时间：2020年5月7日 下午8:51:39
 */
//1、取消懒加载，这个在实体中通过注解@Proxy(lazy=false)来实现。
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)//singleton
public class Pet {
	int id;
  String name;
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
  
}
