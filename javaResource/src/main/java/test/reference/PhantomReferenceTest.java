package test.reference;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 虚引用
 * 随时可能被回收
 *
 * @author: cg1
 * @date: 2021-07-14 23:11
 **/
public class PhantomReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        test02();
    }

    /**
     * 结论 当 Phantom对象内部的bytes被回收后会被加入到refQueue当中
     *
     * @throws InterruptedException
     */
    private static void test02() throws InterruptedException {
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        byte[] bytes = new byte[1024 * 1024 * 10];
        bytes[1] = 3;
        //必须穿ReferenceQueue
        PhantomReference<byte[]> phantomReference = new PhantomReference<>(bytes, queue);
        //字节数组失去强引用
        //   bytes = null;
        Reference<? extends byte[]> ref = queue.poll();
        System.out.println("执行gc前queue是否有数据:" + (ref == null ? "无" : "有"));
        System.out.println("执行gc前是否引用对象:" + phantomReference.get());
        //触发gc
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        Reference<? extends byte[]> poll0 = queue.poll();
        System.out.println("执行gc后是否引用对象:" + phantomReference.get());
        System.out.println("执行gc后是否有数据:" + (poll0 == null ? "无" : "有"));
        System.out.println("执行gc引用是否相等:" + (poll0 == phantomReference ? "相等" : "不相等"));


    }

}
