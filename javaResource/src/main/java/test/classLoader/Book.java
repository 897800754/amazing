package test.classLoader;

public class Book {
    public static void main(String[] args) {
        System.out.println("Hello ShuYi.");
    }

    Book() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    {
        System.out.println("书的普通代码块");
    }

    int price = 110;

    static {
        System.out.println("书的静态代码块");
    }

    static int amount = 112;
}
/**
 * 书的静态代码块
 * Hello ShuYi.
 * 首先根据上面说到的触发初始化的5种情况的第4种（当虚拟机启动时
 * ，用户需要指定一个要执行的主类（包含main()方法的那个类），
 * 虚拟机会先初始化这个主类），我们会进行类的初始化。
 * <p>
 * 在我们代码中，我们只知道有一个构造方法，但实际上Java代码编译成字节码之后，
 * 是没有构造方法的概念的，只有类初始化方法 和 对象初始化方法 。
 * 类初始化方法。编译器会按照其出现顺序，收集类变量的赋值语句、静态代码块，
 * 最终组成类初始化方法。类初始化方法一般在类初始化的时候执行。
 * PS:类构造器(初始化类变量,静态代码块)
 */
