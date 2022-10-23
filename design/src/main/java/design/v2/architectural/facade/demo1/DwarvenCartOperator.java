package design.v2.architectural.facade.demo1;

public class DwarvenCartOperator extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.printf("%s moves gold chunks out of the mine.", name());
    }

    @Override
    public String name() {
        return "Dwarf cart operator";
    }
}
