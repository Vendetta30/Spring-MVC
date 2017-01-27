package com.nexthoughts.services.config;

import com.nexthoughts.command.TopicCommand;
import com.nexthoughts.services.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class BootStrapService implements InitializingBean {

    @Autowired
    TopicService topicService;
    private final Logger logger = LoggerFactory.getLogger(BootStrapService.class);

    @Override
    @Transactional
    @PostConstruct
    public void afterPropertiesSet() {
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");

        logger.info("Bootstrapping data...");

        for (int i = 0; i < 10; i++) {
            TopicCommand topicCommand = new TopicCommand();
            topicCommand.setTopicName("Topic" + i);
            topicService.create(topicCommand);

            logger.info("===================STUDENT CREATED with email" + topicCommand.getTopicName() + "===================");
        }

        System.out.println("...Bootstrapping completed");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
        logger.info("********************************************");
    }
}