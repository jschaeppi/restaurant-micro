package com.aston.orderservice.domain;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/26/21
//BY: joe

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TableOrder {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id", nullable = false)
    private CustomerTable serverTable;
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

    //endregion
}
