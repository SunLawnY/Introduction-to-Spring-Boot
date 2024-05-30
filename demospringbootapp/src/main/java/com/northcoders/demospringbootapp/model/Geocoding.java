package com.northcoders.demospringbootapp.model;

public class Geocoding {
    String name;
    double latitude;
    double longitude;

    public Geocoding(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
