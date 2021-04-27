package com.aston.kafkaproducer.ack;

public class Ingredient {

    private String type;

    public Ingredient() {
    }

    public Ingredient(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
