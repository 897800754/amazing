package test.classLoader;


class Grandpa1 {
    static {
        System.out.println("爷爷在静态代码块");
    }

    public Grandpa1() {
        System.out.println("我是爷爷~");
    }
}

class Father1 extends Grandpa1 {
    static {
        System.out.println("爸爸在静态代码块");
    }

    public Father1() {
        System.out.println("我是爸爸~");
    }
}

class Son1 extends Father1 {
    static {
        System.out.println("儿子在静态代码块");
    }

    public Son1() {
        System.out.println("我是儿子~");
    }
}

public class InitializationDemo2 {
    public static void main(String[] args) {
        new Son1(); //入口 }
    }
}
/**
 * 爷爷在静态代码块
 * 爸爸在静态代码块
 * 儿子在静态代码块
 * 我是爷爷~
 * 我是爸爸~
 * 我是儿子~
 * 1.  首先在入口这里我们实例化一个 Son 对象，因此会触发 Son 类的初始化，
 * 而 Son 类的初始化又会带动 Father 、Grandpa 类的初始化，
 * 从而执行对应类中的静态代码块。因此会输出：「爷爷在静态代码块」、「爸爸在静态代码块」、「儿子在静态代码块」。
 * 2.  当 Son 类完成初始化之后，便会调用 Son 类的构造方法
 * ，而 Son 类构造方法的调用同样会带动 Father、Grandpa 类构造方法的调用，
 * 最后会输出：「我是爷爷~」、「我是爸爸~」、「我是儿子~」。
 */
