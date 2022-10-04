package test.juc.lock;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自己实现AQS锁
 * 该工具在同一时刻，只允许至多两个线程同时访问，超过两个线程的访问将被阻塞，我们将这个同步工具命名为TwinsLock
 * 显然是共享式访问,非独占模式
 *
 * @author: cg1
 * @date: 2021-08-10 23:16
 **/
public class MyAQSTest {

    public static void main(String[] args) {
        MyLock myLock = new MyLock(2);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                myLock.lock();
                try {
                    Class<? extends MyLock.Sync> aClass = myLock.sync.getClass();
                    Class<?> superclass = aClass.getSuperclass();
                    Field field = superclass.getDeclaredField("state");
                    field.setAccessible(true);
                    String format = MessageFormat.format("线程Task执行了,线程名:{0},sync.state状态:{1}", Thread.currentThread().getName(), field.get(myLock.sync));
                    System.out.println(format);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                myLock.unlock();
            }, "线程" + i);
        }
        for (Thread thread : threads) {
            thread.start();
        }

    }


    public static class MyLock implements Lock {


        private Sync sync = new Sync();

        private Integer model;

        public MyLock(Integer model) {
            this.model = model;
        }

        public static class Sync extends AbstractQueuedLongSynchronizer {
//            @Override
//            protected boolean tryAcquire(long arg) {
//                //   System.out.println(MessageFormat.format("线程{0},尝试获取锁", Thread.currentThread().getName()));
//                long state = getState();
//                //可以上锁
//                if (state < arg) {
//                    //+1
//                    if (compareAndSetState(state, state + 1)) {
//                        System.out.println(MessageFormat.format("线程{0},获取锁成功", Thread.currentThread().getName()));
//                        return true;
//                    } else {
//                        return false;
//                    }
//                } else {
//                    //不能上锁
//                    //判断是否锁重入?
//                    return false;
//                }
//            }
//
//            @Override
//            protected boolean tryRelease(long arg) {
//                //   System.out.println(MessageFormat.format("线程{0},尝试释放锁", Thread.currentThread().getName()));
//                while (true) {
//                    long state = getState();
//                    if (state < 0 || state > arg) {
//                        throw new RuntimeException("state<0 ||state >" + arg);
//                    } else {
//                        if (compareAndSetState(state, state - 1)) {
//                            System.out.println(MessageFormat.format("线程{0},释放锁成功", Thread.currentThread().getName()));
//                            return true;
//                        } else {
//                            return false;
//                        }
//                    }
//                }
//            }
        }


        @Override
        public void lock() {
            sync.acquire(model);
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return false;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public void unlock() {
            sync.release(model);
        }

        @Override
        public Condition newCondition() {
            return null;
        }
    }

}
