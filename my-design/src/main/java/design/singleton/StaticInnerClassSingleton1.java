package design.singleton;

/**
 * dcl--double-check-locking
 * 可能会产生空指针异常
 * 原因:见StaticInnerClassSingleton2
 */
public class StaticInnerClassSingleton1 {
    private static StaticInnerClassSingleton1 s;

    private StaticInnerClassSingleton1() {


    }

    public static StaticInnerClassSingleton1 getStaticInnerClassSingleton1() {
        if (s == null) {
            synchronized (StaticInnerClassSingleton1.class) {
                if (s == null) s = new StaticInnerClassSingleton1();
            }
        }
        return s;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                StaticInnerClassSingleton1 s =
                        StaticInnerClassSingleton1.getStaticInnerClassSingleton1();
                System.out.println(s);
            }
            ).start();
        }
    }

}
