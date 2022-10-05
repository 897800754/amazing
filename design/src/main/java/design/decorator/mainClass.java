package design.decorator;

/**
 * @author Administrator
 * @title: mainClass
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2723:56
 */
public class mainClass {
    public static void main(String[] args) {
        LongBlack longBlack = new LongBlack("黑咖啡", 50f, "热");
        //对黑咖啡进行装饰--加奶
        Mike mike = new Mike(longBlack, 20f);
        //加巧克力
        Chocolate c1 = new Chocolate(mike, 20f);
        //再巧克力
        Chocolate c2 = new Chocolate(c1, 20f);
        System.out.println(c2.CostAll());
        System.out.println("==========================");
        System.out.println(new Chocolate(new Chocolate(new Mike(new LongBlack("黑咖啡", 50f, "热"), 20f), 20f), 20f).CostAll());
    }
}
