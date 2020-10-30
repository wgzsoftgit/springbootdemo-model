package com.demomodel.utils.MQ.rabbitMQ.springtext.PushSubscribe.topic;

	import java.util.List;

import com.demomodel.utils.MQ.rabbitMQ.config.ConnectionUtil;
import com.rabbitmq.client.Channel;
	import com.rabbitmq.client.Connection;
	import com.rabbitmq.client.MessageProperties;

	public class Send {

	    private final static String EXCHANGE_NAME = "test_exchange_topic";

	    public static void main(String[] argv) throws Exception {
	        // 获取到连接
	        Connection connection = ConnectionUtil.getConnection("192.168.146.251",5672,"/","guest","guest");
	        // 获取通道
	        Channel channel = connection.createChannel();
	        
	        // 声明exchange，指定类型为fanout
	        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
	        
	        // routingKeyList = 
	        //		 List<String> list = new List<String>(){ "usa.news", "usa.weather", "europe.news", "europe.weather" };
	        
	        String routstr="key.1.2";//路由规则
	        // 消息内容
	        String message = "Hello everyone";
	        // 发布消息到Exchange
	        channel.basicPublish(EXCHANGE_NAME, routstr, null, message.getBytes());
	        
	        System.out.println(" [生产者] Sent '" + message + "'");

	        channel.close();
	        connection.close();
	    }
	
}
