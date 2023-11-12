package design.singleton;

/**
 * 静态内部类实现单例
 * 加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。
 * 懒加载且线程安全
 * （1）为什么这样实现就是单例的？
 * 因为这个类的实例化是靠静态内部类的静态常量实例化的。
 * INSTANCE 是常量，因此只能赋值一次；它还是静态的，因此随着内部类一起加载。
 * （2）这样实现有什么好处？
 * 我记得以前接触的懒汉式的代码好像有线程安全问题，需要加同步锁才能解决。
 * 采用静态内部类实现的代码也是懒加载的，只有第一次使用这个单例的实例的时候才加载；
 * 同时不会有线程安全问题
 **/
public class StaticInnerClassSingleton {
    //1.私有化构造器
    private StaticInnerClassSingleton() {
    }
    //对外提供公共的方法获取单例对象

    public static StaticInnerClassSingleton getInstance() {
        return staticInnerClassSingletonHandler.staticInnerClassSingleton;
    }

    //2.写一个静态内部类,实例化外部类
    private static class staticInnerClassSingletonHandler {
        public static final StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static void main(String[] args) {
        //    staticInnerClassSingletonHandler staticInnerClassSingletonHandler = new staticInnerClassSingletonHandler();
        // System.out.println("1111");
        System.out.println(StaticInnerClassSingleton.getInstance());
        System.out.println(StaticInnerClassSingleton.getInstance());
        System.out.println(StaticInnerClassSingleton.getInstance());
        System.out.println(StaticInnerClassSingleton.getInstance());
    }

}
