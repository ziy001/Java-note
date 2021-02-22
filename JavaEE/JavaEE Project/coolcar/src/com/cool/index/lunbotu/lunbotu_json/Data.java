package com.cool.index.lunbotu.lunbotu_json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziy
 * @version 1.0
 * @date 2020/8/19
 * TODO:JavaBean中一个属性代表一个JSON属性名
 */
public class Data {
    private List<Message> messageList = new ArrayList<>();

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
