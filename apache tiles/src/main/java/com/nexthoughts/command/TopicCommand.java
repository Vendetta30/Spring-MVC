package com.nexthoughts.command;

import com.nexthoughts.domain.Topic;

public class TopicCommand {
    private int id;
    private String topicName;

    public TopicCommand() {

    }

    public TopicCommand(int id, String topicName) {
        this.id = id;
        this.topicName = topicName;
    }

    public TopicCommand(Topic topic) {
        this.id = topic.getId();
        this.topicName = topic.getTopicName();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return this.topicName;
    }
}