package design.observer.original;

/**
 * 气象站
 */
public class WeatherData {
    //温度
    private float temperature;
    //气压
    private float pressure;
    //湿度
    private float humidity;

    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public void dataChange(float temperature, float pressure, float humidity) {
        currentConditions.update(temperature, pressure, humidity);
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public Float getTemperature() {
        return temperature;
    }
}
