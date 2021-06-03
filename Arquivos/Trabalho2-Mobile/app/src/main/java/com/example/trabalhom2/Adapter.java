package com.example.trabalhom2;

import android.app.Activity;
import android.content.Context;
import android.text.style.TtsSpan;
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
    ArrayList<Franchise> franchises; // List of franchises
    ArrayList<Franchise> franchisesCopy; // Copy of the franchises
    private static LayoutInflater inflater = null; // The inflater

    public Adapter(Activity context, ArrayList<Franchise> franchises){ // Constructor
        this.context = context;
        this.franchises = franchises;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.franchisesCopy = new ArrayList<Franchise>();
        this.franchisesCopy.addAll(franchises);
    }

    @Override // BaseAdapter method
    public int getCount() {
        return franchises.size();
    }

    @Override // BaseAdapter method
    public Franchise getItem(int position) {
        return franchises.get(position);
    }

    @Override // BaseAdapter method
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View franchiseItem = convertView; // Get an item as a view
        franchiseItem = inflater.inflate(R.layout.franchise_item, parent, false); // Item of the listview, "franchise_item" layout

        // Each field of the item (franchise's image, name and description)
        ImageView image = (ImageView) franchiseItem.findViewById(R.id.imageViewFranchise);
        TextView name = (TextView) franchiseItem.findViewById(R.id.textViewName);
        TextView description = (TextView) franchiseItem.findViewById(R.id.textViewDescription);

        Franchise currentFranchise = franchises.get(position); // Get a franchise from the list of franchises

        // Set each field of the listview item with the current franchise data
        int imageID = context.getResources().getIdentifier(currentFranchise.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);
        name.setText(currentFranchise.getName());
        description.setText(currentFranchise.getDescription());

        return franchiseItem;
    }

    // Filter list based on the user's search (from SearchView)
    public void searchFilter(String text){
        text = text.toLowerCase(Locale.getDefault());
        franchises.clear(); // Clear list of franchises
        if(text.length()==0){ // If the text is empty
            franchises.addAll(franchisesCopy); // Add all the fracnhises to the list of franchises, no filter
        }
        else{
            for (Franchise franchise : franchisesCopy){ // For each franchise on the copy of franchises
                // If the text is on the franchise title or description
                if (franchise.getName().toLowerCase(Locale.getDefault()).contains(text) || franchise.getDescription().toLowerCase(Locale.getDefault()).contains(text)){
                    franchises.add(franchise); // Add the franchise to the list of franchises
                }
            }
        }
        notifyDataSetChanged();
    }
}
