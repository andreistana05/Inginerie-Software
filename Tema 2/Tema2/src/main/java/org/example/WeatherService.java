package org.example;

import java.util.ArrayList;
import java.time.LocalDate;

public class WeatherService {
    private ArrayList <WeatherStation> weatherStations;
    public WeatherService(ArrayList<WeatherStation> weatherStations) throws InvalidInputException {
        if (weatherStations == null || weatherStations.isEmpty()){
            throw new InvalidInputException("Station list cannot be empty.");
        }
        this.weatherStations = weatherStations;
    }
    public void weeklyAnalysis(WeatherStation weatherStation) {
            ArrayList<Weather> history = weatherStation.getHistory();
            if(history.isEmpty()) {
                System.out.println("No weather records for weather station: " + weatherStation);
                return;
            }
            double minTemp = Double.MAX_VALUE;
            double maxTemp = Double.MIN_VALUE;
            double sum = 0.0;
            int count = 0;
            LocalDate currentDate = LocalDate.now();
            LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
            for(Weather weather : history){
                if(weather.getDate().isAfter(sevenDaysAgo)) {
                    if (weather.getTemperature() < minTemp)
                        minTemp = weather.getTemperature();
                    if (weather.getTemperature() > maxTemp)
                        maxTemp = weather.getTemperature();
                    sum += weather.getTemperature();
                    count++;
                }
            }
            if(count == 0)
                System.out.println("No weather in the last 7 days");
            double averageTemp = sum/count;
            System.out.println("Average temperature: " + averageTemp);
            System.out.println("Lowest temperature: " + minTemp);
            System.out.println("Highest temperature: " + maxTemp);
        }
    public void predictWeather(WeatherStation weatherStation){
        ArrayList<Weather> history = weatherStation.getHistory();
        if (history.size() < 2){
            System.out.println("Not enough data for predicting the weather.");
            return;
        }
        System.out.println("Weather prediction for weather station located in: " + weatherStation.getLocation());
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
    public WeatherStation getNearestWeatherStation(User user) throws InvalidInputException {
        return getNearestWeatherStation(user.getLocation());
    }
    public WeatherStation getNearestWeatherStation(Location location) throws InvalidInputException {
        if(location == null)
            throw new InvalidInputException("Location cannot be null");

        WeatherStation nearest = null;
        double minDistance = Double.MAX_VALUE;
        for(WeatherStation station : weatherStations){
            double distance = Math.pow((location.getLatitude() - station.getLocation().getLatitude()),2)
                    + Math.pow((location.getLongitude() - station.getLocation().getLongitude()),2);
            if(distance < minDistance) {
                minDistance = distance;
                nearest = station;
            }
        }
        return nearest;
    }
}
