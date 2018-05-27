package com.example.joao.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.zip.Inflater;

public class CreateNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_restaurant);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.navigation_create_new, menu);

        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_create_new_save:
                createNewRestaurantInstance();
                Intent intent_home = new Intent(this, MainActivity.class);
                startActivity(intent_home);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createNewRestaurantInstance() {
        AppDatabase db = AppDatabase.getAppDatabase(this);

        EditText name = (EditText)findViewById(R.id.activity_new_restaurant_name);
        EditText description = (EditText)findViewById(R.id.activity_new_restaurant_description);

        Restaurant restaurant = new Restaurant(
                name.getText().toString(),
                description.getText().toString()
        );

        try {
            db.restaurantDAO().insertAll(restaurant);
            Toast.makeText(this, name.getText().toString() + " criado!", Toast.LENGTH_LONG).show();
        } catch (Exception ignored) {
            Toast.makeText(this, "Não foi possível salvar", Toast.LENGTH_SHORT).show();
        }
    }
}