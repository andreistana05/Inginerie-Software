package org.example;

public class AlertSystem {
    public void checkConditions(Weather weather){
        if(weather.getTemperature() > 30)
            System.out.println("Warning! Temperature over 30 degrees Celsius!");
        else if (weather.getTemperature() < 0)
            System.out.println("Warning! Temperature under 0 degrees Celsius!");
        if(weather.getHumidity() > 80)
            System.out.println("Warning! Air humidity is over 80%, it's very likely to rain!");
    }
}
