package design.observer.jdkImpl;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * 公告栏
 */
public class CurrentConditions implements Observer {
    //温度
    private float temperature;
    //气压
    private float pressure;
    //湿度
    private float humidity;

    public CurrentConditions() {
    }

    public void display() {
        System.out.println(temperature);
        System.out.println(pressure);
        System.out.println(humidity);
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    @Override
    public void update(Observable o, Object arg) {
        HashMap<String, Float> map = (HashMap<String, Float>) arg;
        this.temperature = map.get("temperature");
        this.pressure = map.get("pressure");
        this.humidity = map.get("humidity");
        display();
    }
}
