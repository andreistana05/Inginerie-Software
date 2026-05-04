package org.example;

import java.time.LocalDate;

public class Weather {
    private double temperature;
    private double humidity;
    private double pressure;
    private double dewPoint;
    private LocalDate date;
    public Weather(double temperature, double humidity, double pressure, double dewPoint, LocalDate date) throws InvalidInputException{
        if(humidity < 0 || humidity > 100)
            throw new InvalidInputException("Humidity must be between 0 and 100.");
        this.dewPoint = dewPoint;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.date = date;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getHumidity(){
        return humidity;
    }
    public void setHumidity(double humidity){
        this.humidity = humidity;
    }
    public double getPressure(){
        return pressure;
    }
    public void setPressure(double pressure){
        this.pressure = pressure;
    }
    public double getDewPoint(){
        return dewPoint;
    }
    public void setDewPoint(double dewPoint){
        this.dewPoint = dewPoint;
    }
    public LocalDate getDate(){
        return date;
    }
    @Override
    public String toString(){
        return String.format("Temperature: %.1f, humidity: %.1f, pressure: %.1f", temperature, humidity, pressure);
    }

}
