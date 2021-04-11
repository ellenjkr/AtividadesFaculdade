package com.example.franquia;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;


public class Franchise implements Parcelable {

    private String name;
    private String description;
    private String image;

    public Franchise(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    protected Franchise(Parcel in) {
        name = in.readString();
        description = in.readString();
        image = in.readString();
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(image);
    }
}