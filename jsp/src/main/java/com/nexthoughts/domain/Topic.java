package com.nexthoughts.domain;

import com.nexthoughts.command.TopicCommand;

import javax.persistence.*;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String topicName;

    public Topic() {
    }

    public Topic(String topicName) {
        this.topicName = topicName;
    }

    public Topic(TopicCommand topicCommand) {
        this.topicName = topicCommand.getTopicName();
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

    public Topic updateTopic(TopicCommand topicCommand) {
        this.id = topicCommand.getId();
        this.topicName = topicCommand.getTopicName();
        return this;
    }
}