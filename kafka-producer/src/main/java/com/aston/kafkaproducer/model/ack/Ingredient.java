package com.aston.kafkaproducer.model.ack;

public class Ingredient {

    private String name;

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public String getType() {
        return name;
    }

    public void setType(String name) {
        this.name = name;
    }
}
