package design.factory.factoryMethod;

/**
 * @author Administrator
 * @title: AppleFactory
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2616:04
 */
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit createFruitFactoryImpl() {
        return new Apple();
    }
}
