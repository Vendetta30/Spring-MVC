package com.nexthoughts.controller;

import java.util.List;
import java.util.Map;

import com.nexthoughts.command.TopicCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import com.nexthoughts.services.HomeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by vijay on 24/12/16.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        logger.debug("index() is executed!");
        List<TopicCommand> topics = homeService.list();
        for (TopicCommand topicCommand : topics) {
            System.out.println(topicCommand.getId());
        }
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("topicList", topics);
        return model;
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {

        logger.debug("hello() is executed - $name {}", name);

        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        model.addObject("title", homeService.getTitle(name));
        model.addObject("msg", homeService.getDesc());

        return model;

    }
}
