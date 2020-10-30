package com.demomodel.utils.MQ.rabbitMQ.springtext.ACKtext1;

import com.demomodel.utils.MQ.rabbitMQ.config.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.sun.star.io.IOException;

import io.netty.handler.timeout.TimeoutException;
/**
 * 消息确认机制（ACK
 * https://www.cnblogs.com/fenjyang/p/11323738.html
 * @author wgz
 * @date 创建时间：2020年9月18日 下午7:11:53
 */
public class Rec {

    private static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws Exception {

        // 1，获取连接
        Connection connection = ConnectionUtil.getConnection("192.168.146.251",5672,"/","guest","guest");
        // 2，创建通道
        Channel channel = connection.createChannel();
        // 3，声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 4，声明消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {// 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) {
                // body 即消息体
                String msg = new String(body);
                System.out.println(" [x] received : " + msg + "!");
            }
        };
        // 5，监听队列   第二个参数就是是否使用ACK机制，true代表使用，false代表不使用
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
 //但是需要注意的是，手动ACK存在一定的问题。如果消息接收方已经接收但是在业务处理过程中出现异常，那么该消息并未处理完成。
 //但此时消息队列中消息已经被自动删除，因而就会造成消息丢失，这是个非常严重的问题。

//​解决方法：将autoAck改为false，并且添加如下代码

 // 手动进行ACK
//channel.basicAck(envelope.getDeliveryTag(), false);
//​	当ACK机制改为手动时，只有当消息真正消费结束时，通知消息队列并删除消息。
}