package org.apache.rocketmq.samples.springboot.consume;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class Consumer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 100; i++) {
            List<String> messages = rocketMQTemplate.receive(String.class);
            log.info("messages: {}", messages);
        }
    }
}
