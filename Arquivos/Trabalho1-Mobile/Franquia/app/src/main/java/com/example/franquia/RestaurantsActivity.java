package com.example.franquia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        Intent intent = getIntent();
        Franchise franchise = intent.getParcelableExtra("ChosenFranchise");

        String name = franchise.getName();

        TextView textView = findViewById(R.id.nameTextView);
        textView.setText(name);
    }
}