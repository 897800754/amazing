package cn.cg.concurrent.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: cg
 * @date: 2023-03-25 15:59
 **/
public class ScheduleThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());


        executor.schedule(() -> {
            System.out.println("hi !");
        }, 10, TimeUnit.SECONDS);

    }
}
