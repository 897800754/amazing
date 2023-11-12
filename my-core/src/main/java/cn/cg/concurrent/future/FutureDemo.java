package cn.cg.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: cg
 * @date: 2023-03-23 17:51
 **/
public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> stringFutureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "" + System.currentTimeMillis();
            }
        });

        Thread thread = new Thread(stringFutureTask);

        thread.start();

        thread.join();

        System.out.println("----------------" + stringFutureTask.get());
    }
}
