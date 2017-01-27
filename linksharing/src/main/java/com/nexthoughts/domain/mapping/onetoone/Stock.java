package com.nexthoughts.domain.mapping.onetoone;

import com.nexthoughts.command.mapping.onetoone.StockCommand;

import javax.persistence.*;

@Entity
@Table(name = "stock", uniqueConstraints = {@UniqueConstraint(columnNames = "STOCK_NAME"), @UniqueConstraint(columnNames = "STOCK_CODE")})
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer stockId;
    @Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
    private String stockName;
    @Column(name = "STOCK_CODE", unique = true, nullable = false, length = 20)
    private String stockCode;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
    private StockDetail stockDetail;

    public Stock() {

    }

    public Stock(StockCommand stockCommand) {
        this.setStockName(stockCommand.getStockName());
        this.setStockCode(stockCommand.getStockCode());
        this.setStockId(stockCommand.getStockId());
    }

    public Stock(String stockName, String stockCode) {
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    public Stock(String stockName, String stockCode, StockDetail stockDetail) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockDetail = stockDetail;
    }

    public StockDetail getStockDetail() {
        return stockDetail;
    }

    public void setStockDetail(StockDetail stockDetail) {
        this.stockDetail = stockDetail;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public Stock updateStock(StockCommand stockCommand) {
        this.stockId = stockCommand.getStockId();
        this.stockCode = stockCommand.getStockCode();
        this.stockName = stockCommand.getStockName();
        return this;
    }
}
