package design.observer.jdkImpl;


import java.util.Observable;

/**
 * @author Administrator
 * @title: WeatherData
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2715:52
 */
public class WeatherData extends Observable {
    //温度
    private float temperature;
    //气压
    private float pressure;
    //湿度
    private float humidity;

    public void wrapper(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
