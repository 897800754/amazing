package design.observer.advanced;

import java.util.ArrayList;

/**
 * @author Administrator
 * @title: WeatherData
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2715:52
 */
public class WeatherData implements Subject {
    //温度
    private float temperature;
    //气压
    private float pressure;
    //湿度
    private float humidity;
    //存储Observers
    ArrayList<Observer> observerList = new ArrayList<Observer>();

    public WeatherData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observerList.contains(observer)) observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(temperature, pressure, humidity);
            System.out.println("-------------------------");
        }
    }

    //更新完毕,通知
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObserver();
    }

}
