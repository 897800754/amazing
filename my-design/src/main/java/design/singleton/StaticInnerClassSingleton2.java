package design.singleton;

/**
 * dcl导致的空指针异常
 */
public class StaticInnerClassSingleton2 {
    private static volatile StaticInnerClassSingleton2 s;
    private static Object object;

    private StaticInnerClassSingleton2() {

    }


    public static StaticInnerClassSingleton2 getStaticInnerClassSingleton2() {
        if (s == null) {
            synchronized (StaticInnerClassSingleton2.class) {
                if (s == null) {
                    //延长初始化
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /**
                     * 重点----------------jit或者jvm对代码重排序
                     *可能导致执行顺序的不一致,倘若是一下情况,加volatile进行解决!!!!!
                     *   s = new StaticInnerClassSingleton2();
                     *   StaticInnerClassSingleton2.object =new Object();
                     */
                    StaticInnerClassSingleton2.object = new Object();
                    s = new StaticInnerClassSingleton2();
                    return s;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                StaticInnerClassSingleton2 s =
                        StaticInnerClassSingleton2.getStaticInnerClassSingleton2();
                System.out.println(s.object.hashCode());
            }
            ).start();
        }
    }
}
