package design.v2.architectural.facade.demo1;

import java.util.Arrays;

public abstract class DwarvenMineWorker {

    public void goToSleep() {
        System.out.printf("%s goes to sleep.", name());
    }

    public void wakeUp() {
        System.out.printf("%s wakes up.", name());
    }

    public void goHome() {
        System.out.printf("%s goes home.", name());
    }

    public void goToMine() {
        System.out.printf("%s goes to the mine.", name());
    }

    private void action(Action action) {
        switch (action) {
            case GO_TO_SLEEP:
                goToSleep();
                break;
            case WAKE_UP:
                wakeUp();
                break;
            case GO_HOME:
                goHome();
                break;
            case GO_TO_MINE:
                goToMine();
                break;
            case WORK:
                work();
                break;
            default:
                System.out.println("Undefined action");
                break;
        }
    }

    public void action(Action... actions) {
        Arrays.stream(actions).forEach(this::action);
    }

    public abstract void work();

    public abstract String name();

    enum Action {
        GO_TO_SLEEP, WAKE_UP, GO_HOME, GO_TO_MINE, WORK
    }
}







