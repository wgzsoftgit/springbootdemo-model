package com.demomodel.utils.MQ.rabbitMQ.springtext.ACKtext1;

import java.io.IOException;

import com.demomodel.utils.MQ.rabbitMQ.config.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class send {

    private static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws Exception {

        // 1，获取连接
        Connection connection =  ConnectionUtil.getConnection("192.168.146.251",5672,"/","guest","guest");
        // 2，创建通道
        Channel channel = connection.createChannel();
        // 3，声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 4，定义消息
        String msg = "Hello world";
        // 5，发送消息
        channel.basicPublish(null,QUEUE_NAME,null,msg.getBytes());
        System.out.println(" [x] Sent '" + msg + "'");

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}