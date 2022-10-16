package design.v2.behavioral.state.demo2;

/**
 * 出库状态类
 */
public class ProductOutState implements LogisticsState {
    @Override
    public void doAction(JdLogistics context) {
        System.out.println("商品已经出库...");
    }
}
