package design.factory.simpleFactory;

/**
 * @author Administrator
 * @title: Apple
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2611:26
 */
public class Apple implements Fruit {
    @Override
    public void getFruit() {
        System.out.println("获取苹果");
    }

    public void show() {
        System.out.println("苹果是甜的");
    }
}
