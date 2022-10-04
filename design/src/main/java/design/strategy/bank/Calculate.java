package design.strategy.bank;

@FunctionalInterface
public interface Calculate {
    public Double getSalary(Double salary, Double bonus);

}
