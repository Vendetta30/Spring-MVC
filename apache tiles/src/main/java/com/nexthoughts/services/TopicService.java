package com.nexthoughts.services;

import com.nexthoughts.command.TopicCommand;
import com.nexthoughts.domain.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TopicService {
    private final Logger logger = LoggerFactory.getLogger(TopicService.class);
    private SessionFactory sessionFactory;

    @Autowired
    public TopicService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public List<TopicCommand> list() {
        List<TopicCommand> list = new ArrayList<TopicCommand>();
        List<Topic> topics = getSession().createCriteria(Topic.class).list();
        TopicCommand topicCommand = null;
        for (Topic topic : topics) {
            topicCommand = new TopicCommand(topic);
            list.add(topicCommand);
        }
        getSession().close();
        return list;
    }

    public int create(TopicCommand topicCommand) {
        Topic topic = new Topic(topicCommand);
        getSession().save(topic);
        getSession().close();
        return topic.getId();
    }

    public Topic read(int id) {
        Session session = getSession();
        Topic topic = (Topic) session.get(Topic.class, id);
        session.close();
        return topic;
    }

    public void update(TopicCommand topicCommand, int topicId) {
        Session session = getSession();
        Topic topic = (Topic) session.get(Topic.class, topicId);
        topic = topic.updateTopic(topicCommand);
        session.update(topic);
        session.flush();
        session.close();
    }

    public void delete(int id) {
        Session session = getSession();
        Topic topic = (Topic) getSession().get(Topic.class, id);
        session.delete(topic);
        session.flush();
        session.close();
    }
}