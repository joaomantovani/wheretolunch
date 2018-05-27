package com.example.joao.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.TextView;

public class ShowRestaurantActivity extends AppCompatActivity {

    private Restaurant restaurant;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restaurant_detail);


        TextView name = (TextView) findViewById(R.id.card_restaurant_detail_name);
        name.setText(getIntent().getStringExtra("name"));

        TextView description = (TextView) findViewById(R.id.card_restaurant_detail_description);
        description.setText(getIntent().getStringExtra("description"));
    }
}