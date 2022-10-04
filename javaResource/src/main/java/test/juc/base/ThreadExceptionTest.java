package test.juc.base;

import java.util.concurrent.TimeUnit;

/**
 * 设置3个线程，线程名分别为ABC，按照ABC的顺序打印，重复20遍
 *
 * @author: cg1
 * @date: 2021-06-08 18:42
 **/
public class ThreadExceptionTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("123");
        }, "线程1");
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("thread:" + t.getName());
            System.out.println("exception:" + e.toString());
        });
        thread.start();
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
