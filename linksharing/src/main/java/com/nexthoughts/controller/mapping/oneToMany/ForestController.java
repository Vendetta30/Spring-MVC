package com.nexthoughts.controller.mapping.oneToMany;

import com.nexthoughts.command.mapping.oneToMany.ForestCommand;
import com.nexthoughts.command.mapping.onetoone.StockCommand;
import com.nexthoughts.domain.mapping.onetomany.Forest;
import com.nexthoughts.domain.mapping.onetoone.Stock;
import com.nexthoughts.services.mapping.oneToMany.ForestService;
import com.nexthoughts.services.mapping.onetoone.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/forest")
public class ForestController {
    private final Logger logger = LoggerFactory.getLogger(ForestController.class);
    private ForestService forestService;

    @Autowired
    ForestController(ForestService forestService) {
        this.forestService = forestService;
    }

    /*@ModelAttribute("allStock")
    public List<Stock> populateStock() {
        return this.stockService.findAll();
    }*/

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        logger.debug("==============================");
        ModelAndView model = new ModelAndView();
        model.setViewName("forest/create");
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView save(ForestCommand forestCommand) {
        logger.debug("****************************************");
        logger.debug("****************************************");
        logger.debug("This " + forestCommand.getForestName());
        logger.debug("****************************************");
        logger.debug("****************************************");
        int forestId = forestService.create(forestCommand);
        logger.debug("This " + forestId + " has been created");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("forestCommand", forestCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        logger.debug("==============================");
        List<ForestCommand> forests = forestService.list();
        ModelAndView model = new ModelAndView();
        model.setViewName("forest/list");
        model.addObject("forests", forests);
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView();
        Forest forest = forestService.read(id);
        modelAndView.setViewName("forest/edit");
        modelAndView.addObject("forest", forest);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView update(ForestCommand forestCommand) {
        forestService.update(forestCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("forestCommand", forestCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam int id) {
        forestService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }
}