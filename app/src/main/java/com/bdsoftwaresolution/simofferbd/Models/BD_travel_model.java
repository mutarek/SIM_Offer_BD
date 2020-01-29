package com.bdsoftwaresolution.simofferbd.Models;

public class BD_travel_model {
    private String title;
    private String desc;
    private String spot;
    private String img;

    public BD_travel_model() {
    }

    public BD_travel_model(String title, String desc, String spot, String img) {
        this.title = title;
        this.desc = desc;
        this.spot = spot;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
