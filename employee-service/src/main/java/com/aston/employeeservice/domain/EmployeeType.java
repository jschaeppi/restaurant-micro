package com.aston.employeeservice.domain;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/23/21
//BY: joe


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class EmployeeType {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "employeeType")
    private List<Employee> employee;
    //endregion

    //region Constructors

    public EmployeeType() {
    }

    public EmployeeType(String type) {
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

//endregion
}
