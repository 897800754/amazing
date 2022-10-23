package design.v2.behavioral.state.demo1;

/**
 * 状态interface
 */
public interface State {
    /**
     * 进入状态时
     */
    void onEnterState();

    /**
     * 看到
     */
    void observe();
}
