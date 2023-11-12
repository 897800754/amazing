package design.decorator;

/**
 * 调料装饰
 */
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink, Float cost) {
        this.drink = drink;
        this.setCost(cost);
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;

    }

    @Override
    public Float CostAll() {
        return drink.CostAll() + this.getCost();
    }
}
