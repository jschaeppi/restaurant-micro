package com.aston.employeeservice.domain;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/23/21
//BY: joe

import javax.persistence.*;

import java.util.Date;

@Entity
public class Person {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    private String firstName;
    private String MiddleName;
    private String LastName;
    private Date birthDate;
    //endregion

    //region Constructors

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        LastName = lastName;
    }

    public Person(String firstName, String middleName, String lastName, Date birthDate) {
        this.firstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        this.birthDate = birthDate;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    //endregion
}
