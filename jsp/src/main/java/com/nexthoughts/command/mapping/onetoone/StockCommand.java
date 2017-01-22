package com.nexthoughts.command.mapping.onetoone;

import com.nexthoughts.domain.mapping.onetoone.Stock;

public class StockCommand {
    private Integer stockId;
    private String stockName;
    private String stockCode;

    public StockCommand(Integer stockId, String stockName, String stockCode) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockCode = stockCode;
    }

    public StockCommand(Stock stock) {
        this.stockId = stock.getStockId();
        this.stockCode = stock.getStockCode();
        this.stockName = stock.getStockName();
    }

    public StockCommand() {
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
}