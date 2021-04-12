package com.example.franquia;

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
    private ListView restaurantsListView;
    private AdapterRestaurants adapter;
    private Franchise franchise;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        getSupportActionBar().setTitle("Restaurantes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        franchise = intent.getParcelableExtra("ChosenFranchise");

        listRestaurants();
    }


    public void listRestaurants(){
        adapter = new AdapterRestaurants(this, (ArrayList<Restaurant>) franchise.getRestaurants());
        restaurantsListView = (ListView) findViewById(R.id.restaurantsListView);
        restaurantsListView.setAdapter(adapter);
    }
}