package test.juc.lock;

import test.juc.ThreadHelper;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对于reentrantLock的使用
 *
 * @author: cg1
 * @date: 2021-08-10 10:31
 **/
public class ReentrantlLockTest {


    static int i = 0;

    public static void main(String[] args) {
        //默认非公平锁
        ReentrantLock reentrantLock = new ReentrantLock();
        Callable<Integer> callable = () -> {
            reentrantLock.lock();
            for (int j = 0; j < 1_000_000; j++) {
                i++;
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            reentrantLock.unlock();
            return i;
        };
        FutureTask<Integer> futureTask = ThreadHelper.startThread(callable);
        FutureTask<Integer> futureTask1 = ThreadHelper.startThread(callable);
        boolean flag = true;
        while (flag) {
            if (futureTask.isDone() && futureTask1.isDone()) {
                System.out.println(i);
                flag = false;
            }
        }
    }

}
