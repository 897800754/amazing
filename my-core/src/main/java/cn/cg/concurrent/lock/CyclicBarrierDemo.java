package cn.cg.concurrent.lock;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 循环屏障
 *
 * @author: cg
 * @date: 2023-03-26 21:37
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, ExecutionException {
        int limit = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(limit);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> collect = Stream.iterate(0, n -> n + 1)
                .limit(limit)
                .map(x -> action(cyclicBarrier))
                .collect(Collectors.toList());


        List<Future<Integer>> futures = executorService.invokeAll(collect);
        for (Future<Integer> future : futures) {
            System.out.println("future:" + future.get());
        }
        executorService.shutdown();
    }

    public static Callable<Integer> action(CyclicBarrier cyclicBarrier) {

        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = new Random().nextInt(10) + 1;
                TimeUnit.SECONDS.sleep(i);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread() + ":" + i);
                return i;
            }
        };
    }

}
