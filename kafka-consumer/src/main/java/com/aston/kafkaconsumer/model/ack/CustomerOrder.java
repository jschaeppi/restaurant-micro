package com.aston.kafkaconsumer.model.ack;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/28/21
//BY: joe

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Entity
public class CustomerOrder {

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

    @ManyToMany(cascade = CascadeType.ALL)
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
