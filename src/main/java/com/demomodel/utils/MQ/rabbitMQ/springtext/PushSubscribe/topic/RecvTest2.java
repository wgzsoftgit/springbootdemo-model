package com.demomodel.utils.MQ.rabbitMQ.springtext.PushSubscribe.topic;
import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.demomodel.utils.MQ.rabbitMQ.config.ConnectionUtil;
import com.rabbitmq.client.AMQP.BasicProperties;
public class RecvTest2 {
    private final static String QUEUE_NAME = "test_queue_topic_work2";
    private final static String EXCHANGE_NAME = "test_exchange_topic";
    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection =ConnectionUtil.getConnection("192.168.146.251",5672,"/","guest","guest");
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "key.#");
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
                    byte[] body) throws IOException {
                // body 即消息体
                String msg = new String(body);
                System.out.println(" [消费者1] received : " + msg + "!");
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 监听队列，手动ack
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}