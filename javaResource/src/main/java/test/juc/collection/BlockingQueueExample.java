package test.juc.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * 是有界的阻塞队列，内部使用数组存储队列元素。这里的“有界”是指存储容量存在上限，不能无限存储元素。在同一时间内存储容量存在着一个上限值，这个上限制在初始实例化的时候指定，之后便不能修改了。
 *
 * @author: cg1
 * @date: 2021-03-31 16:21
 **/
public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {
        //使用ArrayBlockingQueue初始化一个BlockingQueue，指定容量的上限为1024
        //默认非公平锁
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1024);
        queue.put(1);
        //使用ReentrantLock
        boolean add = queue.add(1);
        System.out.println(add);
        boolean offer = queue.offer(1);
        System.out.println(offer);
        boolean offer1 = queue.offer(1, 100, TimeUnit.MINUTES);
        System.out.println(offer1);
    }
}

