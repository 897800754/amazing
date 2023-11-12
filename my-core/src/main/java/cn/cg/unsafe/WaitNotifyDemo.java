package cn.cg.unsafe;

/**
 * @author: cg
 * @date: 2023-03-21 16:58
 **/
public class WaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("-----阻塞线程-----");
            try {
                waitTest(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----阻塞线程结束-----");
        });

        thread.start();
        Thread.sleep(1000 * 5);
        waitTest(true);
        System.out.println("end");
    }

    public static synchronized void waitTest(boolean flag) throws InterruptedException {
        if (flag) {
            System.out.println("-----start notify-----");
            ParkDemo.class.notifyAll();
            System.out.println("-----end notify-----");
            return;
        }
        System.out.println("-----start wait-----");
        ParkDemo.class.wait();
        System.out.println("-----end wait-----");

    }
}
