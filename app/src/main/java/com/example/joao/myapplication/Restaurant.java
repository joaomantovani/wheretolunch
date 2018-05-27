package com.example.joao.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String description;
    private int photoId;
    private String address;

    private List<Restaurant> restaurantList;

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Restaurant(String name, String description, int photoId, String address) {
        this.name = name;
        this.description = description;
        this.photoId = photoId;
        this.address = address;
    }

    private void initializeData(){
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Aulus"));
        restaurantList.add(new Restaurant("Bardana"));
        restaurantList.add(new Restaurant("Casa da Muqueca"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
