package com.aston.kafkaproducer.model.ack;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/28/21
//BY: joe

import java.util.List;

public class MenuItem {

    //region PROPERTIES
    private Integer id;

    private Integer version;
    private Integer price;

    private String name;

    private List<Ingredient> ingredientList;
    //endregion

    //region Constructors

    public MenuItem() {
    }

    public MenuItem(String name) {
        this.name = name;
    }

    public MenuItem(String name, List<Ingredient> ingredientList) {
        this.name = name;
        this.ingredientList = ingredientList;
    }

    public MenuItem(Integer price, String name) {
        this.price = price;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

//endregion
}
