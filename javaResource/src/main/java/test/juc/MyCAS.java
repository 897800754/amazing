package test.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: cg1
 * @date: 2020-10-22 00:17
 **/
public class MyCAS {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println(andIncrement);
    }
}
