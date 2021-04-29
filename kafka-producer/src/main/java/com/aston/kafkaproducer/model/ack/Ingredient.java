package com.aston.kafkaproducer.model.ack;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Ingredient {

    //region PROPERTIES

    private Integer id;

    private Integer version;

    private String name;

    private IngredientType ingredientType;

    private List<MenuItem> menuItemList;
    //endregion

    //region Constructors

    public Ingredient() {
    }

    public Ingredient(String name, IngredientType ingredientType) {
        this.name = name;
        this.ingredientType = ingredientType;
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

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    //endregion
}
