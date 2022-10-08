package design.v2.behavioral.observer.demo1;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Subject {

    private WeatherType currentWeather;
    private final List<WeatherObserver> observers;

    public Weather() {
        observers = new ArrayList<>();
        currentWeather = WeatherType.SUNNY;
    }

    @Override
    public void addObserver(WeatherObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(WeatherObserver obs) {
        observers.remove(obs);
    }

    /**
     * Makes time pass for weather.
     */
    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        System.out.printf("The weather changed to %s. \r\n", currentWeather);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver obs : observers) {
            obs.update(currentWeather);
        }
    }
}
