package design.observer.advanced;

/**
 * subject被依赖者接口
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
