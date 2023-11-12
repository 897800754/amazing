package design.factory.simpleFactory;

/**
 * @author Administrator
 * @title: 简单工厂模式
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2611:28
 */
public class FruitFactory {
    public static Fruit getFruit(String type) {
        try {
            return (Fruit) Class.forName(type).newInstance();
        } catch (Exception e) {
            System.out.println("无法获取: " + type);
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Fruit apple = FruitFactory.getFruit("cn.cg.factory.simpleFactory.Apple");
        apple.getFruit();
    }
}
