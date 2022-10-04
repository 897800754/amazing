package design.observer.advanced;


public class MainClass {
    public static void main(String[] args) {
        CurrentConditions c1 = new CurrentConditions();
        CurrentConditions c2 = new CurrentConditions();
        CurrentConditions c3 = new CurrentConditions();
        WeatherData weatherData = new WeatherData(23, 20, 20);
        weatherData.registerObserver(c1);
        weatherData.registerObserver(c2);
        weatherData.registerObserver(c3);
        weatherData.notifyObserver();
        weatherData.removeObserver(c1);
        weatherData.update(100, 100, 100);
    }
}
