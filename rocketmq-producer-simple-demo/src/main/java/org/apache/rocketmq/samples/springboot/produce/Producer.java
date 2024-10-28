package org.apache.rocketmq.samples.springboot.produce;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Value("${rocketmq.producer.simple.demo.topic}")
    private String topic;

    public void run() {
        SendResult sendResult = rocketMQTemplate.syncSend(topic, "Hello, World!");
        log.info("sendResult:{}.", sendResult);
    }
}
