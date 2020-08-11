package com.jason.demo.rabbitmq.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类功能描述：<br> Broker:它提供一种传输服务,它的角色就是维护一条从生产者到消费者的路线，保证数据能按照指定的方式进行传输, Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列。
 * Queue:消息的载体,每个消息都会被投到一个或多个队列。 Binding:绑定，它的作用就是把exchange和queue按照路由规则绑定起来. Routing Key:路由关键字,exchange根据这个关键字进行消息投递。
 * vhost:虚拟主机,一个broker里可以有多个vhost，用作不同用户的权限分离。 Producer:消息生产者,就是投递消息的程序. Consumer:消息消费者,就是接受消息的程序.
 * Channel:消息通道,在客户端的每个连接里,可建立多个channel.
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
@Configuration
public class RabbitConfig {
    //队列名
    public static final String FANOUT_QUEUE_NAME = "test_fanout_queue";
    public static final String FANOUT_QUEUE_NAME1 = "test_fanout_queue1";
    public static final String TEST_FANOUT_EXCHANGE = "testFanoutExchange";

    public static final String DIRECT_QUEUE_NAME = "test_direct_queue";
    public static final String TEST_DIRECT_EXCHANGE = "testDirectExchange";
    public static final String DIRECT_ROUTINGKEY = "test";

    public static final String TOPIC_QUEUE_NAME = "test_topic_queue";
    public static final String TEST_TOPIC_EXCHANGE = "testTopicExchange";
    public static final String TOPIC_ROUTINGKEY = "test.*";

    //创建队列
    @Bean
    public Queue createFanoutQueue() {
        return new Queue(FANOUT_QUEUE_NAME);
    }

    //创建队列
    @Bean
    public Queue createFanoutQueue1() {
        return new Queue(FANOUT_QUEUE_NAME1);
    }

    //创建队列
    @Bean
    public Queue createDirectQueue() {
        return new Queue(DIRECT_QUEUE_NAME);
    }

    //创建队列
    @Bean
    public Queue createTopicQueue() {
        return new Queue(TOPIC_QUEUE_NAME);
    }

    //创建交换机
    @Bean
    public FanoutExchange defFanoutExchange() {
        return new FanoutExchange(TEST_FANOUT_EXCHANGE);
    }

    //队列与交换机进行绑定
    @Bean
    Binding bindingFanout() {
        return BindingBuilder.bind(createFanoutQueue()).
            to(defFanoutExchange());
    }

    //队列与交换机进行绑定
    @Bean
    Binding bindingFanout1() {
        return BindingBuilder.bind(createFanoutQueue1()).
            to(defFanoutExchange());
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(TEST_DIRECT_EXCHANGE);
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(createDirectQueue()).
            to(directExchange()).
            with(DIRECT_ROUTINGKEY);
    }

    @Bean
    TopicExchange defTopicExchange() {
        return new TopicExchange(TEST_TOPIC_EXCHANGE);
    }

    @Bean
    Binding bindingTopic() {
        return BindingBuilder.bind(createTopicQueue()).
            to(defTopicExchange()).
            with(TOPIC_ROUTINGKEY);
    }
}