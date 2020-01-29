package com.bdsoftwaresolution.simofferbd.Models;

import com.google.firebase.firestore.Exclude;

public class HotelsModel {
    private String hotelID;
    private String Name;
    private String Picture;
    private Double Rating;
    private int Cost;
    private boolean Room_Exist;
    private String Address;


    public HotelsModel() {
    }

    public HotelsModel(String name, String picture, Double rating, int cost, boolean room_Exist, String address) {
        Name = name;
        Picture = picture;
        Rating = rating;
        Cost = cost;
        Room_Exist = room_Exist;
        Address = address;
    }

    @Exclude
    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public boolean isRoom_Exist() {
        return Room_Exist;
    }

    public void setRoom_Exist(boolean room_Exist) {
        Room_Exist = room_Exist;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
