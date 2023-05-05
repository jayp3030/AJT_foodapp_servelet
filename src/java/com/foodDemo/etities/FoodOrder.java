package com.foodDemo.etities;

public class FoodOrder {

    private int id;
    private String name;
    private String order;
    private String quantity;
    private String suggestion;

    public FoodOrder(int id, String name, String order, String quantity, String suggestion) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.quantity = quantity;
        this.suggestion = suggestion;
    }

    public FoodOrder() {
    }

    public FoodOrder(String name, String order, String quantity) {
        this.name = name;
        this.order = order;
        this.quantity = quantity;
    }

    public FoodOrder(String name, String order, String quantity, String suggestion) {
        this.name = name;
        this.order = order;
        this.quantity = quantity;
        this.suggestion = suggestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

}
