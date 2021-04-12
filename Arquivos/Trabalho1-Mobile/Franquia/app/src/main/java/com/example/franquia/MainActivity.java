package com.example.franquia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView franchisesListView;
    private ArrayList<Franchise> franchises = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFranchises();
    }

    public void addFranchises(){
        franchisesListView = (ListView) findViewById(R.id.franchisesListView);
        Franchise franchiseOne = new Franchise("Pizza Hut", "Pizza Hut é uma cadeia de restaurantes e franquias especializada em pizzas e massas. Com sede na cidade de Plano, no Texas, a Pizza Hut é a maior cadeia de pizzarias do mundo.", "pizzahut");
        Franchise franchiseTwo = new Franchise("Burger King", "Burger King, muitas vezes abreviado como BK, é uma rede de restaurantes especializada em fast-food, fundada nos Estados Unidos por James McLamore e David Edgerton", "burgerking");
        Franchise franchiseThree = new Franchise("China in Box", "China in Box é uma rede de fast-food de comida chinesa, inaugurada em 1992 no bairro paulistano de Moema por Robinson Shiba e presente em várias cidades do Brasil", "chinainbox");
        Franchise franchiseFour = new Franchise("Habib's", "Habib's é uma rede brasileira de restaurantes de comida rápida, especializada em culinária árabe. A rede vende mais de 600 milhões de esfirras por ano", "habibs");

        Restaurant restaurantOne = new Restaurant("Restaurante 1");
        Restaurant restaurantTwo = new Restaurant("Restaurante 2");
        Restaurant restaurantThree = new Restaurant("Restaurante 3");
        Restaurant restaurantFour = new Restaurant("Restaurante 4");

        franchiseOne.addRestaurant(restaurantOne);
        franchiseOne.addRestaurant(restaurantTwo);

        franchiseTwo.addRestaurant(restaurantTwo);
        franchiseThree.addRestaurant(restaurantThree);
        franchiseFour.addRestaurant(restaurantFour);

        this.franchises.add(franchiseOne);
        this.franchises.add(franchiseTwo);
        this.franchises.add(franchiseThree);
        this.franchises.add(franchiseFour);

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

}