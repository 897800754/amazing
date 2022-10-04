package test.classLoader;

/**
 * final static 与static加载顺序
 */
public class Demo1 {
    public static Demo1 d = new Demo1();
    //准备阶段赋予i=1,
    //console:Demo1构造方法1
    //Demo1静态代码块
    public static final int i = 1;

    //准备阶段 i = 0
    //console:Demo1构造方法0
    //Demo1静态代码块
    // public static  int i;
    static {
        System.out.println("Demo1静态代码块");
    }

    public Demo1() {
        System.out.println("Demo1构造方法" + i);
    }

    public static void main(String[] args) {

    }

}
