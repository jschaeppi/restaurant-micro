package com.aston.kafkaproducer.model.ack;

import java.util.List;

public class CustomerOrder {

    //region PROPERTIES
    private Integer id;

    private Integer version;

    private List<OrderStatus> orderStatus;

    private CustomerTable serverTable;

    private List<MenuItem> menuItems;
    //endregion

    //region Constructors

    public CustomerOrder() {
    }

    public CustomerOrder(boolean status, CustomerTable table) {
        this.serverTable = table;
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

    public CustomerTable getServerTable() {
        return serverTable;
    }

    public void setServerTable(CustomerTable serverTable) {
        this.serverTable = serverTable;
    }

    public List<OrderStatus> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<OrderStatus> orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

//endregion
}
