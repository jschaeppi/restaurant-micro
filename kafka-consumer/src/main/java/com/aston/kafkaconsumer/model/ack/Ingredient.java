package com.aston.kafkaconsumer.model.ack;

//PROJECT CREATED BY: IntelliJ IDEA
//CREATED ON: 4/28/21
//BY: joe

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Entity
public class Ingredient {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_type_id")
    private IngredientType ingredientType;

    @ManyToMany(mappedBy = "ingredientList")
    @JsonIgnore
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
