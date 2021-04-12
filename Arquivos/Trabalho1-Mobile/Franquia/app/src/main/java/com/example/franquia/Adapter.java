package com.example.franquia;

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
    Activity context;
    ArrayList<Franchise> franchises;
    ArrayList<Franchise> franchisesCopy;

    private static LayoutInflater inflater = null;

    public Adapter(Activity context, ArrayList<Franchise> franchises){
        this.context = context;
        this.franchises = franchises;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.franchisesCopy = new ArrayList<Franchise>();
        this.franchisesCopy.addAll(franchises);
    }

    @Override
    public int getCount() {
        return franchises.size();
    }

    @Override
    public Franchise getItem(int position) {
        return franchises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View franchiseItem = convertView;
        franchiseItem = inflater.inflate(R.layout.franchise_item, parent, false);

        ImageView image = (ImageView) franchiseItem.findViewById(R.id.imageViewFranchise);
        TextView name = (TextView) franchiseItem.findViewById(R.id.textViewName);
        TextView description = (TextView) franchiseItem.findViewById(R.id.textViewDescription);

        Franchise currentFranchise = franchises.get(position);

        int imageID = context.getResources().getIdentifier(currentFranchise.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);
        name.setText(currentFranchise.getName());
        description.setText(currentFranchise.getDescription());

        return franchiseItem;
    }

    public void searchFilter(String text){
        text = text.toLowerCase(Locale.getDefault());
        franchises.clear();
        if(text.length()==0){
            franchises.addAll(franchisesCopy);
        }
        else{
            for (Franchise franchise : franchisesCopy){
                if (franchise.getName().toLowerCase(Locale.getDefault()).contains(text) || franchise.getDescription().toLowerCase(Locale.getDefault()).contains(text)){
                    franchises.add(franchise);
                }
            }
        }
        notifyDataSetChanged();
    }
}
