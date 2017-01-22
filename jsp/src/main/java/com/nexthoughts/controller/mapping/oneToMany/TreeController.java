package com.nexthoughts.controller.mapping.oneToMany;

import com.nexthoughts.command.mapping.oneToMany.ForestCommand;
import com.nexthoughts.command.mapping.oneToMany.TreeCommand;
import com.nexthoughts.domain.mapping.onetomany.Tree;
import com.nexthoughts.services.mapping.oneToMany.TreeService;
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
@RequestMapping(value = "/tree")
public class TreeController {
    private final Logger logger = LoggerFactory.getLogger(TreeController.class);
    private TreeService treeService;

    @Autowired
    TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        logger.debug("==============================");
        ModelAndView model = new ModelAndView();
        List<ForestCommand> forests = treeService.forestList();
        logger.debug("forestCommand " + forests);
        logger.debug("***************************33333333333333333*************************************");
        logger.debug("****************************************************************");
        model.setViewName("tree/create");
        model.addObject("forests", forests);
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView save(TreeCommand treeCommand) {
        logger.debug("****************************************");
        logger.debug("treeCommand " + treeCommand);
        logger.debug("****************************************");
        logger.debug("This " + treeCommand.getTreeIdentity());
        logger.debug("****************************************");
        logger.debug("****************************************");
        int treeId = treeService.create(treeCommand);
        logger.debug("This " + treeCommand.getTreeIdentity());
        logger.debug("****************************************");
        logger.debug("This " + treeId + " has been created");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
//        modelAndView.addObject("treeCommand", treeCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("==============================");
        List<TreeCommand> trees = treeService.list();
        ModelAndView model = new ModelAndView();
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("trees ${trees} " + trees);
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("==============================");
        logger.debug("==============================");
        model.setViewName("tree/list");
        model.addObject("trees", trees);
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView();
        Tree tree = treeService.read(id);
        modelAndView.setViewName("tree/edit");
        modelAndView.addObject("tree", tree);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView update(TreeCommand treeCommand) {
        treeService.update(treeCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("treeCommand", treeCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam int id) {
        treeService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }
}