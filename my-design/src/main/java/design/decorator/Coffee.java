package design.decorator;

/**
 * 饮料类的超类
 */
public abstract class Coffee extends Drink {
    //热的还是冷的
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
