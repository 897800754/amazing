package design.observer.original;

/**
 * 公告板
 */
public class CurrentConditions {
    //温度
    private float temperature;
    //气压
    private float pressure;
    //湿度
    private float humidity;

    public CurrentConditions() {
    }

    public CurrentConditions(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public void display() {
        System.out.println(temperature);
        System.out.println(pressure);
        System.out.println(humidity);
    }

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
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

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }


}
