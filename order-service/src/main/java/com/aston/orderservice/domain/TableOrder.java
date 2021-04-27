package com.aston.orderservice.domain;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/26/21
//BY: joe

import javax.persistence.*;
import javax.persistence.criteria.Order;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.*;
import java.util.List;

@Entity
public class TableOrder {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_status_id")
    private List<OrderStatus> orderStatus;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private CustomerTable serverTable;

    @ManyToMany
    private List<MenuItem> menuItems;
    //endregion

    //region Constructors

    public TableOrder() {
    }

    public TableOrder(boolean status, CustomerTable table) {
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

    public CustomerTable getTable() {
        return serverTable;
    }

    public void setTable(CustomerTable table) {
        this.serverTable = table;
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
