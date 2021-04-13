package com.example.franquia;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRestaurants extends BaseAdapter {
    Activity context; // The context
    ArrayList<Restaurant> restaurants; // List of restaurants
    private static LayoutInflater inflater = null; // The inflater

    public AdapterRestaurants(Activity context, ArrayList<Restaurant> restaurants){ // Constructor
        this.context = context;
        this.restaurants = restaurants;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override // BaseAdapter method
    public int getCount() {
        return restaurants.size();
    }

    @Override // BaseAdapter method
    public Restaurant getItem(int position) {
        return restaurants.get(position);
    }

    @Override // BaseAdapter method
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View restaurantItem = convertView; // Get an item as a view
        restaurantItem = inflater.inflate(R.layout.restaurant_item, parent, false); // Item of the listview, "restaurant_item" layout

        // Each field of the item (restaurant's name, city, address and image)
        TextView name = (TextView) restaurantItem.findViewById(R.id.textViewRestaurantName);
        TextView city = (TextView) restaurantItem.findViewById(R.id.textViewRestaurantCity);
        TextView address = (TextView) restaurantItem.findViewById(R.id.textViewRestaurantAddress);
        ImageView image = (ImageView) restaurantItem.findViewById(R.id.imageViewRestaurant);

        Restaurant currentRestaurant = restaurants.get(position); // Get a restaurant from the list of restaurants

        // Set each field of the listview item with the current restaurant data
        name.setText(currentRestaurant.getName());
        city.setText("Cidade: " + currentRestaurant.getCity());
        address.setText("Endereço: " + currentRestaurant.getAddress());
        int imageID = context.getResources().getIdentifier(currentRestaurant.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);

        return restaurantItem;
    }
}
