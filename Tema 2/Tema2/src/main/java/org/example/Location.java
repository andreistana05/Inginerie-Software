package org.example;

public class Location {
    private double latitude;
    private double longitude;
    private String city;
    public Location(double latitude, double longitude, String city) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }
    @Override
    public String toString(){
        return this.latitude + " " + this.longitude + " " + this.city;
    }
    public double getLatitude(){
        return latitude;
    }
    public double getLongitude(){
        return longitude;
    }
    public String getCity(){
        return city;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public void setCity(String city){
        this.city = city;
    }
}

