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
import java.util.Locale;

public class Adapter extends BaseAdapter {
    Activity context; // The context
    ArrayList<MenuItem> menuItems; // List of franchises
    ArrayList<MenuItem> franchisesCopy; // Copy of the franchises
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
        View franchiseItem = convertView; // Get an item as a view
        franchiseItem = inflater.inflate(R.layout.menu_item, parent, false); // Item of the listview, "franchise_item" layout

        // Each field of the item (franchise's image, name and description)
        ImageView image = (ImageView) franchiseItem.findViewById(R.id.imageViewFranchise);
        TextView name = (TextView) franchiseItem.findViewById(R.id.textViewName);
        TextView description = (TextView) franchiseItem.findViewById(R.id.textViewDescription);

        MenuItem currentMenuItem = menuItems.get(position); // Get a franchise from the list of franchises

        // Set each field of the listview item with the current franchise data
        int imageID = context.getResources().getIdentifier(currentMenuItem.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);
        name.setText(currentMenuItem.getName());
        description.setText(currentMenuItem.getDescription());

        return franchiseItem;
    }

    // Filter list based on the user's search (from SearchView)
    public void searchFilter(String text){
        text = text.toLowerCase(Locale.getDefault());
        menuItems.clear(); // Clear list of franchises
        if(text.length()==0){ // If the text is empty
            menuItems.addAll(franchisesCopy); // Add all the fracnhises to the list of franchises, no filter
        }
        else{
            for (MenuItem menuItem : franchisesCopy){ // For each franchise on the copy of franchises
                // If the text is on the franchise title or description
                if (menuItem.getName().toLowerCase(Locale.getDefault()).contains(text) || menuItem.getDescription().toLowerCase(Locale.getDefault()).contains(text)){
                    menuItems.add(menuItem); // Add the franchise to the list of franchises
                }
            }
        }
        notifyDataSetChanged();
    }
}
