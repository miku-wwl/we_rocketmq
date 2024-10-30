package org.apache.rocketmq.samples.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.samples.springboot.msg.MsgInfo;
import org.apache.rocketmq.samples.springboot.produce.RocketMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class TestRocketMqController {

    @Autowired
    private RocketMqProducer rocketMqProducer;

    @GetMapping("/send")
    public void sendMsg() {
//        rocketMqProducer.sendMessage("我来测试一下rocketmq");

        MsgInfo msgInfo = new MsgInfo();
        msgInfo.setTitle("好的啊");
        msgInfo.setContent("是的，这里");
        rocketMqProducer.sendMsgInfo(msgInfo);
    }
}