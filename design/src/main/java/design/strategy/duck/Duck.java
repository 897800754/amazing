package design.strategy.duck;

/**
 * 鸭子类的超类
 */
public abstract class Duck {
    //鸭子会叫
    public void shout() {
        System.out.println("鸭子叫");
    }

    ;

    //鸭子会飞
    public void fly() {
        System.out.println("鸭子飞");
    }

    ;
}
