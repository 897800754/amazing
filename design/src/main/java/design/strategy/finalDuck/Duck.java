package design.strategy.finalDuck;

/**
 * @author Administrator
 * @title: Duck
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2711:32
 */
public abstract class Duck {
    private Fly fly;
    private Shout shout;

    public Duck() {

    }

    public Duck(Fly fly, Shout shout) {
        this.fly = fly;
        this.shout = shout;
    }

    public void fly() {
        if (fly != null) fly.show();
    }

    public void shout() {
        if (shout != null) shout.show();
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public Fly getFly() {
        return fly;
    }

    public void setShout(Shout shout) {
        this.shout = shout;
    }

    public Shout getShout() {
        return shout;
    }
}
