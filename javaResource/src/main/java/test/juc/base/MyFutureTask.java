package test.juc.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: cg1
 * @date: 2020-10-07 00:13
 **/
public class MyFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(() -> {
            System.out.println("threadName:" + Thread.currentThread().getName());
            Thread.sleep(5_000);
            return 1;
        });
        //尝试多线程去跑同一段代码,run()方法会进行cas,保证只有一根线程执行,另外一根线程直接被return
        Thread myThread = new Thread(task, "myThread");
        Thread myThread1 = new Thread(task, "myThread1");
        myThread.start();
        myThread1.start();
        //当前main线程进行get操作,如果是多线程进行get操作呢?
        //答案在awaitDone方法内
        System.out.println(task.get());
    }

    public static class 啊 extends FutureTask {

        public 啊(Callable callable) {
            super(callable);
        }

        public 啊(Runnable runnable, Object result) {
            super(runnable, result);
        }

        @Override
        protected void done() {
            try {
                System.out.println(get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
