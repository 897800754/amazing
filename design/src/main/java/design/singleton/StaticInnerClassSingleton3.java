package design.singleton;

/**
 * 静态内部类--单例模式复习
 */
public class StaticInnerClassSingleton3 {
    private StaticInnerClassSingleton3() {
    }

    private static class StaticInnerClassSingleton3Inner {
        private static final StaticInnerClassSingleton3 s = new StaticInnerClassSingleton3();
    }

    public static StaticInnerClassSingleton3 getStaticInnerClassSingleton3() {
        return StaticInnerClassSingleton3Inner.s;
    }

    /**
     * 这是非懒加载,因为main函数在该方法内部
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                StaticInnerClassSingleton3 s =
                        StaticInnerClassSingleton3.getStaticInnerClassSingleton3();
                System.out.println(s);
            }
            ).start();
        }
    }
}
