package com.demomodel.utils.MQ.rabbitMQ.springtext.PushSubscribe.springboot.config;

import java.nio.charset.StandardCharsets;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

//消费者
//@Component
@Slf4j
public class MsgConsumer {
//
//    @RabbitListener(
//            bindings =
//            {
//                    @QueueBinding(value = @Queue(value = RabbitConfig.FANOUT_QUEUE_NAME, durable = "true"),
//                            exchange = @Exchange(value = RabbitConfig.TEST_FANOUT_EXCHANGE, type = "fanout"))
//            })
//    @RabbitHandler
//    public void processFanoutMsg(Message massage) {
//        String msg = new String(massage.getBody(), StandardCharsets.UTF_8);
//        log.info("received Fanout message : " + msg);
//    }
//
//    @RabbitListener(
//            bindings =
//            {
//                    @QueueBinding(value = @Queue(value = RabbitConfig.FANOUT_QUEUE_NAME1, durable = "true"),
//                            exchange = @Exchange(value = RabbitConfig.TEST_FANOUT_EXCHANGE, type = "fanout"))
//            })
//    @RabbitHandler
//    public void processFanout1Msg(Message massage) {
//        String msg = new String(massage.getBody(), StandardCharsets.UTF_8);
//        log.info("received Fanout1 message : " + msg);
//    }
//
//    @RabbitListener(
//            bindings =
//            {
//                    @QueueBinding(value = @Queue(value = RabbitConfig.DIRECT_QUEUE_NAME, durable = "true"),
//                            exchange = @Exchange(value = RabbitConfig.TEST_DIRECT_EXCHANGE),
//                            key = RabbitConfig.DIRECT_ROUTINGKEY)  //类型默认是direct
//            })
//    @RabbitHandler
//    public void processDirectMsg(Message massage) {
//        String msg = new String(massage.getBody(), StandardCharsets.UTF_8);
//        log.info("received Direct message : " + msg);
//    }
//
//    @RabbitListener(
//            bindings =
//            {
//                    @QueueBinding(value = @Queue(value = RabbitConfig.TOPIC_QUEUE_NAME, durable = "true"),
//                            exchange = @Exchange(value = RabbitConfig.TEST_TOPIC_EXCHANGE, type = "topic"),
//                            key = RabbitConfig.TOPIC_ROUTINGKEY)
//            })
//    @RabbitHandler
//    public void processTopicMsg(Message massage) {
//        String msg = new String(massage.getBody(), StandardCharsets.UTF_8);
//        log.info("received Topic message : " + msg);
//    }
//
}