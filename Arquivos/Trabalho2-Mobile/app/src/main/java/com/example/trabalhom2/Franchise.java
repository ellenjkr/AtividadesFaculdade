package com.example.trabalhom2;



public class Franchise { // Must implement Parcelable so it can be sent to a new acitivy as an object

    // Attributes
    private String name;
    private String description;
    private String price;
    private String gluten;
    private String cal;
    private String image;

    public Franchise(String name, String description, String price, String gluten, String cal, String image) { // Constructor
        this.name = name;
        this.description = description;
        this.price = price;
        this.gluten = gluten;
        this.cal = cal;
        this.image = image;
    }

    // Get
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPrice() {
        return this.price;
    }

    public String getGluten() {
        return this.gluten;
    }

    public String getCal() {
        return this.cal;
    }

    public String getImage() {
        return this.image;
    }
}