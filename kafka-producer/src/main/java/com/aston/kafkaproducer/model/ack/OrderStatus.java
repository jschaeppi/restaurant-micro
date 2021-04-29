package com.aston.kafkaproducer.model.ack;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/28/21
//BY: joe

import java.util.List;

public class OrderStatus {

    //region PROPERTIES
    private Integer id;

    private Integer version;

    private String statusType;

    private List<CustomerOrder> customerOrders;
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

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }


    //endregion
}
