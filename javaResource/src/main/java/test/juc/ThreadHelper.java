package test.juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author: cg1
 * @date: 2021-08-10 10:34
 **/
public class ThreadHelper {


    public static <T> FutureTask<T> startThread(Callable<T> callable) {
        FutureTask<T> tFutureTask = new FutureTask<T>(callable);
        int i = new Random().nextInt(1000);
        Thread thread = new Thread(tFutureTask, "线程Id:" + i);
        thread.start();
        return tFutureTask;
    }

}
