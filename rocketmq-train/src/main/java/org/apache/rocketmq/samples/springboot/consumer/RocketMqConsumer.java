package org.apache.rocketmq.samples.springboot.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "queue_topic", consumerGroup = "my-group1")
public class RocketMqConsumer implements RocketMQListener<String> {
    public void onMessage(String message) {
        System.out.println("received message: " + message);
    }
}