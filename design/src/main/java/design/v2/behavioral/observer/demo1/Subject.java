package design.v2.behavioral.observer.demo1;

/**
 * @author: cg
 * @date: 2022-10-08 23:52
 **/
public interface Subject {

    void addObserver(WeatherObserver obs);

    void removeObserver(WeatherObserver obs);

    void notifyObservers();

}
