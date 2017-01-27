package com.nexthoughts.controller.mapping.onetoone;

import com.nexthoughts.command.mapping.onetoone.StockCommand;
import com.nexthoughts.command.mapping.onetoone.StockDetailCommand;
import com.nexthoughts.domain.mapping.onetoone.StockDetail;
import com.nexthoughts.services.mapping.onetoone.StockDetailService;
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
@RequestMapping(value = "/stockDetail")
public class StockDetailController {
    private final Logger logger = LoggerFactory.getLogger(StockDetailController.class);
    private StockDetailService stockDetailService;

    @Autowired
    StockDetailController(StockDetailService stockDetailService) {
        this.stockDetailService = stockDetailService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        logger.debug("==============================");
        ModelAndView model = new ModelAndView();
        List<StockCommand> stocks = stockDetailService.stockList();
        logger.debug("stockCommands " + stocks);
        logger.debug("***************************33333333333333333*************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        model.setViewName("stockDetail/create");
        model.addObject("stocks", stocks);
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView save(StockDetailCommand stockDetailCommand) {
        logger.debug("****************************************");
        logger.debug("stockDetailCommand " + stockDetailCommand);
        logger.debug("****************************************");
        logger.debug("This " + stockDetailCommand.getRemark());
        logger.debug("This " + stockDetailCommand.getListedDate());
        logger.debug("This " + stockDetailCommand.getCompName());
        logger.debug("This " + stockDetailCommand.getCompDesc());
        logger.debug("****************************************");
        logger.debug("****************************************");
        int stockDetailId = stockDetailService.create(stockDetailCommand);
        logger.debug("This " + stockDetailCommand.getStockId());
        logger.debug("****************************************");
        logger.debug("This " + stockDetailId + " has been created");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
//        modelAndView.addObject("stockDetailCommand", stockDetailCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        logger.debug("==============================");
        List<StockDetailCommand> stockDetails = stockDetailService.list();
        ModelAndView model = new ModelAndView();
        model.setViewName("stockDetail/list");
        model.addObject("stockDetails", stockDetails);
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView();
        StockDetail stockDetail = stockDetailService.read(id);
        modelAndView.setViewName("stockDetail/edit");
        modelAndView.addObject("stockDetail", stockDetail);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView update(StockDetailCommand stockDetailCommand) {
        stockDetailService.update(stockDetailCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("stockDetailCommand", stockDetailCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam int id) {
        stockDetailService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

}