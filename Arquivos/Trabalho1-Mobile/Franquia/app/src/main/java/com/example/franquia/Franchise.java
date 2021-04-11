package com.example.franquia;
import java.util.ArrayList;
import java.util.List;


public class Franchise {

    private String name;
    private String description;
    private String image;

        public Franchise(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }


}