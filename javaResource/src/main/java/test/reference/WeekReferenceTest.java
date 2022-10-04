package test.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 软应用
 * 当gc时,会被回收
 *
 * @author: cg1
 * @date: 2021-07-14 23:11
 **/
public class WeekReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        //test01();
        test02();

    }

    /**
     * 结论 当weakReference对象内部的bytes被回收后会被加入到refQueue当中
     *
     * @throws InterruptedException
     */
    private static void test02() throws InterruptedException {
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        byte[] bytes = new byte[1024 * 1024 * 10];
        WeakReference<byte[]> weakReference = new WeakReference<>(bytes, queue);
        //字节数组失去强引用
        //失去强引用才会被回收
        bytes = null;
        Reference<? extends byte[]> ref = queue.poll();
        System.out.println("执行gc前queue是否有数据:" + (ref == null ? "无" : "有"));
        System.out.println("执行gc前是否引用对象:" + weakReference.get());

        //触发gc
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        Reference<? extends byte[]> poll0 = queue.poll();
        System.out.println("执行gc后是否引用对象:" + weakReference.get());
        System.out.println("执行gc后是否有数据:" + (poll0 == null ? "无" : "有"));
        System.out.println("执行gc引用是否相等:" + (poll0 == weakReference ? "相等" : "不相等"));
    }

    /**
     * 引用对象被gc
     *
     * @throws InterruptedException
     */
    private static void test01() throws InterruptedException {
        int i = 200;
        ArrayList<WeakReference<byte[]>> weakReferences = new ArrayList<>();
        while (i-- > 0) {
            byte[] bytes = new byte[1024 * 1024 * 10];
            WeakReference<byte[]> weakReference = new WeakReference<>(bytes);
            System.out.println("当前引用对象为" + weakReference.get());
            weakReferences.add(weakReference);
            i--;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        for (WeakReference weakReference : weakReferences) {
            System.out.println("当前引用对象为" + weakReference.get());
        }
    }

}
