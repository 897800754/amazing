package cn.cg.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: cg
 * @date: 2023-03-24 15:39
 **/
public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(executorService);
        executorCompletionService.submit(() -> {
            Thread.sleep(1000);
            System.out.println("exec 1000ms");
            return 1000;
        });
        executorCompletionService.submit(() -> {
            Thread.sleep(2000);
            System.out.println("exec 2000ms");
            return 2000;
        });

        for (int i = 0; i < 2; i++) {
            Integer o = executorCompletionService.take().get();
            System.out.println(o);
        }
        executorService.shutdownNow();
    }
}
