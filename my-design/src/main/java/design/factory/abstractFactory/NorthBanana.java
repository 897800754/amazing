package design.factory.abstractFactory;

/**
 * @author Administrator
 * @title: Banana
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2611:27
 */
public class NorthBanana extends Banana implements Fruit {
    @Override
    public void getFruit() {
        System.out.println(NorthApple.class.getName());
    }
}
