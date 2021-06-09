package com.example.trabalhom2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    Activity context; // The context
    ArrayList<MenuItem> menuItems; // List of menu items
    ArrayList<MenuItem> franchisesCopy; // Copy of the menu items
    private static LayoutInflater inflater = null; // The inflater

    public Adapter(Activity context, ArrayList<MenuItem> menuItems){ // Constructor
        this.context = context;
        this.menuItems = menuItems;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.franchisesCopy = new ArrayList<MenuItem>();
        this.franchisesCopy.addAll(menuItems);
    }

    @Override // BaseAdapter method
    public int getCount() {
        return menuItems.size();
    }

    @Override // BaseAdapter method
    public MenuItem getItem(int position) {
        return menuItems.get(position);
    }

    @Override // BaseAdapter method
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View menuItem = convertView; // Get an item as a view
        menuItem = inflater.inflate(R.layout.menu_item, parent, false); // Item of the listview, "menu_item" layout

        // Each field of the item
        ImageView image = (ImageView) menuItem.findViewById(R.id.imageViewMenuItem);
        TextView name = (TextView) menuItem.findViewById(R.id.textViewName);
        TextView description = (TextView) menuItem.findViewById(R.id.textViewDescription);
        TextView gluten = (TextView) menuItem.findViewById(R.id.textViewGluten);
        TextView cal = (TextView) menuItem.findViewById(R.id.textViewCal);
        TextView price = (TextView) menuItem.findViewById(R.id.textViewPrice);

        MenuItem currentMenuItem = menuItems.get(position); // Get a menu item from the list of menu items

        // Set each field of the listview item with the current menu item data
        int imageID = context.getResources().getIdentifier(currentMenuItem.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);
        name.setText(currentMenuItem.getName());
        description.setText(currentMenuItem.getDescription());
        gluten.setText("Contém Gluten? " + currentMenuItem.getGluten());
        cal.setText("Calorias: " + currentMenuItem.getCal());
        price.setText("R$ " + currentMenuItem.getPrice());

        return menuItem;
    }
}
