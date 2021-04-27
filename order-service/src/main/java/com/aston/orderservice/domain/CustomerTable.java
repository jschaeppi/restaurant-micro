package com.aston.orderservice.domain;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/26/21
//BY: joe

import javax.persistence.*;

import java.util.List;

@Entity
public class CustomerTable {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;


    private boolean status;

    @OneToMany(mappedBy = "serverTable")
    private List<TableOrder> orderList;
    //endregion

    //region Constructors

    public CustomerTable() {

    }

    public CustomerTable(List<TableOrder> orderList) {
        this.orderList = orderList;
    }

    public CustomerTable(boolean status, List<TableOrder> orderList) {
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

    public List<TableOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<TableOrder> orderList) {
        this.orderList = orderList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //endregion
}
