package com.jason.demo.rabbitmq.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * 类功能描述：<br>
 * <ul>
 * <li>类功能描述1<br>
 * <li>类功能描述2<br>
 * <li>类功能描述3<br>
 * </ul>
 * 修改记录：<br>
 * <ul>
 * <li>修改记录描述1<br>
 * <li>修改记录描述2<br>
 * <li>修改记录描述3<br>
 * </ul>
 *
 * @author xuefl
 * @version 5.0 since 2020-01-02
 */
@Component
@Slf4j
public class MsgConsumer {

    @RabbitListener(
        bindings =
            {
                @QueueBinding(value = @Queue(value = RabbitConfig.FANOUT_QUEUE_NAME, durable = "true"),
                    exchange = @Exchange(value = RabbitConfig.TEST_FANOUT_EXCHANGE, type = "fanout"))
            })
    @RabbitHandler
    public void processFanoutMsg(Message massage) {
        String msg = new String(massage.getBody(), StandardCharsets.UTF_8);
        log.info("received Fanout message : " + msg);
    }

    @RabbitListener(
        bindings =
            {
                @QueueBinding(value = @Queue(value = RabbitConfig.FANOUT_QUEUE_NAME1, durable = "true"),
                    exchange = @Exchange(value = RabbitConfig.TEST_FANOUT_EXCHANGE, type = "fanout"))
            })
    @RabbitHandler
    public void processFanout1Msg(Message massage) {
        String msg = new String(massage.getBody(), StandardCharsets.UTF_8);
        log.info("received Fanout1 message : " + msg);
    }

    @RabbitListener(
        bindings =
            {
                @QueueBinding(value = @Queue(value = RabbitConfig.DIRECT_QUEUE_NAME, durable = "true"),
                    exchange = @Exchange(value = RabbitConfig.TEST_DIRECT_EXCHANGE),
                    key = RabbitConfig.DIRECT_ROUTINGKEY)
            })
    @RabbitHandler
    public void processDirectMsg(Message massage) {
        String msg = new String(massage.getBody(), StandardCharsets.UTF_8);
        log.info("received Direct message : " + msg);
    }

    @RabbitListener(
        bindings =
            {
                @QueueBinding(value = @Queue(value = RabbitConfig.TOPIC_QUEUE_NAME, durable = "true"),
                    exchange = @Exchange(value = RabbitConfig.TEST_TOPIC_EXCHANGE, type = "topic"),
                    key = RabbitConfig.TOPIC_ROUTINGKEY)
            })
    @RabbitHandler
    public void processTopicMsg(Message massage) {
        String msg = new String(massage.getBody(), StandardCharsets.UTF_8);
        log.info("received Topic message : " + msg);
    }

}