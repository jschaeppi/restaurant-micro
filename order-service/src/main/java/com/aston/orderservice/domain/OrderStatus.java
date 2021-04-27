package com.aston.orderservice.domain;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/27/21
//BY: joe

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Entity
public class OrderStatus {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    private String statusType;

    @ManyToMany(mappedBy = "orderStatus")
    private List<TableOrder> tableOrders;
    //endregion

    //region Constructors

    public OrderStatus() {
    }

    public OrderStatus(String statusType) {
        this.statusType = statusType;
    }

    //endregion
    //region GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public List<TableOrder> getTableOrders() {
        return tableOrders;
    }

    public void setTableOrders(List<TableOrder> tableOrders) {
        this.tableOrders = tableOrders;
    }


    //endregion
}
