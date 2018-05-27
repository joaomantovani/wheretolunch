package com.example.joao.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "restaurant")
public class Restaurant {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "photo_id")
    private int photoId;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "acceptedTicked")
    private boolean acceptedTicket;

    public Restaurant(String name) {
        this.name = name;
    }

    @Ignore
    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Ignore
    public Restaurant(String name, String description, boolean acceptedTicket) {
        this.name = name;
        this.description = description;
        this.acceptedTicket = acceptedTicket;
    }

    @Ignore
    public Restaurant(String name, String description, int photoId, String address) {
        this.name = name;
        this.description = description;
        this.photoId = photoId;
        this.address = address;
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

    public boolean isAcceptedTicket() {
        return acceptedTicket;
    }

    public void setAcceptedTicket(boolean acceptedTicket) {
        this.acceptedTicket = acceptedTicket;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
