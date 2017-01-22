package com.nexthoughts.controller;

import com.nexthoughts.command.TopicCommand;
import com.nexthoughts.domain.Topic;
import com.nexthoughts.services.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/topic")
public class TopicController {
    private final Logger logger = LoggerFactory.getLogger(TopicController.class);
    private final TopicService topicService;

    @Autowired
    TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute(new TopicCommand());
        return "topicCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView save(TopicCommand topicCommand) {
        logger.debug("****************************************");
        logger.debug("****************************************");
        logger.debug("This " + topicCommand.getTopicName());
        logger.debug("****************************************");
        logger.debug("****************************************");
        int topicId = topicService.create(topicCommand);
        logger.debug("This " + topicId + " has been created");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("topicCommand", topicCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        logger.debug("==============================");
        List<TopicCommand> topics = topicService.list();
        ModelAndView model = new ModelAndView();
        model.setViewName("topicList");
        model.addObject("topicList", topics);
        return model;
    }

    @RequestMapping(value = "/edit/{topicId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("topicId") int topicId) {
        ModelAndView modelAndView = new ModelAndView();
        Topic topic = topicService.read(topicId);
        modelAndView.setViewName("editTopic");
        modelAndView.addObject("topic", topic);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{topicId}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("topicId") int topicId, TopicCommand topicCommand) {
        topicService.update(topicCommand, topicId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/topic/list");
        modelAndView.addObject("topicCommand", topicCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{topicId}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("topicId") int topicId) {
        topicService.delete(topicId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/topic/list");
        return modelAndView;
    }
}