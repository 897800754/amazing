package cn.cg.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: cg
 * @date: 2023-02-17 00:05
 **/
public class Lock1 {

    private static Integer i = 0;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        ReentrantLock reentrantLock = new ReentrantLock();

        int count = 0;

        ArrayList<Future> futures = new ArrayList<>();

        List<? extends Future<?>> collect = Stream
                .iterate(0, n -> n + 1)
                .limit(1000)
                .map(x -> {
                    Future<?> submit = executorService.submit(() -> {
                        reentrantLock.lock();
                        i++;
                        reentrantLock.unlock();
                    });
                    return submit;
                }).collect(Collectors.toList());

        while (true) {
            if (collect.stream().allMatch(Future::isDone)) {
                System.out.println("结果为" + i);
                break;
            } else {
                TimeUnit.SECONDS.sleep(1);
            }
        }
        executorService.shutdownNow();
    }
}
