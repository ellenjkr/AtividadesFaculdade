package com.example.trabalhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView franchisesListView; // ListView for the franchises
    private ArrayList<Franchise> franchises = new ArrayList<>(); // Array with franchises
    private Adapter adapter; // Adapter for the franchises


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Defines the layout

        getSupportActionBar().setTitle("Franquias"); // Set title for the activity

        addFranchises(); // Add franchises to the array of franchises

        adapter = new Adapter(this, franchises); // Creates adapter
        franchisesListView.setAdapter(adapter); // Set adapter, responsible for filling the listview with the franchises

    }


    public void addFranchises(){
        franchisesListView = (ListView) findViewById(R.id.franchisesListView); // Get listview

        DbHelper dbHelper = new DbHelper(MainActivity.this);
        //dbHelper.saveData("nome2", "decricao2", "200.50", "sim", "300", "pizzahut");

        Cursor cursor = dbHelper.ViewData();

        while(cursor.moveToNext()){
            Franchise menuItem = new Franchise(cursor.getString(1), cursor.getString(2), cursor.getString(3),  cursor.getString(4), cursor.getString(5), cursor.getString(6));

            this.franchises.add(menuItem);
        }
    }
}