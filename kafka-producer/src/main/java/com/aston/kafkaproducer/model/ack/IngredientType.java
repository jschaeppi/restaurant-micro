package com.aston.kafkaproducer.model.ack;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/28/21
//BY: joe


import java.util.List;

public class IngredientType {

    //region PROPERTIES
    private Integer id;

    private Integer version;

    private String type;

    private List<Ingredient> ingredientList;
    //endregion

    //region Constructors


    public IngredientType() {
    }

    public IngredientType(String type) {
        this.type = type;
    }

    public IngredientType(String type, List<Ingredient> ingredientList) {
        this.type = type;
        this.ingredientList = ingredientList;
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

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
//endregion
}
