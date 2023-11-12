package design.v2.architectural.facade.demo1;

public class DwarvenGoldDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.printf("%s digs for gold.", name());
    }

    @Override
    public String name() {
        return "Dwarf gold digger";
    }
}
