package org.example;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) throws InvalidInputException {
        WeatherStation ws1 = new WeatherStation(new Location(45.75, 21.23, "Timisoara"));
        WeatherStation ws2 = new WeatherStation(new Location(44.43, 26.10, "Bucuresti"));
        WeatherStation ws3 = new WeatherStation(new Location(46.77, 23.60, "Cluj"));

        ws1.updateHistory(31.0, 90, 1013.25, 10);
        ws1.updateHistory(29.5, 75, 1011.00, 12);
        ws2.updateHistory(25.0, 50, 1015.00, 8);

        ArrayList<WeatherStation> stations = new ArrayList<>();
        stations.add(ws1); stations.add(ws2); stations.add(ws3);

        WeatherService service = new WeatherService(stations);

        User user = new User("Andrei", new Location(45.80, 21.30, "Timisoara"));
        WeatherStation nearest = service.getNearestWeatherStation(user);
        System.out.println("Nearest station: " + nearest.getLocation());

        service.weeklyAnalysis(ws1);
        service.predictWeather(ws1);
    }
}
