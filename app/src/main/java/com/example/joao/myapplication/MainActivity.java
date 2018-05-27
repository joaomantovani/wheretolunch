package com.example.joao.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabShuffle;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabShuffle = findViewById(R.id.fab_shuffle_restaurants);

        mRecyclerView = findViewById(R.id.restaurants_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //Layout Manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Aulus"));
        restaurantList.add(new Restaurant("Bardana"));
        restaurantList.add(new Restaurant("Casa da Muqueca"));
        restaurantList.add(new Restaurant("Burguer King"));
        restaurantList.add(new Restaurant("Armazém Nobre"));
        restaurantList.add(new Restaurant("Alzirão"));
        restaurantList.add(new Restaurant("Bandejão"));
        restaurantList.add(new Restaurant("Pepe Loco"));
        restaurantList.add(new Restaurant("Quinta do Barão"));
        restaurantList.add(new Restaurant("Barão Lanches"));
        restaurantList.add(new Restaurant("Dalbein"));

        //Specify an adapter
        mAdapter = new RestaurantAdapter(restaurantList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.navigation, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent intent_home = new Intent(this, MainActivity.class);
                startActivity(intent_home);
                return true;
            case R.id.navigation_configuration:
                Intent intent_configuration =
                        new Intent(this, ConfigurationActivity.class);
                startActivity(intent_configuration);
                return true;
            case R.id.navigation_credits:
                Intent intent_credits =
                        new Intent(this, CreditsActivity.class);
                startActivity(intent_credits);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        fabShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant restaurantSorted = restaurantList.get(new Random().nextInt(restaurantList.size()));

                Toast.makeText(
                        MainActivity.this,
                        "Sorteado: " + restaurantSorted.getName(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
