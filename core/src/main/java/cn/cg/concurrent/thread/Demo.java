package cn.cg.concurrent.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: cg
 * @date: 2023-03-24 10:52
 **/
public class Demo {

    private static AtomicInteger param = new AtomicInteger(0);

    private static Integer param1 = 1;


    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    param1++;
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(param1 == 10000);
    }

    private static void test1() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    param.addAndGet(1);
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(param.get() == 10000);
    }
}
