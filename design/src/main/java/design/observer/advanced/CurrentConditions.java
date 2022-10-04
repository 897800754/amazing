package design.observer.advanced;

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

    @Override
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

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

}
