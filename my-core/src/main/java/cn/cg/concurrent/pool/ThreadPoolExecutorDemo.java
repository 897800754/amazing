package cn.cg.concurrent.pool;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: cg
 * @date: 2023-03-25 18:11
 **/
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> callables = Stream.iterate(0, n -> n + 5)
                .limit(3)
                .map(x -> new Callable<Integer>() {

                    @Override
                    public Integer call() throws Exception {
                        TimeUnit.SECONDS.sleep(x);
                        System.out.println("callable:" + x);
                        return x;
                    }
                }).collect(Collectors.toList());

        System.out.println("invokeAll执行前当前时间" + LocalDateTime.now());
        //所有future为NORMAL,才返回
//        List<Future<Integer>> futures = executorService.invokeAll(callables);
        List<Future<Integer>> futures = executorService.invokeAll(callables);
        System.out.println("invokeAll执行后当前时间" + LocalDateTime.now());
        for (Future<Integer> future : futures) {
            System.out.println("获取结果" + future.get());
        }
        executorService.shutdown();

    }
}
