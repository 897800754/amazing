package design.v2.behavioral.observer.demo1;

public class Hobbits implements WeatherObserver {

    @Override
    public void update(WeatherType currentWeather) {
        System.out.println("The hobbits are facing " + currentWeather.getDescription() + " weather now");
    }
}
