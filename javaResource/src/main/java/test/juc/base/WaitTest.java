package test.juc.base;

/**
 * @author: cg1
 * @date: 2021-07-25 18:15
 **/
public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(100);
        synchronized (WaitTest.class) {
            WaitTest.class.notifyAll();
        }

    }


    public static synchronized void test() throws InterruptedException {
        System.out.println("1");
        WaitTest.class.wait();
        System.out.println("2");
    }
}
