package design.v2.behavioral.command.demo1;


/**
 * 目标
 */
public abstract class Target {

    private Size size;

    private Visibility visibility;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public abstract String toString();

    public void printStatus() {
        System.out.printf("%s, [size=%s] [visibility=%s] \r\n", this, getSize(), getVisibility());
    }
}
