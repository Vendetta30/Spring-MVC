package com.nexthoughts.services.mapping.onetoone;

import com.nexthoughts.command.mapping.onetoone.StockCommand;
import com.nexthoughts.domain.mapping.onetoone.Stock;
import com.nexthoughts.domain.mapping.onetoone.StockDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private final Logger logger = LoggerFactory.getLogger(StockService.class);
    private SessionFactory sessionFactory;

    @Autowired
    StockService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public List<StockCommand> list() {

        List<StockCommand> stockCommands = new ArrayList<StockCommand>();
        List<Stock> stocks = getSession().createCriteria(Stock.class).list();
        for (Stock stock : stocks) {
            stockCommands.add(new StockCommand(stock));
        }
        return stockCommands;
    }

    public int create(StockCommand stockCommand) {
        Stock stock = new Stock(stockCommand);
        getSession().save(stock);
        getSession().close();
        return stock.getStockId();
    }

    public Stock read(int id) {
        Session session = getSession();
        Stock stock = (Stock) session.get(Stock.class, id);
        session.close();
        return stock;
    }

    public void update(StockCommand stockCommand, int topicId) {
        Session session = getSession();
        Stock stock = (Stock) session.get(Stock.class, topicId);
        stock = stock.updateStock(stockCommand);
        session.update(stock);
        session.flush();
        session.close();
    }

    public void delete(int id) {
        Session session = getSession();
        Stock stock = (Stock) getSession().get(Stock.class, id);
        session.delete(stock);
        session.flush();
        session.close();
    }
}
