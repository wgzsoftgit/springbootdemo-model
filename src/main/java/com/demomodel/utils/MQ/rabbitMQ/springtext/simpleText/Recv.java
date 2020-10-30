package com.demomodel.utils.MQ.rabbitMQ.springtext.simpleText;

import java.io.IOException;

import com.demomodel.utils.MQ.rabbitMQ.config.ConnectionUtil;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
//该消费者模拟性能较差的情况下
//​	经典面试题：如何避免消息堆积？

//​	1） 采用workqueue，多个消费者监听同一队列。
//​	2）接收到消息以后，通过线程池，异步消费。
public class Recv {
    private final static String QUEUE_NAME = "Work_queue";

    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection("192.168.146.251",5672,"/","guest","guest");
        // 获取通道
        final Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
     
        // 设置每个消费者同时只能处理一条消息
        channel.basicQos(1);
        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
        	
			// 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
                    byte[] body) throws IOException {
                // body 即消息体
                String msg = new String(body);
                System.out.println(" [消费者1] received : " + msg + "!");
                System.out.println(" [消费者2] received : " + msg + "!");
                try {
                    // 模拟完成任务的耗时：1000ms
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                // 手动ACK
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 监听队列。
        channel.basicConsume(QUEUE_NAME, false, consumer);
//        queue:队列的名称；
//        autoAck:设置是否自动确认。建议设成false，即不自动确认,默认不设置也是false；
//        consumerTag:消者标签，用来区分多个消费者，不设置默认“”；
//        noLocal:设置为true则表示不能将同一个Connection中生产者发送的消息传送给这个Connection中的消费者，默认是false；
//        exclusive:设置是否排他,默认是false；
//        arguments:设置消费者的其他参数,默认是null；
//        callback:设置消费者的回调函数。用来处理RabbitMQ推送过来的消息，比如DefaultConsumer，使用时需要客户端重写(override )其中的方法。
    }
}