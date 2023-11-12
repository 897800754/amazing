package design.factory.abstractFactory;


public class NorthApple extends Apple implements Fruit {
    @Override
    public void getFruit() {
        System.out.println(NorthApple.class.getName());
    }
}
