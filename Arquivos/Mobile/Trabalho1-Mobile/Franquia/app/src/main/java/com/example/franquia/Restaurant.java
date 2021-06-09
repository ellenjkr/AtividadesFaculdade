package com.example.franquia;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant implements Parcelable { // Must implement Parcelable so the franchise can send a list of restaurants to the new activity

    // Attributes
    private String name;
    private String city;
    private String address;
    private String image;

    public Restaurant(String name, String city, String address, String image) { // Constructor
        this.name = name;
        this.city = city;
        this.address = address;
        this.image = image;
    }

    // Get
    public String getName() {
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public String getAddress(){
        return this.address;
    }

    public String getImage(){
        return this.image;
    }

    protected Restaurant(Parcel in) { // Parcel method
        name = in.readString();
        city = in.readString();
        address = in.readString();
        image = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() { // Parcel method
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    } // Parcel method

    @Override
    public void writeToParcel(Parcel dest, int flags) { // Parcel method
        dest.writeString(name);
        dest.writeString(city);
        dest.writeString(address);
        dest.writeString(image);
    }
}