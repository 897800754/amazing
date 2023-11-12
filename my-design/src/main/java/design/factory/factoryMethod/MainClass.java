package design.factory.factoryMethod;

/**
 * @author Administrator
 * @title: MainClass
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2616:14
 */
public class MainClass {
    public static void main(String[] args) {
        FruitFactory appleFactory = new AppleFactory();
        Fruit a = appleFactory.createFruitFactoryImpl();
        a.getFruit();
    }
}
