package test.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试 lockInterruptibly lock 方法的区别  lockInterruptibly(响应中断) lock不响应中断,与中断无关
 *
 * @author: cg1
 * @date: 2021-08-10 16:35
 **/
public class LockInterruptiblyTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread threadA = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取锁");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获取到了锁");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放锁");
                lock.unlock();
            }
        }, "线程A");
        Thread threadB = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取锁");
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "获取到了锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放锁");
                lock.unlock();
            }
        }, "线程B");

        Thread threadC = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "尝试获取锁");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获取到了锁");
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放锁");
                lock.unlock();
            }
        }, "线程C");
        threadA.start();
        threadB.start();
        threadC.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("开始打断线程B");
        threadB.interrupt();
        System.out.println("threadB中断状态:" + threadB.isInterrupted());
        System.out.println("开始打断线程C");
        threadC.interrupt();
        System.out.println("threadC中断状态:" + threadC.isInterrupted());
        System.out.println("--------------------------------------------------------");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("threadB中断状态:" + threadB.isInterrupted());
        System.out.println("threadC中断状态:" + threadC.isInterrupted());
    }


}
