package cn.cg.concurrent.lock;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 倒计时器
 *
 * @author: cg
 * @date: 2023-03-26 21:37
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int limit = 10;
        CountDownLatch countDownLatch = new CountDownLatch(limit);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> collect = Stream.iterate(0, n -> n + 1)
                .limit(limit)
                .map(x -> action(countDownLatch))
                .collect(Collectors.toList());

        collect.forEach(executorService::submit);
        System.out.println("before countDownLatch");
        countDownLatch.await();


        System.out.println("after countDownLatch");
        executorService.shutdown();
    }

    public static Callable<Integer> action(CountDownLatch countDownLatch) {

        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = new Random().nextInt(10) + 1;
                TimeUnit.SECONDS.sleep(i);
                System.out.println(Thread.currentThread() + ":" + i);
                countDownLatch.countDown();
                return i;
            }
        };
    }
}
