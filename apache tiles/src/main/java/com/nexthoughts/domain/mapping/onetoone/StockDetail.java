package com.nexthoughts.domain.mapping.onetoone;

import com.nexthoughts.command.mapping.onetoone.StockDetailCommand;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock_detail")
public class StockDetail {
    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "stock"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    private Integer stockDetailId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Stock stock;

    @Column(name = "COMP_NAME", nullable = false)
    private String compName;

    @Column(name = "COMP_DESC", nullable = false)
    private String compDesc;

    @Column(name = "REMARK", nullable = false)
    private String remark;

    @Temporal(TemporalType.DATE)
    @Column(name = "LISTED_DATE", nullable = false, length = 10)
    private Date listedDate;

    public StockDetail() {

    }

    public StockDetail(StockDetailCommand stockDetailCommand) {
        this.stockDetailId = stockDetailCommand.getStockDetailId();
        this.compName = stockDetailCommand.getCompName();
        this.compDesc = stockDetailCommand.getCompDesc();
        this.remark = stockDetailCommand.getRemark();
        this.listedDate = new Date();
    }

    public StockDetail(Stock stock, String compName, String compDesc, String remark, Date listedDate) {
        this.compDesc = compDesc;
        this.compName = compName;
        this.stock = stock;
        this.remark = remark;
        this.listedDate = listedDate;
    }

    public Date getListedDate() {

        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }

    public String getRemark() {

        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCompDesc() {

        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getCompName() {

        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Stock getStock() {

        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return stockDetailId;
    }

    public void setId(Integer id) {
        this.stockDetailId = stockDetailId;
    }

    public StockDetail updateStockDetail(StockDetailCommand stockDetailCommand) {
        this.stockDetailId = stockDetailCommand.getStockDetailId();
        this.compName = stockDetailCommand.getCompName();
        this.compDesc = stockDetailCommand.getCompDesc();
        this.remark = stockDetailCommand.getRemark();
        this.listedDate = stockDetailCommand.getListedDate();
        return this;
    }
}
