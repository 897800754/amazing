package test.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: cg1
 * @date: 2021-07-25 19:44
 **/
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    /**
     * 3
     * 1
     * 2
     * 4
     *
     * @throws InterruptedException
     */
    private static void test1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("3");
            /**
             * blocker是用来记录线程被阻塞时被谁阻塞的。用于线程监控和分析工具来定位原因的。
             * setBlocker(t, blocker)方法的作用是记录t线程是被broker阻塞的。因此我们只关注最核心的方法，也就是UNSAFE.park(false, 0L)。
             *
             * UNSAFE是一个非常强大的类，他的的操作是基于底层的，也就是可以直接操作内存，因此我们从JVM的角度来分析一下：
             */
            LockSupport.park();
            System.out.println("4");
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        LockSupport.unpark(thread);
        System.out.println("2");
    }
}
