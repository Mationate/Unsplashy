package com.adacherSoft.unsplashy.models;

/**
 * Created by adacher on 10-07-17.
 */

public class Unsplash {

    private String color;
    private UnsplashUrl urls;
    private UnsplashUser user;

    public Unsplash() {
    }

    public UnsplashUrl getUrls() {
        return urls;
    }

    public void setUrls(UnsplashUrl urls) {
        this.urls = urls;
    }

    public UnsplashUser getUser() {
        return user;
    }

    public void setUser(UnsplashUser user) {
        this.user = user;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
