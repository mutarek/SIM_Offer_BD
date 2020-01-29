package com.bdsoftwaresolution.simofferbd;

public class HotelListModel {
    private String Name;
    private String Picture;
    private String Cost;
    private String Location;
    private String Address;

    public HotelListModel() {
    }

    public HotelListModel(String name, String picture, String cost, String location, String address) {
        Name = name;
        Picture = picture;
        Cost = cost;
        Location = location;
        Address = address;
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

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
