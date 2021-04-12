package com.example.franquia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {
    private ListView restaurantsListView;
    private AdapterRestaurants adapter;
    private Franchise franchise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        Intent intent = getIntent();
        franchise = intent.getParcelableExtra("ChosenFranchise");

        listRestaurants();
//        List<Restaurant> restaurants = franchise.getRestaurants();
//        Restaurant restaurant = restaurants.get(0);
//        String name = restaurant.getName();

//        TextView textView = findViewById(R.id.nameTextView);
//        textView.setText(name);

//        restaurantsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
//                intent.putExtra("ChosenFranchise", franchises.get(i));
//                startActivity(intent);
//            }
//        });

    }
    public void listRestaurants(){
        adapter = new AdapterRestaurants(this, (ArrayList<Restaurant>) franchise.getRestaurants());
        restaurantsListView = (ListView) findViewById(R.id.restaurantsListView);
        restaurantsListView.setAdapter(adapter);
    }
    }