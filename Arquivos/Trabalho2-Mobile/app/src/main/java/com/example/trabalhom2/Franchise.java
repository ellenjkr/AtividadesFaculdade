package com.example.trabalhom2;



public class Franchise { // Must implement Parcelable so it can be sent to a new acitivy as an object

    // Attributes
    private String name;
    private String description;
    private float price;
    private boolean gluten;
    private int cal;

    public Franchise(String name, String description, float price, boolean gluten, int cal) { // Constructor
        this.name = name;
        this.description = description;
        this.price = price;
        this.gluten = gluten;
        this.cal = cal;
    }

    // Get
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public float getPrice() {
        return this.price;
    }

    public boolean getGluten() {
        return this.gluten;
    }

    public int getCal() {
        return this.cal;
    }
}