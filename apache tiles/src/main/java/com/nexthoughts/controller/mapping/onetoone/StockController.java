package com.nexthoughts.controller.mapping.onetoone;

import com.nexthoughts.command.mapping.onetoone.StockCommand;
import com.nexthoughts.domain.mapping.onetoone.Stock;
import com.nexthoughts.services.mapping.onetoone.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/stock")
public class StockController {
    private final Logger logger = LoggerFactory.getLogger(StockController.class);
    private StockService stockService;

    @Autowired
    StockController(StockService stockService) {
        this.stockService = stockService;
    }

    /*@ModelAttribute("allStock")
    public List<Stock> populateStock() {
        return this.stockService.findAll();
    }*/

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        logger.debug("==============================");
        model.addAttribute(new StockCommand());
        return "stockCreate";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView save(StockCommand stockCommand) {
        logger.debug("****************************************");
        logger.debug("****************************************");
        logger.debug("****************************************");
        logger.debug("****************************************");
        logger.debug("This " + stockCommand.getStockCode());
        logger.debug("This " + stockCommand.getStockName());
        logger.debug("****************************************");
        logger.debug("****************************************");
        int stockId = stockService.create(stockCommand);
        logger.debug("This " + stockId + " has been created");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("stockCommand", stockCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        logger.debug("==============================");
        List<StockCommand> stocks = stockService.list();
        ModelAndView model = new ModelAndView();
        model.setViewName("stockList");
        model.addObject("stocks", stocks);
        return model;
    }

    @RequestMapping(value = "/edit/{stockId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("stockId") int stockId) {
        ModelAndView modelAndView = new ModelAndView();
        Stock stock = stockService.read(stockId);
        modelAndView.setViewName("editStock");
        modelAndView.addObject("stock", stock);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{stockId}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("stockId") int stockId, StockCommand stockCommand) {
        stockService.update(stockCommand, stockId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/stock/list");
        modelAndView.addObject("stockCommand", stockCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{stockId}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("stockId") int stockId) {
        stockService.delete(stockId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/stock/list");
        return modelAndView;
    }

}