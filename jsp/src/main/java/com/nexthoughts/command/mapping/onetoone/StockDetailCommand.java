package com.nexthoughts.command.mapping.onetoone;

import com.nexthoughts.domain.mapping.onetoone.Stock;
import com.nexthoughts.domain.mapping.onetoone.StockDetail;

import java.util.Date;

public class StockDetailCommand {
    private Integer stockDetailId;
    private String compName;
    private String compDesc;
    private String remark;
    private Date listedDate;
    private Integer stockId;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public StockDetailCommand() {
    }

    public StockDetailCommand(StockDetail stockDetail) {
    }

    public StockDetailCommand(Integer stockDetailId) {
        this.stockDetailId = stockDetailId;
    }

    public StockDetailCommand(String compName) {
        this.compName = compName;
    }

    public StockDetailCommand(Integer stockDetailId, String compName, String compDesc, String remark, Date listedDate) {
        this.stockDetailId = stockDetailId;
        this.compName = compName;
        this.compDesc = compDesc;
        this.remark = remark;
        this.listedDate = listedDate;
    }

    public Integer getStockDetailId() {
        return stockDetailId;
    }

    public void setStockDetailId(Integer stockDetailId) {
        this.stockDetailId = stockDetailId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }
}