package design.factory.abstractFactory;

/**
 * @author Administrator
 * @title: ClassMain
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2618:01
 */
public class ClassMain {
    public static void main(String[] args) {
        FruitFactory ff = new NorthFactory();
        ff.getApple().getFruit();
    }
}
