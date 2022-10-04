package design.strategy.bank;

public class Demo {
    //薪水税
    private static final Double SALARY_TAX = 0.1D;
    //奖金税
    private static final Double BONUS_TAX = 0.2D;

    public static void main(String[] args) {
        Double salary = 10_000D;
        Double bonus = 2_000D;
        Bank bank = new Bank((s, b) -> {
            return (s - s * SALARY_TAX) + (b - b * BONUS_TAX);
        }, salary, bonus);
        System.out.println(bank.getFinalSalary());
    }
}
