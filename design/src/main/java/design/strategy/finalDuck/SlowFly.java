package design.strategy.finalDuck;

/**
 * @author Administrator
 * @title: SlowFly
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2711:43
 */
public class SlowFly implements Fly {
    @Override
    public void show() {
        System.out.println("慢慢地飞");
    }
}
