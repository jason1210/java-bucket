package com.jason.demo.rabbitmq.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class MsgProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send2FanoutTestQueue(String massage) {
        rabbitTemplate.convertAndSend(RabbitConfig.TEST_FANOUT_EXCHANGE,
            "", massage);
    }

    public void send2DirectTestQueue(String massage) {
        rabbitTemplate.convertAndSend(RabbitConfig.TEST_DIRECT_EXCHANGE,
            RabbitConfig.DIRECT_ROUTINGKEY, massage);
    }

    public void send2TopicTestAQueue(String massage) {
        rabbitTemplate.convertAndSend(RabbitConfig.TEST_TOPIC_EXCHANGE,
            "test.aaa", massage);
    }

    public void send2TopicTestBQueue(String massage) {
        rabbitTemplate.convertAndSend(RabbitConfig.TEST_TOPIC_EXCHANGE,
            "test.bbb", massage);
    }

}