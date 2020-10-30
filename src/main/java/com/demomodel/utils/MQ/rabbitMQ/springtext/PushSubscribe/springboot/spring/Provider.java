package com.demomodel.utils.MQ.rabbitMQ.springtext.PushSubscribe.springboot.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Provider {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	//exchange 交换器名称
	//@Value("${mq.config.exchange}")
	private String exchange;
	public void sendMsg(String msg){
		rabbitTemplate.convertAndSend(exchange, "user.log.debug", msg);
	}
}