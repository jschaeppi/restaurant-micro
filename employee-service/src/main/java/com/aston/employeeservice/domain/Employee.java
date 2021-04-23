package com.aston.employeeservice.domain;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/23/21
//BY: joe

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee extends Person {

    //region PROPERTIES

    private String empNum;
    private Double payRate;

    @ManyToOne(cascade = CascadeType.ALL)
    private EmployeeType employeeType;
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

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

//endregion
}
