package com.example.franquia;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant implements Parcelable {

    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    protected Restaurant(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public String getName() {
        return this.name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}