package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WeatherStation weatherStation1 = new WeatherStation(45.5, 40.5);
        WeatherStation weatherStation2 = new WeatherStation(42.5, 42.7);
        WeatherStation weatherStation3 = new WeatherStation(40.5, 45.9);
        weatherStation1.updateHistory(30.5, 90, 1013.25, 10);
        weatherStation1.updateHistory(29.5, 85, 1013.25, 15);
        weatherStation2.updateHistory(25, 50, 1013.25, 16);
        weatherStation3.updateHistory(26,95, 1013.25, 5.6);
        weatherStation2.updateHistory(27,70, 1013.25, 12.5);
        weatherStation1.weeklyAnalysis();
        weatherStation1.predictWeather();
    }
}
