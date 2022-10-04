package design.strategy.finalDuck;

/**
 * 鸭子项目最终版
 */
public class MainClass {
    public static void main(String[] args) {
        /*Duck greenHeadDuck = new GreenHeadDuck();
        greenHeadDuck.setFly(()->{
            System.out.println("飞...");
        });
        greenHeadDuck.setShout(()->{
            System.out.println("叫...");
        });
        greenHeadDuck.fly();
        greenHeadDuck.shout();*/
        Duck greenHeadDuck = new GreenHeadDuck();
        greenHeadDuck.setFly(new FastFly());
        greenHeadDuck.fly();

    }
}
