package com.example.franquia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


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

        setOnClick(); // Action for when a franchise is clicked
    }

    public void addFranchises(){
        franchisesListView = (ListView) findViewById(R.id.franchisesListView); // Get listview

        // Declaration of franchises
        Franchise pizzahut = new Franchise("Pizza Hut", "Pizza Hut é uma cadeia de restaurantes e franquias especializada em pizzas e massas. Com sede na cidade de Plano, no Texas, a Pizza Hut é a maior cadeia de pizzarias do mundo.", "pizzahut");
        Franchise burgerking = new Franchise("Burger King", "Burger King, muitas vezes abreviado como BK, é uma rede de restaurantes especializada em fast-food, fundada nos Estados Unidos por James McLamore e David Edgerton", "burgerking");
        Franchise chinainbox = new Franchise("China in Box", "China in Box é uma rede de fast-food de comida chinesa, inaugurada em 1992 no bairro paulistano de Moema por Robinson Shiba e presente em várias cidades do Brasil", "chinainbox");
        Franchise habibs = new Franchise("Habib's", "Habib's é uma rede brasileira de restaurantes de comida rápida, especializada em culinária árabe. A rede vende mais de 600 milhões de esfirras por ano", "habibs");

        // Add restaurants to the franchises
        pizzahut.addRestaurant(new Restaurant("Pizza Hut BC", "Balneário Camboriú", "Av. Santa Catarina, 1", "pizzahutbc"));
        pizzahut.addRestaurant(new Restaurant("Pizza Hut Blumenau", "Blumenau", "R. 7 de Setembro, 1213", "pizzahutbnu"));
        pizzahut.addRestaurant(new Restaurant("Pizza Hut Floripa", "Floripa", "R. Bocaiúva, 1761", "pizzahutfloripa"));

        burgerking.addRestaurant(new Restaurant("Burger King BC", "Balneário Camboriú", "Av. Brasil, 1755", "burgerkingbc"));
        burgerking.addRestaurant(new Restaurant("Burger King Itajaí", "Itajaí", "R. Samuel Heusi, 278", "burgerkingitj"));
        burgerking.addRestaurant(new Restaurant("Burger King Floripa", "Floripa", "R. Bocaiúva, 2468", "burgerkingfloripa"));

        chinainbox.addRestaurant(new Restaurant("China in Box BC", "Balneário Camboriú", "R. Pernambuco, 18", "chinainboxbc"));
        chinainbox.addRestaurant(new Restaurant("China in Box Blumenau", "Blumenau", "R. 7 de Setembro, Nº 2.680", "chinainboxbnu"));
        chinainbox.addRestaurant(new Restaurant("China in Box Floripa", "Floripa", "Av. Rio Branco, Nº 197", "chinainboxfloripa"));

        habibs.addRestaurant(new Restaurant("Habib's Blumenau", "Blumenau", "R. Antônio da Veiga, 737", "habibsbnu"));
        habibs.addRestaurant(new Restaurant("Habib's Floripa", "Floripa", "Av. Beira Mar Norte, 3826", "habibsfloripa"));
        habibs.addRestaurant(new Restaurant("Habib's Joinville", "Joinville", "R. Dr. João Colin, 518", "habibsjoinville"));
        habibs.addRestaurant(new Restaurant("Habib's Curitiba", "Curitiba", "Av. Silva Jardim, 401", "habibscuritiba"));

        // Add franchises to the array of franchises
        this.franchises.add(pizzahut);
        this.franchises.add(burgerking);
        this.franchises.add(chinainbox);
        this.franchises.add(habibs);
    }

    public void setOnClick(){
        // Action for item click
        franchisesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class); // Creates a new intent that opens a new activity (Restaurants page)

                // Send the franchise object to the new activity. Franchise and Restaurant must implement Parcelable
                intent.putExtra("ChosenFranchise", franchises.get(i));
                startActivity(intent); // Start new activity
            }
        });
    }

    // Search
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem actionMenuItem = menu.findItem(R.id.actionSearch); // Get the menu item

        SearchView searchView = (SearchView)actionMenuItem.getActionView(); // Get the SearchView from the menu item
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // When someone writes on SearchView
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){ // If text is empty
                    adapter.searchFilter("");
                }
                else{ // If text is not empty
                    adapter.searchFilter(newText);
                }
                return true;
            }
        });
        return true;
    }
}