package com.aston.kafkaconsumer.model.ack;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/28/21
//BY: joe

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Entity
public class CustomerTable {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;
    private Integer size;
    private Integer customerCount;
    private Integer serverId;

    private boolean validCount;
    private boolean status;

    @JsonIgnore
    @OneToMany(mappedBy = "serverTable")
    private List<CustomerOrder> orderList;
    //endregion

    //region Constructors

    public CustomerTable() {

    }

    public CustomerTable(List<CustomerOrder> orderList) {
        this.orderList = orderList;
    }

    public CustomerTable(boolean status, List<CustomerOrder> orderList) {
        this.status = status;
        this.orderList = orderList;
    }

    public CustomerTable(Integer customerCount, Integer serverId, boolean validCount, boolean status) {
        this.customerCount = customerCount;
        this.serverId = serverId;
        this.validCount = validCount;
        this.status = status;
    }

    public CustomerTable(Integer size, Integer customerCount, Integer serverId, boolean validCount, boolean status, List<CustomerOrder> orderList) {
        this.size = size;
        this.customerCount = customerCount;
        this.serverId = serverId;
        this.validCount = validCount;
        this.status = status;
        this.orderList = orderList;
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

    public List<CustomerOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<CustomerOrder> orderList) {
        this.orderList = orderList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(Integer customerCount) {
        this.customerCount = customerCount;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public boolean isValidCount() {
        return validCount;
    }

    public void setValidCount(boolean validCount) {
        this.validCount = validCount;
    }

    //endregion
}
