package cn.cg.concurrent.lock;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: cg
 * @date: 2023-03-26 21:53
 **/
public class SemaphoreDemo {
    public static Integer count = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int limit = 100000;
        Semaphore semaphore = new Semaphore(1);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> collect = Stream.iterate(0, n -> n + 1)
                .limit(limit)
                .map(x -> action(semaphore))
                .collect(Collectors.toList());


        executorService.invokeAll(collect);

        System.out.println("end:"+count);

        executorService.shutdown();
    }

    public static Callable<Integer> action(Semaphore semaphore) {

        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                semaphore.acquire();
                count++;
                semaphore.release();
                System.out.println("count:" + count);
                return count;
            }
        };
    }
}
