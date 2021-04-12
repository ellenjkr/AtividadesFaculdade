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
    private ListView franchisesListView;
    private ArrayList<Franchise> franchises = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Franquias");

        addFranchises();
    }

    public void addFranchises(){
        franchisesListView = (ListView) findViewById(R.id.franchisesListView);
        Franchise pizzahut = new Franchise("Pizza Hut", "Pizza Hut é uma cadeia de restaurantes e franquias especializada em pizzas e massas. Com sede na cidade de Plano, no Texas, a Pizza Hut é a maior cadeia de pizzarias do mundo.", "pizzahut");
        Franchise burgerking = new Franchise("Burger King", "Burger King, muitas vezes abreviado como BK, é uma rede de restaurantes especializada em fast-food, fundada nos Estados Unidos por James McLamore e David Edgerton", "burgerking");
        Franchise chinainbox = new Franchise("China in Box", "China in Box é uma rede de fast-food de comida chinesa, inaugurada em 1992 no bairro paulistano de Moema por Robinson Shiba e presente em várias cidades do Brasil", "chinainbox");
        Franchise habibs = new Franchise("Habib's", "Habib's é uma rede brasileira de restaurantes de comida rápida, especializada em culinária árabe. A rede vende mais de 600 milhões de esfirras por ano", "habibs");

        pizzahut.addRestaurant(new Restaurant("Pizza Hut BC", "Balneário Camboriú", "Av. Santa Catarina, 1", "pizzahutbc"));
        burgerking.addRestaurant(new Restaurant("Burger King BC", "Balneário Camboriú", "Av. Brasil, 1755", "burgerkingbc"));
        chinainbox.addRestaurant(new Restaurant("China in Box BC", "Balneário Camboriú", "R. Pernambuco, 18", "chinainboxbc"));

        habibs.addRestaurant(new Restaurant("Habib's Blumenau", "Blumenau", "R. Antônio da Veiga, 737", "habibsbnu"));
        habibs.addRestaurant(new Restaurant("Habib's Floripa", "Florianópolis", "Av. Beira Mar Norte, 3826", "habibsfloripa"));
        habibs.addRestaurant(new Restaurant("Habib's Joinville", "Joinville", "R. Dr. João Colin, 518", "habibsjoinville"));
        habibs.addRestaurant(new Restaurant("Habib's Curitiba", "Curitiba", "Av. Silva Jardim, 401", "habibscuritiba"));

        this.franchises.add(pizzahut);
        this.franchises.add(burgerking);
        this.franchises.add(chinainbox);
        this.franchises.add(habibs);

        adapter = new Adapter(this, franchises);
        franchisesListView.setAdapter(adapter);

        franchisesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
                intent.putExtra("ChosenFranchise", franchises.get(i));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem actionMenuItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView)actionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    adapter.searchFilter("");
                }
                else{
                    adapter.searchFilter(newText);
                }
                return true;
            }
        });
        return true;
    }
}