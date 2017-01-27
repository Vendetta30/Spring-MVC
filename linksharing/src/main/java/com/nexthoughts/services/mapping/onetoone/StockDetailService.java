package com.nexthoughts.services.mapping.onetoone;

import com.nexthoughts.command.mapping.onetoone.StockCommand;
import com.nexthoughts.command.mapping.onetoone.StockDetailCommand;
import com.nexthoughts.domain.mapping.onetoone.Stock;
import com.nexthoughts.domain.mapping.onetoone.StockDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockDetailService {
    private final Logger logger = LoggerFactory.getLogger(StockDetailService.class);
    private SessionFactory sessionFactory;

    @Autowired
    StockDetailService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public List<StockCommand> stockList() {
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("******************************3333333333333**********************************");
        List<StockCommand> stockCommands = new ArrayList<StockCommand>();
        List<Stock> stocks = getSession().createCriteria(Stock.class).list();
        for (Stock stock : stocks) {
            stockCommands.add(new StockCommand(stock));
        }
        return stockCommands;
    }

    public List<StockDetailCommand> list() {
        List<StockDetailCommand> stockDetailCommands = new ArrayList<StockDetailCommand>();
        List<StockDetail> stockDetails = getSession().createCriteria(StockDetail.class).list();
        for (StockDetail stockDetail : stockDetails) {
            stockDetailCommands.add(new StockDetailCommand(stockDetail));
        }
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("stockDetailCommands " + stockDetailCommands);
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("**************************************");
        return stockDetailCommands;
    }

    public int create(StockDetailCommand stockDetailCommand) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        StockDetail stockDetail = new StockDetail(stockDetailCommand);
        logger.debug("#########################################");
        logger.debug("#########################################");
        logger.debug("#########################################");
        logger.debug("#########################################");
        logger.debug("stockDetail " + stockDetail.getListedDate());
        logger.debug("#########################################");
        logger.debug("#########################################");
        logger.debug("#########################################");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        stockDetail.setStock(getStock(stockDetailCommand.getStockId()));
        logger.debug("stockDetail " + stockDetail.getStock());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("#########################################");
        logger.debug("#########################################");
        logger.debug("#########################################");
        session.save(stockDetail);
        transaction.commit();
        session.close();
        return stockDetail.getId();
    }

    public StockDetail read(int id) {
        Session session = getSession();
        StockDetail stockDetail = (StockDetail) session.get(StockDetail.class, id);
        session.close();
        return stockDetail;
    }

    public void update(StockDetailCommand stockDetailCommand) {
        Session session = getSession();
        StockDetail stockDetail = (StockDetail) session.get(Stock.class, stockDetailCommand.getStockDetailId());
        stockDetail = stockDetail.updateStockDetail(stockDetailCommand);
        session.update(stockDetail);
        session.flush();
        session.close();
    }

    public void delete(int id) {
        Session session = getSession();
        StockDetail stockDetail = (StockDetail) getSession().get(StockDetail.class, id);
        session.delete(stockDetail);
        session.flush();
        session.close();
    }

    public Stock getStock(int id) {
        Session session = getSession();
        Stock stock = (Stock) session.get(Stock.class, id);
        session.close();
        return stock;
    }
}