package com.example.franquia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        Intent intent = getIntent();
        Franchise franchise = intent.getParcelableExtra("ChosenFranchise");

        List<Restaurant> restaurants = franchise.getRestaurants();
        Restaurant restaurant = restaurants.get(0);
        String name = restaurant.getName();

        TextView textView = findViewById(R.id.nameTextView);
        textView.setText(name);
    }
}