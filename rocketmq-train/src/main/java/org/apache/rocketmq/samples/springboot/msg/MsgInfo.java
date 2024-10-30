package org.apache.rocketmq.samples.springboot.msg;

import lombok.Data;
import org.apache.rocketmq.samples.springboot.util.ConstUtil;

import java.io.Serializable;

@Data
public class MsgInfo implements Serializable {
    int type = ConstUtil.MQ_MSG_TYPE_MSG;

    String[] userNameArr;
    String userName;
    String mobile;
    String email;
    String title;
    String content;
    String sender;

    String action;
    String actionType;
    String actionSubType;
}
