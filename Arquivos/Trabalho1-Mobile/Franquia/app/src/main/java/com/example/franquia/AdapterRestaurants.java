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
    Activity context;
    ArrayList<Restaurant> restaurants;

    private static LayoutInflater inflater = null;

    public AdapterRestaurants(Activity context, ArrayList<Restaurant> restaurants){
        this.context = context;
        this.restaurants = restaurants;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return restaurants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View restaurantItem = convertView;
        restaurantItem = inflater.inflate(R.layout.restaurant_item, parent, false);

        TextView name = (TextView) restaurantItem.findViewById(R.id.textViewRestaurantName);
        TextView city = (TextView) restaurantItem.findViewById(R.id.textViewRestaurantCity);
        TextView address = (TextView) restaurantItem.findViewById(R.id.textViewRestaurantAddress);
        ImageView image = (ImageView) restaurantItem.findViewById(R.id.imageViewRestaurant);

        Restaurant currentRestaurant = restaurants.get(position);

        name.setText(currentRestaurant.getName());
        city.setText("Cidade: " + currentRestaurant.getCity());
        address.setText("Endereço: " + currentRestaurant.getAddress());
        int imageID = context.getResources().getIdentifier(currentRestaurant.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);

        return restaurantItem;
    }
}
