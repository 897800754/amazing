package design.v2.architectural.facade.demo1;


import java.util.ArrayList;
import java.util.Collection;

/**
 * @author chengang
 */
public class DwarvenGoldmineFacade {

    private final ArrayList<DwarvenMineWorker> workers;

    public DwarvenGoldmineFacade() {
        workers = new ArrayList<DwarvenMineWorker>() {
            {
                this.add(new DwarvenGoldDigger());
                this.add(new DwarvenCartOperator());
                this.add(new DwarvenTunnelDigger());
            }
        };
    }

    public void startNewDay() {
        makeActions(workers, DwarvenMineWorker.Action.WAKE_UP, DwarvenMineWorker.Action.GO_TO_MINE);
    }

    public void digOutGold() {
        makeActions(workers, DwarvenMineWorker.Action.WORK);
    }

    public void endDay() {
        makeActions(workers, DwarvenMineWorker.Action.GO_HOME, DwarvenMineWorker.Action.GO_TO_SLEEP);
    }

    private static void makeActions(Collection<DwarvenMineWorker> workers,
                                    DwarvenMineWorker.Action... actions) {
        workers.forEach(worker -> worker.action(actions));
    }
}
