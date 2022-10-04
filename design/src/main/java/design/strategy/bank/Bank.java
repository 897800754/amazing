package design.strategy.bank;

public class Bank {

    private Double salary;
    private Double bonus;
    //计算最终薪水接口,
    private Calculate calculate;

    public Bank(Calculate calculate, Double salary, Double bonus) {
        this.calculate = calculate;
        this.salary = salary;
        this.bonus = bonus;
    }

    public Double getFinalSalary() {
        if (calculate != null) {
            return calculate.getSalary(salary, bonus);
        }
        return null;
    }

}
