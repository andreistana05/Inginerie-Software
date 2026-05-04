package org.example;

import java.util.ArrayList;
import java.time.LocalDate;

public class WeatherStation {
    private ArrayList<Weather> history;
    private Location location;
    private AlertSystem alertSystem;
    public WeatherStation(Location location){
        this.location = location;
        this.history = new ArrayList<>();
        this.alertSystem = new AlertSystem();
    }
    public ArrayList<Weather> getHistory(){
        return history;
    }
    public Location getLocation(){
        return location;
    }
    public void updateHistory(double temperature, double humidity, double pressure, double dewPoint) throws InvalidInputException {
        Weather newWeather = new Weather(temperature, humidity, pressure, dewPoint, LocalDate.now());
        history.add(newWeather);
        System.out.println("New weather input added for: " + newWeather + ", in the " + this.location + " weather station.");
        alertSystem.checkConditions(newWeather);
    }
}
