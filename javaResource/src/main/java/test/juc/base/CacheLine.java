package test.juc.base;

import java.util.concurrent.CountDownLatch;

/**
 * @author: cg1
 * @date: 2021-04-01 16:08
 **/
public class CacheLine {

    /**
     * 超过了64字节
     */
    public static class T {
        public long p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
        public volatile long x;
        public long p11, p12, p13, p14, p15, p16;
    }

    /**
     * 未超过64字节
     */
    public static class T_slow {
        public volatile long x;
    }


    public static void main(String[] args) throws InterruptedException {
        int count = 100_000_000;
        //CountDownLatch countDownLatch = noUserCacheLine(count);
        CountDownLatch countDownLatch = userCacheLine(count);
        long start = System.currentTimeMillis();
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }

    private static CountDownLatch userCacheLine(int count) {
        T[] tArr = new T[2];
        tArr[0] = new T();
        tArr[1] = new T();
        //使用缓存行对齐
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            for (int count0 = 1; count0 < count; count0++) {
                tArr[0].x = ++tArr[0].x;
            }

            countDownLatch.countDown();
        });
        Thread t2 = new Thread(() -> {
            for (int count0 = 1; count0 < count; count0++) {
                tArr[1].x = ++tArr[1].x;
            }
            countDownLatch.countDown();
        });

        t1.start();
        t2.start();
        return countDownLatch;
    }

    private static CountDownLatch noUserCacheLine(int count) {
        T_slow[] tArr = new T_slow[2];
        tArr[0] = new T_slow();
        tArr[1] = new T_slow();
        //不使用缓存行对齐
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            for (int count0 = 1; count0 < count; count0++) {
                tArr[0].x = ++tArr[0].x;
            }

            countDownLatch.countDown();
        });
        Thread t2 = new Thread(() -> {
            for (int count0 = 1; count0 < count; count0++) {
                tArr[1].x = ++tArr[1].x;
            }
            countDownLatch.countDown();
        });

        t1.start();
        t2.start();
        return countDownLatch;
    }
}
