package design.v2.behavioral.state.demo1;

/**
 * 生气状态
 */
public class AngryState implements State {

    private final Mammoth mammoth;

    public AngryState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    @Override
    public void observe() {
        System.out.printf("%s is furious! \r\n", mammoth);
    }

    @Override
    public void onEnterState() {
        System.out.printf("%s gets angry! \r\n", mammoth);
    }
}
