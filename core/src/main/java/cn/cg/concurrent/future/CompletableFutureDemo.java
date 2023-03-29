package cn.cg.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: cg
 * @date: 2023-03-24 15:30
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("exec 1000ms");
            return 1000;
        }).thenApplyAsync((res) -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("exec 2000ms");
            return 2000;
        }).whenComplete((res, exception) -> {
            System.out.println("whenComplete:" + res);
        });
        System.out.println(future.get());
    }
}
