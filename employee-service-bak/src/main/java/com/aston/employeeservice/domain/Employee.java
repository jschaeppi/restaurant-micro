package com.aston.employeeservice.domain;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/23/21
//BY: joe

import javax.persistence.*;

@Entity
public class Employee extends Person {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    private String empNum;
    private Double payRate;
    //endregion

    //region Constructors


    public Employee() {
    }

    public Employee(String empNum, Double payRate) {
        this.empNum = empNum;
        this.payRate = payRate;
    }

    public Employee(String firstName, String lastName, String empNum, Double payRate) {
        super(firstName, lastName);
        this.empNum = empNum;
        this.payRate = payRate;
    }


    //endregion
    //region GETTERS AND SETTERS

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getEmpNum() {
        return empNum;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    public Double getPayRate() {
        return payRate;
    }

    public void setPayRate(Double payRate) {
        this.payRate = payRate;
    }


    //endregion
}
