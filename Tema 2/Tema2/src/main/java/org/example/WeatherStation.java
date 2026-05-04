package org.example;

import java.util.ArrayList;
import java.time.LocalDate;

public class WeatherStation {
    private ArrayList<Weather> history;
    private double latitude;
    private double longitude;
    private AlertSystem alertSystem;
    public WeatherStation(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
        this.history = new ArrayList<>();
        this.alertSystem = new AlertSystem();
    }
    public void updateHistory(double temperature, double humidity, double pressure, double dewPoint){
        Weather newWeather = new Weather(temperature, humidity, pressure, dewPoint, LocalDate.now());
        history.add(newWeather);
        System.out.println("New weather input added for: " + newWeather + ", in the " + this.latitude + ", " + this.longitude + " weather station.");
        alertSystem.checkConditions(newWeather);
    }
    public void weeklyAnalysis(){
        if (history.isEmpty())
            return;
        double minTemp = Double.MAX_VALUE;
        double maxTemp = Double.MIN_VALUE;
        double sum = 0.0;
        int count = 0;
        LocalDate currentDate = LocalDate.now();
        LocalDate sevenDaysAgo = currentDate.minusDays(7);
        for(Weather weather: history){
            if(weather.getDate().isAfter(sevenDaysAgo)){
                if(weather.getTemperature() < minTemp)
                    minTemp = weather.getTemperature();
                if(weather.getTemperature() > maxTemp)
                    maxTemp = weather.getTemperature();
            sum += weather.getTemperature();
            count++;
            }
        }
        if (count == 0) {
            System.out.println("No weather recordings in the last 7 days.");
            return;
        }
        double avgTemp = sum/count;
        System.out.println("Location: " +  this.latitude + ", " + this.longitude);
        System.out.println("Average temperature: " + avgTemp);
        System.out.println("Minimum temperature: " + minTemp + ", maximum temperature: " + maxTemp);

    }
    public void predictWeather(){
        if (history.size() < 2){
            System.out.println("Not enough data for predicting the weather.");
            return;
        }
        System.out.println("Weather prediction for weather station located in: " + this.latitude + ", " + this.longitude);
        Weather last = history.get(history.size()-1);
        Weather prev = history.get(history.size()-2);
        double pressureDiff = last.getPressure() - prev.getPressure();
        if(pressureDiff < -2.0)
            System.out.println("There is a storm coming (sudden pressure drop).");
        else if(pressureDiff > 2.0)
            System.out.println("Weather is getting nicer.");
        else
            System.out.println("Stable meteorological conditions.");
    }
}
