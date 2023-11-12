package cn.cg.unsafe;

/**
 * @author: cg
 * @date: 2023-03-21 16:38
 **/
public class ParkDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("-----阻塞线程-----");
//            LockSupport.park();
            UnSafeUtils.getUnsafe().park(false, 0);
            System.out.println("-----阻塞线程结束-----");
        });
        thread.start();
        Thread.sleep(1000 * 5);
        UnSafeUtils.getUnsafe().unpark(thread);

        System.out.println("end");
    }

}
