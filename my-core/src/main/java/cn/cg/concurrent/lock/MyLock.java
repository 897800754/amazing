package cn.cg.concurrent.lock;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: cg
 * @date: 2023-03-26 19:22
 **/
public class MyLock implements Lock {

    private final Sync SYNC = new Sync();


    static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
//            return super.tryAcquire(arg);
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

    }


    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void lock() {
        SYNC.acquire(0);
    }

    @Override
    public void unlock() {
        SYNC.release(0);
    }


    private static volatile Integer count = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorCompletionService<Integer> integerExecutorCompletionService = new ExecutorCompletionService<Integer>(executorService);

        MyLock myLock = new MyLock();
        int limit = 1000;
        List<Callable<Integer>> collect = Stream.iterate(0, n -> n + 1)
                .limit(limit)
                .map(x -> (Callable<Integer>) () -> {
                    myLock.lock();
                    count++;
                    myLock.unlock();
                    return count;
                })
                .collect(Collectors.toList());
        List<Future<Integer>> futures = executorService.invokeAll(collect);
        for (Callable<Integer> integerCallable : collect) {
            integerExecutorCompletionService.submit(integerCallable);
        }

        for (int i = 0; i < limit; i++) {
            Future<Integer> future = integerExecutorCompletionService.poll(10, TimeUnit.SECONDS);
            System.out.println("future:" + future.get());
        }
//        for (Future<Integer> future : futures) {
//            System.out.println("future:" + future.get() + "lock:" + myLock.SYNC.isHeldExclusively());
//        }
        System.out.println("---------------------------------");
        System.out.println(count);
        executorService.shutdown();
    }


}
