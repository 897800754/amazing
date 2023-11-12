package design.decorator;

/**
 * 饮料类与调料类的共同父类
 */
public abstract class Drink {
    private String desc;
    private Float cost;

    public String getDesc() {
        return desc + " : " + cost + " & ";
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float CostAll() {
        return this.getCost();
    }
}
