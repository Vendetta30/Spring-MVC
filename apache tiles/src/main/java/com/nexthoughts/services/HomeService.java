package com.nexthoughts.services;

import com.nexthoughts.command.TopicCommand;
import com.nexthoughts.domain.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {
    private final Logger logger = LoggerFactory.getLogger(HomeService.class);
    private SessionFactory sessionFactory;

    @Autowired
    public HomeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }


    public String getDesc() {

        logger.debug("getDesc() is executed!");

        return "Gradle + Spring MVC";

    }

    public String getTitle(String name) {

        logger.debug("getTitle() is executed! $name : {}", name);

        if (StringUtils.isEmpty(name)) {
            return "Hello World";
        } else {
            return "Hello " + name;
        }

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
}
