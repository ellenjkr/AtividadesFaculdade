package com.example.trabalhom2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView menuItemsListView; // ListView for the menu items
    private ArrayList<MenuItem> menuItems = new ArrayList<>(); // Array with menu items
    private Adapter adapter; // Adapter for the menu items


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Defines the layout

        getSupportActionBar().setTitle("Cardápio"); // Set title for the activity

        addMenuItems(); // Add menu items to the array of menu items

        adapter = new Adapter(this, menuItems); // Creates adapter
        menuItemsListView.setAdapter(adapter); // Set adapter, responsible for filling the listview with the menu items

    }

    public void addMenuItems(){
        menuItemsListView = (ListView) findViewById(R.id.menuItemsListView); // Get listview

        DbHelper dbHelper = new DbHelper(MainActivity.this); // Get the db helper
        // dbHelper.saveData("Suco de Laranja", "Suco de laranja natural 200ml", "4", "não", "86", "suquinho"); // Add new line to the database


        Cursor cursor = dbHelper.ViewData(); // Get the cursor to view the data

        while(cursor.moveToNext()){ // Iterate through the cursor
            // Create new menu item with the data from the database
            MenuItem menuItem = new MenuItem(cursor.getString(1), cursor.getString(2), cursor.getString(3),  cursor.getString(4), cursor.getString(5), cursor.getString(6));

            this.menuItems.add(menuItem); // Add menu item to the list of menu items
        }
    }
}