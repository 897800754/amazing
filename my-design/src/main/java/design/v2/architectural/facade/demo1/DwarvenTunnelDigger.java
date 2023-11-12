package design.v2.architectural.facade.demo1;

public class DwarvenTunnelDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        System.out.printf("%s creates another promising tunnel.", name());
    }

    @Override
    public String name() {
        return "Dwarven tunnel digger";
    }
}
