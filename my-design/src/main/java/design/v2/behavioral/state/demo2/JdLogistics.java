package design.v2.behavioral.state.demo2;

import java.util.Objects;

public class JdLogistics {
    private LogisticsState logisticsState;

    public void setLogisticsState(LogisticsState logisticsState) {
        this.logisticsState = logisticsState;
    }

    public LogisticsState getLogisticsState() {
        return logisticsState;
    }

    public void doAction() {
        Objects.requireNonNull(logisticsState);
        logisticsState.doAction(this);
    }
}
