package classLoaderLearn;

/**
 * @author Administrator
 * @title: ada
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/7/1323:03
 */

public class Book1 {
    public static void main(String[] args) {
        staticFunction();
    }

    static Book book = new Book();

    static {
        System.out.println("书的静态代码块");
    }

    {
        System.out.println("书的普通代码块");
    }

    Book1() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    public static void staticFunction() {
        System.out.println("书的静态方法");
    }

    int price = 110;
    static int amount = 112;
}
/**
 * 1.book类中的main方法,所以初始化类变量
 * static Book book = new Book();
 * --创建book
 * {
 * System.out.println("书的普通代码块");
 * }
 * System.out.println("书的构造方法");
 * System.out.println("price=" + price + ",amount=" + amount);
 * <p>
 * static {
 * System.out.println("书的静态代码块");
 * }
 * System.out.println("书的静态方法");
 * 答案:书的普通代码块-1
 * int price = 110;
 * 书的构造方法-2
 * "price=" + 110 + ",amount=" + 0-3
 * 书的静态代码块-4
 * 书的静态方法-5
 * 结果分析(类构造器的概念):
 * 1.当 JVM 在准备阶段的时候，便会为类变量分配内存和进行初始化。
 * 此时，我们的 book 实例变量被初始化为 null，amount 变量被初始化为 0。
 * 2.当进入初始化阶段后，因为 Book 方法是程序的入口，
 * 根据我们上面说到的类初始化的五种情况的第四种（当虚拟机启动时，用户需要指定一个要执行的主类
 * （包含main()方法的那个类），虚拟机会先初始化这个主类）。
 * 所以JVM 会初始化 Book 类，即执行类构造器 。
 * 3.JVM 对 Book 类进行初始化首先是执行类构造器（按顺序收集类中所有静态代码块和类变量赋值语句就组成了
 * 类构造器 ），
 * 后执行对象的构造器（按顺序收集成员变量赋值和普通代码块，最后收集对象构造器，最终组成对象构造器 ）。
 */
