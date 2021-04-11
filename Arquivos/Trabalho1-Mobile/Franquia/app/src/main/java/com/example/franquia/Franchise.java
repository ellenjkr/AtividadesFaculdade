package com.example.franquia;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;


public class Franchise implements Parcelable {

    private String name;
    private String description;
    private String image;
    private List restaurants;

    public Franchise(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.restaurants = new ArrayList<Restaurant>();
    }

    protected Franchise(Parcel in) {
        name = in.readString();
        description = in.readString();
        image = in.readString();
        restaurants = new ArrayList<Restaurant>();
        in.readTypedList(restaurants, Restaurant.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(image);
        dest.writeTypedList(restaurants);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Franchise> CREATOR = new Creator<Franchise>() {
        @Override
        public Franchise createFromParcel(Parcel in) {
            return new Franchise(in);
        }

        @Override
        public Franchise[] newArray(int size) {
            return new Franchise[size];
        }
    };

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public List getRestaurants(){
        return this.restaurants;
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }

}