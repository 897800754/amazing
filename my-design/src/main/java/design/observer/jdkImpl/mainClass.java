package design.observer.jdkImpl;

import java.util.HashMap;
import java.util.Observable;

/**
 * @author Administrator
 * @title: mainClass
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2717:11
 */
public class mainClass {
    public static void main(String[] args) {
        //创建观察者
        CurrentConditions c1 = new CurrentConditions();
        CurrentConditions c2 = new CurrentConditions();
        CurrentConditions c3 = new CurrentConditions();
        //创建被观察对象
        Observable w = new WeatherData();
        w.addObserver(c1);
        w.addObserver(c2);
        w.addObserver(c3);
        HashMap<String, Float> map = new HashMap<>();
        map.put("temperature", 100f);
        map.put("pressure", 20f);
        map.put("humidity", 10f);
        ((WeatherData) w).wrapper(map);
    }
}
