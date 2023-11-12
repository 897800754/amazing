package cn.cg.unsafe;

public class Target {
    private String name = "张三";

    private Target() {

    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }
}
