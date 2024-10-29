/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.samples.springboot;

import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.apache.rocketmq.client.core.RocketMQClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* https://github.com/apache/rocketmq-clients/issues/430
* francisoliverlee commented on Mar 30, 2023 目前proxy还不支持自动创建topic
* 手动创建topic
* root@lavm-zs4titdxl5:/home/rocket/rocketmq-all-5.3.0-bin-release# sh bin/mqadmin updatetopic -n localhost:9876 -t demo-test -c DefaultCluster
* create topic to 117.72.69.172:10911 success.
* TopicConfig [topicName=demo-test, readQueueNums=8, writeQueueNums=8, perm=RW-, topicFilterType=SINGLE_TAG, topicSysFlag=0, order=false, attributes={}]
* root@lavm-zs4titdxl5:/home/rocket/rocketmq-all-5.3.0-bin-release#
* */


@SpringBootApplication
public class V5ProducerApplication implements CommandLineRunner {
    @Autowired
    private RocketMQClientTemplate rocketMQClientTemplate;

    @Value("${rocketmq.producer.topic}")
    private String topic;


    public static void main(String[] args) {
        SpringApplication.run(V5ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        SendReceipt sendReceipt = rocketMQClientTemplate.syncSendNormalMessage(topic, "Hello V5");
        System.out.println(sendReceipt);
    }
}