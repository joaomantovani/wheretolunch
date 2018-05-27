package com.example.joao.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RestaurantDao {

    @Query("select * from restaurant")
    List<Restaurant> getAll();

    @Query("select * from restaurant where name like :restaurantName")
    Restaurant findByName(String restaurantName);

    @Query("select COUNT(*) from restaurant")
    int countRestaurants();

    @Insert
    void insertAll(Restaurant... restaurants);

    @Delete
    void delete(Restaurant restaurant);
}
