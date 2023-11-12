package design.v2.behavioral.state.demo2;

/**
 * 接单状态
 */
public class OrderState implements LogisticsState {
    @Override
    public void doAction(JdLogistics context) {
        System.out.println("商家已经接单，正在处理中...");
    }
}
