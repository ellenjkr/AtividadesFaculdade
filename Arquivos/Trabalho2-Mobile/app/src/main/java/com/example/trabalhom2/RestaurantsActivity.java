package com.example.trabalhom2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {
    private ListView restaurantsListView; // ListView for the restaurants
    private AdapterRestaurants adapter; // Adapter for the restaurants
    private Franchise franchise; // The restaurants franchise

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants); // Defines the layout

        getSupportActionBar().setTitle("Restaurantes"); // Set title for the activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Back button

        Intent intent = getIntent(); // Get the intent that brought the user to this activity
        franchise = intent.getParcelableExtra("ChosenFranchise"); // Get the data sent with the intent

       // listRestaurants(); // List all the franchise's restaurants on the listview
    }
/*

    public void listRestaurants(){
        adapter = new AdapterRestaurants(this, (ArrayList<Restaurant>) franchise.getRestaurants()); // Creates adapter
        restaurantsListView = (ListView) findViewById(R.id.restaurantsListView);  // Get listview
        restaurantsListView.setAdapter(adapter); // Set adapter, responsible for filling the listview with the restaurants
    }*/
}